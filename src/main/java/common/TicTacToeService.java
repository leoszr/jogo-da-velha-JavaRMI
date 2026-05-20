package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicTacToeService extends Remote {
    SimboloJogador registerPlayer(String playerName) throws RemoteException;

    char[] getBoard() throws RemoteException;

    SimboloJogador getCurrentTurn() throws RemoteException;

    StatusPartida getStatus() throws RemoteException;

    SimboloJogador getWinner() throws RemoteException;

    String getMessage() throws RemoteException;

    boolean makeMove(String playerName, int position) throws RemoteException;
}
