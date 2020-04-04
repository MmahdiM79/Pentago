

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
    public boolean isPlayerSelectValid(Board gameBoard, int y, int x)
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
    public void applyPlayerSelect(Board gameBoard, int y, int x, Player player)
    {
        gameBoard.setBoard(y, x, player.getPlayerID());
    }
}