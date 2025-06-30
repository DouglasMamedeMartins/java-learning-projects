package exercicios.exercicio06;

import java.util.Scanner;

public class TabuadaDeUmNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total;
        System.out.println("Digite um número: ");
        int numero = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            total = numero * i;
            System.out.printf("%d" + " x " + "%d" + " = " + "%d", numero, i, total);
            System.out.println();
        }
    }
}
