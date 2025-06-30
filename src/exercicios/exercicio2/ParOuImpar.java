package exercicios.exercicio2;

import java.util.Scanner;

public class ParOuImpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número para ser verificado");
        int numeroParaVerificar = scanner.nextInt();

        if (numeroParaVerificar % 2 == 0) {
            System.out.println("Número par");
        } else {
            System.out.println("Número ímpar");
        }
    }
}
