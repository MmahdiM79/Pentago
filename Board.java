

/**
 * This class repersent a simple Pentago game's board
 * 
 * @author Mohammad Mahdi Malmsi
 * @version 0.0.0
 */
public class Board
{
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