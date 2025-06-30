package exercicios.exercicio08;

import java.util.Scanner;

public class JogoDeAdivinhacaoComNumeroAleatorio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = (int) (Math.random() * 10) + 1;
        int tentativas = 0;
        int numeroAdivinhado;

        System.out.println("Jogo de Adivinhação Com Números Aleatórios");
        do {
            System.out.println("Tente adivinhar o número entre 1 e 10: ");
            numeroAdivinhado = scanner.nextInt();

            if (numeroAdivinhado == numeroSecreto) {
                tentativas++;
                System.out.println("Parabéns você acertou em: " + tentativas + " tentativas");
            } else {
                System.out.println("Errado!");
                tentativas++;
            }
        } while (numeroSecreto != numeroAdivinhado);
    }
}
