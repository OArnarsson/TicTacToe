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
        TTT.board.updateCell(0, 0, true);
        TTT.board.updateCell(0, 1, true);
        TTT.board.updateCell(0, 2, true);
        assertEquals(true, TTT.gameOver());
    }

    @Test //6.01
    public void verticalWinFailure() {
        TTT.board.updateCell(0, 0, true);
        TTT.board.updateCell(0, 1, true);
        TTT.board.updateCell(2, 1, true);
        assertEquals(false, TTT.gameOver());
    }

    @Test //6.1
    public void horizontalWin() {
        TTT.board.updateCell(0, 0, true);
        TTT.board.updateCell(1, 0, true);
        TTT.board.updateCell(2, 0, true);
        assertEquals(true, TTT.gameOver());
    }

    @Test //6.2
    public void crossWin() {
        TTT.board.updateCell(0, 0, true);
        TTT.board.updateCell(1, 1, true);
        TTT.board.updateCell(2, 2, true);
        assertEquals(true, TTT.gameOver());
    }

    @Test //6.3
    public void otherCrossWin() {
        TTT.board.updateCell(0, 2, false);
        TTT.board.updateCell(1, 1, false);
        TTT.board.updateCell(2, 0, false);
        assertEquals(true, TTT.gameOver());
    }
}
