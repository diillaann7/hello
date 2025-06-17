import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class weather {
    public static void main(String[] args) {
        tictactoe tic = new tictactoe();

    }

    public static class tictactoe implements ActionListener {
        Random random = new Random();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JLabel label = new JLabel();
        JButton[] buttons = new JButton[9];
        boolean player1_turn;

        tictactoe() {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.getContentPane().setBackground(Color.white);
            frame.setLayout(new BorderLayout());
            frame.setResizable(false);

            label.setBackground(Color.BLUE);
            label.setForeground(Color.CYAN);
            label.setFont(new Font("Ink Free", Font.BOLD, 75));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.TOP);
            label.setText("Tic-Tac-Toe");
            label.setOpaque(true);
            frame.add(label, BorderLayout.NORTH);

            panel1.setLayout(new GridLayout(3, 3)); // Korrekte Initialisierung von GridLayout (3x3)
            for (int i = 0; i < buttons.length; i++) { // Korrektur der Schleife (i < buttons.length)
                buttons[i] = new JButton();
                buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i].setBackground(Color.gray);
                buttons[i].addActionListener(this);
                panel1.add(buttons[i]);
            }
            frame.add(panel1, BorderLayout.CENTER); // Panel richtig zum Frame hinzufügen
            frame.setVisible(true);
            firstturn();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons[i]) {
                    if (player1_turn) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(255, 0, 0));
                            buttons[i].setText("X");
                            player1_turn = false;
                            label.setText("O turn");
                            check();
                        }
                    } else {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(0, 0, 255));
                            buttons[i].setText("O");
                            player1_turn = true;
                            label.setText("X turn");
                            check();
                        }
                    }
                }
            }

        }

        public void firstturn() {
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (random.nextInt(2) == 0) {
                player1_turn = true;
                label.setText("X turn");
            } else {
                player1_turn = false;
                label.setText("O turn");
            }

        }

        public void check() {
            if ((buttons[0].getText() == "X") &&
                    (buttons[1].getText() == "X") &&
                    (buttons[2].getText() == "X")) {
                xwins(0, 1, 2);
            }
            if ((buttons[3].getText() == "X") &&
                    (buttons[4].getText() == "X") &&
                    (buttons[5].getText() == "X")) {
                xwins(3, 4, 5);
            }
            if ((buttons[6].getText() == "X") &&
                    (buttons[7].getText() == "X") &&
                    (buttons[8].getText() == "X")) {
                xwins(6, 7, 8);
            }
            if ((buttons[0].getText() == "X") &&
                    (buttons[3].getText() == "X") &&
                    (buttons[6].getText() == "X")) {
                xwins(0, 3, 6);
            }
            if ((buttons[1].getText() == "X") &&
                    (buttons[4].getText() == "X") &&
                    (buttons[7].getText() == "X")) {
                xwins(1, 4, 7);
            }
            if ((buttons[2].getText() == "X") &&
                    (buttons[5].getText() == "X") &&
                    (buttons[8].getText() == "X")) {
                xwins(2, 5, 8);
            }
            if ((buttons[0].getText() == "X") &&
                    (buttons[4].getText() == "X") &&
                    (buttons[8].getText() == "X")) {
                xwins(0, 4, 8);
            }
            if ((buttons[2].getText() == "X") &&
                    (buttons[4].getText() == "X") &&
                    (buttons[6].getText() == "X")) {
                xwins(2, 4, 6);
            }
            if ((buttons[0].getText() == "O") &&
                    (buttons[1].getText() == "O") &&
                    (buttons[2].getText() == "O")) {
                owins(0, 1, 2);
            }
            if ((buttons[3].getText() == "O") &&
                    (buttons[4].getText() == "O") &&
                    (buttons[5].getText() == "O")) {
                owins(3, 4, 5);
            }
            if ((buttons[6].getText() == "O") &&
                    (buttons[7].getText() == "O") &&
                    (buttons[8].getText() == "O")) {
                owins(6, 7, 8);
            }
            if ((buttons[0].getText() == "O") &&
                    (buttons[3].getText() == "O") &&
                    (buttons[6].getText() == "O")) {
                owins(0, 3, 6);
            }
            if ((buttons[1].getText() == "O") &&
                    (buttons[4].getText() == "O") &&
                    (buttons[7].getText() == "O")) {
                owins(1, 4, 7);
            }
            if ((buttons[2].getText() == "O") &&
                    (buttons[5].getText() == "O") &&
                    (buttons[8].getText() == "O")) {
                owins(2, 5, 8);
            }
            if ((buttons[0].getText() == "O") &&
                    (buttons[4].getText() == "O") &&
                    (buttons[8].getText() == "O")) {
                owins(0, 4, 8);
            }
            if ((buttons[2].getText() == "O") &&
                    (buttons[4].getText() == "O") &&
                    (buttons[6].getText() == "O")) {
                owins(2, 4, 6);
            }
            boolean dr = true;
            for (int i = 0; i < 9; i++) {
                if (buttons[i].getText() == "") {
                    dr = false;
                    break;

                }

            }
            if (dr) {
                draw();
            }
        }

        public void xwins(int a, int b, int c) {
            buttons[a].setBackground(Color.green);
            buttons[b].setBackground(Color.green);
            buttons[c].setBackground(Color.green);
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            label.setText("X wins");
        }

        public void owins(int a, int b, int c) {
            buttons[a].setBackground(Color.green);
            buttons[b].setBackground(Color.green);
            buttons[c].setBackground(Color.green);
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            label.setText("O wins");
        }

        public void draw() {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
                label.setText("draw");

            }
        }
    }
}
