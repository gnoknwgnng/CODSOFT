import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    public static int playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attemptsAllowed = 5;
        int attemptsTaken = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Can you guess it?");
        System.out.println("You have " + attemptsAllowed + " attempts to guess correctly.");

        while (attemptsTaken < attemptsAllowed) {
            System.out.print("Attempt " + (attemptsTaken + 1) + ": Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int guess = scanner.nextInt();
            attemptsTaken++;

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the correct number in " + attemptsTaken + " attempts.");
                return attemptsAllowed - attemptsTaken + 1; // Score based on remaining attempts
            } else if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
        return 0; // No score if the user didn't guess correctly
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int roundsPlayed = 0;

        while (true) {
            int score = playGame(scanner);
            totalScore += score;
            roundsPlayed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over! You played " + roundsPlayed + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }
}
