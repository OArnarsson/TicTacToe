package ttt;

public class Board {
    Cell[][] cells;

    //Initializes the game board.
    public Board() {
        cells = new Cell[3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    //Updates the string value of the cell chosen.
    public boolean updateCell(int row, int col, boolean human) {
        if(validateInput(row, col)) {
            if(human)
                cells[row][col].setValue("X");
            else
                cells[row][col].setValue("O");

            return true;
        }

        return false;
    }

    //Makes sure all inputs are legit.
    public boolean validateInput(int row, int col) {
        if(row > 3 || row < 0 || col > 3 || col < 0 || cells[row][col].getValue() != "")
            return false;

        return true;
    }

    //Checks if we already have a winner.
    public boolean gameOver() {
        for(int i=0; i<3; i++) {
            //Horziontal check
            if(cells[i][0].getValue() != "" && cells[i][0].getValue() == cells[i][1].getValue() && cells[i][1].getValue() == cells[i][2].getValue())
                return true;

            //Vertical check
            if(cells[0][i].getValue() != "" && cells[0][i].getValue() == cells[1][i].getValue() && cells[1][i].getValue() == cells[2][i].getValue())
                return true;
        }

        //Crosschecks
        if(cells[0][0].getValue() != "" && cells[0][0].getValue() == cells[1][1].getValue() && cells[1][1].getValue() == cells[2][2].getValue())
            return true;
        if(cells[0][2].getValue() != "" && cells[0][2].getValue() == cells[1][1].getValue() && cells[1][1].getValue() == cells[2][0].getValue())
            return true;

        return false;
    }


}
