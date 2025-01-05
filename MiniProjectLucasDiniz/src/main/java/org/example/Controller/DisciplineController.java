package org.example.Controller;

import org.example.Model.Discipline;
import org.example.microServices.DisciplineService;

import java.util.List;

public class DisciplineController {
    private final DisciplineService disciplineService;

    public DisciplineController() {
        this.disciplineService = new DisciplineService();

    }

    public void showDisciplines() {
        List<Discipline> disciplines = disciplineService.listDisciplines();
        System.out.println("\nDisciplines available for enrollment:");
        disciplines.forEach(System.out::println);

    }

    public Discipline findDisciplineById(int disciplineId) {
        return disciplineService.findDisciplineById(disciplineId);

    }


}

