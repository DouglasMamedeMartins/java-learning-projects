package exercicios.exercicio05;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int contador = scanner.nextInt();

        for (int i = 1; i <= contador; i++) {
            System.out.println(i);
        }
    }
}
