package jpProblems;

import java.util.Arrays;

public class AbstractExam {
    public static void main(String[] args) {

        String allMarks="100 5,100 5,53 5,76 3|0,100,5";
        System.out.println(result(allMarks));
    }

        public static String result (String allMarks){
            double cgpa = 0;
            double gradepoint = 0;
            double gradePointSum = 0;
            double totalGradePoints = 0;
            String[] marks = allMarks.split("[|]");
            System.out.println(Arrays.toString(marks));

            for (int i = 0; i < marks.length; i++) {
                //for subject marks
                if (i == 0) {
                    String[] subjectMarks = marks[i].split(",");
                    System.out.println(Arrays.toString(subjectMarks));

                    for (int j = 0; j < subjectMarks.length; j++) {
                        String[] subjectMarks2 = subjectMarks[j].split(" ");
                        System.out.println(Arrays.toString(subjectMarks2));
                                gradepoint = calgradePoint(Integer.parseInt(subjectMarks2[0].trim()));
                        System.out.println(gradepoint);

                                gradePointSum += (gradepoint * Integer.parseInt(subjectMarks2[1].trim()));
                                totalGradePoints += 5;

                        }
                    }



                //for ncc and sports
                else {
                    String[] NSmarks = marks[i].split(",");
                    if (Integer.parseInt(NSmarks[0].trim())==1) {


                                gradepoint = calgradePoint(Integer.parseInt(NSmarks[1].trim()));


                                gradePointSum += (gradepoint * Integer.parseInt(NSmarks[2].trim()));
                                totalGradePoints += 5;


                    }
                }

            }
            cgpa = gradePointSum / totalGradePoints;

            System.out.println(gradePointSum+" "+totalGradePoints);
            return String.format("%.2f", cgpa);

        }


    private static double calgradePoint(int score){
        if (score >= 75 && score <= 100) {

            int diff=score-75;
            double ans= 9.0 + (double) 1 /25 * diff;

            return Math.round(ans*10.0)/10.0; // Linear interpolation within the range 9.0-10.0
        } else if (score >= 60 && score <= 74) {
            double ans=8.0 +(double)0.9/15 * (score - 60);
            return  Math.round(ans*10.0)/10.0; // Linear interpolation within the range 8.0-8.9
        } else if (score >= 50 && score <= 59) {
            double ans= 7.0 + 0.1 * (score - 50);
            return Math.round(ans*10.0)/10.0;// Linear interpolation within the range 7.0-7.9
        } else if (score >= 40 && score <= 49) {
            double ans= 6.0 + 0.1 * (score - 40);
            return  Math.round(ans*10.0)/10.0; // Linear interpolation within the range 6.0-6.9
        } else {
            return 0.0;
        }

      }
}
