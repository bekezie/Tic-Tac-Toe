import java.util.Arrays;
import java.util.Scanner;

/**
 * This will play the game TicTacToe with two players each taking turns.
 * Each user will insert an x an y pair of coordinates to tell which space
 * they wish to put their symbol (x or o) into.
 * Then a winner or tie will be determined, good luck to the players.
 * Author: Bernard Ekezie, Christopher Morris, Blake Koontz
 * Version: 1.2
 * since: 2020-10-20
 */

public class TicTacToe2 {

    /**
     * constant symbol used by player x to mark spots on game board
     */
    static final String x = "x";

    /**
     * constant symbol used by player o to mark spots on game board
     */
    static final String o = "o";

    /**
     * constant symbol used to mark spots on game board that have not been selected
     */
    static final String Blank = "_";

/**
 *  main method for playing TicTacToe
 *  Initialize variables for loop for game to begin
 *  then initialize variables used at beginning of game
 *  afterward game begins in loop with game board of rows and columns with an "-"
 *  symbol designating each space.
 *  Prompt user for input then take in both user's
 *  input (x and o) sequentially validate input and then
 *  mark board till one user is winner then ask users if play again
 * @param args Unused
 *
 */
    public static void main(String[] args) {
        // boolean used to allow user either play again or quit game
        boolean restart = true;
        // String used for player to enter a response to continue or end game
        String answer;
        while (restart) {

            System.out.println("LETS PLAY");

            //board
            String[][] board = new String[3][3];
            // player
            String plyr = x;
            // tie set to zero
            int tie = 0;


            // initializing the entire board to "blank spaces" to bypass nullpointer exception
            for (int i = 0; i < board.length; i++) {
                Arrays.fill(board[i], Blank);
            }

            // boolean which checks to see whether player x or o won
            boolean x_won = false;
            boolean o_won = false;


            System.out.println("Welcome to Tic Tac Toe. X moves first");
            //Calls function to prints board to screen
            PrintBoard(board);
            Scanner keyboard = new Scanner(System.in);

            // loop that continues to run game while neither x or o has won and game is not tied.
            while (!x_won && !o_won && tie < 9) {

                System.out.println("Enter a row between (0, 1, or 2) for player " + plyr + ":");
                // allows users enters row and column of board
                String position = "";
                int row = -1;
                boolean rowValidSw = false;
                while (rowValidSw == false)
                {
                    position = keyboard.next();
                    boolean rowCheckedSw;
                    rowCheckedSw = checkInt(position);
                    if(rowCheckedSw == true)
                    {
                        int rowValidInt = Integer.parseInt(position);
                        if (rowValidInt >= 0 && rowValidInt <= 2)
                        {
                            rowValidSw = true;
                            row = rowValidInt;
                        }
                        else
                        {
                            System.out.println("Out of bounds.");
                            System.out.println("Try again.");
                            System.out.println("Enter a row between (0, 1, or 2) for player " + plyr + ":");
                    //        System.out.println("Enter a row and column between (0, 1, or 2) for player x:");
                            rowValidSw = false;
                        }
                    }
                    else
                    {
                        rowValidSw= false;
                        rowCheckedSw = false;
                        System.out.println("Try again.");
                        System.out.println("Enter a row between (0, 1, or 2) for player " + plyr + ":");
                     //   System.out.println("Enter a row and column between (0, 1, or 2) for player x:");
                    }

                }

                System.out.println("Enter a column between (0, 1, or 2) for player " + plyr + ":");

                int col = -1;
                boolean colValidSW = false;
                while (colValidSW == false)
                {
                    position = keyboard.next();
                    boolean colValidIntSw;
                    colValidIntSw = checkInt(position);
                    if(colValidIntSw == true)
                    {
                        int colValidInt = Integer.parseInt(position);
                        if (colValidInt >= 0 && colValidInt <= 2)
                        {

                            colValidSW = true;
                            col = colValidInt;

                        }
                        else
                        {
                            System.out.println("Out of bounds.");
                            System.out.println("Try again.");
                            System.out.println("Enter a column between (0, 1, or 2) for player " + plyr + ":");
                   //         System.out.println("Enter a row and column between (0, 1, or 2) for player y:");
                            colValidSW = false;
                        }
                    }
                    else
                    {
                        colValidSW = false;
                        colValidIntSw = false;

                        System.out.println("Try again.");
                        System.out.println("Enter a column between (0, 1, or 2) for player " + plyr + ":");
                  //      System.out.println("Enter a row and column between (0, 1, or 2) for player y:");
                    }
                    // checks if the users row or col are out of bounds of the table

                }


                // check if the users tries to take a space that has already been filled
                if (board[row][col].equals(x) || board[row][col].equals(o)) {
                    System.out.println("Space already taken!");
                    System.out.println("Try again.");
                    continue;
                }

                // sets location of board equal to player which is either x or o
                board[row][col] = plyr;
                //calls function to prints board to screen
                PrintBoard(board);
                // increments tie by 1
                tie++;

                // check to see whether plyr is equal to x
                if (plyr.equals(x)) {
                    //sets x_won to either true or false. If true the user wins if false user hasn't won, continue.
                    x_won = winnerCheck(board, x);
                    //change player if no win
                    if (!x_won) {
                        plyr = o;
                    }
                } else {
                    //sets o_won to either true or false. If true the user wins if false user hasn't won, continue.
                    o_won = winnerCheck(board, o);
                    //change player if no win
                    if (!o_won) {
                        plyr = x;
                    }
                }
            }
            // checks to see if tie is equal to board length
            if (tie == 9 && !o_won && !x_won) {
                System.out.println("It's a tie!");
                // prints the player who won the game
            } else {
                System.out.println(plyr + " is the winner! Good game!");
            }
            System.out.println("Play again?");
            System.out.println("Enter Yes or No");
            answer = "";
            while(! (answer.equalsIgnoreCase("No") ||answer.equalsIgnoreCase("Yes")))
            {
                answer = keyboard.next();
                if (answer.equalsIgnoreCase("No"))
                {
                    restart = false;
                }
                else if (answer.equalsIgnoreCase("Yes"))
                {
                    restart = true;
                }
                else
                {
                    System.out.println("Invalid response, please enter valid decision!");
                    System.out.println("Play again?");
                    System.out.println("Enter Yes or No");
                    restart = false;
                }
            }

        }
        System.out.println("END GAME");
        System.exit(0);
    }

