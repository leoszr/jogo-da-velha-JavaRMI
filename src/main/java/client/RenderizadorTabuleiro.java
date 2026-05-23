package client;

public final class RenderizadorTabuleiro {
    private static final int TAMANHO_TABULEIRO = 9;

    private RenderizadorTabuleiro() {
    }

    public static String renderizar(char[] tabuleiro) {
        if (tabuleiro == null || tabuleiro.length != TAMANHO_TABULEIRO) {
            throw new IllegalArgumentException("Tabuleiro deve ter 9 posições.");
        }

        StringBuilder texto = new StringBuilder();

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            char valorCasa = tabuleiro[i];
            String exibicaoCasa = (valorCasa == 'X' || valorCasa == 'O')
                    ? String.valueOf(valorCasa)
                    : String.valueOf(i + 1);

            texto.append(' ').append(exibicaoCasa).append(' ');

            if (i % 3 != 2) {
                texto.append('|');
            }

            if (i % 3 == 2 && i < TAMANHO_TABULEIRO - 1) {
                texto.append(System.lineSeparator())
                        .append("-----------")
                        .append(System.lineSeparator());
            }
        }

        return texto.toString();
    }
}
