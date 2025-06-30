package revisao.revisao2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuComRepeticao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("1. Dizer Bom dia");
            System.out.println("2. Mostrar horário");
            System.out.println("3. sair");
            System.out.println("Escolha uma opção");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("Bom dia.");
                    break;
                }
                case 2: {
                    LocalTime agora = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    System.out.println("horário atual: " + agora.format(formatter));
                    break;
                }
                case 3: {
                    System.out.println("Sistema encerrado!");
                    break;
                }
                default: {
                    System.out.println("Opção inválida");
                    break;
                }
            }
        }
    }
}
