package exercicios.exercicio20;

import java.util.Scanner;

public class ValidadorDeSenhaForte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;
        boolean temEspecial = false;

        System.out.println("Digite uma senha para validar: ");

        String senha = scanner.nextLine();

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);

            if (senha.length() < 8) {
                System.out.println("Senha deve conter pelo menos 8 caractares.");
                return;
            } else if (!Character.isLowerCase(c)) {
                System.out.println("Senha deve ter pelo menos uma letra maiuscula");
                return;
            } else if (!Character.isUpperCase(c)) {
                System.out.println("Senha deve ter pelo menos uma letra minuscula");
                return;
            } else if (!Character.isDigit(c)) {
                System.out.println("Senha deve ter pelo menos um número");
            } else {
                temMaiuscula = true;
                temMinuscula = true;
                temNumero = true;
                temEspecial = true;

            }
        }

        if (senha.length() >= 8 && temMaiuscula && temMinuscula && temEspecial && temNumero) {
            System.out.println("Senha forte");
        } else {
            System.out.println("Senha fraca");
        }
        scanner.close();
    }
}
