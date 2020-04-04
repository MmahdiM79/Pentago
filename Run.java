import java.util.Scanner;


/**
 * The main class of the game.
 * This game designed for UNIX bash !. 
 * (may not work on windows)
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public class Run 
{
    // for read the players inputs from the terminal
    private static Scanner inputs = new Scanner(System.in);


    // this method check the player input
    private static boolean isValid(String choosenBlock)
    {
        return (choosenBlock.charAt(0) < '7' && '0' < choosenBlock.charAt(0))
                && 
                (choosenBlock.charAt(1) <= 'F' && 'A' <= choosenBlock.charAt(1));
    }

    public static void main(String[] args) 
    {
        // preparing terminal
        Printer.colorReset();
        Printer.calibrate(inputs);


        // required variables
        String holdInputs = null; // hold players input for check them 
        int operand = 0; // the player input for menu
        Player player1; // the player one. white color
        Player player2; // the player two. black color



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

            
            break;
        }
    }
}