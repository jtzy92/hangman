package joey;

import java.util.List;
import java.util.Scanner;

public class PlayerEntry {

    public PlayerEntry() {
    }

    public static boolean getPlayerInput(Scanner keyInput, String word, List<Character> allGuesses){
        System.out.println("Please enter a letter: ");
        String input = keyInput.nextLine().toLowerCase();
        allGuesses.add(input.charAt(0));
        return word.contains(input);
    }
}
