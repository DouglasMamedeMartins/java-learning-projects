package exercicios.exercicio03;

import java.util.Scanner;

public class VerificadorDeMaioridade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua idade para verificar se é maior de idade ou menor");
        int idade = scanner.nextInt();

        if (idade < 18) {
            System.out.println("Você é menor de idade");
        } else {
            System.out.println("Você é maior de idade");
        }
    }
}
