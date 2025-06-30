package projetosniveljunior.projeto4.service;

import projetosniveljunior.projeto4.domain.Tarefa;
import projetosniveljunior.projeto4.repository.TarefaRepository;

import java.util.List;
import java.util.Scanner;

public class TarefaService {
    private final TarefaRepository repository;
    private final Scanner scanner = new Scanner(System.in);
    private final String fraseParaListar = "\n [%d] tarefa: %s, descricao: %s, status: %s";

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    private String lerTarefa() {
        System.out.print("Digite a tarefa: ");
        String tarefa = scanner.nextLine();
        if (tarefa.isEmpty()) {
            System.out.println("Tarefa não pode estar vazia");
            return null;
        }
        return tarefa;
    }

    private String lerDescricao() {
        System.out.print("Digite a descrição(não é obrigatório): ");
        String descricao = scanner.nextLine();
        if (descricao.isEmpty()) {
            return null;
        }
        return descricao;
    }

    public void cadastrarTarefa() {
        String titulo = lerTarefa();
        if (titulo == null) return;

        String descricao = lerDescricao();

        Tarefa tarefa = new Tarefa(titulo, descricao, false);
        repository.adicionar(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
        System.out.println(tarefa);
    }

    public void listarTarefas() {
        int contador = 1;
        if (repository.listar().isEmpty()) {
            System.out.println("Não tem tarefas para mostrar!");
            return;
        }

        for (Tarefa tarefa : repository.listar()) {
            System.out.printf((fraseParaListar) + "%n", contador++,
                    tarefa.getTitulo(),
                    tarefa.getDescricao() != null ? tarefa.getDescricao() : "(sem descricao)",
                    tarefa.isConcluida() ? "Concluída" : "Pendente");
        }
    }

    public void busca() {
        System.out.print("Digite a tarefa para buscar: ");
        String tarefaBuscada = scanner.nextLine();
        List<Tarefa> encontrados = repository.buscarPorTitulo(tarefaBuscada);
        if (encontrados.isEmpty()) {
            System.out.println("Nenhuma tarefa disponivel.");
            return;
        }
        int contador = 1;
        for (Tarefa tarefa : encontrados) {
            System.out.printf((fraseParaListar) + "%n", contador++,
                    tarefa.getTitulo(),
                    tarefa.getDescricao() != null ? tarefa.getDescricao() : "(sem descricao)",
                    tarefa.isConcluida() ? "Concluída" : "Pendente");
        }
    }

    public void editar() {
        if (repository.tamanho() == 0) {
            System.out.println("Não tem tarefas para editar.");
            return;
        }
        listarTarefas();
        System.out.print("\nDigite a tarefa pelo indice que deseja editar: ");

        int indiceDaTarefa = scanner.nextInt();
        scanner.nextLine();

        if (indiceDaTarefa < 1 || indiceDaTarefa > repository.tamanho()) {
            System.out.println("Valor do índice inválido.");
            return;
        }

        Tarefa tarefa = repository.obterPorIndice(indiceDaTarefa);

        System.out.print("Digite o novo titulo (ou digite ENTER para manter):  ");
        String novoTitulo = scanner.nextLine();

        if (!novoTitulo.isEmpty()) {
            tarefa.setTitulo(novoTitulo);
        }

        System.out.print("Digite a nova descrição (ou digite ENTER para manter): ");

        String novaDescricao = scanner.nextLine();
        if (!novaDescricao.isEmpty()) {
            tarefa.setDescricao(novaDescricao);
        }

        System.out.print("Digite 'true' para marcar como concluída, 'false' para pendente (ou Enter para manter):  ");

        String concluido = scanner.nextLine().toLowerCase();

        if (concluido.equals("true")) {
            tarefa.setConcluida(true);
        } else if (concluido.equals("false")) {
            tarefa.setConcluida(false);
        }

        System.out.println("\nTarefa atualizada:");
        System.out.printf("Título: %s%nDescrição: %s%nStatus: %s%n",
                tarefa.getTitulo(),
                tarefa.getDescricao() != null ? tarefa.getDescricao() : "(sem descrição)",
                tarefa.isConcluida() ? "Concluída" : "Pendente");
    }

    public void remover() {
        if (repository.listar().isEmpty()) {
            System.out.println("Não tem tarefas para remover.");
            return;
        }
        listarTarefas();
        System.out.print("Escolha uma tarefa por índice para remover: ");
        int indiceParaRemover = scanner.nextInt();
        scanner.nextLine();

        if (indiceParaRemover < 1 || indiceParaRemover > repository.tamanho()) {
            System.out.println("Índice inválido. Nenhuma tarefa foi removida.");
            return;
        }
        repository.remove(indiceParaRemover);
        System.out.println("Tarefa removida com sucesso!");
    }
}


