package projetosniveljunior.projeto6.service;

import projetosniveljunior.projeto6.domain.Student;
import projetosniveljunior.projeto6.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class StudentService {
    StudentRepository repository;
    private final Scanner scanner = new Scanner(System.in);

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    private String readStudentName() {
        System.out.print("Enter the student's name: ");
        String studentName = scanner.nextLine();
        if (studentName.isEmpty()) {
            System.out.println("Student name cannot be empty!");
            return null;
        }
        return studentName;
    }

    private String readRegistrationNumber() {
        System.out.print("Enter registration number: ");
        String registrationNumber = scanner.nextLine();
        if (registrationNumber.isEmpty()) {
            System.out.println("Registration number cannot be empty!");
            return null;
        }
        return registrationNumber;
    }


    private String readCourse() {
        System.out.print("Enter the course: ");
        String course = scanner.nextLine();
        if (course.isEmpty()) {
            System.out.println("Course cannot be empty!");
            return null;
        }
        return course;
    }


    public void addStudent() {
        String name = readStudentName();
        String registrationNumber = readRegistrationNumber();
        String course = readCourse();

        if (name == null || registrationNumber == null || course == null) {
            System.out.println("Data cannot be empty!");
            return;
        }
        Student student = new Student(name, registrationNumber, course);

        repository.create(student);
        System.out.println("Student added successfully!");
    }

    public void listAllStudents() {
        List<Student> students = repository.listAll();
        if (students.isEmpty()) {
            System.out.println("There are not registered students!");
        } else {
            System.out.println("=== Registered Students ===");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void searchByRegistrationNumber() {
        System.out.print("Enter the registration number: ");
        String registrationNumber = scanner.nextLine();
        if (registrationNumber.isEmpty()) {
            System.out.println("Registration Number cannob be empty!");
            return;
        }

        List<Student> found = repository.searchByRegistrationNumber(registrationNumber);

        if (registrationNumber.isEmpty()) {
            System.out.println("Registration number cannot be empty!");
        } else {
            for (Student s : found) {
                System.out.println(s);
            }
        }
    }

    public void editStudent() {
        System.out.print("Enter registration number of student to edit: ");
        String reg = scanner.nextLine();

        List<Student> found = repository.searchByRegistrationNumber(reg);

        if (found.isEmpty()) {
            System.out.println("No student found with this registration number.");
            return;
        }

        Student student = found.get(0);

        System.out.println("Editing student: " + student);
        System.out.print("Enter new name (leaver blank to keep): ");

        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            student.setName(newName);
        }

        System.out.print("Enter new course (leaver blank to keep): ");
        String newCourse = scanner.nextLine();

        if (!newCourse.isEmpty()) {
            student.setCourse(newCourse);
        }

        repository.update(student);
        System.out.println("Student updated successfully!");
    }

    public void deleteStudent() {
        System.out.print("Enter registration number of student to delete: ");
        String reg = scanner.nextLine();

        List<Student> found = repository.searchByRegistrationNumber(reg);

        if (found.isEmpty()) {
            System.out.println("No student found with this registration number.");
            return;
        }

        Student student = found.get(0);

        System.out.println("Are you sure you want to delete this student? ");
        System.out.println(student);
        System.out.print("Type 'yes' to confirm: ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            repository.delete(reg);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Deletion canceled.");
        }
    }
}
