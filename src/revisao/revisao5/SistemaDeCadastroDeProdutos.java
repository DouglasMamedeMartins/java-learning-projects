package revisao.revisao5;

import revisao.revisao5.domain.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaDeCadastroDeProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        int incrementador = 1;
        List<Produto> produtos = new ArrayList<>();

        do {
            System.out.println("\nBem vindo ao sistema de cadastro de produtos!");
            System.out.println("Digite a opção abaixo para realizar uma operação.");
            System.out.println("1. Cadastrar Um Produto.");
            System.out.println("2. Listar Todos Os Protudos.");
            System.out.println("3. Buscar Um Produto Pelo Nome.");
            System.out.println("4. Sair Do Sistema.");
            System.out.print("Qual operação deseja realizar? ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {
                    Produto produto = new Produto();
                    System.out.print("nome: ");
                    String nome = scanner.nextLine();
                    produto.setNome(nome);

                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    produto.setPreco(preco);
                    scanner.nextLine();

                    System.out.print("quantidade: ");
                    int quantidade = scanner.nextInt();
                    produto.setQuantidade(quantidade);
                    scanner.nextLine();

                    if (produto.getNome().trim().isEmpty() || produto.getNome().matches(".*\\d.*")) {
                        System.out.println("Campo nome está inválido, digite apenas caracteres!");
                    } else if (produto.getPreco() <= 0) {
                        System.out.println("Produto não pode ter valor menor ou igual a 0!");
                    } else if (produto.getQuantidade() <= 0) {
                        System.out.println("Produto não pode ter quantidade menor ou igual a 0");
                    } else {
                        System.out.println("Produto cadastrado com sucesso!");

                    }
                    produtos.add(produto);
                    break;
                }
                case 2: {
                    System.out.println("listar todos os produtos");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto disponivel no momento, faça um cadastro usando a opção 1");
                    }
                    incrementador = 1;
                    for (Produto produto : produtos) {
                        System.out.println("\nProduto: " + incrementador++);
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Preco: " + produto.getPreco());
                        System.out.println("Quantidade: " + produto.getQuantidade());
                        System.out.println();
                    }
                    break;
                }
                case 3: {
                    if (produtos.isEmpty()) {
                        System.out.println("Não tem produtos cadastrados no momento!");
                    }
                    System.out.print("\nDigite o nome do Produto: ");
                    String produtoParaPesquisar = scanner.nextLine();

                    if (produtoParaPesquisar.trim().isEmpty() || produtoParaPesquisar.matches(".*\\d.*")) {
                        System.out.println("Nome não pode estar em branco ou conter números!");
                    }
                    boolean encontrado = false;
                    for (Produto produto : produtos) {
                        if (produto.getNome().equalsIgnoreCase(produtoParaPesquisar)) {
                            System.out.println("Produto encontrado: " + produto.getNome());
                            System.out.println("Preco: " + produto.getPreco());
                            System.out.println("Quantidade: " + produto.getQuantidade());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Sistema encerrado!\nVolte sempre!");
                    break;
                }
                default: {
                    System.out.println("Operação inválida");
                    break;
                }
            }
        }
        while (opcao != 4);
        scanner.close();

    }
}
