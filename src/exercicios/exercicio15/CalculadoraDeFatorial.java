package exercicios.exercicio15;

import java.util.Scanner;

public class CalculadoraDeFatorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo a Calculadora de Fatorial!");
        System.out.println("Digite um número para verificar o seu fatorial");
        int numeroFatorial = scanner.nextInt();

        if (numeroFatorial < 0) {
            System.out.println("Digite um número válido");
        } else {
            int fatorial = 1;
            System.out.print(numeroFatorial + "! = ");
            for (int i = numeroFatorial; i > 0; i--) {
                fatorial *= i;
                System.out.print(i);
                if (i > 1) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" = ");
                }
            }
            System.out.println(fatorial);
        }
        scanner.close();
    }
}
