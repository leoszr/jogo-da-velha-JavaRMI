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

    public TicTacToeServiceImpl() throws RemoteException {
        tabuleiro = new char[TAMANHO_TABULEIRO];
        Arrays.fill(tabuleiro, CASA_VAZIA);
        status = StatusPartida.AGUARDANDO_JOGADORES;
        turnoAtual = SimboloJogador.X;
    }

    @Override
    public SimboloJogador registerPlayer(String playerName) throws RemoteException {
        return null;
    }

    @Override
    public char[] getBoard() throws RemoteException {
        return tabuleiro.clone();
    }

    @Override
    public SimboloJogador getCurrentTurn() throws RemoteException {
        return turnoAtual;
    }

    @Override
    public StatusPartida getStatus() throws RemoteException {
        return status;
    }

    @Override
    public SimboloJogador getWinner() throws RemoteException {
        return null;
    }

    @Override
    public String getMessage() throws RemoteException {
        return "Aguardando jogadores.";
    }

    @Override
    public boolean makeMove(String playerName, int position) throws RemoteException {
        return false;
    }
}
