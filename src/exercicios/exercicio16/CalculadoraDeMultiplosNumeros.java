package exercicios.exercicio16;

import java.util.Scanner;

public class CalculadoraDeMultiplosNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numero;
        int soma = 0;
        int quantidade = 0;
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        System.out.println("Digite números inteiros(0 para encerrar):");

        while (true) {
            numero = scanner.nextInt();

            if (numero == 0) {
                break;
            }

            soma += numero;

            quantidade++;

            if (numero > maior) {
                maior = numero;
            }

            if (numero < menor) {
                menor = numero;
            }


        }

        if (quantidade > 0) {
            double media = (double) soma / quantidade;
            System.out.println("\nResultado: ");
            System.out.println("Soma: " + soma);
            System.out.println("Quantidade de números: " + quantidade);
            System.out.println("Média: " + media);
            System.out.println("Maior número: " + maior);
            System.out.println("Menor número: " + menor);
        } else {
            System.out.println("Nenhum número foi digitado.");
        }

        scanner.close();
    }
}

