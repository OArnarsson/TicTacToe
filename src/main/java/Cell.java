package ttt;

public class Cell {
    String value;
    private int rowNumber, colNumber;

    //Initializes the cell
    public Cell(int row, int col) {
        this.rowNumber = row;
        this.colNumber = col;
        this.value = "";
    }

    //Returns the cell value.
    public String getValue() {
        return String.valueOf(value);
    }

    //Updates the cell value.
    public void setValue(String input) {
        value = input;
    }

}
