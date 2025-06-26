import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {

    // Method containig the game logic, input validation, and feedback
    public int gameLogic(int rNum, Scanner sc) {
        int guess;
        int attempts = 0;
        System.out.println("+---------------------------------------------------+");
        System.out.println("        Guess a number between 1 and 100");
        System.out.println("+---------------------------------------------------+");

        // Loop until the user is right, with exception handling like input mismatch and range checking
        while (true) {
            try {
                System.out.print("Guess: ");
                guess = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.\n");
                sc.next(); // Clear the invalid input
                continue;
            }
            
            if (guess < 1 || guess > 100) {  // range check
                System.out.println("Please enter a number between 1 and 100\n"); 
                continue;
            }
            attempts++; // Attempts increment to keep track of the number of guesses

            int diff = Math.abs(guess - rNum); // to check closeness of the guess

            if (guess == rNum) {
                System.out.println("\n+---------------------------------------------------+");
                System.out.println("  Congratulations you've guessed the right number!!\n");
                System.out.printf("               Number %d in %d attempts\n", rNum, attempts);
                System.out.println("+---------------------------------------------------+");
                break;
            }

            // Feedback based on the user's guess
            if (guess < rNum) {
                if (diff < 10) {
                    System.out.println("Low, but close!\n");
                } else if (diff < 30) {
                    System.out.println("Low\n");
                } else if (diff < 50) {
                    System.out.println("Very Low!\n");
                } else {
                    System.out.println("Way off!\n");
                }
            }
            if (guess > rNum) {
                if (diff < 10) {
                    System.out.println("High, but close!\n");
                } else if (diff < 30) {
                    System.out.println("High\n");
                } else if (diff < 50) {
                    System.out.println("Very High\n");
                } else {
                    System.out.println("Way off!\n");
                }
            }
        }
        return attempts; // Returns the number of attempts made to guess the number
    }

    // Main method begins here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userChoice;
        int highScore = Integer.MAX_VALUE;
        GuessNumber game = new GuessNumber();

        // Loop to check if the user wants to play again
        do {
            int rNum = (int) (Math.random() * 100) + 1;     // Random number between 1 and 100
            int attempts = game.gameLogic(rNum, sc);
            if (attempts < highScore) {     // Check for highscore 
                highScore = attempts;
                System.out.println("\nNew High Score: " + highScore + " attempts!");
            } else {
                System.out.println("\nYour score: " + attempts + " attempts.");
                System.out.println("Current High Score: " + highScore + " attempts.");
            }
            System.out.println("\nDo you want to play again? (y/n)");
            userChoice = sc.next().trim();
            while (!userChoice.equalsIgnoreCase("y") && !userChoice.equalsIgnoreCase("n")) {
                System.out.println("Invalid choice! Please enter 'y' to play again or 'n' to exit.");
                userChoice = sc.next().trim();
            }
        } while (userChoice.equalsIgnoreCase("y"));
        sc.close();
    }
}