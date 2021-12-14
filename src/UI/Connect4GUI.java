package UI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Author: Jesus Kana
 * version: 001
 *
 * Connect4GUI creates a GUI for Connect 4 that the user can choose to use at the start of the game.
 *
 * Version 001 of this code is heavily influenced by the Tic Tac Toe example.
 * Future versions will not be.
 */
public class Connect4GUI extends Application
{
    // Indicate which player has a turn, initially it is the X player
    private char whoseTurn = 'X';
    // Create and initialize cell
    private Cell[][] cell = new Cell[6][7];
    // Create and initialize a status label
    private Label lblStatus = new Label("Yellow's turn to play");
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
/**
 * Holds the cells.
 */
        GridPane pane = new GridPane();
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++)
                pane.add(cell[i][j] = new Cell(), j, i);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatus);
/**
 * Creating the scene and placing it on the Stage.
 */
        Scene scene = new Scene(borderPane, 900, 600);
        primaryStage.setTitle("Connect4"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    /** Determine if the cell are all occupied */
    public boolean isFull()
    {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++)
                if (cell[i][j].getToken() == ' ')
                    return false;
        return true;
    }

    /**
     * Determines if the play has connected 4 letter vertically.
     * @param playersLetter
     * @return
     */
    public boolean verticalCheckWinner(char playersLetter){
        short letterCounter = 0;
        short winningLine = 0;
        for (int j = 0; j < 7; j++){
            for (int i = 0; i < 6; i++) {
                if (cell[i][j].getToken() == playersLetter) {
                    letterCounter++;
                    if (letterCounter >= 4) {
                        winningLine++;
                    }
                } else {
                    letterCounter = 0;
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
     * Determines if the player has connected 4 letter
     * horizontally.
     * @param playersLetter if player is X or O
     * @return if the user is a winner or not
     */
    public boolean horizontalCheckWinner(char playersLetter)
    {
        short letterCount = 0;
        short winningLine = 0;

        for(int i = 0; i < 6; i++){
            letterCount = 0;
            for(int j = 0; j < 7; j++){
                if(cell[i][j].getToken() == playersLetter){
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
            if(cell[i][firstCheck].getToken() == playersLetter){
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
            if(cell[i][secondCheck].getToken() == playersLetter){
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
            if(cell[i][thirdCheck].getToken() == playersLetter){
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
            if(cell[i][fourthCheck].getToken() == playersLetter){
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
            if(cell[i][fifthCheck].getToken() == playersLetter){
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
            if(cell[i][sixthCheck].getToken() == playersLetter){
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
            if(cell[i][firstCheck].getToken() == playersLetter){
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
            if(cell[i][secondCheck].getToken() == playersLetter){
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
            if(cell[i][thirdCheck].getToken() == playersLetter){
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
            if(cell[i][fourthCheck].getToken() == playersLetter){
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
            if(cell[i][fifthCheck].getToken() == playersLetter){
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
            if(cell[i][sixthCheck].getToken() == playersLetter){
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
     * Inner class that is used to create, place, and check if a
     * particular token is a winner.
     */
    public class Cell extends Pane
    {
        // Token used for this cell
        private char token = ' ';
        public Cell()
        {
            setStyle("-fx-border-color: black");
            this.setPrefSize(2000, 2000);
            this.setOnMouseClicked(e -> handleMouseClick());
        }
        /** Return token */
        public char getToken() {
            return token;
        }
        /** Set a new token */
        public void setToken(char c)
        {
            token = c;
            if (token == 'X')
            {
                Ellipse ellipseX = new Ellipse(this.getWidth() / 2,
                        this.getHeight() / 2, this.getWidth() / 2 - 10,
                        this.getHeight() / 2 - 10);
                ellipseX.centerXProperty().bind(this.widthProperty().divide(2));
                ellipseX.centerYProperty().bind(this.heightProperty().divide(2));
                ellipseX.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
                ellipseX.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
                ellipseX.setStroke(Color.YELLOW);
                ellipseX.setFill(Color.YELLOW);
                getChildren().add(ellipseX); // Add the ellipse to the pane
            }
            else if (token == 'O') {
                Ellipse ellipse = new Ellipse(this.getWidth() / 2,
                        this.getHeight() / 2, this.getWidth() / 2 - 10,
                        this.getHeight() / 2 - 10);
                ellipse.centerXProperty().bind(this.widthProperty().divide(2));
                ellipse.centerYProperty().bind(this.heightProperty().divide(2));
                ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
                ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
                ellipse.setStroke(Color.RED);
                ellipse.setFill(Color.RED);
                getChildren().add(ellipse); // Add the ellipse to the pane
            }
        }

        /**
         * Handles the mouse Click events and checks if the placement is a winning move or not.
         */
        private void handleMouseClick()
        {
            // If cell is empty and game is not over
            if (token == ' ' && whoseTurn != ' ')
            {
                setToken(whoseTurn); // Set token in the cell
                // Check game status
                if (verticalCheckWinner(whoseTurn)) {
                    if( whoseTurn == 'X'){
                        lblStatus.setText("Yellow" + " won! The game is over");
                    }
                    else{
                        lblStatus.setText("Red" + " won! The game is over");
                    }
                    whoseTurn = ' '; // Game is over
                }
                else if (horizontalCheckWinner(whoseTurn)) {
                    if( whoseTurn == 'X'){
                        lblStatus.setText("Yellow" + " won! The game is over");
                    }
                    else{
                        lblStatus.setText("Red" + " won! The game is over");
                    }
                    whoseTurn = ' '; // Game is over
                }
                else if (diagonalChecker(whoseTurn)) {
                    if( whoseTurn == 'X'){
                        lblStatus.setText("Yellow" + " won! The game is over");
                    }
                    else{
                        lblStatus.setText("Red" + " won! The game is over");
                    }
                    whoseTurn = ' '; // Game is over
                }
                else if (oppositeDiagonalChecker(whoseTurn)) {
                    if( whoseTurn == 'X'){
                        lblStatus.setText("Yellow" + " won! The game is over");
                    }
                    else{
                        lblStatus.setText("Red" + " won! The game is over");
                    }
                    whoseTurn = ' '; // Game is over
                }
                else if (isFull()) {
                    lblStatus.setText("Draw! The game is over");
                    whoseTurn = ' '; // Game is over
                }
                else {
                    // Change the turn
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    // Display whose turn
                    if( whoseTurn == 'X'){
                        lblStatus.setText("Yellow" + "'s turn");
                    }
                    else{
                        lblStatus.setText("Red" + "'s turn");
                    }
                }
            }
        }
    }
}

