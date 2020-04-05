import java.util.Scanner;


/**
 * The main class of the game.
 * This game designed for UNIX bash !. 
 * (may not work on windows)
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.0
 */
public class Run 
{
    // for read the players inputs from the terminal
    private static Scanner inputs = new Scanner(System.in);



    // this method check the player input
    private static boolean isValid(String choosenBlock, char which)
    {
        if (which == 'b')
            return (choosenBlock.charAt(0) < '7' && '0' < choosenBlock.charAt(0))
                    && 
                    (choosenBlock.charAt(1) <= 'F' && 'A' <= choosenBlock.charAt(1));

    //  else
            return (choosenBlock.charAt(0) < '7' && '0' < choosenBlock.charAt(0))
                    && 
                    (choosenBlock.charAt(1) == 'f' ||  choosenBlock.charAt(1) == 't');
    }


    // this method change the player input String to integer
    private static int deCode(String choosenBlock, char which)
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
                }
        }

        return -1;
    }

    // this method is for play the player turn
    private static void playTurn(Board gameBoard, Player player, String holdInputs)
    {     
        int x, y; // the coordinates of player choosen block 
        boolean rotate; // true: clock wise,  false: counter clock wise


        // while player one get invalid input for his/her choosen block
        while(true)
        {
            // show the map to the player
            Printer.printVisualBoard(gameBoard);

            // get the player choosen block
            Printer.printTurn1(player);
            holdInputs = inputs.nextLine();


            // check the player input
            if (holdInputs.length() > 2 || holdInputs.length() == 0 ||  !isValid(holdInputs, 'b'))
            {
                Printer.inValidInputError(inputs);
                continue;
            }

            // apply player choose
            y = deCode(holdInputs, 'Y');
            x = deCode(holdInputs, 'X');
            Rules.applyPlayerSelect(gameBoard, y, x, player);
            break;
        }

        // check the player one is winner or not
        if (Rules.isWinner(gameBoard, player))
            return;

        // while player one get invalid input for his/her choose square to rotate
        while (true)
        {
            // show the map to the player
            Printer.printVisualBoard(gameBoard);

            // get the player choosen square to rotate
            Printer.printTurn2(player);
            holdInputs = inputs.nextLine();

            
            // check the player input
            if (holdInputs.length() > 3 || holdInputs.length() == 0 || !isValid(holdInputs, 's'))
            {
                Printer.inValidInputError(inputs);
                continue;
            }

            // apply player rotate
            x = (int)holdInputs.charAt(0) - 48;
            System.out.println(holdInputs + "-----" + x + "-----");
            rotate = holdInputs.charAt(1) == 't'? true: false;
            gameBoard.rotate(x, rotate);
            break;
        }

        // check the player  i winner or not
        if (Rules.isWinner(gameBoard, player))
            return;
    }

    public static void main(String[] args) 
    {
        // preparing terminal
        Printer.colorReset();
        Printer.calibrate(inputs);


        // required variables
        Board gameBoard = new Board();
        String holdInputs = null; // hold players input for check them 
        int operand = 0; // the player input for menu
        Player player1; // the player one. white color
        Player player2; // the player two. black color
        

        System.out.println((int)'0' + "-----" + (int)'9');
    
        // whlie the user has not select exit option
        while (true)
        {
            // while player get the valid integer
            while (true)
            {
                // show menu to the player
                Printer.printMenu();
                // get the player choose
                holdInputs = inputs.nextLine();

                
                // check the player input
                if ((holdInputs.length() == 1) 
                    && 
                    (holdInputs.charAt(0) > '0') 
                    && 
                    (holdInputs.charAt(0) < '4'))
                {
                    operand = (int)holdInputs.charAt(0) - 48;
                    System.out.println(operand);
                    break;
                }
                
                // warn the player that his/her inputs is invalid
                Printer.inValidInputError(inputs);
            }



            switch (operand)
            {
                case 1:

                    // get the player one name
                    Printer.getPlayerName(1);
                    holdInputs = inputs.nextLine();

                    // creat player one
                    player1 = new Player(holdInputs, "", 0, 1, 'W', "");


                    // get the player two name
                    Printer.getPlayerName(2);
                    holdInputs = inputs.nextLine();

                    // creat player two
                    player2 = new Player(holdInputs, "", 0, -1, 'B', "");



                    while (!Rules.isGameEnded())
                    {
                        // player 1 turn
                        playTurn(gameBoard, player1, holdInputs);

                        if (Rules.isGameEnded())
                            break;

                        // player 2 turn
                        playTurn(gameBoard, player2, holdInputs);
                    }
                break;

                case 2:
                break;

                case 3:
                    return;
            }
        }
    }
}