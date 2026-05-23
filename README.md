# Jogo da Velha com Java RMI

Projeto de Sistemas Distribuídos: jogo da velha em Java com cliente/servidor usando RMI.

## O que é

- **Servidor**: guarda estado da partida, valida jogadas e define vencedor/empate.
- **Cliente**: roda no terminal, mostra tabuleiro e envia jogadas.
- **Comunicação**: Java RMI na porta `1099`.

## Requisitos

- Java **JDK 17+**
- Terminal Linux/macOS/Windows
- Git (se for baixar pelo repositório)

## Como baixar

### Opção 1 — Git

```bash
git clone https://github.com/leoszr/jogo-da-velha-JavaRMI.git
cd jogo-da-velha-JavaRMI
```

### Opção 2 — ZIP

1. Acesse o repositório no GitHub.
2. Clique em **Code**.
3. Baixe como **Download ZIP**.
4. Extraia o arquivo e abra a pasta do projeto no terminal.

## Como compilar

Na raiz do projeto:

```bash
rm -rf out
mkdir -p out
javac -d out $(find src/main/java -name '*.java')
```

## Como jogar

### 1) Iniciar o servidor

Em um terminal:

```bash
java -cp out server.ServerMain
```

Saída esperada:

```text
Servidor RMI ativo na porta 1099. Serviço: TicTacToeService
```

### 2) Abrir o cliente do jogador X

Em outro terminal:

```bash
java -cp out client.ClientMain
```

Digite um nome, por exemplo:

```text
ana
```

Se der certo, o cliente mostra o símbolo recebido:

```text
Você entrou como: X
```

### 3) Abrir o cliente do jogador O

Em outro terminal:

```bash
java -cp out client.ClientMain
```

Digite outro nome, por exemplo:

```text
bia
```

O segundo jogador recebe `O`.

### 4) Jogar

- O cliente mostra o tabuleiro.
- Quando for sua vez, digite uma posição de **1 a 9**.
- Casas vazias mostram números.
- Casas ocupadas mostram `X` ou `O`.

Exemplo de tabuleiro vazio:

```text
 1 | 2 | 3
-----------
 4 | 5 | 6
-----------
 7 | 8 | 9
```

### 5) Regras do jogo

- Só entram **2 jogadores**.
- Primeiro jogador vira `X`.
- Segundo jogador vira `O`.
- A partida começa depois do segundo jogador.
- Jogada fora do turno é recusada.
- Jogada em casa ocupada é recusada.
- Partida termina com vitória ou empate.

## Exemplo de partida

### Vitória de X

Sequência:

- X: `1`
- O: `4`
- X: `2`
- O: `5`
- X: `3`

Resultado: `X` vence.

### Empate

Sequência:

- X: `1`
- O: `2`
- X: `3`
- O: `5`
- X: `4`
- O: `6`
- X: `8`
- O: `7`
- X: `9`

Resultado: empate.

## Cenários para testar

- Conectar jogador `X`
- Conectar jogador `O`
- Tentar conectar terceiro jogador
- Tentar jogar fora do turno
- Tentar jogar em casa ocupada
- Finalizar com vitória
- Finalizar com empate

## Observações

- O servidor fica em execução até ser parado manualmente.
- O cliente consulta o estado da partida em loop.
- Se o servidor cair, o cliente exibirá erro de conexão.

## Estrutura do projeto

- `src/main/java/common`: contrato remoto e enums
- `src/main/java/server`: implementação e bootstrap do servidor
- `src/main/java/client`: cliente de terminal e renderização do tabuleiro
