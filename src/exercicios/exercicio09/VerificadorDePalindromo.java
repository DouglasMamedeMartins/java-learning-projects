package exercicios.exercicio09;

import java.util.Scanner;

public class VerificadorDePalindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a palavra: ");
        String palavra = scanner.nextLine();
        String palavraInvertida = new StringBuilder(palavra).reverse().toString();

        if (palavra.equals(palavraInvertida)) {
            System.out.println("É um palíndromo!");
        } else {
            System.out.println("Não é um palíndromo");
        }
    }
}
