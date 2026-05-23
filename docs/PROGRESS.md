# Progresso de Desenvolvimento

Use este arquivo para acompanhar execução das tasks.

## Status possíveis

- `TODO`: ainda não iniciada
- `IN_PROGRESS`: em desenvolvimento
- `DONE`: concluída
- `BLOCKED`: bloqueada

## Resumo

| Métrica | Valor |
|---|---:|
| Total de tasks | 15 |
| TODO | 0 |
| IN_PROGRESS | 0 |
| DONE | 15 |
| BLOCKED | 0 |
| Progresso | 100% |

## Checklist por ordem de implementação

| Ordem | Task | Status | Observações |
|---:|---|---|---|
| 1 | [TASK-001 — Criar estrutura do projeto](tasks/TASK-001-criar-estrutura-projeto.md) | DONE |  |
| 2 | [TASK-002 — Criar enums do domínio](tasks/TASK-002-criar-enums-dominio.md) | DONE |  |
| 3 | [TASK-003 — Remover DTOs do planejamento](tasks/TASK-003-remover-dtos-planejamento.md) | DONE | Planejamento ajustado para tipos simples no RMI |
| 4 | [TASK-004 — Criar interface remota RMI](tasks/TASK-004-criar-interface-remota-rmi.md) | DONE | Interface criada; enums alinhados ao contrato planejado |
| 5 | [TASK-005 — Implementar estado inicial da partida](tasks/TASK-005-implementar-estado-inicial-partida.md) | DONE | Estado inicial implementado |
| 6 | [TASK-006 — Implementar registro de jogadores](tasks/TASK-006-implementar-registro-jogadores.md) | DONE | Registro de jogadores implementado |
| 7 | [TASK-007 — Implementar servidor RMI](tasks/TASK-007-implementar-servidor-rmi.md) | DONE | Servidor RMI implementado |
| 8 | [TASK-008 — Implementar consulta de estado](tasks/TASK-008-implementar-consulta-estado.md) | DONE |  |
| 9 | [TASK-009 — Implementar renderização do tabuleiro](tasks/TASK-009-implementar-renderizacao-tabuleiro.md) | DONE |  |
| 10 | [TASK-010 — Implementar validação de jogadas](tasks/TASK-010-implementar-validacao-jogadas.md) | DONE |  |
| 11 | [TASK-011 — Implementar execução de jogada válida](tasks/TASK-011-implementar-execucao-jogada-valida.md) | DONE |  |
| 12 | [TASK-012 — Implementar detecção de vitória](tasks/TASK-012-implementar-deteccao-vitoria.md) | DONE |  |
| 13 | [TASK-013 — Implementar detecção de empate](tasks/TASK-013-implementar-deteccao-empate.md) | DONE |  |
| 14 | [TASK-014 — Implementar cliente TUI](tasks/TASK-014-implementar-cliente-tui.md) | DONE |  |
| 15 | [TASK-015 — Documentar execução e teste manual](tasks/TASK-015-documentar-execucao-teste-manual.md) | DONE |  |

## Histórico

