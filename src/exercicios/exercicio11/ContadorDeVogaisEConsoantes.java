package exercicios.exercicio11;

import java.util.Scanner;

public class ContadorDeVogaisEConsoantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vogais = 0;
        int consoantes = 0;

        System.out.println("Bem vindo ao programa de caça vogais e consoantes");
        System.out.println("Digite uma palavra ou frase para verificar!");
        String palavraOuFrase = scanner.nextLine();

        for (int i = 0; i < palavraOuFrase.length(); i++) {

            char letras = palavraOuFrase.toLowerCase().charAt(i);
            if (Character.isLetter(letras)) {
                if (letras == 'a' || letras == 'e' || letras == 'i' || letras == 'o' || letras == 'u') {
                    vogais += 1;
                } else {
                    consoantes += 1;
                }
            }
        }
        System.out.println("Vogais " + vogais);
        System.out.println("Consoantes " + consoantes);
        scanner.close();
    }
}
