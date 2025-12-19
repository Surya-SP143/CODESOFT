import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("STUDENT GRADE CALCULATOR");

        System.out.print("Enter number of subjects: ");
        int subjectCount = sc.nextInt();
        sc.nextLine(); // clear buffer

        if (subjectCount <= 0) {
            System.out.println("Invalid number of subjects!");
            
        }

        int totalMarks = 0;

        for (int i = 1; i <= subjectCount; i++) {

            System.out.print("\nEnter name of Subject " + i + ": ");
            String subjectName = sc.nextLine();

            int marks;
            while (true) {
                System.out.print("Enter marks for " + subjectName + " (0-100): ");
                marks = sc.nextInt();

                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println(" Marks must be between 0 and 100!");
                }
            }

            totalMarks += marks;
            sc.nextLine(); // clear buffer
        }

        double average = (double) totalMarks / subjectCount;
        String grade = calculateGrade(average);

        System.out.println("\n RESULT SUMMARY ");
        System.out.println("Total Marks        : " + totalMarks);
        System.out.printf("Average Percentage : %.2f%%\n", average);
        System.out.println("Grade              : " + grade);

        sc.close();
    }

    private static String calculateGrade(double percentage) {

        if (percentage >= 90) return "A+ (Outstanding)";
        else if (percentage >= 80) return "A (Excellent)";
        else if (percentage >= 70) return "B (Very Good)";
        else if (percentage >= 60) return "C (Good)";
        else if (percentage >= 50) return "D (Average)";
        else return "F (Fail)";
    }
}
