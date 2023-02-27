package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("wordList.txt");

        Scanner sc = new Scanner(file);


        ArrayList<String> words = new ArrayList<>();

        while(sc.hasNextLine()) {
            words.add(sc.nextLine());
        }
        System.out.println(words);

    }
}

