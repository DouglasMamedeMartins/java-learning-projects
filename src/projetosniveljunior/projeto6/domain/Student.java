package projetosniveljunior.projeto6.domain;

import java.util.Objects;

public class Student {
    private String name;
    private String registrationNumber;
    private String course;

    public Student(String name, String registrationNumber, String course) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(registrationNumber, student.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(registrationNumber);
    }

    public String toFile() {
        return name + ";" + registrationNumber + ";" + course;
    }

    public static Student fromFile(String line) {
        String[] parts = line.split(";");
        return new Student(parts[0], parts[1], parts[2]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
