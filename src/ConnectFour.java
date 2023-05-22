/**
 * connect four main class
 * @author riley kim
 * @version 5/18/23
 * help from Ryan, Sarah, Issie, and Bobby
 *
 */
public class ConnectFour implements BoardGame   {
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;

    /**
     * starts new game
     */
    public ConnectFour()    {
        newGame();
    }

    /**
     * creates a board for new game
     */
    @Override
    public void newGame() {
        board = new int[6][7];
        currentPlayer = 1+(int)(Math.random()*2);
        winningPositions = new Position[4];
    }

    /**
     * tests if game over
     * @return true: game is over, false: otherwise
     */
    @Override
    public boolean gameOver() {
        boolean full = true;
        for (int i = 0; i < 7; i++) {
            if(!columnFull(i))    {
                full = false;
            }
        }
        return getWinner() != 0 || full;
    }

    /**
     * tests who the winner is
     * @return 0: no winner, 1: player 1 is the winner, 2: player 2 is the winner.
     */
    @Override
    public int getWinner() {
        return horiz() > 0 ? horiz() : vert() > 0 ? vert() : Math.max(diag(), 0);
    }
    private int horiz() {
        int count = 0, player = 0;
        for (int r = 5; r >= 0; r--) {
            count = 0;
            for (int c = 0; c < 7; c++) {
                if (board[r][c] == 0)   {
                    count = 0;
                    player = 0;
                }
                if (board[r][c] == 1)   {
                    if (player == 1)    {
                        count++;
                    }
                    else{
                        player = 1;
                        count = 1;
                    }
                }
                if (board[r][c] == 2)   {
                    if (player == 2)    {
                        count++;
                    }
                    else{
                        player = 2;
                        count = 1;
                    }
                }
                if (count == 4) {
                    setWinningPositions(r, c, 1);
                    return player;
                }

            }
        }
        return 0;
    }
    private int vert()   {
        int count = 0, player = 0;
        for (int c = 0; c < 7; c++) {
            count = 0;
            for (int r = 5; r >= 0; r--) {
                if (board[r][c] == 0)   {
                    count = 0;
                    player = 0;
                }
                if (board[r][c] == 1)   {
                    if (player == 1)    {
                        count++;
                    }
                    else{
                        player = 1;
                        count = 1;
                    }
                }
                if (board[r][c] == 2)   {
                    if (player == 2)    {
                        count++;
                    }
                    else{
                        player = 2;
                        count = 1;
                    }
                }
                if (count == 4) {
                    setWinningPositions(r, c, 0);
                    return player;
                }

            }
        }
        return 0;
    }

    private int diag() {
        for(int r = 5; r >= 0; r--) {
            for (int c = 0; c < 7; c++) {

                if (r >= 3 && c <= 3) {
                    if (board[r][c] == board[r - 1][c + 1] && board[r][c] == board[r - 2][c + 2] && board[r][c] == board[r - 3][c + 3] && board[r][c] != 0) {
                        setWinningPositions(r, c, 5);
                        return board[r][c];
                    }
                }
                if (r >= 3 && c >= 3) {
                    if (board[r][c] == board[r - 1][c - 1] && board[r][c] == board[r - 2][c - 2] && board[r][c] == board[r - 3][c - 3] && board[r][c] != 0) {
                        setWinningPositions(r, c, 3);
                        return board[r][c];
                    }
                }
                if (r <= 2 && c <= 3) {
                    if (board[r][c] == board[r + 1][c + 1] && board[r][c] == board[r + 2][c + 2] && board[r][c] == board[r + 3][c + 3] && board[r][c] != 0) {
                        setWinningPositions(r, c, 2);
                        return board[r][c];
                    }
                }
                if (r <= 2 && c >= 3) {
                    if (board[r][c] == board[r + 1][c - 1] && board[r][c] == board[r + 2][c - 2] && board[r][c] == board[r + 3][c - 3] && board[r][c] != 0) {
                        setWinningPositions(r, c, 4);
                        return board[r][c];
                    }
                }
            }
        }
        return 0;
    }
    private void setWinningPositions(int r, int c, int method)  {
        switch (method) {
            case 0 -> {
                winningPositions[0] = new Position(c, r);
                winningPositions[1] = new Position(c, r + 1);
                winningPositions[2] = new Position(c, r + 2);
                winningPositions[3] = new Position(c, r + 3);
            }
            case 1 -> {
                winningPositions[0] = new Position(c, r);
                winningPositions[1] = new Position(c - 1, r);
                winningPositions[2] = new Position(c - 2, r);
                winningPositions[3] = new Position(c - 3, r);
            }
            case 2 -> {
                winningPositions[0] = new Position(c, r);
                winningPositions[1] = new Position(c + 1, r + 1);
                winningPositions[2] = new Position(c + 2, r + 2);
                winningPositions[3] = new Position(c + 3, r + 3);
            }
            case 3 -> {
                winningPositions[0] = new Position(c, r);
                winningPositions[1] = new Position(c - 1, r - 1);
                winningPositions[2] = new Position(c - 2, r - 2);
                winningPositions[3] = new Position(c - 3, r - 3);
            }
            case 4 -> {
                winningPositions[0] = new Position(c, r);
                winningPositions[1] = new Position(c - 1, r + 1);
                winningPositions[2] = new Position(c - 2, r + 2);
                winningPositions[3] = new Position(c - 3, r + 3);
            }
            case 5 -> {
                winningPositions[0] = new Position(c, r);
                winningPositions[1] = new Position(c + 1, r - 1);
                winningPositions[2] = new Position(c + 2, r - 2);
                winningPositions[3] = new Position(c + 3, r - 3);
            }
        }
    }


    /**
     * Where are the tokens that determine who the winner is?
     * @return the locations of the pieces that determine the game winner.
     */
    @Override
    public Position[] getWinningPositions() {
        if(winningPositions[0] == null) winningPositions[0] = new Position(-1, -1);
        return winningPositions;
    }

    /**
     * tests if the column has room for an additional move
     * @param column the column number
     * @return false if there is room for another move in the column, true if not
     */
    @Override
    public boolean columnFull(int column) {
        return board[0][column] != 0;
    }

    /**
     * change the game to reflect the current player placing a piece in the column
     * @param col the col number
     */
    @Override
    public void play(int col) {
        if(!columnFull(col)) {
            for (int i = 5; i >= 0; i--)    {
                if(board[i][col] == 0)   {
                    board[i][col] = currentPlayer;
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    return;
                }
            }

        }
    }

    /**
     * current board configuration
     * @return
     * 0: not filled
     * 1: filled by the player 1's piece
     * 2: filled by the player 2's piece
     */
    @Override
    public int[][] getBoard() {
        return board;
    }

    /**
     * finds current player
     * @return the current player
     */
    public int getCurrentPlayer()   {
        return currentPlayer;
    }
}