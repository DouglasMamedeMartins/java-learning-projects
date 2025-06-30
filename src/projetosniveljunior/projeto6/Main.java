package projetosniveljunior.projeto6;

import projetosniveljunior.projeto6.repository.StudentRepository;
import projetosniveljunior.projeto6.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n==== Student System ====");
            System.out.println("1) Register student");
            System.out.println("2) List All Students");
            System.out.println("3) Search by registration number");
            System.out.println("4) Edit student");
            System.out.println("5) Remove student");
            System.out.println("6) Exit");

            System.out.print("Enter an option: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> service.addStudent();
                case 2 -> service.listAllStudents();
                case 3 -> service.searchByRegistrationNumber();
                case 4 -> service.editStudent();
                case 5 -> service.deleteStudent();
                case 6 -> System.out.println("System closed!");
                default -> System.out.println("Invalid option");
            }

        } while (opcao != 6);

        scanner.close();
    }
}
