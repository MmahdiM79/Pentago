import java.util.Scanner;

/**
 * The main class of the game
 * This game designed for UNIX bash !. 
 * (may not work on windows)
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public class Run 
{
    // for read the players inputs from the terminal
    private static Scanner iputs = new Scanner(System.in);


    // this method check the player input
    private static boolean isValid(String choosenBlock)
    {
        return (choosenBlock.charAt(0) < '7' && '0' < choosenBlock.charAt(0))
                && 
                (choosenBlock.charAt(1) <= 'F' && 'A' <= choosenBlock.charAt(1));
    }

    public static void main(String[] args) 
    {
        
    }
}