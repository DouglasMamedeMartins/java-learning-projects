package exercicios.exercicio13;

import java.util.Scanner;

public class VerificadorDeNumeroPrimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao programa verificador de número primo");
        System.out.println("Digite um número para ser verificado: ");
        int numeroParaVerificar = scanner.nextInt();
        boolean ehPrimo = true;

        if (numeroParaVerificar <= 1) {
            ehPrimo = false;
        } else {
            for (int i = 2; i < numeroParaVerificar; i++) {
                if (numeroParaVerificar % i == 0) {
                    ehPrimo = false;
                    break;
                }
            }
        }

        if (ehPrimo) {
            System.out.println(numeroParaVerificar + " é um número primo!");
        } else {
            System.out.println(numeroParaVerificar + " não é um número primo");
        }

        scanner.close();
    }
}
