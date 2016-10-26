package ttt;

//Imports
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


public class TicTacToeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    TicTacToe TTT = new TicTacToe();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test //1
    public void testPrint(){
      TTT.printBoard();
      assertEquals("1 2 3\n4 5 6\n7 8 9\n", outContent.toString());
    }

    @Test //2
    public void testInputPrint() {
      TTT.askForInput();
      assertEquals("Please enter a number between 1 and 9\n", outContent.toString());
    }

    @Test //3
    public void testingFailingValidation() {
        assertEquals(false, TTT.validateInput(0));
    }
    @Test //3.1
    public void testingPassingValidation() {
        assertEquals(true, TTT.validateInput(9));
    }

    @Test //4
    public void updateBoard() {
        TTT.updateBoard(3, 'X');
        TTT.printBoard();
        assertEquals("1 2 X\n4 5 6\n7 8 9\n", outContent.toString());
    }
    @Test //4.1
    public void updateBoardAt1358() {
        TTT.updateBoard(1, 'X');
        TTT.updateBoard(2, 'O');
        TTT.updateBoard(3, 'X');
        TTT.updateBoard(4, 'O');
        TTT.updateBoard(5, 'X');
        TTT.updateBoard(8, 'X');
        TTT.updateBoard(9, 'O');
        TTT.printBoard();
        assertEquals("X O X\nO X 6\n7 X O\n", outContent.toString());
    }

    @Test //5.1
    public void humanPlayerFalse() {
        assertEquals(false, TTT.humanPlayer(0));
    }

    @Test //5.2
    public void humanPlayerTrue() {
        assertEquals(true, TTT.humanPlayer(1));
        assertEquals(true, TTT.humanPlayer(2));
        assertEquals(true, TTT.humanPlayer(3));
        assertEquals(true, TTT.humanPlayer(4));
        assertEquals(true, TTT.humanPlayer(5));
        assertEquals(true, TTT.humanPlayer(6));
        assertEquals(true, TTT.humanPlayer(7));
        assertEquals(true, TTT.humanPlayer(8));
        assertEquals(true, TTT.humanPlayer(9));
    }

    @Test //6.0
    public void verticalWin() {
        TTT.updateBoard(1, 'X');
        TTT.updateBoard(2, 'X');
        TTT.updateBoard(3, 'X');
        assertEquals(true, TTT.gameOver());
    }

    @Test //6.01
    public void verticalWinFailure() {
        TTT.updateBoard(1, 'X');
        TTT.updateBoard(5, 'X');
        TTT.updateBoard(3, 'X');
        assertEquals(false, TTT.gameOver());
    }

    @Test //6.1
    public void horizontalWin() {
        TTT.updateBoard(1, 'X');
        TTT.updateBoard(4, 'X');
        TTT.updateBoard(7, 'X');
        assertEquals(true, TTT.gameOver());
    }

    @Test //6.11
    public void horizontalWinFailure() {
        TTT.updateBoard(1, 'X');
        TTT.updateBoard(2, 'X');
        TTT.updateBoard(7, 'X');
        assertEquals(false, TTT.gameOver());
    }

    @Test //6.2
    public void crossWin() {
        TTT.updateBoard(1, 'X');
        TTT.updateBoard(5, 'X');
        TTT.updateBoard(9, 'X');
        assertEquals(true, TTT.gameOver());
    }

    @Test //6.21
    public void crossWinFailure() {
        TTT.updateBoard(1, 'X');
        TTT.updateBoard(3, 'X');
        TTT.updateBoard(9, 'X');
        assertEquals(false, TTT.gameOver());
    }

    @Test //6.3
    public void otherCrossWin() {
        TTT.updateBoard(3, 'X');
        TTT.updateBoard(5, 'X');
        TTT.updateBoard(7, 'X');
        assertEquals(true, TTT.gameOver());
    }
}
