package LabOfLamdaStream.src.level2;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class ExamData {

    private String studentName;
    private double testScore;

    public ExamData(String studentName, double testScore) {
        this.studentName = studentName;
        this.testScore = testScore;
    }

    public static void main(String[] args) {
        List<ExamData> data = new ArrayList<ExamData>() {
            private static final long serialVersionUID = 1L;

            {
                add(new ExamData("George", 91.3));
                add(new ExamData("Tom", 88.9));
                add(new ExamData("Rick", 80));
                add(new ExamData("Harold", 90.8));
                add(new ExamData("Ignatius", 60.9));
                add(new ExamData("Anna", 77));
                add(new ExamData("Susan", 87.3));
                add(new ExamData("Phil", 99.1));
                add(new ExamData("Alex", 84));
            }
        };

        DoubleSummaryStatistics doubleSummaryStatistics = data.stream().mapToDouble(score -> score.testScore).summaryStatistics();
        //another way:
        /*  DoubleSummaryStatistics doubleSummaryStatistics = data.stream().mapToDouble(score -> score.testScore)
            .collect(Collectors.summarizingDouble(Double::doubleValue));

         */

        System.out.println("maximum score :" + doubleSummaryStatistics.getMax());
        System.out.println("average score : " + doubleSummaryStatistics.getAverage());
        System.out.println("minimum score : " + doubleSummaryStatistics.getMin());

    }
}

