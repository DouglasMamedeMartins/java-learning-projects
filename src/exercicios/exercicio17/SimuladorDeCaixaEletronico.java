package exercicios.exercicio17;

import java.util.Scanner;

public class SimuladorDeCaixaEletronico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor do saque (múltiplo de 10): ");
        int valor = scanner.nextInt();

        if (valor <= 0 || valor % 10 != 0) {
            System.out.println("Valor inválido. Digite um valor positivo e múltiplo de 10.");
        } else {
            int notas100, notas50, notas20, notas10;

            notas100 = valor / 100;
            valor = valor % 100;

            notas50 = valor / 50;
            valor = valor % 50;

            notas20 = valor / 20;
            valor = valor % 20;

            notas10 = valor / 10;

            System.out.println("Notas entregues: ");
            if (notas100 > 0) System.out.println(notas100 + " nota(s) de R$100");
            if (notas50 > 0) System.out.println(notas50 + " nota(s) de R$50");
            if (notas20 > 0) System.out.println(notas20 + " nota(s) de R$20");
            if (notas10 > 0) System.out.println(notas10 + " nota(s) de R$10");
        }
        scanner.close();
    }
}
