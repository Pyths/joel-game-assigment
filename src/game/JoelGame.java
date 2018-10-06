package game;

import java.util.Arrays;
import java.util.Scanner;

public class JoelGame {
    public static Scanner scan = new Scanner(System.in);
    public final static String GREEN = "G";
    public final static String RED = "R";
    public final static String[] ORIGINAL_POSITIONS = new String[] {GREEN, GREEN, GREEN, GREEN, null, RED, RED, RED, RED};

    public static void main(String[] args) {
        int i = -1;
        String[] currGame = new String[9];
        currGame = ORIGINAL_POSITIONS;
        System.out.println(Arrays.toString(currGame));
        while (!isOver(currGame)) {
            i = getValue("Enter index: ", currGame);
            currGame = changePosition(currGame, i);
            System.out.println(Arrays.toString(currGame));
        }
    }

    public static String[] changePosition(String[] game, int index) {
        // index is in the array-range
        int move = game[index] == "G" ? 1 : -1; // check if moves frontward or backward.
        if (game[index + move] == null) {
            game[index + move] = game[index];
            game[index] = null;
        } else if (game[index + move] != game[index] && game[index + (2 * move)] == null) {
            game[index + (2 * move)] = game[index];
            game[index] = null;
        }
        return game;
    }

    public static boolean isOver(String[] game) {
        final String[] FINAL_POSITIONS = new String[] { RED, RED, RED, RED, null, GREEN, GREEN, GREEN, GREEN};
        return Arrays.equals(game, FINAL_POSITIONS);
    }

    public static int getValue(String prompt, String[] game) {
        int inInt = -1;
        boolean isInt = false;
        do {
            try {
                System.out.print(prompt);
                String s = scan.nextLine();
                inInt = Integer.parseInt(s);
                isInt = game.length >= inInt && inInt > 0 ? true : false;
            } catch (NumberFormatException ex) {
                //isInt = false; // this statement is not needed. It's redundant.
                //System.out.print(ex.getMessage() + "\n");
            }
        } while (!isInt);
        return inInt;
    }
}
