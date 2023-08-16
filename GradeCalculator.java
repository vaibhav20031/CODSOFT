import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Scanner;

public class GradeCalculator {
    static{
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Arial",Font.BOLD,25)));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String no =JOptionPane.showInputDialog(null,"ENTER THE NO OF SUBJECTS");   ///** */
        int numSubjects=Integer.parseInt(no);

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {

            String sub_marks =JOptionPane.showInputDialog(null,"Enter marks obtained in subject " + (i + 1) + ": ");   ///** */
            marks[i]=Integer.parseInt(sub_marks);
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        String grade;

        if (averagePercentage >= 90) {
            grade = "A";
        }
        else if (averagePercentage >= 75) {
            grade = "B";
        }
        else if (averagePercentage >= 60) {
            grade = "C";
        }
        else if (averagePercentage >= 50) {
            grade = "D";
        }
        else {
            grade = "F";
        }

        JOptionPane.showMessageDialog(null,"Total Marks: " + totalMarks);
        JOptionPane.showMessageDialog(null,"Average Percentage: " + averagePercentage + "%");
        JOptionPane.showMessageDialog(null,"Grade: " + grade);

        scanner.close();
    }
}
