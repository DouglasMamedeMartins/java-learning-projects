package revisao.revisao1;

import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double resultado;

        System.out.print("Digite o primeiro número: ");

        int numero1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");

        int numero2 = scanner.nextInt();

        System.out.print("Digite a operação: ");

        String operacao = scanner.next();

        if (operacao.equals("+")) {
            resultado = numero1 + numero2;
            System.out.print("Resultado: " + resultado);
        } else if (operacao.equals("-")) {
            resultado = numero1 - numero2;
            System.out.print("Resultado: " + resultado);
        } else if (operacao.equals("*")) {
            resultado = numero1 * numero2;
            System.out.print("Resultado: " + resultado);
        } else if (operacao.equals("/")) {
            if (numero2 == 0) {
                System.out.println("Não é possivel dividir por 0");
            } else {
                resultado = (double) numero1 / numero2;
                System.out.print("Resultado: " + resultado);
            }

        } else {
            System.out.println("Operação inválida");
        }
        scanner.close();
    }
}
