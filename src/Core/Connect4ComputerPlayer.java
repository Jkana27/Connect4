package Core; /**
 * @author Jesus Kana
 * In this class we create a method to generate the random
 * numbers that the computer will use to make his turn.
 */

import java.util.Random;

public class Connect4ComputerPlayer {
    /**
     * The maximum for our random number generator.
     */
    private int max;
    /**
     * The minimum for our random number generator.
     */
    private int min;

    public Connect4ComputerPlayer(){
        this.max = 7;
        this.min = 1;
    }

    /**
     *This method is used to generate a random number for out Computer.
     * @return a number that will be used to select a column for the computer.
     */
    public int generateNumber(){
        int randomNumber;
        randomNumber = (int)(Math.random() * (max - min + 1) + min);
        return randomNumber;
    }
}
