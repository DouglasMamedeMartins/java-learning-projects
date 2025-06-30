package exercicios.exercicio07;

import java.util.Scanner;

public class JogoDeAdivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = 5;
        int tentativa;
        int chances = 3;

        System.out.println("Jogo de Adivinhação");
        System.out.println("Você tem apenas 3 chances");

        do {
            System.out.println("Tente adivinhar o número: ");
            tentativa = scanner.nextInt();

            if (tentativa == numeroSecreto) {
                System.out.println("Parabéns você acertou!");
            } else {
                System.out.println("Errado! Tente novamente");
                chances--;
                System.out.println("Você tem apenas: " + chances + " chances");
            }
            if (chances == 0) {
                System.out.println("Suas chances acabaram. o número era: " + numeroSecreto);
                return;
            }
        } while (tentativa != numeroSecreto);

        scanner.close();
    }
}
