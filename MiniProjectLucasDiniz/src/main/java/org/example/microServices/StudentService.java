package org.example.microServices;

import org.example.Model.Student;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService implements StudentsInterface {
    private final String endpoint = "https://rmi6vdpsq8.execute-api.us-east-2.amazonaws.com/msAluno";
    private final HttpClient client = HttpClient.newHttpClient();
    private final StudentParser parser = new StudentParser();

    private final List<Student> cachedStudents = new ArrayList<>();
    private boolean cacheInitialized = false;

    public StudentService() {
        getRefreshStudents();
    }


    public void getRefreshStudents() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Student> students = parser.parse(response.body());

            cachedStudents.clear();
            cachedStudents.addAll(students);
            cacheInitialized = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Student> getStudents() {
        if (!cacheInitialized) {
            getRefreshStudents();
        }
        return new ArrayList<>(cachedStudents);
    }


    public List<Student> getInPersonHistoryStudents() {
        return getStudents().stream()
                .filter(student -> "História".equalsIgnoreCase(student.getCourse()) && "presencial".equalsIgnoreCase(student.getModality()))
                .collect(Collectors.toList());
    }


    public Student findStudentById(int id) {
        return getStudents().stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public List<Student> findStudentByName(String name) {
        return getStudents().stream()
                .filter(student -> student.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
