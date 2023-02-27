package hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {

    public static void main(String[] args) {


        int maxTry = 10;
        int count = 0;
        Scanner scan = new Scanner(System.in);

        String secretWord = "trabzon";

        System.out.println("The word you have to guess has " + secretWord.length() + " letters.");

        ArrayList<Character> guessList = new ArrayList<>();

        for (int i = 0; i < maxTry; i++) {
            String guess;
            do {
                System.out.print("Your guess : ");
                guess = scan.next();
                if (guess.length() > 1 || !Character.isLetter(guess.charAt(0))) {
                    System.out.println("Incorrect enter. Please try again");
                }
            } while (!Character.isAlphabetic(guess.charAt(0)) || guess.length() > 1);

            guess = guess.toLowerCase();

            guessList.add(guess.charAt(0));
            count++;

            String guessWord = maskWord(secretWord, guessList);
            System.out.println(guessWord);

            if (guessWord.equals(secretWord)) {
                System.out.println("!!!!! CONGRATULATIONS !!!!!");
                break;
            }
            if (count == maxTry) {
                System.out.println(" ");
                System.out.println(" !!! YOU FAILED !!!");
                break;
            }
            System.out.println("Remaining number of guess: " + (maxTry - count));
            System.out.println();
        }
    }

    public static String maskWord(String secretWord, ArrayList<Character> guessList) {

        String result = "";

        int x = secretWord.length();

        for (int i = 0; i < x; i++) {
            Character ch = secretWord.charAt(i);
            if (guessList.contains(ch)) {
                result = result.concat(ch + "");
            } else {
                result = result.concat("*");
            }
        }
        return result;
    }
}

