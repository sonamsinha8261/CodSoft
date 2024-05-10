
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int maxAttempts = 10; // Limiting the number of attempts
        int score = 0; // Initialize the user's score
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        Random rand=new Random();


        while (playAgain) {
            
            int randomNumber= rand.nextInt(max)+1;
            int numberOfAttempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI've picked a number between " + min + " and " + max + ".");
            System.out.println("We have " + maxAttempts + " attempts to guess it.");

            while (!hasGuessedCorrectly && numberOfAttempts < maxAttempts) {
                System.out.print("Attempt " + (numberOfAttempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfAttempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly!");
                    hasGuessedCorrectly = true;
                    score += maxAttempts - numberOfAttempts + 1; // Update score based on attempts left
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
           playAgain = playChoice.equals("yes")|| playChoice.equals("y");
             
        }

        System.out.println("\nYour final score is: " + score);
        scanner.close();
    }
}