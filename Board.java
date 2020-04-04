

/**
 * This class repersent a simple Pentago game's board
 * 
 * @author Mohammad Mahdi Malmsi
 * @version 0.0.8
 */
public class Board
{
            /* Feilds */

    // the dimensions of the game board 
    private final int BOARD_X = 6;
    private final int BOARD_Y = 6;
    
    // the dimensions of the game visual board 
    private final int VISUAL_BOARD_X = (6 * 7) + 5;
    private final int VISUAL_BOARD_Y = (6 * 4) + 3;


    // the main board of the game 
    //  1 refers to player 1 (W: white)
    // -1 refers to player 2 (B: black)
    //  0 refers to empty block
    private int[][] mainBoard;

    // the visual board of the game
    private char[][] visualBoard;





          /* Constructor */

    /**
     * Creat a new board
     * (no args Constructor)
     */
    public Board()
    {
        // set up main board
        mainBoard = new int[BOARD_Y][BOARD_X];
        for (int j = 0; j < BOARD_Y; j++)
            for (int i = 0; i < BOARD_X; i++)
                mainBoard[j][j] = 0;


        // set up visual board
        visualBoard = new char[VISUAL_BOARD_Y][VISUAL_BOARD_X];
        makeVisualBoard();
    }





            /* Methods */


    // * getter methods *

    /**
     * @return the visual board
     */
    public char[][] getVisualBoard() 
    {
        return visualBoard;
    }
    /**
     * @return the y of the visual board
     */
    public int getVisualBoardY() 
    {
        return VISUAL_BOARD_Y;
    }
    /**
     * @return the x of the visual board
     */
    public int getVisualBoardX() 
    {
        return VISUAL_BOARD_X;
    }

    /**
     * get the kind of a block of board
     * 
     * @param y : the y of the block
     * @param x : the x of the block
     * 
     * @return the kind of the choosen block. < 1: player 1, white>,
     *                                        <-1: player 2, black>,
     *                                        < 0: empty>
     */
    public int getMainBoardBlockKind(int y, int x)
    {
        return mainBoard[y][x];
    }



    /**
     * Change the main board blocks kind.
     * 
     * @param y : the y of the block
     * @param x : the x of the block
     * @param kind : the new kind of the block to set. < 1: player 1, white>, 
     *                                                 <-1: player 2, black>, 
     *                                                 < 0: empty> 
     */
    public void setBoard(int y, int x, int kind)
    {
        // change main board
        mainBoard[y][x] = kind;

    
        char kindChar = '\0';
        switch (kind)
        {
            case 1:
                kindChar = 'W';
            break;

            case -1:
                kindChar = 'B';
            break;

            case 0:
                kindChar = ' ';
            break;
        }


        // change visual board
        setVisualBoard(y, x, kindChar);
    }



    public void rotate(int squerNumber, boolean way)
    {
        int x = 0, y = 0;
        switch (squerNumber)
        {
            case 2:
                x = 3;
            break;

            case 3:
                y = 3;
            break;

            case 4:
                y = x = 3;
            break;
        }


        int hold =  mainBoard[y][x];

        if (way)
        {
            setBoard(y, x, mainBoard[y+2][x]);
            setBoard(y+2, x, mainBoard[y+2][x+2]);
            setBoard(y+2, x+2, mainBoard[y][x+2]);
            setBoard(y, x+2, hold);

            hold = mainBoard[y+1][x];
            setBoard(y+1, x, mainBoard[y+2][x+1]);
            setBoard(y+2, x+1, mainBoard[y+1][x+2]);
            setBoard(y+1, x+2, mainBoard[y][x+1]);
            setBoard(y, x+1, hold);
        }
        else
        {
            setBoard(y, x, mainBoard[y][x+2]);
            setBoard(y, x+2, mainBoard[y+2][x+2]);
            setBoard(y+2, x+2, mainBoard[y+2][x]);
            setBoard(y+2, x, hold);

            hold = mainBoard[y+1][x];
            setBoard(y+1, x, mainBoard[y][x+1]);
            setBoard(y, x+1, mainBoard[y+1][x+2]);
            setBoard(y+1, x+2, mainBoard[y+2][x+1]);
            setBoard(y+2, x+1, hold);
        }
    }

    
    /**
     * Reset the board for new game 
     */
    public void reset()
    {
        for (int j = 0; j < BOARD_Y; j++)
            for (int i = 0; i < BOARD_X; i++)
                setBoard(j, i, 0);
    }


    // change the visual board kind
    private void setVisualBoard(int y, int x, char kind)
    {
        if (y > 2)
            y = (4 * y) + 3;
        else
            y = (4 * y) + 1;

        if (x > 2) 
            x = (7 * x) + 5;
        else
            x = (7 * x) + 1;


        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 6; i++)
                visualBoard[y+j][x+i] = kind;
    }


    // this method fill the visual board for first time
    private void makeVisualBoard()
    {
        int y = 0, x = 0;
        for (int j = 0; j < VISUAL_BOARD_Y; j++)
            for (int i = 0; i < VISUAL_BOARD_X; i++)
            {
                if (j > 13)
                    y = 2;
                else
                    y = 0;

                if (i > 24)
                    x = 4;
                else 
                    x = 0;
                    

                if (i == 22 || i == 23 || i == 24)
                    visualBoard[j][i] = ' ';

                else if (j == 13)
                    visualBoard[j][i] = ' ';
                    
                else if ((j-y)%4 == 0 && (i-x)%7 == 0)
                    visualBoard[j][i] = '•';

                else if ((j-y)%4 == 0 && (i-x)%7 != 0)
                    visualBoard[j][i] = '-';

                else if ((j-y)%4 != 0 && (i-x)%7 == 0)
                    visualBoard[j][i] = '|';

                else
                    visualBoard[j][i] = ' ';
            }
    }
}
