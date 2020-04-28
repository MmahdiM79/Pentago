import java.util.HashMap;



/**
 * This class is a simple bot that play insted player 2
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.0
 */
public class Bot extends Player
{
               /* Feilds */

    // the blocks that bot can choose
    // rank is a float that make difrence between selectable blocks
    // the bot will chose the higher rank 
    private HashMap<String, Float> emptyBlocksRank;


    // rank is an int that make difrence squers rotate
    // the bot will select the higher rank
    private HashMap<String, Integer> squeresRotateRank;








            /* Constructor */

    /**
     * Creat a new bot with given ID and character
     * 
     * @param botID : the ID of the bot
     * @param botCharacter : the charater of the bot
     */
    public Bot(int botID, char botCharacter)
    {
        super("BOT", "", 0, botID, botCharacter, "");

        emptyBlocksRank = new HashMap<>();
        squeresRotateRank = new HashMap<>();
    }







            /*  Methods  */

    /**
     * This method is a kind of main method for bot
     * It makes bot decision
     * 
     * @param gameBoard : the board of the game
     */
    public void playTurn(Board gameBoard)
    {
        resetRanks();


        // check that the board has empty blocks or not
        if (gameBoard.getNumberOfEmptyBlocks() == 0)
            return;

        // rank the empty blocks
        rankTheEmptyBlocks(gameBoard);
        
        String botChoose = null;
        for (String block : emptyBlocksRank.keySet())
        {
            if (botChoose == null)
            {
                botChoose = block;
                continue;
            }

            if (emptyBlocksRank.get(block) > emptyBlocksRank.get(botChoose))
                botChoose = block;
        }
        int y = deCode(botChoose, 'Y');
        int x = deCode(botChoose, 'X');
        Rules.applyPlayerSelect(gameBoard, y, x, this);
        

        // check that the game is ended or not
        if (Rules.isWinner(gameBoard, this))
            return;

        
        // rank the squares rotate
        rankSqueresRotate(gameBoard);

        String botRotateChoose = null;
        for (String rotate: squeresRotateRank.keySet())
        {
            if (botRotateChoose == null)
            {
                botRotateChoose = rotate;
                continue;
            }

            if (squeresRotateRank.get(rotate) >= squeresRotateRank.get(botRotateChoose))
                botRotateChoose = rotate;
        }

        int squareNumber = (int)botRotateChoose.charAt(0) - 48;
        boolean rotateWise = botRotateChoose.charAt(1) == 't' ? true: false;

        gameBoard.rotate(squareNumber, rotateWise);
    }






    // this method rank the empty blocks
    private void rankTheEmptyBlocks(Board gameBoard)
    {
        float rank = 0;

        for (int j = 0; j < gameBoard.getMainBoardY(); j++)
            for (int i = 0; i < gameBoard.getMainBoardX(); i++)
                if (gameBoard.getMainBoardBlockKind(j, i) == 0)
                {
                    rank = (-1.1f) * (Math.abs(j - 2.5f) + Math.abs(i - 2.5f));
                    emptyBlocksRank.put(makeCode(j, i), rank);
                }
    }


    // this method rank the squares rotate
    private void rankSqueresRotate(Board gameBoard)
    {
        Player opponent = new Player("", "", 0, (-1)*this.getPlayerID(), '\0', "");

        for (int n = 1; n < 5; n++)
        {
            gameBoard.rotate(n, true);
            if (Rules.isWinner(gameBoard, opponent))
                squeresRotateRank.put("" + n + 't', -10);
            else
                squeresRotateRank.put("" + n + 't', opponentBlocksCount(gameBoard, (-1)*this.getPlayerID(), n));


            gameBoard.rotate(n, false);
            gameBoard.rotate(n, false);
            if (Rules.isWinner(gameBoard, opponent))
                squeresRotateRank.put("" + n + 'f', -10);
            else
                squeresRotateRank.put("" + n + 'f', opponentBlocksCount(gameBoard, (-1)*this.getPlayerID(), n));

            gameBoard.rotate(n, true);
        }
        
        Rules.setWinner(null);
    }


    // this method reset the ranks of the blocks and squares
    private void resetRanks()
    {
        // reset the empty blocks rank
        for (String block: emptyBlocksRank.keySet())
        {
            emptyBlocksRank.replace(block, -3000.0f);
        }

        // reset the squers rank
        for (String squarRotate: squeresRotateRank.keySet())
        {
            squeresRotateRank.replace(squarRotate, -3000);
        }
    }


    // this method count the number of the opponent blocks in square
    private int opponentBlocksCount(Board gameBoard, int opponentID, int squareNumber)
    {
        int y = 0, x = 0;
        switch (squareNumber)
        {
            case 2:
                x = 3;
            break;

            case 3:
                y = 3;
            break;

            case 4:
                x = y = 3;
            break;
        }

        int cntr = 0;
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 3; i++)
                if (gameBoard.getMainBoardBlockKind(y+j, x+i) == opponentID)
                    cntr++;

        return cntr;
    }

    
    // thie method converts the i,j to string
    // example: (3, 4) >>> "5D"
    private String makeCode(int y, int x)
    {
        char X = '\0';
        switch (x)
        {
            case 0:
                X = 'A';
            break;

            case 1:
                X = 'B';
            break;

            case 2:
                X = 'C';
            break;

            case 3:
                X = 'D';
            break;

            case 4:
                X = 'E';
            break;

            case 5:
                X = 'F';
            break;

            case 6:
                X = 'G';
            break;

            case 7:
                X = 'H';
            break;
        }

        return "" + (y+1) + X;
    }


    // this method converts string to i,j
    // example: "5D" >>> (3, 4)
    private int deCode(String choosenBlock, char which)
    {
        switch (which)
        {
            case 'X':
                return (int)choosenBlock.charAt(1) - 65;

            case 'Y':
                switch (choosenBlock.charAt(0))
                {
                    case '1':
                        return 0;

                    case '2':
                        return 1;

                    case '3':
                        return 2;

                    case '4':
                        return 3;

                    case '5':
                        return 4;

                    case '6':
                        return 5;

                    case '7':
                        return 6;

                    case '8':
                        return 7;
                }
        }

        return -1;
    }
}