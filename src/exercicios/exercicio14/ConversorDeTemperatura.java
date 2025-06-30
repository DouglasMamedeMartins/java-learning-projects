package exercicios.exercicio14;

import java.util.Scanner;

public class ConversorDeTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float conversao;

        System.out.println("Bem vindo ao programa de conversão de temperatura");
        System.out.println("Por gentileza informe a temperatura em C ou F para que possa ser convertido!");
        float temperatura = scanner.nextFloat();

        System.out.println("Agora digite a unidade de origem: ");
        String unidadeDeOrigem = scanner.next();

        if (unidadeDeOrigem.equalsIgnoreCase("c")) {
            conversao = (temperatura * 9 / 5) + 32;
            System.out.printf("%.1f°C é igual a %.1f°F%n", temperatura, conversao);
        } else if (unidadeDeOrigem.equalsIgnoreCase("f")) {
            conversao = (temperatura - 32) * 5 / 9;
            System.out.printf("%.1f°F é igual a %.1f°C%n", temperatura, conversao);
        } else {
            System.out.println("Unidade inválida. Por favor digite apenas C ou F.");
        }

        scanner.close();
    }
}
