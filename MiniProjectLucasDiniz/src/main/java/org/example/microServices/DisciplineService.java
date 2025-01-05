package org.example.microServices;

import org.example.Model.Discipline;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisciplineService implements DisciplinesInterfaces{
    private final String endpoint = "https://sswfuybfs8.execute-api.us-east-2.amazonaws.com/disciplinaServico/msDisciplina";
    private final HttpClient client = HttpClient.newHttpClient();
    private final DisciplineParser parser = new DisciplineParser();

    private final Map<Integer, Discipline> disciplineMap = new HashMap<>();
    private boolean cacheInitialized = false;

    public DisciplineService() {
        getRefreshDisciplines();
    }


    public void getRefreshDisciplines() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Discipline> disciplines = parser.parse(response.body());


            disciplineMap.clear();
            for (Discipline discipline : disciplines) {
                disciplineMap.put(discipline.getId(), discipline);
            }
            cacheInitialized = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Discipline> listDisciplines() {
        if (!cacheInitialized) {
            getRefreshDisciplines();
        }
        return new ArrayList<>(disciplineMap.values());
    }


    public Discipline findDisciplineById(int disciplineId) {
        if (!cacheInitialized) {
            getRefreshDisciplines();
        }
        return disciplineMap.get(disciplineId);
    }
}
