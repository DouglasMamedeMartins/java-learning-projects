package revisao.revisao4;

import revisao.revisao4.domain.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroDeNomes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();
        int opcao = 0;
        boolean encontrado;

        while (opcao != 4) {
            System.out.println("Bem vindo ao sistema de cadastro!");
            System.out.println("1. Cadastrar.");
            System.out.println("2. Listar todos.");
            System.out.println("3. Pesquisar.");
            System.out.println("4. Sair.");
            System.out.print("Qual opção deseja ? ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    Pessoa pessoa = new Pessoa();
                    pessoa.setNome(nome);
                    pessoas.add(pessoa);
                    System.out.println();
                    continue;
                }
                case 2: {
                    System.out.println("\n--- Lista de pessoas cadastradas ---");
                    if (pessoas.isEmpty()) {
                        System.out.println("Não tem pessoas cadastrados\n");

                    } else {
                        for (Pessoa p : pessoas) {
                            System.out.println(p.getNome());
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.print("Digite o nome da pessoa: ");
                    String nomePesquisado = scanner.nextLine();
                    encontrado = false;

                    for (Pessoa pessoa : pessoas) {
                        if (pessoa.getNome().equalsIgnoreCase(nomePesquisado)) {
                            System.out.println("Nome encontrado: " + pessoa.getNome());
                            System.out.println();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Nome não encontrado!");
                        System.out.println();
                    }
                    break;
                }
                case 4: {
                    System.out.println("Sistema encerrado!");
                    return;
                }

                default: {
                    System.out.println("Opção inválida");
                }
            }
        }
        scanner.close();
    }


}
