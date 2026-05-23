package server;

import common.SimboloJogador;
import common.StatusPartida;
import common.TicTacToeService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class TicTacToeServiceImpl extends UnicastRemoteObject implements TicTacToeService {
    private static final int TAMANHO_TABULEIRO = 9;
    private static final char CASA_VAZIA = ' ';

    private final char[] tabuleiro;
    private StatusPartida status;
    private SimboloJogador turnoAtual;
    private String jogadorX;
    private String jogadorO;
    private SimboloJogador vencedor;
    private String mensagem;

    public TicTacToeServiceImpl() throws RemoteException {
        tabuleiro = new char[TAMANHO_TABULEIRO];
        Arrays.fill(tabuleiro, CASA_VAZIA);
        status = StatusPartida.AGUARDANDO_JOGADORES;
        turnoAtual = SimboloJogador.X;
        mensagem = "Aguardando jogadores.";
    }

    @Override
    public synchronized SimboloJogador registerPlayer(String playerName) throws RemoteException {
        if (playerName != null && (playerName.equals(jogadorX) || playerName.equals(jogadorO))) {
            mensagem = "Nome de jogador repetido.";
            return null;
        }

        if (jogadorX == null) {
            jogadorX = playerName;
            mensagem = "Jogador registrado com símbolo X.";
            return SimboloJogador.X;
        }

        if (jogadorO == null) {
            jogadorO = playerName;
            status = StatusPartida.EM_ANDAMENTO;
            mensagem = "Jogador registrado com símbolo O. Partida iniciada.";
            return SimboloJogador.O;
        }

        mensagem = "Partida cheia.";
        return null;
    }

    @Override
    public synchronized char[] getBoard() throws RemoteException {
        return tabuleiro.clone();
    }

    @Override
    public synchronized SimboloJogador getCurrentTurn() throws RemoteException {
        return turnoAtual;
    }

    @Override
    public synchronized StatusPartida getStatus() throws RemoteException {
        return status;
    }

    @Override
    public synchronized SimboloJogador getWinner() throws RemoteException {
        return vencedor;
    }

    @Override
    public synchronized String getMessage() throws RemoteException {
        if (status == StatusPartida.AGUARDANDO_JOGADORES) {
            if (jogadorX == null && jogadorO == null) {
                return "Aguardando jogadores.";
            }
            if (jogadorX != null && jogadorO == null) {
                return "Aguardando segundo jogador.";
            }
        }

        if (status == StatusPartida.EM_ANDAMENTO && (mensagem == null || mensagem.isBlank())) {
            return "Partida em andamento.";
        }

        return mensagem;
    }

    @Override
    public synchronized boolean makeMove(String playerName, int position) throws RemoteException {
        if (status != StatusPartida.EM_ANDAMENTO) {
            mensagem = "Partida não está em andamento.";
            return false;
        }

        if (playerName == null || (!playerName.equals(jogadorX) && !playerName.equals(jogadorO))) {
            mensagem = "Jogador não registrado.";
            return false;
        }

        SimboloJogador simboloJogador = playerName.equals(jogadorX) ? SimboloJogador.X : SimboloJogador.O;
        if (simboloJogador != turnoAtual) {
            mensagem = "Não é turno deste jogador.";
            return false;
        }

        if (position < 1 || position > TAMANHO_TABULEIRO) {
            mensagem = "Posição inválida. Use valores de 1 a 9.";
            return false;
        }

        int indiceCasa = position - 1;
        if (tabuleiro[indiceCasa] != CASA_VAZIA) {
            mensagem = "Casa já está ocupada.";
            return false;
        }

        tabuleiro[indiceCasa] = simboloJogador.name().charAt(0);

        if (verificarVitoria(simboloJogador)) {
            vencedor = simboloJogador;
            status = (simboloJogador == SimboloJogador.X) ? StatusPartida.X_VENCEU : StatusPartida.O_VENCEU;
            mensagem = "Jogador " + simboloJogador + " venceu a partida.";
            return true;
        }

        if (verificarEmpate()) {
            status = StatusPartida.EMPATE;
            mensagem = "Partida terminou em empate.";
            return true;
        }

        turnoAtual = (turnoAtual == SimboloJogador.X) ? SimboloJogador.O : SimboloJogador.X;
        mensagem = "Jogada realizada com sucesso.";
        return true;
    }

    private boolean verificarVitoria(SimboloJogador simboloJogador) {
        char simbolo = simboloJogador.name().charAt(0);

        int[][] combinacoesVencedoras = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] combinacao : combinacoesVencedoras) {
            if (tabuleiro[combinacao[0]] == simbolo
                    && tabuleiro[combinacao[1]] == simbolo
                    && tabuleiro[combinacao[2]] == simbolo) {
                return true;
            }
        }

        return false;
    }

    private boolean verificarEmpate() {
        for (char casa : tabuleiro) {
            if (casa == CASA_VAZIA) {
                return false;
            }
        }
        return true;
    }
}
