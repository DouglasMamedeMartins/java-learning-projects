package projetosniveljunior.projeto5;

import projetosniveljunior.projeto5.repository.BookRepository;
import projetosniveljunior.projeto5.service.BookService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Bem vindo ao sistema de Cadastro de Livros");
            System.out.println("1) Cadastrar livro");
            System.out.println("2) Listar livros");
            System.out.println("3) Buscar livro por título");
            System.out.println("4) Editar livro");
            System.out.println("5) Remover livro");
            System.out.println("6) Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> service.create();
                case 2 -> service.listAll();
                case 3 -> service.search();
                case 4 -> service.editBook();
                case 5 -> service.removeBook();
                case 6 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }


        } while (opcao != 6);

        scanner.close();
    }
}
