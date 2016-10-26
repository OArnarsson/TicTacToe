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
    public void testInputPrint(){
      TTT.askForInput();
      assertEquals("Please enter a number between 1 and 9\n", outContent.toString());
    }
}
