package gradeCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GraderModel {

    ArrayList<Presentation> presentations;
    HashMap<String, Integer> finalGrades;

    public void run() {
        presentations = new ArrayList<>();
        readFromFile("segradess.txt");
        finalGrades();
        printFinals();
    }

    public void finalGrades() {
        finalGrades = new HashMap<>();
        for (Presentation p : presentations) {
            System.out.println(p.calculateTotalPoints() + "," + p.getReviewed().getName() + "," + p.getReviewer().getName());

            if (finalGrades.containsKey(p.getReviewed().getName())) {
                finalGrades.replace(p.getReviewed().getName(),
                        (finalGrades.get(p.getReviewed().getName())
                                + ((p.getReviewer() instanceof Teacher) ? 35 * p.calculateTotalPoints() : 30 * p.calculateTotalPoints())));
            } else {
                finalGrades.put(p.getReviewed().getName(), (p.getReviewer() instanceof Teacher) ? 35 * p.calculateTotalPoints() : 30 * p.calculateTotalPoints());
            }
        }
    }

    public void printFinals() {
        Iterator it = finalGrades.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + "," + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public void readFromFile(String filename) {
        try {
            Scanner in = new Scanner(new File(filename));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (!(line.startsWith("#")) && !(line.isEmpty())) {
                    presentations.add(processLine(line));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Presentation processLine(String line) {
        Presentation p = null;
        String[] lineData = line.split(",");
        if (line.isEmpty()) {
            System.out.println("No data found.");
        }

        if (lineData.length > 1) {
            p = new Presentation(Integer.parseInt(lineData[0]), lineData[1],
                    Integer.parseInt(lineData[2]), lineData[3]);
            p.setPoints(new int[]{Integer.parseInt(lineData[4]),
                    Integer.parseInt(lineData[5]),
                    Integer.parseInt(lineData[6]),
                    Integer.parseInt(lineData[7]),
                    Integer.parseInt(lineData[8]),
                    Integer.parseInt(lineData[9])});
        }
        return p;
    }

    public static void main(String[] args) {
        new GraderModel().run();
    }
}
