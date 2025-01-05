package org.example.Controller;

import org.example.microServices.StudentService;
import org.example.Model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentController {
    private final StudentService studentService = new StudentService();

    public String listInPersonHistoryStudents() {
        List<Student> students = studentService.getInPersonHistoryStudents();
        if (students.isEmpty()) {
            return "No students found.\n";
        } else {
            System.out.println();
            return  students.stream()
                    .map(Student::toString)
                    .collect(Collectors.joining("\n"));

        }
    }

    public String findStudentById(int id) {
        Student student = studentService.findStudentById(id);
        return student != null ? student.toString() : "Student not found.\n";

    }

    public String findStudentByName(String name) {
        List<Student> students = studentService.findStudentByName(name);
        if (students.isEmpty()) {
            return "No students found.\n";
        } else {
            return students.stream()
                    .map(Student::toString)
                    .collect(Collectors.joining("\n"));

        }
    }
}
