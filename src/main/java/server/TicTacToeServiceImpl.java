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
        return null;
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
    public boolean makeMove(String playerName, int position) throws RemoteException {
        return false;
    }
}
