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
| TODO | 11 |
| IN_PROGRESS | 0 |
| DONE | 4 |
| BLOCKED | 0 |
| Progresso | 27% |

## Checklist por ordem de implementação

| Ordem | Task | Status | Observações |
|---:|---|---|---|
| 1 | [TASK-001 — Criar estrutura do projeto](tasks/TASK-001-criar-estrutura-projeto.md) | DONE |  |
| 2 | [TASK-002 — Criar enums do domínio](tasks/TASK-002-criar-enums-dominio.md) | DONE |  |
| 3 | [TASK-003 — Remover DTOs do planejamento](tasks/TASK-003-remover-dtos-planejamento.md) | DONE | Planejamento ajustado para tipos simples no RMI |
| 4 | [TASK-004 — Criar interface remota RMI](tasks/TASK-004-criar-interface-remota-rmi.md) | DONE | Interface criada; enums alinhados ao contrato planejado |
| 5 | [TASK-005 — Implementar estado inicial da partida](tasks/TASK-005-implementar-estado-inicial-partida.md) | TODO |  |
| 6 | [TASK-006 — Implementar registro de jogadores](tasks/TASK-006-implementar-registro-jogadores.md) | TODO |  |
| 7 | [TASK-007 — Implementar servidor RMI](tasks/TASK-007-implementar-servidor-rmi.md) | TODO |  |
| 8 | [TASK-008 — Implementar consulta de estado](tasks/TASK-008-implementar-consulta-estado.md) | TODO |  |
| 9 | [TASK-009 — Implementar renderização do tabuleiro](tasks/TASK-009-implementar-renderizacao-tabuleiro.md) | TODO |  |
| 10 | [TASK-010 — Implementar validação de jogadas](tasks/TASK-010-implementar-validacao-jogadas.md) | TODO |  |
| 11 | [TASK-011 — Implementar execução de jogada válida](tasks/TASK-011-implementar-execucao-jogada-valida.md) | TODO |  |
| 12 | [TASK-012 — Implementar detecção de vitória](tasks/TASK-012-implementar-deteccao-vitoria.md) | TODO |  |
| 13 | [TASK-013 — Implementar detecção de empate](tasks/TASK-013-implementar-deteccao-empate.md) | TODO |  |
| 14 | [TASK-014 — Implementar cliente TUI](tasks/TASK-014-implementar-cliente-tui.md) | TODO |  |
| 15 | [TASK-015 — Documentar execução e teste manual](tasks/TASK-015-documentar-execucao-teste-manual.md) | TODO |  |

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

## Como atualizar

1. Ao iniciar uma task, mudar status para `IN_PROGRESS`.
2. Ao concluir critérios de aceite, mudar status para `DONE`.
3. Se houver impedimento, mudar status para `BLOCKED` e preencher observação.
4. Atualizar resumo numérico.
5. Registrar mudança no histórico.