    /**
     * winnerCheck method for playing TicTacToe
     * check current board to see if a player has won the game after every move
     * @param board user input unchecked for validity that should indicate row box on board
     * @param temp symbol for player to check if all symbols in a row are the same, indicating winner
     * @return boolean that is true if player has won, false otherwise
     *
     */
    // Function that checks to see whether player is equal to one of the 3 locations in board: horizontal, vertical, or diagonal
    // If so it return true else it returns false
    private static boolean winnerCheck(String[][] board, String temp ) {
        return ((board[0][0].equals(temp) && board[0][1].equals(temp) && board[0][2].equals(temp)) ||
                (board[1][0].equals(temp) && board[1][1].equals(temp) && board[1][2].equals(temp)) ||
                (board[2][0].equals(temp) && board[2][1].equals(temp) && board[2][2].equals(temp)) ||
                (board[0][0].equals(temp) && board[1][0].equals(temp) && board[2][0].equals(temp)) ||
                (board[0][1].equals(temp) && board[1][1].equals(temp) && board[2][1].equals(temp)) ||
                (board[0][2].equals(temp) && board[1][2].equals(temp) && board[2][2].equals(temp)) ||
                (board[0][2].equals(temp) && board[1][1].equals(temp) && board[2][0].equals(temp)) ||
                (board[0][0].equals(temp) && board[1][1].equals(temp) && board[2][2].equals(temp)));
    }

    /**
     * PrintBoard method for playing TicTacToe
     * method to print current board state
     * @param board user input unchecked for validity that should indicate row box on board
     * return nothing, print out board state
     *
     */
    //Function that prints board to screen
    public static void PrintBoard(String[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].equals(Blank))
                    System.out.print("\t" + Blank + "\t|");
                else
                    System.out.print("\t" + board[row][col] + "\t|");
            }
            System.out.println();
        }
    }

    /**
     * checkInt method for playing TicTacToe
     * check for valid input from user
     * @param position user input for row or column to check if input is an integer between 0 and 2
     * @return boolean that returns true if user enters valid input, false otherwise
     *
     */
    private static boolean checkInt(String position)
    {
        boolean isValidInt = false;
        try{
            Integer.parseInt(position);
            isValidInt = true;
        }
        catch (NumberFormatException notInt)
        {
            System.out.println("Not a valid integer");
            isValidInt = false;
        }
        return isValidInt;
    }
}
