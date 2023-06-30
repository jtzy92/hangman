package joey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ScanFirst {

    private PrintWord printWord = new PrintWord();
    private PrintHangedMan printHangedMan = new PrintHangedMan();
    private PlayerEntry playerEntry = new PlayerEntry();
    List<String> words = new ArrayList<>();
    List<Character> guesses = new ArrayList<>();
    String word = "";
    Integer wrongGuess = 0;


    public void printGameWord(){
        try {
            Scanner userKey = new Scanner(System.in);
            System.out.println("1 or 2 Players");
            String playerNumber = userKey.nextLine();

            if(playerNumber.equals("1")) {
                Scanner scanner = new Scanner(new File("C:/Users/joeyt/git/hangman/HangManGame/src/resources/words.txt"));
                while (scanner.hasNext()) {
                    words.add(scanner.nextLine());
                }
                Random rand = new Random();
                word = words.get(rand.nextInt(words.size()));
//                System.out.println(word);
                while(true){
                    printHangedMan.printHangMan(wrongGuess);
                    if(wrongGuess >= 6){
                        System.out.println("Game Over");
                        System.out.println("The word was : "+ word);
                        break;
                    }
                    printWord.printWordState(word, guesses);
                    if(!playerEntry.getPlayerInput(userKey,word,guesses)){
                        wrongGuess++;
                    }
                    if(printWord.printWordState(word, guesses)){
                        System.out.println("You Win");
                        break;
                    }
                }
            } else {
                System.out.println("Player 1, key in your word of choice: ");
                word = userKey.nextLine().toLowerCase();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Ready for player 2! Good luck!");
                while (true) {
                    printHangedMan.printHangMan(wrongGuess);
                    if (wrongGuess >= 6) {
                        System.out.println("Game Over");
                        System.out.println("The word was : " + word);
                        break;
                    }
                    printWord.printWordState(word, guesses);
                    if (!playerEntry.getPlayerInput(userKey, word, guesses)) {
                        wrongGuess++;
                    }
                    if (printWord.printWordState(word, guesses)) {
                        System.out.println("You Win");
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}