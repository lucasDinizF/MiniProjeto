package org.example.Model;

public class Discipline {
    private int id;
    private String name;
    private String course;

    public Discipline(int id, String course, String name) {
        this.id = id;
        this.name = name;
        this.course = course;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String toString() {

        return "id: " +  id + "\n" + "Name: " +  name + "\n" + "Course: " +  course + " \n ";
    }
}
