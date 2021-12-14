package Core; /**
 * @author Jesus Kana
 * @version 5
 * The program is a Connect 4 game where 'X' and 'O'
 * Take turns entering their character on the game board.
 * The game is set up so that 'X' always go first.
 *
 */

import UI.Connect4GUI;
import UI.Connect4TextConsole;
import javafx.application.Application;

import java.util.Scanner;

public class Connect4 {
    public static void main(String[] args) {
        /**
         * Creates the initial boards for the players.
         * This will allow us to use the methods we created
         * to interact with our game.
         */
        System.out.println("Enter ‘G’ for JavaFX GUI, ’T’ for text UI, or enter 'O' play " +
                "our very buggy new feature: ");

        Scanner scan = new Scanner(System.in);
        char selection = scan.next().charAt(0);
        if (selection == 'G' || selection == 'g')
            Application.launch(Connect4GUI.class);
        else if (selection == 'T' || selection == 't')
            new Connect4TextConsole().runGame();
        else if (selection == 'O' || selection == 'o'){
            Application.launch(Connect4Server.class);
            Application.launch(Connect4Client.class);
        }
        else
            System.out.println("Invalid Entry!\n");

}
}

