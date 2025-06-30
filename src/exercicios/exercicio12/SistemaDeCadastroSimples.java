package exercicios.exercicio12;

import java.util.Scanner;

public class SistemaDeCadastroSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema de cadastro simples!");

        System.out.println("Quantos usuários deseja cadastrar? ");
        int quantidadeDeUsuarios = scanner.nextInt();
        scanner.nextLine();

        String[] usuarios = new String[quantidadeDeUsuarios];

        for (int i = 0; i < quantidadeDeUsuarios; i++) {
            System.out.println("Digite o " + (i + 1) + "º nome: ");
            usuarios[i] = scanner.nextLine();
        }

        System.out.println("Nomes cadastrados :");
        for (int i = 0; i < quantidadeDeUsuarios; i++) {
            System.out.println("- " + usuarios[i]);
        }
        scanner.close();
    }
}
