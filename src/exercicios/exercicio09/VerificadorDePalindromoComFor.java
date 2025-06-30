package exercicios.exercicio09;

import java.util.Scanner;

public class VerificadorDePalindromoComFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma palavra: ");

        String palavra = scanner.nextLine();
        String invertida = "";

        for (int i = palavra.length() - 1; i >= 0; i--) {
            invertida += palavra.charAt(i);
        }

        if (palavra.equalsIgnoreCase(invertida)) {
            System.out.println("É um palíndromo!");
        } else {
            System.out.println("Não é um palíndromo");
        }
        scanner.close();
    }
}
