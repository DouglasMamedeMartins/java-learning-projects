package projetosniveljunior.projeto4.view;

import projetosniveljunior.projeto4.repository.TarefaRepository;
import projetosniveljunior.projeto4.service.TarefaService;

import java.util.Scanner;

public class SistemaDeGerenciamentoDeTarefas {
    public static void main(String[] args) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        TarefaRepository repository = new TarefaRepository();
        TarefaService service = new TarefaService(repository);

        do {
            System.out.println("\nBem vindo ao programa de gerenciamento de tarefas profissionalizado!");
            System.out.println("1) Cadastrar tarefa");
            System.out.println("2) Listar tarefas");
            System.out.println("3) Buscar tarefa por título");
            System.out.println("4) Editar tarefa");
            System.out.println("5) Remover tarefa");
            System.out.println("6) Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> service.cadastrarTarefa();
                case 2 -> service.listarTarefas();
                case 3 -> service.busca();
                case 4 -> service.editar();
                case 5 -> service.remover();
                case 6 -> System.out.println("Saindo do sistema!");
                default -> System.out.println("Opção inválida");
            }
        } while (opcao != 6);
        scanner.close();
    }
}
