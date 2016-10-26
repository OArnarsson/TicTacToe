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
