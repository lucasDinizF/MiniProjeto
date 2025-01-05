package org.example.microServices;

import org.example.Model.Discipline;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DisciplineParser implements JsonParser<Discipline> {

    @Override
    public List<Discipline> parse(String responseBody) {
        JSONArray DisciplinesArray = new JSONArray(responseBody);
        List<Discipline> Disciplines = new ArrayList<>();

        for (int i = 0; i < DisciplinesArray.length(); i++) {
            JSONObject disciplineObj = DisciplinesArray.getJSONObject(i);
            Discipline discipline = new Discipline(
                    disciplineObj.getInt("id"),
                    disciplineObj.getString("curso"),
                    disciplineObj.getString("nome")
            );
            Disciplines.add(discipline);
        }
        return Disciplines;
    }
}
