

/**
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public class Rules
{


    /**
     * This method check the player choosen block
     * 
     * @param gameBoard : the board of the game
     * @param y : the y of the choosen block
     * @param x : the x of the choosen block
     * 
     * @return {@code true} if and only if the choosen block is empty.
     *         otherwise {@code false}.
     */
    public static boolean isPlayerSelectValid(Board gameBoard, int y, int x)
    {
        if (gameBoard.getMainBoardBlockKind(y, x) == 0)
            return true;

    //  else
        return false;
    }


    /**
     * This method put the player color to his/her choosen block
     * 
     * @param gameBoard : the board of the game
     * @param y : the y of the choosen block
     * @param x : the x of the choosen block
     * @param player : the player
     */
    public static void applyPlayerSelect(Board gameBoard, int y, int x, Player player)
    {
        gameBoard.setBoard(y, x, player.getPlayerID());
    }


    /**
     * This method search for a sequence of lenght 5
     * 
     * 
     * @param gameBoard : the board of the game
     * @param player : the player to check
     * 
     * @return : {@code true} if the given player has built a sequence of lenght 5
     */
    public static boolean isWinner(Board gameBoard, Player player)
    {
        if (checkSequenceHorizontal(gameBoard, 0, player.getPlayerID()))
            return true;
        if (checkSequenceHorizontal(gameBoard, 1, player.getPlayerID()))
            return true;

        
        if (checkSequenceVertical(gameBoard, 0, player.getPlayerID()))
            return true;
        if (checkSequenceVertical(gameBoard, 1, player.getPlayerID()))
            return true;


        if (checkSequenceDiagonal(gameBoard, true, player.getPlayerID()))
            return true;
        if (checkSequenceDiagonal(gameBoard, false, player.getPlayerID()))
            return true;

        return false;
    }


    // this method search for a sequence lenght of 5 in lines
    private static boolean checkSequenceHorizontal(Board gameBoard, int first, int kind)
    {
        int len = 0;
        for (int j = 0; j < gameBoard.getMainBoardY(); j++)
        {
            for (int i = 0+first; i < gameBoard.getMainBoardX()-1+first; i++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }

            if (len == 5)
                return true;

            len = 0;
        }

        return false;
    }


    // this method search for a sequence lenght of 5 in columns
    private static boolean checkSequenceVertical(Board gameBoard, int first, int kind)
    {
        int len = 0;
        for (int i = 0; i < gameBoard.getMainBoardX(); i++)
        {
            for (int j = 0+first; j < gameBoard.getMainBoardY()-1+first; j++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }

            if (len == 5)
                return true;

            len = 0;
        }

        return false;
    }


    // this method search for a sequence lenght of 5 in diameters
    private static boolean checkSequenceDiagonal(Board gameBoard, boolean whichDiameter, int kind)
    {
        int len = 0;
        if (whichDiameter)
        {
            for (int j = 4, i = 0; i < 5 && j >= 0; j--, i++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }
            if (len == 5)
                return true;


            len = 0;
            for (int j = 5, i = 0; i < 5 && j > 0; j--, i++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }
            if (len == 5)
                return true;


            len = 0;
            for (int j = 4, i = 1; i < 6 && j >= 0; j--, i++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }
            if (len == 5)
                return true;

            
            len = 0;
            for (int j = 5, i = 1; i < 6 && j > 0; j--, i++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }
            if (len == 5)
                return true;
        }


        else 
        {
            len = 0;
            for (int j = 0, i = 1; i < 6 && j < 6; j++, i++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }
            if (len == 5)
                return true;


            len = 0;
            for (int j = 0, i = 0; i < 5 && j < 5; j++, i++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }
            if (len == 5)
                return true;
            

            len = 0;
            for (int j = 1, i = 1; i < 6 && j < 6; j++, i++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }
            if (len == 5)
                return true;

            
            len = 0;
            for (int j = 1, i = 0; i < 5 && j < 6; j++, i++)
            {
                if (gameBoard.getMainBoardBlockKind(j, i) == kind)
                    len++;
                else
                    break;
            }
            if (len == 5)
                return true;
        }

        return false;
    }
}