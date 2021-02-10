package gradeCalculator;

public class Reviewer {
    private int id;
    private String name;
    private int[] givenGrades;


    public Reviewer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getGivenGrades() {
        return givenGrades;
    }

    public void setGivenGrades(int[] givenGrades) {
        this.givenGrades = givenGrades;
    }
}
