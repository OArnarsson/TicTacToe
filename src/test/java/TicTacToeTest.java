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
        TTT.updateBoard(3);
        TTT.printBoard();
        assertEquals("1 2 X\n4 5 6\n7 8 9\n", outContent.toString());
    }
    @Test //4.1
    public void updateBoardAt13578() {
        TTT.updateBoard(1);
        TTT.updateBoard(3);
        TTT.updateBoard(5);
        TTT.updateBoard(7);
        TTT.updateBoard(8);
        TTT.printBoard();
        assertEquals("X 2 X\n4 X 6\nX X 9\n", outContent.toString());
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

}
