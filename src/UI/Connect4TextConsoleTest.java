package UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Connect4TextConsoleTest {
    Connect4TextConsole connect4TextConsoleUnderTest = new Connect4TextConsole();
    final char[][] grid = new char[6][7];

    @Test
    void testCreateUI() {
        // Setup

        // Run the test
        connect4TextConsoleUnderTest.createUI(grid);

        // Verify the results
    }

    @Test
    void testCheckIfValidPlay() {
        // Setup

        // Run the test
        final boolean result = connect4TextConsoleUnderTest.checkIfValidPlay(1);

        // Verify the results
        assertTrue(result);
    }


    @Test
    void testDiagonalChecker() {
        // Setup
        char letter = 'X';
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                    connect4TextConsoleUnderTest.grid[i][j] = letter;

            }
        }

        // Run the test
        final boolean result = connect4TextConsoleUnderTest.diagonalChecker(letter);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testEnterAnotherColumn() {
        // Setup

        // Run the test
        connect4TextConsoleUnderTest.enterAnotherColumn();

        // Verify the results
    }

    @Test
    void testHorizontalCheckWinner() {
        // Setup
        char letter = 'X';
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                connect4TextConsoleUnderTest.grid[i][j] = letter;

            }
        }
        // Run the test
        final boolean result = connect4TextConsoleUnderTest.horizontalCheckWinner(letter);

        // Verify the results
        assertTrue(result);
    }


    @Test
    void testOppositeDiagonalChecker() {
        // Setup
        char letter = 'X';
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                connect4TextConsoleUnderTest.grid[i][j] = letter;

            }
        }
        // Run the test
        final boolean result = connect4TextConsoleUnderTest.oppositeDiagonalChecker(letter);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testVerticalCheckWinner() {
        // Setup
        char letter = 'X';
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                connect4TextConsoleUnderTest.grid[i][j] = letter;

            }
        }
        // Run the test
        final boolean result = connect4TextConsoleUnderTest.verticalCheckWinner(letter, 1);

        // Verify the results
        assertTrue(result);
    }


}