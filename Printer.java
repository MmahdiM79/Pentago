import java.util.Scanner;

/**
 * This class do all required prints
 * This class designed for UNIX bash
 * ( may not work on windows )
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.7
 */
public class Printer 
{
            /* Feilds */


    // Reset the color of the terminal
    private static final String RESET = "\033[92;40m"; 

    // indent
    private static final String indent = "\t\t\t      ";


   // Regular Colors
   public static final String BLACK = "\033[0;30m";   // BLACK
   public static final String RED = "\033[0;31m";     // RED
   public static final String GREEN = "\033[0;32m";   // GREEN
   public static final String YELLOW = "\033[0;33m";  // YELLOW
   public static final String BLUE = "\033[0;34m";    // BLUE
   public static final String PURPLE = "\033[0;35m";  // PURPLE
   public static final String CYAN = "\033[0;36m";    // CYAN
   public static final String WHITE = "\033[0;37m";   // WHITE


   // Background
   public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
   public static final String RED_BACKGROUND = "\033[41m";    // RED
   public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
   public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
   public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
   public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
   public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
   public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

   // High Intensity
   public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
   public static final String RED_BRIGHT = "\033[0;91m";    // RED
   public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
   public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
   public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
   public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
   public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
   public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE


   // High Intensity backgrounds
   public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
   public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
   public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
   public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
   public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
   public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
   public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
   public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE







                    /* Methods */


      
    /**
     * This method print the game menu
     */
    public static void printMenu()
    {
        clear();
        System.out.println(RESET);

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(indent + "\t      " + "🃏 <@••••••. Pentago Game .••••••@> 🀄️");
        System.out.print("\n\n");
        System.out.println(indent + "\t      " + "       1. new Two Player game");
        System.out.println(indent + "\t      " + "      2. new Single Player game");
        System.out.print("\n");
        System.out.println(indent + "\t      " + "               3. exit");
        System.err.println(indent + "\t      " + "🀄️ <@••••••••••••••••••••••••••••@> 🃏");
        System.out.print("\n\n");
        System.out.print(  indent + "\t      " + "                 0_0? ");
    }                

    /**
     * This method print the visual board in standard output(termianl)
     * Run this code in an Unix-base OS to see it colorfull =)
     * 
     * @param visualBoard : the visual board of the game
     * @param y_len : the width of the visual board
     * @param x_len : the lenght of the visual board
     */
    public static void printVisualBoard(char[][] visualBoard, int y_len, int x_len)
    {
        clear();


        System.out.print(indent + RESET);
        System.out.print("      ");
        for (char k = 'A'; k <= 'F'; k++)
        {
            System.out.print(CYAN_BRIGHT + k + "      ");

            if (k == 'C')
                System.out.print("    ");
        }

        System.out.print("\n");



        for (int j = 0; j < y_len; j++)
        {
            System.out.print(indent);
            

            if (j < 13)
            {
                if (j%4 == 2)
                    System.out.print(CYAN_BRIGHT + (j/4 + 1) + " " + RESET);
                else
                    System.err.print("  ");
            }
            else if (j > 14)
            {
                if ((j-2)%4 == 2)
                    System.out.print(CYAN_BRIGHT + ((j-2)/4 + 1) + " " + RESET);
                else
                    System.err.print("  ");
            }
            else 
                System.err.print("  ");

            for (int i = 0; i < x_len; i++)
            {
                if (visualBoard[j][i] == '•' || visualBoard[j][i] == '-' || visualBoard[j][i] == '|')
                    System.out.print(YELLOW_BRIGHT + RED_BACKGROUND + visualBoard[j][i]);
 
                else if (visualBoard[j][i] == 'B')
                    System.out.print(BLACK_BACKGROUND + " ");

                else if (visualBoard[j][i] == 'W')
                    System.err.print(WHITE_BACKGROUND_BRIGHT + " ");

                else
                    System.out.print(RED_BACKGROUND + visualBoard[j][i]);

                System.out.print(RESET);
            }

            System.out.print("\n");
        }
    }


    /**
     * This method print the player name and some other words to get player choosen block
     * 
     * @param player : the player that should choose a block
     */
    public static void printTurn(Player player)
    {
        System.out.print(RESET + 
                    "  Hey " + BLACK_BACKGROUND_BRIGHT +  player.getFirstName() + RESET + 
                            " it's your turn. choose a block from white blocks(example: '3D'): ");
    }


    /**
     * This method says congratulations to winner player =)
     * 
     * @param winnePlayer : the winner player
     * @param finish : the input source
     */
    public static void printWinner(Player winnePlayer, Scanner finish)
    {
        System.out.println(indent + "\t         " +
                            "Congratulations " + 
                                BLACK_BACKGROUND_BRIGHT + winnePlayer.getFirstName() + RESET +
                                    ". you win !");

        finishEnter(finish);
    }


    /**
     * This mehtod calibrate the font size of the terminal
     * 
     * @param finish : the players input source
     */
    public static void calibrate(Scanner finish)
    {
        clear();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(RESET + indent + "\b\b\b\b\b\b\b" +
                                "please use (cntrl, +) and (cntrl, -) to fit this line to your screen");

        System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
        finishEnter(finish);
    }


    /**
     * This method reset the color of the terminal
     * Both text color and background color
     * 
     * ()
     */
    public static void colorReset()
    {
        System.out.println(RESET);
    }


    /**
     * This method warn the player that his/her choosen block is in valid
     * 
     * @param finish : the player input source
     */
    public static void wrongChooseError(Scanner finish)
    {
        System.out.println(indent + "\t     " + 
                                YELLOW_BACKGROUND_BRIGHT + RED_BRIGHT + 
                                        "<@ ! YOU CAN NOT CHOOSE THAT BLOCK ! @>" + RESET);

        finishEnter(finish);
    }


    /**
     * This method warn the player that his/her input is in valid
     * 
     * @param finish : the player input source
     */
    public static void inValidInputError(Scanner finish)
    {
        System.out.println(indent + "\t         " + 
                                YELLOW_BACKGROUND_BRIGHT + RED_BRIGHT +
                                            "<@ ! YOUR INPUT IS INVALID ! @>" + RESET);
        finishEnter(finish);
    }




    // this method wait until player push 'enter' bottom
    private static void finishEnter(Scanner inputsSource)
    {
        System.out.println(indent + "\t\t    " + "(press enter to continue)");
        inputsSource.nextLine();
    }


    // this method clear the terminal
    private static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}