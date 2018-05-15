package hw3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Homework #3
 *
 * @author Aleksandr Kurov
 * @version dated Май 14, 2018
 */
public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("\nPlease select game:\n1) Guess Number Game\n2) Guess Word Game");
            System.out.print("\nYour choice: ");

            switch (scanner.nextInt()) {
                case 1:
                    // task 1: Guess Number Game
                    GuessNumberGame(scanner);
                    break;
                case 2:
                    // task 2: Guess Word Game
                    GuessWordGame(scanner);
                    break;
                default:
                    System.out.println("Undefined game.");
            }

            System.out.print("\nSelect game again? 1 - yes / 0 - no: ");

        } while (scanner.nextInt() == 1);

        scanner.close();
        System.out.println("bye-bye");

    }

    /**
     * task 1: Guess Number Game
     */
    public static void GuessNumberGame(Scanner scanner) {

        do {

            System.out.println("\nHi User. I ask number in [0, 9] range for you.\n" +
                    "Try to guess it, you have 3 tries. Good Luck!\n");

            int askInt = new Random().nextInt(10);

            int i;
            for (i = 1; i < 4; i++) {
                System.out.printf("Make a guess #%d: ", i);
                int getInt = scanner.nextInt();
                if (askInt > getInt) {
                    System.out.println("Nope =( Your number is LESS.\n");
                } else if (askInt < getInt) {
                    System.out.println("Nope =( Your number is BIGGER.\n");
                } else {
                    System.out.println("\n### You WON! ###\n");
                    break;
                }
            }

            if (i == 4) {
                System.out.println("### Sorry... You LOSE! ###\n");
            }

            System.out.print("Play again? 1 - yes / 0 - no: ");

        } while (scanner.nextInt() == 1);

    }

    /**
     * task 2: Guess Word Game
     */
    public static void GuessWordGame(Scanner scanner) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        char[] lastAnswer = new char[15];

        do {

            System.out.println("\nHi User. I ask word in given list for you.\n" +
                    "Try to guess it. Good Luck!\n");

            String askWord = words[new Random().nextInt(words.length)];
            Arrays.fill(lastAnswer, '#');

            while (true) {

                System.out.print("\ninput word: ");
                String getWord = scanner.next().toLowerCase();

                if (askWord.equals(getWord)) {
                    System.out.println("\n### You WON! ###\n");
                    break;
                }

                int len = (askWord.length() <= getWord.length()) ? askWord.length() : getWord.length();

                for (int i = 0; i < len; i++)
                    if (askWord.charAt(i) == getWord.charAt(i)) lastAnswer[i] = askWord.charAt(i);

                System.out.println(lastAnswer);

            }

            System.out.print("Play again? 1 - yes / 0 - no: ");

        } while (scanner.nextInt() == 1);

    }

}
