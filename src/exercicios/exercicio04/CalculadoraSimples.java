package exercicios.exercicio04;

import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {
        float total;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora Simples");

        System.out.println();

        System.out.println("Digite o primeiro número: ");

        float numero1 = scanner.nextFloat();

        System.out.println("Digite o segundo número: ");

        float numero2 = scanner.nextFloat();

        System.out.println("Digite a operação (+, -, *, /)");

        String operador = scanner.next();

        if (operador.equals("+")) {
            total = numero1 + numero2;
            System.out.println("Como escolheu a operação + a soma é: " + total);
        } else if (operador.equals("-")) {
            total = numero1 - numero2;
            System.out.println("Como escolheu a operação - a subtração é: " + total);
        } else if (operador.equals("*")) {
            total = numero1 * numero2;
            System.out.println("Como escolheu a operação * a multiplicação é: " + total);
        } else if (operador.equals("/")) {
            if (numero2 == 0) {
                System.out.println("Não é possível dividir por zero");
            } else {
                total = numero1 / numero2;
                System.out.println("Como escolheu a operação / a divisão é: " + total);
            }
        } else {
            System.out.println("Operador inválido");
        }
    }
}
