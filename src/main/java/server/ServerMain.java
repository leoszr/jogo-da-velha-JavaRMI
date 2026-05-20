package server;

import common.TicTacToeService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.util.concurrent.CountDownLatch;

public class ServerMain {
    private static final int PORTA_RMI = 1099;
    private static final String NOME_SERVICO = "TicTacToeService";

    public static void main(String[] args) throws RemoteException, InterruptedException {
        Registry registry = criarOuObterRegistry();
        TicTacToeService service = new TicTacToeServiceImpl();

        registry.rebind(NOME_SERVICO, service);

        System.out.println("Servidor RMI ativo na porta " + PORTA_RMI + ". Serviço: " + NOME_SERVICO);

        new CountDownLatch(1).await();
    }

    private static Registry criarOuObterRegistry() throws RemoteException {
        try {
            return LocateRegistry.createRegistry(PORTA_RMI);
        } catch (ExportException exception) {
            return LocateRegistry.getRegistry(PORTA_RMI);
        }
    }
}
