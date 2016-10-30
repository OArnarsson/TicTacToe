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

    @Test //0
    public void testConstructor() {
        assertEquals("123456789", String.valueOf(TTT.board));
    }

    @Test //1
    public void testPrint() {
      TTT.printBoard();
      assertEquals("1 2 3\n4 5 6\n7 8 9\n___________________________________________________________________\n", outContent.toString());
    }

    @Test //2
    public void testInputPrint() {
      TTT.askForInput();
      assertEquals("Please enter a number between 1 and 9.\n", outContent.toString());
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
    public void testAskForInput() {
        TTT.askForInput();
        assertEquals("Please enter a number between 1 and 9.\n", outContent.toString());
    }

    @Test //5.0
    public void testInputOutOfRange() {
        TTT.inputOutOfRange();
        assertEquals("The number you entered was out of range.\n", outContent.toString());
    }

    @Test //5.1
    public void testInvalidInput() {
        TTT.inputInvalid();
        assertEquals("The number you entered was not available.\n", outContent.toString());
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
