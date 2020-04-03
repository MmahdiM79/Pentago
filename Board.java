

/**
 * This class repersent a simple Pentago game's board
 * 
 * @author Mohammad Mahdi Malmsi
 * @version 0.0.0
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

    /**
     * Change the main board blocks kind.
     * 
     * @param y : the y of the block
     * @param x : the x of the block
     * @param kind : the new kind of the block to set. < 1: player 1, white>, <-1: player 2, black>, < 0: empty> 
     */
    public void setBoard(int y, int x, int kind)
    {
        // change main board
        mainBoard[y][x] = kind;

    
        char kindChar;
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


    // change the visual board kind
    private void setVisualBoard(int y, int x, char kind)
    {
        if (y > 2)
            y = (4 * y) + 3;
        y = (4 * y) + 1;

        if (x > 2) 
            x = (7 * x) + 5;
        x = (7 * x) + 1;


        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 3; i++)
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