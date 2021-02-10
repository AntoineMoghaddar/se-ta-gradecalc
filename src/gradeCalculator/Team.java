package gradeCalculator;

public class Team extends Reviewer {
    private static final int WEIGHT = 30;

    private int grade;

    public Team(int id, String name) {
        super(id, name);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
