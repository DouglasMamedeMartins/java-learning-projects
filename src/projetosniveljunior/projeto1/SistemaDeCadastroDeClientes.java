package projetosniveljunior.projeto1;

import projetosniveljunior.projeto1.domain.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaDeCadastroDeClientes {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n==== Sistema de Clientes ====");
            System.out.println("1. Cadastrar Clientes");
            System.out.println("2. Listar clientes");
            System.out.println("3. sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.println("Digite o nome do cliente");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o email do cliente");
                    String email = scanner.nextLine();
                    System.out.println("Digite o telefone do cliente");
                    String telefone = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, email, telefone);
                    clientes.add(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                }
                case 2: {
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente está cadastrado!");
                    } else {
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Saindo do sistema!");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (opcao != 3);

        scanner.close();
        System.out.println("Sistema encerrado.");
    }
}
