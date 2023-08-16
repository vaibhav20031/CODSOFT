import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class NumberGuessingGame {
    static{
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Arial",Font.BOLD,25)));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int start = 1;
        int end = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalScore = 0;

        JOptionPane.showMessageDialog(null,"Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int secretNumber = random.nextInt(end - start + 1) + start;
            int attempts = 0;
            int score = 0;

            rounds++;
            JOptionPane.showMessageDialog(null,"Round " + rounds);

            while (attempts < maxAttempts) {
                String no =JOptionPane.showInputDialog(null,"GUESS NO BETWEEN "+start +" TO "+ end);   ///** */
                int guess=Integer.parseInt(no);

                attempts++;

                if (guess < secretNumber) {
                    JOptionPane.showMessageDialog(null,"Too low! Try again.");
                }
                else if (guess > secretNumber) {
                    JOptionPane.showMessageDialog(null,"Too high! Try again.");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Congratulations! You guessed the correct number " + secretNumber + " in " + attempts + " attempts.");
                    score++;
                    break;
                }
            }

            if (attempts == maxAttempts && secretNumber != maxAttempts) {
                JOptionPane.showMessageDialog(null,"Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
            }

            totalScore += score;

            String playAgainResponse =JOptionPane.showInputDialog(null,"Do you want to play again? (yes/no): ");
            playAgain = playAgainResponse.equalsIgnoreCase("yes");

        }

        JOptionPane.showMessageDialog(null,"Game Over! You played " + rounds + " rounds and scored a total of " + totalScore + " points.");
    }
}
