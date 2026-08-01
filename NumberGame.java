import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int round = 1;

        System.out.println("====================================");
        System.out.println("      WELCOME TO NUMBER GAME");
        System.out.println("====================================");

        boolean playAgain = true;

        while (playAgain) {

            int randomNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == randomNumber) {

                    System.out.println("\nCorrect!");
                    System.out.println("You guessed it in " + attempts + " attempts.");

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Round Score : " + score);
                    guessed = true;
                    break;

                } else if (guess < randomNumber) {

                    System.out.println("Too Low!");

                } else {

                    System.out.println("Too High!");

                }

                System.out.println("Remaining Attempts : " + (maxAttempts - attempts));
            }

            if (!guessed) {

                System.out.println("\nGame Over!");
                System.out.println("The correct number was : " + randomNumber);

            }

            System.out.println("\nTotal Score : " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }

            round++;
        }

        System.out.println("\n================================");
        System.out.println("Thanks for Playing!");
        System.out.println("Final Score : " + totalScore);
        System.out.println("================================");

        sc.close();
    }
}