package UI;

import Core.Connect4ComputerPlayer;

import java.util.Scanner;

public class Connect4TextConsole {
    /**
     * This creates the array that we will use for our
     * game board.
     */
    char[][] grid;

    /**
     * This constructor creates our initial game
     * board that the program will interact with.
     */
    public Connect4TextConsole(){
        System.out.println("Welcome to Connect 4!\n");
        System.out.println("  1   2   3   4   5   6   7");
        System.out.println("-----------------------------");
        grid = new char[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 6) {
                    System.out.print("| " + grid[i][j] + " |\n");
                } else {
                    System.out.print("| " + grid[i][j] + " ");
                }
            }
        }
        System.out.println("-----------------------------\n");
    }

    /**
     * This is used to create a new board.
     * We need this to reflect the changes the players
     * make to the board with each turn.
     * @param grid used for the board
     */
    public void createUI(char[][] grid){
        System.out.println("  1   2   3   4   5   6   7");
        System.out.println("-----------------------------");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 6) {
                    System.out.print("| " + grid[i][j] + " |\n");
                } else {
                    System.out.print("| " + grid[i][j] + " ");
                }
            }
        }
        System.out.println("-----------------------------\n");
    }

    /**
     * This is used to make sure that there is not an element
     * already present when the player is making a choice
     * where to pur their Letter. If the move is invalid
     * it asks the user to put their letter in a column that
     * is not full.
     * @param column that the user wants to insert their letter
     *               into
     * @return boolean that indicated whether the move is valid
     */
    public boolean checkIfValidPlay(int column){
        if(grid[5][column-1] == 0){
            return true;
        }

        else if(grid[4][column-1] == 0){
            return true;
        }

        else if(grid[3][column-1] == 0){
            return true;
        }

        else if (grid[2][column-1] == 0){
            return true;
        }

        else if(grid[1][column-1] == 0){
            return true;
        }

        else if(grid[0][column-1] == 0){
            return true;
        }

        else {
            enterAnotherColumn();
            return false;
        }
    }

    /**
     * This inserts the letter into the intended column.
     * The series of if statements are used to determine
     * where the letter will land when inserted into the
     * column.
     * @param piece the players letter
     * @param column where the player wants to place thier
     *               letter
     */
    public void insertPiece(char piece, int column){
        if(grid[5][column-1] == 0){
            grid[5][column - 1] = piece;
            createUI(grid);


        }
        else if(grid[4][column-1] == 0){
            grid[4][column - 1] = piece;
            createUI(grid);

        }
        else if(grid[3][column-1] == 0){
            grid[3][column - 1] = piece;
            createUI(grid);

        }
        else if (grid[2][column-1] == 0){
            grid[2][column - 1] = piece;
            createUI(grid);

        }
        else if(grid[1][column-1] == 0){
            grid[1][column - 1] = piece;
            createUI(grid);

        }
        else if(grid[0][column-1] == 0){
            grid[0][column - 1] = piece;
            createUI(grid);

        }
        else {
            enterAnotherColumn();

        }
    }

    /**
     * Simple method to let Player O know it is
     * their turn.
     */
    public void nextTurnO(){

        System.out.println("Player O – your turn. Choose a column number from 1-7: ");

    }

    /**
     * Simple method to let Player X know it is
     * their turn.
     */
    public void nextTurnX(){

        System.out.println("Player X – your turn. Choose a column number from 1-7: ");

    }

    /**
     * Simple method to let the player know that the column they chose is full.
     */
    public void enterAnotherColumn(){
        System.out.println("This column is full please choose another: ");
    }

    /**
     * Determines if the play has connected 4 letter vertically.
     * @param playersLetter
     * @param column on the game board
     * @return
     */
    public boolean verticalCheckWinner(char playersLetter, int column){
        short letterCounter = 0;
        short winningLine = 0;
        for (int i = 0; i < 6; i++){
            if(grid[i][column-1] == playersLetter){
                letterCounter++;
                if (letterCounter >= 4) {
                    winningLine++;
                }
            }
            else{
                letterCounter = 0;
            }
        }
        if(winningLine >= 1){
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * Determines if the player has connected 4 letter
     * horizontally.
     * @param playersLetter
     * @return if the user is a winner or not
     */
    public boolean horizontalCheckWinner(char playersLetter){
        short letterCount = 0;
        short winningLine = 0;

        for(int i = 0; i < 6; i++){
            letterCount = 0;
            for(int j = 0; j < 7; j++){
                if(grid[i][j] == playersLetter){
                    letterCount++;
                    if(letterCount >= 4){
                        winningLine++;
                    }
                }
                else{
                    letterCount = 0;
                }
            }
        }

        if(winningLine >= 1){
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * Determines if the player has connected 4 letters
     * diagonally.
     * @param playersLetter
     * @return if the player is a winner or not
     */
    public boolean diagonalChecker(char playersLetter){
        short letterCount = 0;
        short winningLine = 0;

        short firstCheck = 0;
        short secondCheck = 0;
        short thirdCheck = 0;
        short fourthCheck = 1;
        short fifthCheck = 2;
        short sixthCheck = 3;


        for(int i = 3; i >= 0; i--){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][firstCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            firstCheck++;
        }


        for(int i = 4; i >= 0; i--){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][secondCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            secondCheck++;
        }


        for(int i = 5; i >= 0; i--){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][thirdCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            thirdCheck++;
        }


        for(int i = 5; i >= 0; i--){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][fourthCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            fourthCheck++;
        }


        for(int i = 5; i >= 1; i--){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][fifthCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            fifthCheck++;
        }


        for(int i = 5; i >= 2; i--){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][sixthCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            sixthCheck++;
        }



        if(winningLine >= 1){
            return true;
        }
        else{
            return false;
        }


    }

    /**
     * Determines if the user has connected 4 letter diagonally.
     * @param playersLetter this will be either an 'X' or an 'O'
     * @return if the user is a winner or not.
     */

    public boolean oppositeDiagonalChecker(char playersLetter){
        short letterCount = 0;
        short winningLine = 0;

        short firstCheck = 0;
        short secondCheck = 0;
        short thirdCheck = 0;
        short fourthCheck = 1;
        short fifthCheck = 2;
        short sixthCheck = 3;


        for(int i = 2; i <= 5; i++){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][firstCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            firstCheck++;
        }


        for(int i = 1; i <= 5; i++){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][secondCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            secondCheck++;
        }


        for(int i = 0; i <= 5; i++){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][thirdCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            thirdCheck++;
        }


        for(int i = 0; i <= 5; i++){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][fourthCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            fourthCheck++;
        }


        for(int i = 0; i <= 4; i++){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][fifthCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            fifthCheck++;
        }


        for(int i = 0; i <= 3; i++){
            if(letterCount >= 4){
                winningLine++;
            }
            if(grid[i][sixthCheck] == playersLetter){
                letterCount++;
            }
            else{
                letterCount = 0;
            }
            sixthCheck++;
        }


        if(winningLine >= 1){
            return true;
        }
        else{
            return false;
        }


    }

    public void runGame(){
        Connect4TextConsole connect4 = new Connect4TextConsole();

        //Used to make comparison to users input
        String playerVsComputer = "C";
        String playerVsPlayer = "P";

        //The boolean value used for our Do While loop
        boolean validInput  = false;

        System.out.println("Welcome to Connect 4!\n To begin the game, please enter 'P' if" +
                " you want to play against another player; or enter 'C' to play against" +
                " a computer.");
        Scanner User = new Scanner(System.in);
        String playerChoice = User.next();
        /**
         * This Do While loop is used to make sure that the user enters either
         * a 'P' or 'C' when prompted to enter a value. It will continue to prompt
         * the user until valid input is entered.
         */
        do{
            System.out.println("The input you enter is invalid.\n Please enter either 'P'" +
                    " to play local with another person or 'C' to play with a computer.");
            playerChoice = User.next();

            if(playerChoice.equals(playerVsPlayer) || (playerChoice.equals(playerVsComputer))){
                validInput = true;
            }
            else{
                validInput = false;
            }
        }
        while(validInput == false);

        /**d
         *We are using a while statement to loop through the game
         * until there is a winner.
         */
        if(playerChoice.equals(playerVsPlayer)) {
            while (true) {
                /**
                 * This is the segment where all of Player X's
                 * actions take place. Here we get Player X's
                 * input and check if the input is valid.
                 * If players decided to put an X in a full column
                 * then they are asked to choose another. If they enter a
                 * number <1 or >7 then their turn is skipped.
                 * finally we check if the player has connected 4
                 */
                connect4.nextTurnX();
                Scanner PlayerX = new Scanner(System.in);

                try {
                    int columnX = PlayerX.nextInt();
                    if (columnX > 7 || columnX < 1) {
                        System.out.println("This is an invalid number!\nYou lose a turn! :(");

                    } else {
                        if (connect4.checkIfValidPlay(columnX) == false) {
                            connect4.nextTurnX();
                            columnX = PlayerX.nextInt();
                            connect4.insertPiece('X', columnX);
                        } else {
                            connect4.insertPiece('X', columnX);
                        }

                        if (connect4.verticalCheckWinner('X', columnX) == true) {
                            System.out.println("Player X wins");
                            break;
                        }
                        if (connect4.horizontalCheckWinner('X') == true) {
                            System.out.println("Player X wins");
                            break;
                        }
                        if (connect4.diagonalChecker('X') == true) {
                            System.out.println("Player X wins");
                            break;
                        }
                        if (connect4.oppositeDiagonalChecker('X') == true) {
                            System.out.println("Player X wins");
                            break;
                        }
                    }

                }
                catch(Exception notValidInput){
                    System.out.println("You did not enter a number. I am sorry but you have lost " +
                            "your turn.");
                }
                /**
                 * This is the segment where all of Player O's
                 * actions take place. Here we get Player O's
                 * input and check if the input is valid.
                 * If players decided to put an O in a full column
                 * then they are asked to choose another. If they enter a
                 * number <1 or >7 then their turn is skipped.
                 * finally we check if the player has connected 4
                 */
                connect4.nextTurnO();
                Scanner PlayerO = new Scanner(System.in);

                try {
                    int columnO = PlayerO.nextInt();
                    if (columnO > 7 || columnO < 1) {
                        System.out.println("This is an invalid number!\nYou lose a turn! :(");

                    } else {
                        if (connect4.checkIfValidPlay(columnO) == false) {
                            connect4.nextTurnO();
                            columnO = PlayerO.nextInt();
                            connect4.insertPiece('O', columnO);
                        } else {
                            connect4.insertPiece('O', columnO);
                        }

                        if (connect4.verticalCheckWinner('O', columnO) == true) {
                            System.out.println("Player O wins");
                            break;
                        }
                        if (connect4.horizontalCheckWinner('O') == true) {
                            System.out.println("Player O wins");
                            break;
                        }
                        if (connect4.diagonalChecker('O') == true) {
                            System.out.println("Player O wins");
                            break;
                        }
                        if (connect4.oppositeDiagonalChecker('O') == true) {
                            System.out.println("Player O wins");
                            break;
                        }
                    }
                } catch (Exception notValidInput) {
                    System.out.println("You did not enter a number. I am sorry but you have lost " +
                            "your turn.");
                }

            }
        }
        else if(playerChoice.equals(playerVsComputer)){
            Connect4ComputerPlayer computer = new Connect4ComputerPlayer();
            while (true) {
                /**
                 * This is the segment where all of Player X's
                 * actions take place. Here we get Player X's
                 * input and check if the input is valid.
                 * If players decided to put an X in a full column
                 * then they are asked to choose another. If they enter a
                 * number <1 or >7 then their turn is skipped.
                 * finally we check if the player has connected 4
                 */
                connect4.nextTurnX();
                Scanner PlayerX = new Scanner(System.in);

                try {
                    int columnX = PlayerX.nextInt();
                    if (columnX > 7 || columnX < 1) {
                        System.out.println("This is an invalid number!\nYou lose a turn! :(");

                    } else {
                        if (connect4.checkIfValidPlay(columnX) == false) {
                            connect4.nextTurnX();
                            columnX = PlayerX.nextInt();
                            connect4.insertPiece('X', columnX);
                        } else {
                            connect4.insertPiece('X', columnX);
                        }

                        if (connect4.verticalCheckWinner('X', columnX) == true) {
                            System.out.println("Player X wins");
                            break;
                        }
                        if (connect4.horizontalCheckWinner('X') == true) {
                            System.out.println("Player X wins");
                            break;
                        }
                        if (connect4.diagonalChecker('X') == true) {
                            System.out.println("Player X wins");
                            break;
                        }
                        if (connect4.oppositeDiagonalChecker('X') == true) {
                            System.out.println("Player X wins");
                            break;
                        }
                    }

                }
                catch(Exception notValidInput){
                    System.out.println("You did not enter a number. I am sorry but you have lost " +
                            "your turn.");
                }
                /**
                 * This is the segment where all of Player O's
                 * actions take place. Here we get Player O's
                 * input and check if the input is valid.
                 * If players decided to put an O in a full column
                 * then they are asked to choose another. If they enter a
                 * number <1 or >7 then their turn is skipped.
                 * finally we check if the player has connected 4.
                 *
                 * NOTE: This is the segment of code that will be used for our
                 * computer. It is identical to the real persons 'O' code the only
                 * difference is the instead of asking for user input for the which
                 * column to place the 'O' we are using the number generator implemented
                 * in the Connect4ComputerPlayer class.
                 */
                connect4.nextTurnO();
                int columnO = computer.generateNumber();

                if (connect4.checkIfValidPlay(columnO) == false) {
                    connect4.nextTurnO();
                    columnO = computer.generateNumber();
                    connect4.insertPiece('O', columnO);
                }

                else {
                    connect4.insertPiece('O', columnO);
                }

                if (connect4.verticalCheckWinner('O', columnO) == true) {
                    System.out.println("Player O wins");
                    break;
                }
                if (connect4.horizontalCheckWinner('O') == true) {
                    System.out.println("Player O wins");
                    break;
                }
                if (connect4.diagonalChecker('O') == true) {
                    System.out.println("Player O wins");
                    break;
                }
                if (connect4.oppositeDiagonalChecker('O') == true) {
                    System.out.println("Player O wins");
                    break;
                }


            }
        }
        else{
            System.out.println("None of your choices are valid.");
        }
    }
}
