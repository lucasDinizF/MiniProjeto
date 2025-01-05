package org.example.Model;

public class Student {
    private int id;
    private String name;
    private String course;
    private String modality;
    private String status;

    public Student(int id, String name, String course, String modality, String status) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.modality = modality;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getModality() {
        return modality;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return  "id: " + id + "\n" + "Name: " +  name + "\n" + "Course: " +  course + "\n" + "Modality: " +  modality + "\n" +  "Status: " + status + "\n";
    }
}