| Data | Task | Mudança | Observações |
|---|---|---|---|
| 2026-05-19 | Todas | Criado acompanhamento inicial | Todas como TODO |
| 2026-05-19 | TASK-001 | Task iniciada (TODO → IN_PROGRESS) | Estrutura base de pastas Java |
| 2026-05-19 | TASK-001 | Task concluída (IN_PROGRESS → DONE) | Pastas `common`, `server`, `client` criadas |
| 2026-05-19 | TASK-002 | Task iniciada (TODO → IN_PROGRESS) | Criação de enums de domínio |
| 2026-05-19 | TASK-002 | Task concluída (IN_PROGRESS → DONE) | Enums `PlayerSymbol` e `GameStatus` criados |
| 2026-05-19 | TASK-003 | Task iniciada (TODO → IN_PROGRESS) | Início de criação dos DTOs serializáveis |
| 2026-05-20 | TASK-003 | Task alterada e concluída (IN_PROGRESS → DONE) | DTOs removidos do planejamento; contrato RMI usará tipos simples |
| 2026-05-20 | TASK-004 | Task iniciada (TODO → IN_PROGRESS) | Criação da interface remota RMI |
| 2026-05-20 | TASK-004 | Task concluída (IN_PROGRESS → DONE) | Interface `TicTacToeService` criada; contrato compila |
| 2026-05-20 | TASK-005 | Task iniciada (TODO → IN_PROGRESS) | Implementação inicial do estado da partida |
| 2026-05-20 | TASK-005 | Task concluída (IN_PROGRESS → DONE) | Estado inicial compila e valida critérios de aceite |
| 2026-05-20 | TASK-006 | Task iniciada (TODO → IN_PROGRESS) | Implementação do registro de jogadores |
| 2026-05-20 | TASK-006 | Task concluída (IN_PROGRESS → DONE) | Registro de jogadores compila e valida critérios de aceite |
| 2026-05-20 | TASK-007 | Task iniciada (TODO → IN_PROGRESS) | Implementação do servidor RMI |
| 2026-05-20 | TASK-007 | Task concluída (IN_PROGRESS → DONE) | Servidor RMI compila, inicia e publica serviço |
| 2026-05-23 | TASK-008 | Task iniciada (TODO → IN_PROGRESS) | Implementação de consultas de estado |
| 2026-05-23 | TASK-008 | Task concluída (IN_PROGRESS → DONE) | Consultas de estado implementadas e compilação validada |
| 2026-05-23 | TASK-009 | Task iniciada (TODO → IN_PROGRESS) | Implementação da renderização do tabuleiro |
| 2026-05-23 | TASK-009 | Task concluída (IN_PROGRESS → DONE) | Utilitário de renderização criado no cliente e compilação validada |
| 2026-05-23 | TASK-010 | Task iniciada (TODO → IN_PROGRESS) | Implementação de validação de jogadas |
| 2026-05-23 | TASK-010 | Task concluída (IN_PROGRESS → DONE) | Validações de jogada implementadas sem alterar tabuleiro em caso inválido |
| 2026-05-23 | TASK-011 | Task iniciada (TODO → IN_PROGRESS) | Implementação da execução de jogada válida |
| 2026-05-23 | TASK-011 | Task concluída (IN_PROGRESS → DONE) | Jogada válida agora marca tabuleiro, alterna turno e retorna sucesso |
| 2026-05-23 | TASK-012 | Task iniciada (TODO → IN_PROGRESS) | Implementação da detecção de vitória |
| 2026-05-23 | TASK-012 | Task concluída (IN_PROGRESS → DONE) | Vitória horizontal/vertical/diagonal detectada, status e vencedor atualizados |
| 2026-05-23 | TASK-013 | Task iniciada (TODO → IN_PROGRESS) | Implementação da detecção de empate |
| 2026-05-23 | TASK-013 | Task concluída (IN_PROGRESS → DONE) | Empate detectado com tabuleiro cheio sem vencedor; status e mensagem atualizados |
| 2026-05-23 | TASK-014 | Task iniciada (TODO → IN_PROGRESS) | Implementação do cliente TUI |
| 2026-05-23 | TASK-014 | Task concluída (IN_PROGRESS → DONE) | Cliente terminal criado com loop de jogo, renderização e integração RMI |
| 2026-05-23 | TASK-015 | Task iniciada (TODO → IN_PROGRESS) | Documentação de execução e teste manual |
| 2026-05-23 | TASK-015 | Task concluída (IN_PROGRESS → DONE) | README atualizado com pré-requisitos, execução e cenários de teste manual |

## Como atualizar

1. Ao iniciar uma task, mudar status para `IN_PROGRESS`.
2. Ao concluir critérios de aceite, mudar status para `DONE`.
3. Se houver impedimento, mudar status para `BLOCKED` e preencher observação.
4. Atualizar resumo numérico.
5. Registrar mudança no histórico.
