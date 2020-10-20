import java.util.Arrays;
import java.util.Scanner;
public class TicTacToe2 {
    static final String x = "x";
    static final String o = "o";
    static final String Blank = "_";

    public static void main(String[] args) {
        // boolean used to allow user either play again or quit game
        boolean Restart = true;
        // String used for player to enter a response to continue or end game
        String Answer;
        while (Restart) {

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

                System.out.println("Enter a row and column between (0, 1, or 2) for player " + plyr + ":");
                // allows users enters row and column of board
                int row = keyboard.nextInt();
                int col = keyboard.nextInt();

                // checks if the users row or col are out of bounds of the table
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Out of bounds.");
                    System.out.println("Try again.");
                    continue;
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
            if (tie == 9) {
                System.out.println("It's a tie!");
                // prints the player who won the game
            } else {
                System.out.println(plyr + " is the winner! Good game!");
            }
            System.out.println("Play again?");
            System.out.println("Enter Yes or No");
            Answer = keyboard.next();
            if (Answer.equalsIgnoreCase("No"))
            {
                System.out.println("QUIT GAME");
                Restart = false;
                System.exit(0);
            }
            else if (Answer.equalsIgnoreCase("Yes"))
            {
                System.out.println("LETS PLAY");
                Restart = true;
            }
            else
            {
                System.out.println("Invalid response!");
                System.out.println("END GAME");
                Restart = false;
                System.exit(0);
            }
        }
    }

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
}
