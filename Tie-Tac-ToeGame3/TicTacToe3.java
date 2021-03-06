import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe3 extends JFrame implements ActionListener
{
    static final String x = "x";
    static final String o = "o";

    private String plyr = "x";
    private int tie = 0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel label;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    public static void main(String[] args)
    {
        TicTacToe3 gui = new TicTacToe3( );
        gui.setVisible(true);
    }

    public TicTacToe3( ) {
        super("Welcome to Tic Tac Toe. X moves first.");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        label = new JLabel("");
        add(label, BorderLayout.NORTH);

        JPanel board = new JPanel();
        board.setLayout(new GridLayout(3, 3));
        button1 = new JButton("");
        button1.addActionListener(this);

        button2 = new JButton("");
        button2.addActionListener(this);

        button3 = new JButton("");
        button3.addActionListener(this);

        button4 = new JButton("");
        button4.addActionListener(this);

        button5 = new JButton("");
        button5.addActionListener(this);

        button6 = new JButton("");
        button6.addActionListener(this);

        button7 = new JButton("");
        button7.addActionListener(this);

        button8 = new JButton("");
        button8.addActionListener(this);

        button9 = new JButton("");
        button9.addActionListener(this);
        board.add(button1);
        board.add(button2);
        board.add(button3);
        board.add(button4);
        board.add(button5);
        board.add(button6);
        board.add(button7);
        board.add(button8);
        board.add(button9);


        add(board, BorderLayout.CENTER);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String val  = e.getActionCommand( );



        // boolean which checks to see whether player x or o won
        boolean x_won = false;
        boolean o_won = false;


        if (val.equals("")) {
            JButton button = (JButton) e.getSource();
            button.setText(plyr);
            tie++;
        }

        if (plyr == x) {
            //sets x_won to either true or false. If true the user wins if false user hasn't won, continue.
            x_won = winnerCheck(x);
            //change player if no win
            if (!x_won) {
                plyr = o;
                label.setText(plyr + " move.");
            }
        } else {
            //sets o_won to either true or false. If true the user wins if false user hasn't won, continue.
            o_won = winnerCheck(o);
            //change player if no win
            if (!o_won) {
                plyr = x;
                label.setText(plyr + " move.");
            }
        }

        if (tie == 9 && !x_won && !o_won) {
            label.setText("It's a tie!");
        }

        if (o_won || x_won) {
            label.setText(plyr + " is the winner!");

        }


    }
    private boolean winnerCheck(String temp)
    {
        return  button1.getText() == temp && button2.getText() == temp && button3.getText() == temp ||
                button4.getText() == temp && button5.getText() == temp && button6.getText() == temp ||
                button7.getText() == temp && button8.getText() == temp && button9.getText() == temp ||

                button1.getText() == temp && button4.getText() == temp && button7.getText() == temp ||
                button2.getText() == temp && button5.getText() == temp && button8.getText() == temp ||
                button3.getText() == temp &&  button6.getText() == temp && button9.getText() == temp ||

                button1.getText() == temp && button5.getText() == temp && button9.getText() == temp ||
                button7.getText() == temp && button5.getText() == temp && button3.getText() == temp;

    }
}
