package org.example.microServices;

import org.example.Model.Student;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class StudentParser implements JsonParser<Student> {

    @Override
    public List<Student> parse(String responseBody) {
        JSONArray studentsArray = new JSONArray(responseBody);
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < studentsArray.length(); i++) {
            JSONObject studentObj = studentsArray.getJSONObject(i);
            Student student = new Student(
                    studentObj.getInt("id"),
                    studentObj.getString("nome"),
                    studentObj.getString("curso"),
                    studentObj.getString("modalidade"),
                    studentObj.getString("status")
            );
            students.add(student);
        }
        return students;
    }
}
