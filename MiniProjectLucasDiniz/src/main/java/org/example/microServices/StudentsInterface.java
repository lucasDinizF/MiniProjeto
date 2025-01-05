package org.example.microServices;


import org.example.Model.Student;

import java.util.List;

public interface StudentsInterface {
    void getRefreshStudents();
    List<Student> getInPersonHistoryStudents();


}
