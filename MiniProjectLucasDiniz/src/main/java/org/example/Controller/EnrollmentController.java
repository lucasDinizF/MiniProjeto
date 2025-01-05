package org.example.Controller;

import org.example.Model.Student;
import org.example.Model.Discipline;
import org.example.microServices.EnrollmentService;
import org.example.microServices.StudentService;

import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    private final StudentService studentService;
    DisciplineController disciplineController = new DisciplineController();

    public EnrollmentController() {
        this.enrollmentService = new EnrollmentService();
        this.studentService = new StudentService();

    }

    public String enrollStudent(int studentId, int disciplineId) {
        Student student = studentService.findStudentById(studentId);
        if (student != null && "ativo".equalsIgnoreCase(student.getStatus())) {
            Discipline selectedDiscipline = disciplineController.findDisciplineById(disciplineId);

            if (selectedDiscipline != null) {
                if (enrollmentService.enrollStudent(student, selectedDiscipline)) {
                    return "Enrollment successful.\n";
                } else {
                    return "Enrollment could not be completed.\n";
                }
            } else {
                return "Discipline not found.\n";
            }
        } else {
            return "Student not found or not active.\n";
        }
    }

    public String listEnrolledDisciplines(int studentId) {
        List<Discipline> disciplines = enrollmentService.listEnrolledDisciplines(studentId);
        return disciplines.isEmpty()
                ? "No disciplines found for the student.\n"
                : disciplines.stream().map(Discipline::toString).collect(Collectors.joining("\n"));
    }

    public String removeEnrolledDiscipline(int studentId, int disciplineId) {
        boolean success = enrollmentService.removeDiscipline(studentId, disciplineId);
        return success ? "Discipline successfully removed.\n" : "Could not remove discipline.\n";
    }
}
