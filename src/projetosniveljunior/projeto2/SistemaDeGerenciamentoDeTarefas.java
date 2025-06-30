package projetosniveljunior.projeto2;

import projetosniveljunior.projeto2.domain.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaDeGerenciamentoDeTarefas {
    private static void exibirTarefas(List<Tarefa> tarefas, String frasePadrao) {
        int contador = 1;
        for (Tarefa tarefa : tarefas) {
            String demanda = switch (tarefa.getPrioridade()) {
                case 1 -> "Alta";
                case 2 -> "Média";
                case 3 -> "Baixa";
                default -> "Desconhecida";
            };
            String status = tarefa.isConcluida() ? "Concluída" : "Pendente";
            System.out.printf(frasePadrao.formatted(contador++, tarefa.getDescricao(), demanda, status));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Tarefa> tarefas = new ArrayList<>();
        int opcao;
        final String frasePadrao = "\n[%d] %s - Prioridade: %s - Status: %s";

        do {
            System.out.println("\n==== Sistema de Tarefas ====");
            System.out.println("1. Adicionar uma tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Concluir tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {
                    Tarefa tarefa = new Tarefa();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    if (descricao.isEmpty()) {
                        System.out.println("Descrição não pode estar vazia");
                        break;
                    }
                    tarefa.setDescricao(descricao);
                    System.out.print("Prioridade: ");
                    int prioridade = scanner.nextInt();
                    tarefa.setPrioridade(prioridade);
                    if (tarefa.getPrioridade() < 1 || tarefa.getPrioridade() > 3) {
                        System.out.println("prioridade inválida!");
                        break;
                    }
                    tarefas.add(tarefa);
                    System.out.println("Tarefa adicionada com Sucesso!");
                    break;
                }
                case 2: {
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas cadastradas!");
                    }
                    exibirTarefas(tarefas, frasePadrao);
                    break;
                }
                case 3: {
                    if (tarefas.isEmpty()) {
                        System.out.println("Não existe tarefas cadastradas!");
                        continue;
                    }
                    System.out.println("\n === Tarefas Disponíveis === ");

                    exibirTarefas(tarefas, frasePadrao);

                    System.out.print("\nSelecione a tarefa para ser concluída: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    if (numero < 1 || numero > tarefas.size()) {
                        System.out.println("Número inválido!");
                    } else {
                        Tarefa tarefaSelecionada = tarefas.get(numero - 1);
                        if (tarefaSelecionada.isConcluida()) {
                            System.out.println("Tarefa já está concluída!");
                        } else {
                            tarefaSelecionada.setConcluida(true);
                            System.out.println("Tarefa concluída com sucesso!");
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Saindo do sistema.");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (opcao != 4);
        scanner.close();
    }
}
