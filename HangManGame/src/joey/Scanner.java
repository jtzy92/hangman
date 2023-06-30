package joey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scanner {

    private PrintWord printWord = new PrintWord();
    List<String> words = new ArrayList<>();
    List<Character> guesses = new ArrayList<>();

    public void startGame(){
        try {
            java.util.Scanner scanner = new java.util.Scanner(new File("C:/Users/joeyt/git/hangman/HangManGame/src/resources/words.txt"));
            while(scanner.hasNext()){
                words.add(scanner.nextLine());
            }
            Random rand = new Random();
            String word = words.get(rand.nextInt(words.size()));
            System.out.println(word);
            printWord.printWordState(word,guesses);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}