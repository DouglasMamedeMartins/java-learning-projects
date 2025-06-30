package projetosniveljunior.projeto3.menu;

import projetosniveljunior.projeto3.service.GerenciadorDeContatos;

import java.util.Scanner;

public class MenuService {
    private final GerenciadorDeContatos gerenciador;
    private final Scanner scanner;

    public MenuService(GerenciadorDeContatos gerenciador, Scanner scanner) {
        this.gerenciador = gerenciador;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n==== Sistema De Cadastro e Gerenciamento De Contatos ====");
            System.out.println("1) Cadastrar contato");
            System.out.println("2) Listar contatos");
            System.out.println("3) Buscar contato por nome");
            System.out.println("4) Editar contato");
            System.out.println("5) Remover contato");
            System.out.println("6) Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> gerenciador.cadastrarContato();
                case 2 -> gerenciador.listarContatos();
                case 3 -> gerenciador.buscarContato();
                case 4 -> gerenciador.editarContato();
                case 5 -> gerenciador.removerContato();
                case 6 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }
}
