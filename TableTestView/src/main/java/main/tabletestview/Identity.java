package main.tabletestview;

public class Identity {
    private String name;
    private int id;
    private double cgpa;
    private String university;
    private int age;
    private String nationality;

    public Identity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setPhone(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Identity(String name, int id, double cgpa, String university, int age, String nationality) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
        this.university = university;
        this.age = age;
        this.nationality = nationality;
    }


}
