package gradeCalculator;

public class    Presentation {

    public Reviewer teacher, team, reviewed;
    private int[] points;

    public Presentation(int dir, String name, int dirRev, String nameRev) {
        if (dir == 23 || dir == 24) {
            teacher = new Teacher(dir, name);
        } else {
            team = new Team(dir, name);
        }
        reviewed = new Team(dirRev, nameRev);
    }

    public Reviewer getReviewer() {
        return (teacher != null) ? teacher : team;
    }

    public void setPoints(int[] points) {
        this.points = points;
    }


    public Reviewer getReviewed() {
        return reviewed;
    }

    public int calculateTotalPoints() {
        int ps = 0;
        if (teacher != null) {
            if (teacher.getId() == 24)
                ps = countgrades();
            else
                ps = calcMultiples();
        } else
            ps = calculateinRatio();

        return ps;
    }

    private int countgrades() {
        int total = 0;
        for (int i : points) {
            total = total + i;
        }
        return total;
    }

    private int calcMultiples() {
        int total = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] != -1) {
                if (i == 0 || i == 2) {
                    total = total + calcDouble(points[i]);
                } else {
                    total = total + calcTripple(points[i]);
                }
            }
        }
        return total;
    }

    public int calculateinRatio() {
        int ps;
        if (points[5] == -1) //Max 70 punten
            ps = (calcMultiples() * 100) / 70;
        else // Max 85 punten
            ps = (calcMultiples() * 100) / 85;
        return ps;
    }

    private int calcTripple(int point) {
        return point * 3;
    }

    private int calcDouble(int point) {
        return point * 2;
    }
}
