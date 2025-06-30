package revisao.revisao3;

import revisao.revisao3.domain.Aluno;

import java.util.Scanner;

public class MediaDeNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = new Aluno();
        double media;

        System.out.println("Programa de média de notas.");
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        if (nome.isEmpty()) {
            System.out.println("Nome não pode estar vazio");
            return;
        }
        aluno.setNome(nome);
        System.out.print("Digite a nota1: ");
        double nota1 = scanner.nextDouble();
        aluno.setNota1(nota1);
        System.out.print("Digite a nota2: ");

        double nota2 = scanner.nextDouble();
        aluno.setNota2(nota2);
        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
            System.out.println("Notas devem estar entre 0 e 10.");
            return;
        }

        media = (aluno.getNota1() + aluno.getNota2()) / 2;
        System.out.printf("Média de %s é: %.2f%n", aluno.getNome(), media);
        scanner.close();

    }
}