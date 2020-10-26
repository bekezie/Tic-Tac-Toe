import java.util.Scanner;

/**
 * This will play the game TicTacToe with two players each taking turns.
 * Each user will insert a number from 1 to 9 to tell which space
 * they wish to put their symbol (x or o) into.
 * Then a winner or tie will be determined, good luck to the players.
 *
 * Author: Bernard Ekezie, Christopher Morris, Blake Koontz
 * Version: 1.2
 * since: 2020-10-20
 *
 * Note: Errors occur when using "at" symbol as tags show unrecognized
 */


public class TicTacToe1 {

        /**
        *  constant symbol used by player x to mark spots on game board
        */
        static final char x = 'x';

        /**
         *  constant symbol used by player o to mark spots on game board
        */
        static final char o = 'o';

        /**
        *  Initialize row at 0
        */
        static int Row = 0;

        /**
        *  Initialize col at 0
        */
        static int Col = 0;


        /**
         *  main method for playing TicTacToe
         *  Initialize variables for loop for game to begin
         *  then initalize variables used at beginning of game
         *  afterward game begins in loop with game board of 1 to 9.
         * Prompt user for input then take in both user's
         *  input (x and o) sequentially validate input and then
         *  mark board till one user is winner then ask users if play again
         * @param args Unused
         *
        */
        public static void main(String[] args) {
        boolean restart = true;
        // String used for player to enter a response to continue or end game
        String answer;

        while (restart) {

            System.out.println("LETS PLAY");
            // initializing the entire board to "blank spaces" to bypass nullpointer exception
            char[][] board = {{'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'},};
            // player
            char plyr = x;
            // tie set to zero
            int tie = 0;

            // boolean which checks to see whether player x or o won
            boolean x_won = false;
            boolean o_won = false;


            System.out.println("Welcome to Tic Tac Toe. X moves first.");
            PrintBoard(board);
            //Calls function to prints board to screen
            Scanner keyboard = new Scanner(System.in);

            // loop that continues to run game while neither x or o has won and game is not tied.
            while (!x_won && !o_won && tie < 9) {

                System.out.println("Enter a position from (1 to 9) for player " + plyr + ":");
                // allows users enters position of board
                String position = keyboard.next();

                // function used to retrieve row of position chosen
                Row = Rows(position);

                // function used to retrieve column of position chosen
                Col = Cols(position);

                // checks if the users row or col are out of bounds of the table
                if (Row < 0 || Col > 2 || Row < 0 || Col > 2) {
                    System.out.println("Out of bounds.");
                    System.out.println("Try again.");
                    continue;
                }

                // check if the users tries to take a space that has already been filled
                if (board[Row][Col] == x || board[Row][Col] == o) {
                    System.out.println("Space already taken!");
                    System.out.println("Try again.");
                    continue;
                }


                // sets location of board equal to player which is either x or o
                board[Row][Col] = plyr;
                //calls function to prints board to screen
                PrintBoard(board);
                // increments tie by 1
                tie++;

                // check to see whether plyr is equal to x
                if (plyr == x) {
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
            if (tie == 9 && !x_won && !o_won) {
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
        System.out.println("QUIT GAME");
        System.exit(0);
    }

    /**
     *  Rows method for playing TicTacToe
     *  check for input validation and indicate which row box to fill in from user input
     * @param  position user input unchecked for validity that should indicate row box on board
     * @return int that should be checked and validated to be correct row box on board
     *
     */
    // function that returns row location of position
    private static int Rows(String position)
    {
        if (position.equals("1"))
            return 0;
        else if (position.equals("2"))
            return 0;
        else if (position.equals("3"))
            return 0;
        else if (position.equals("4"))
            return 1;
        else if (position.equals("5"))
            return 1;
        else if (position.equals("6"))
            return 1;
        else if (position.equals("7"))
            return 2;
        else if (position.equals("8"))
            return 2;
        else if (position.equals("9"))
            return 2;
        else
        {
            return -1; //Needed to keep the compiler happy
        }
    }

    /**
     *  Cols method for playing TicTacToe
     *  check for input validation and indicate which row box to fill in from user input
     * @param  position user input unchecked for validity that should indicate cols box on board
     * @return int that should be checked and validated to be correct cols box on board
     *
     */
    // function that returns column location of position
    private static int Cols(String position)
    {
        if (position.equals("1"))
            return 0;
        else if (position.equals("2"))
            return 1;
        else if (position.equals("3"))
            return 2;
        else if (position.equals("4"))
            return 0;
        else if (position.equals("5"))
            return 1;
        else if (position.equals("6"))
            return 2;
        else if (position.equals("7"))
            return 0;
        else if (position.equals("8"))
            return 1;
        else if (position.equals("9"))
            return 2;
        else
        {
            return -1; //Needed to keep the compiler happy
        }
    }

    /**
     *
     * Check combinations if user wins to get 3 in a row
     * @param  temp user input unchecked for validity that should indicate cols box on board
     * @param board array of array that contains the game board with squares filled
     * @return boolean that indicates true if user won and false if no win
     *
     */
    // Function that checks to see whether player is equal to one of the 3 locations in board: horizontal, vertical, or diagonal
    // If so it return true else it returns false
    private static boolean winnerCheck(char[][] board, char temp) {
        return ((board[0][0] == (temp) && board[0][1] == (temp) && board[0][2] == (temp)) ||
                (board[1][0] == (temp) && board[1][1] == (temp) && board[1][2] == (temp)) ||
                (board[2][0] == (temp) && board[2][1] == (temp) && board[2][2] == (temp)) ||
                (board[0][0] == (temp) && board[1][0] == (temp) && board[2][0] == (temp)) ||
                (board[0][1] == (temp) && board[1][1] == (temp) && board[2][1] == (temp)) ||
                (board[0][2] == (temp) && board[1][2] == (temp) && board[2][2] == (temp)) ||
                (board[0][2] == (temp) && board[1][1] == (temp) && board[2][0] == (temp)) ||
                (board[0][0] == (temp) && board[1][1] == (temp) && board[2][2] == (temp)));
    }

    /**
     * Print the game board everytime for visual of game
     * @param  board array of array that contains the game board with squares filled
     *
     */
    //Function that prints board to screen
    public static void PrintBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                if (board[row][col] != x || board[row][col] != o)
                    System.out.print("\t" + board[row][col] + "\t|");
                else
                    System.out.print("\t" + board[row][col] + "\t|");
            System.out.println();

        }
        System.out.println();
    }
}














