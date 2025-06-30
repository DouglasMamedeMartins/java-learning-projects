package exercicios.exercicio10;

import java.util.Scanner;

public class mediaEmaiorValorComArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos números você deseja digitar? ");
        int quantidadeDesejada = scanner.nextInt();


        int[] numerosArmazenados = new int[quantidadeDesejada];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;

        for (int i = 0; i < quantidadeDesejada; i++) {
            System.out.println("Digite o " + (i + 1) + " número para verificar a média e o maior");
            numerosArmazenados[i] = scanner.nextInt();
            soma += numerosArmazenados[i];

            if (numerosArmazenados[i] > maiorNumero) {
                maiorNumero = numerosArmazenados[i];
            }
        }

        double media = (double) soma / quantidadeDesejada;

        System.out.println("A média dos números informados é: " + media);
        System.out.println("O maior número informado é : " + maiorNumero);
        scanner.close();
    }
}
