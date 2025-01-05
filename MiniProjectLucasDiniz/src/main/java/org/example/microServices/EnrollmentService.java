package org.example.microServices;

import org.example.Model.Student;
import org.example.Model.Discipline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentService {
    private final Map<Integer, List<Discipline>> enrollments;

    public EnrollmentService() {

        this.enrollments = new HashMap<>();

    }

    public boolean enrollStudent(Student student, Discipline discipline) {
        if ("ativo".equalsIgnoreCase(student.getStatus())) {
             if ("presencial".equalsIgnoreCase(student.getModality())){
                if ("História".equalsIgnoreCase(student.getCourse())) {
                    if ("História".equalsIgnoreCase(discipline.getCourse())) {

                        enrollments.computeIfAbsent(student.getId(), k -> new ArrayList<>()).add(discipline);

                    }
                }
            }
            return true;
        }
        return false;
    }

    public List<Discipline> listEnrolledDisciplines(int studentId) {
        return enrollments.getOrDefault(studentId, new ArrayList<>());
    }

    public boolean removeDiscipline(int studentId, int disciplineId) {
        List<Discipline> enrolledDisciplines = enrollments.get(studentId);
        if (enrolledDisciplines != null) {
            return enrolledDisciplines.removeIf(discipline -> discipline.getId() == disciplineId);
        }
        return false;
    }
}
