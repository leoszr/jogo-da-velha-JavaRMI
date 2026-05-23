package client;

import common.SimboloJogador;
import common.StatusPartida;
import common.TicTacToeService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {
    private static final String HOST_PADRAO = "localhost";
    private static final int PORTA_RMI = 1099;
    private static final String NOME_SERVICO = "TicTacToeService";

    public static void main(String[] args) {
        String host = (args.length > 0 && args[0] != null && !args[0].isBlank()) ? args[0] : HOST_PADRAO;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite seu nome: ");
            String nomeJogador = scanner.nextLine();

            Registry registry = LocateRegistry.getRegistry(host, PORTA_RMI);
            TicTacToeService service = (TicTacToeService) registry.lookup(NOME_SERVICO);

            SimboloJogador simboloJogador = service.registerPlayer(nomeJogador);
            if (simboloJogador == null) {
                System.out.println("Não foi possível entrar na partida: " + service.getMessage());
                return;
            }

            System.out.println("Você entrou como: " + simboloJogador);

            while (true) {
                char[] tabuleiro = service.getBoard();
                SimboloJogador turnoAtual = service.getCurrentTurn();
                StatusPartida status = service.getStatus();
                SimboloJogador vencedor = service.getWinner();
                String mensagem = service.getMessage();

                System.out.println();
                System.out.println(RenderizadorTabuleiro.renderizar(tabuleiro));
                System.out.println("Status: " + status);
                System.out.println("Mensagem: " + mensagem);

                if (status == StatusPartida.X_VENCEU || status == StatusPartida.O_VENCEU || status == StatusPartida.EMPATE) {
                    if (status == StatusPartida.EMPATE) {
                        System.out.println("Resultado: empate.");
                    } else {
                        System.out.println("Resultado: vencedor " + vencedor + ".");
                    }
                    return;
                }

                if (turnoAtual != simboloJogador) {
                    Thread.sleep(1500);
                    continue;
                }

                System.out.print("Sua vez. Escolha posição (1-9): ");
                if (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Entrada inválida. Digite número de 1 a 9.");
                    continue;
                }

                int posicao = scanner.nextInt();
                scanner.nextLine();

                boolean jogadaFeita = service.makeMove(nomeJogador, posicao);
                if (!jogadaFeita) {
                    System.out.println("Jogada recusada: " + service.getMessage());
                }
            }
        } catch (Exception exception) {
            System.out.println("Erro no cliente: " + exception.getMessage());
        }
    }
}
