package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicTacToeService extends Remote {
    PlayerSymbol registerPlayer(String playerName) throws RemoteException;

    char[] getBoard() throws RemoteException;

    PlayerSymbol getCurrentTurn() throws RemoteException;

    GameStatus getStatus() throws RemoteException;

    PlayerSymbol getWinner() throws RemoteException;

    String getMessage() throws RemoteException;

    boolean makeMove(String playerName, int position) throws RemoteException;
}
