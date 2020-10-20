import java.util.Scanner;
public class TicTacToe1 {
    static final char x = 'x';
    static final char o = 'o';
    static int Row = 0;
    static int Col = 0;
    public static void main(String[] args) {
        // boolean used to allow user either play again or quit game
        boolean Restart = true;
        // String used for player to enter a response to continue or end game
        String Answer;
        while (Restart) {
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












