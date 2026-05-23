## Jogo da Velha com Java RMI

Trabalho da matéria de Sistemas Distribuídos realizado pelo grupo 3: Leonardo Rodrigues, Lucas Barreto e Gilmar Gabriel.

## Pré-requisitos

- Java JDK 17+ instalado
- Terminal Linux/macOS (ou equivalente no Windows)

## Estrutura

- `src/main/java/common`: contrato remoto e enums
- `src/main/java/server`: servidor RMI
- `src/main/java/client`: cliente TUI e renderização do tabuleiro

## Como compilar

Na raiz do projeto:

```bash
rm -rf out
mkdir -p out
javac -d out $(find src/main/java -name '*.java')
```

## Como executar

### 1) Iniciar servidor

Em um terminal:

```bash
java -cp out server.ServerMain
```

Saída esperada (exemplo):

```text
Servidor RMI ativo na porta 1099. Serviço: TicTacToeService
```

### 2) Iniciar cliente 1 (jogador X)

Em outro terminal:

```bash
java -cp out client.ClientMain
```

Digite nome, por exemplo: `ana`.

### 3) Iniciar cliente 2 (jogador O)

Em outro terminal:

```bash
java -cp out client.ClientMain
```

Digite nome, por exemplo: `bia`.

### 4) Tentar cliente 3 (recusado)

Em outro terminal:

```bash
java -cp out client.ClientMain
```

Digite nome, por exemplo: `carlos`.

Esperado: mensagem de recusa (`Partida cheia.` ou equivalente).

## Cenário de teste manual

### Cenário A — validações e vitória

1. Conectar jogador X (`ana`).
2. Conectar jogador O (`bia`).
3. Tentar conectar terceiro jogador (`carlos`) e verificar recusa.
4. Jogada válida de X na posição `1`.
5. Em X, tentar jogar de novo fora do turno e verificar recusa.
6. Em O, jogar na posição `1` (ocupada) e verificar recusa.
7. Finalizar com vitória de X (exemplo):
   - O joga `4`
   - X joga `2`
   - O joga `5`
   - X joga `3` (X vence)
8. Verificar status final e vencedor exibidos nos clientes.

### Cenário B — empate

Iniciar nova partida (reinicie servidor e dois clientes) e executar sequência sem vitória:

- X: `1`
- O: `2`
- X: `3`
- O: `5`
- X: `4`
- O: `6`
- X: `8`
- O: `7`
- X: `9`

Esperado:

- Status final de empate.
- Mensagem de empate.
- Novas jogadas recusadas após término.

## Observações

- O cliente consulta estado do servidor em loop.
- Jogada só é solicitada no turno do jogador local.
- Mensagens de erro/estado são exibidas no terminal.
