import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        int totalScore = 0;

        System.out.println("WELCOME TO THE NUMBER GUESSING GAME ");

        boolean playAgain = true;

        while (playAgain) {
            totalRounds++;
            int secretNumber = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds + " begins!");
            System.out.println("Guess a number between " + MIN + " and " + MAX);
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();
                attemptsLeft--;

                if (guess == secretNumber) {
                    guessedCorrectly = true;
                    roundsWon++;
                    int roundScore = attemptsLeft * 10 + 50;
                    totalScore += roundScore;

                    System.out.println(" Correct! You guessed the number.");
                    System.out.println("Attempts remaining: " + attemptsLeft);
                    System.out.println("Round Score: " + roundScore);
                    break;
                } 
                else if (guess > secretNumber) {
                    System.out.println(" Too High!");
                } 
                else {
                    System.out.println(" Too Low!");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n You've run out of attempts.");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            scanner.nextLine(); // clear buffer
            String choice = scanner.nextLine().toLowerCase();

            playAgain = choice.equals("yes");
        }

        System.out.println("\n GAME SUMMARY ");
        System.out.println("Total Rounds Played : " + totalRounds);
        System.out.println("Rounds Won          : " + roundsWon);
        System.out.println("Total Score         : " + totalScore);

        System.out.println("\nThank you for playing! ");
        scanner.close();
    }
}
