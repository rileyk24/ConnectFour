/**
 * @author riley kim
 * @version 5/18/23
 * position class
 * Help from Ryan, Sarah, Issie, and Bobby
 */
public class Position {
    private int row, col;

    /**
     * Position of row and colum
     * @param col
     * @param row
     */
    public Position(int col, int row) {
        this.row = row;
        this.col = col;

    }

    /**
     * gets the row
     * @return row
     */

    public int getRow() {
        return row;
    }

    /**
     * sets the row
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }


    /**
     * gets the column
     * @return col
     */
    public int getCol() {
        return col;
    }

    /**
     * sets the col
     * @param col
     */

    public void setCol(int col) {
        this.col = col;
    }

    /**
     * tests if row and col are equal
     * @param other
     * @return boolean of true or false
     */

    public boolean equals(Object other) {
        if (other instanceof Position) {
            Position temp = (Position)other;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;
    }
}