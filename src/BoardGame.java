
/**
 * BoardGame describes the behaviors of a 2-person game played
 *   on a rectangular grid.
 * @author Jo Perry
 * 
 * Used with permission 01/22/2012
 * YOU MAY NOT MODIFY THIS FILE IN ANY WAY
 */
public interface BoardGame { 
    /**
     * Prepares the board for a new game.
     */
    public void newGame();  
    
    /**
     * Is the game over?
     * @return true if the game is over, false otherwise
     */
    public boolean gameOver(); 
    
    /**
     * Who is the winner?
     * @return 0 if there is no winner, 1 if the first player is a winner, 2 if the second player is a winner.
     */
    public int getWinner(); 
    
    /**
     * Where are the tokens that determine who the winner is?
     * @return the locations of the pieces that determine the game winner.
     */
    public Position[] getWinningPositions();
    
    /**
     * Does the column have room for an additional move?
     * @param col the column number
     * @return false if there is room for another move in the column, true if not.
     */
    public boolean columnFull(int col);
    
    /**
     * change the game to reflect the current player placing a piece in the column.
     * @param col the column number
     */
    public void play(int col);
    
    /**
     * current board configuration
     * @return
     *   0: not filled
	 *   1: filled by the player 1 piece
	 *   2: filled by the player 2 piece
     */
    public int[][] getBoard();  
}
