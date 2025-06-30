package projetosniveljunior.projeto6.repository;

import projetosniveljunior.projeto6.domain.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public static final String FILE_NAME = "data/student.txt";

    public void create(Student student) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(student.toFile() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> listAll() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromFile(line);
                if (student != null) {
                    students.add(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public List<Student> searchByRegistrationNumber(String registrationNumber) {
        List<Student> found = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromFile(line);
                if (student.getRegistrationNumber().equals(registrationNumber)) {
                    found.add(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return found;
    }

    public void update(Student updatedStudent) {
        List<Student> updatedList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Student student = Student.fromFile(line);
                if (student.getRegistrationNumber().equals(updatedStudent.getRegistrationNumber())) {
                    updatedList.add(updatedStudent);
                } else {
                    updatedList.add(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(FILE_NAME, false)) {
            for (Student s : updatedList) {
                writer.write(s.toFile() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String registrationNumber) {
        List<Student> updatedList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromFile(line);
                if (!student.getRegistrationNumber().equals(registrationNumber)) {
                    updatedList.add(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(FILE_NAME, false)) {
            for (Student s : updatedList) {
                writer.write(s.toFile() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}