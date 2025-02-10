import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tictactoe {
    public static void main(String[] args) {
        tic t = new tic();
    }

    public static class tic implements ActionListener {
        JFrame frame = new JFrame();
        JButton[] buttons = new JButton[9];
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        Random random = new Random();

        boolean player1 = true;
        boolean gameOver = false;

        public tic() {
            frame.setSize(500, 500);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            panel.setLayout(new GridLayout(3, 3, 10, 10));
            panel.setBounds(50, 70, 400, 350);
            frame.add(panel);
            label.setText("tic tac toe");

            for (int i = 0; i < 9; i++) {
                buttons[i] = new JButton();
                buttons[i].setBackground(Color.gray);
                buttons[i].setFocusPainted(false);
                buttons[i].addActionListener(this);
                panel.add(buttons[i]);
            }
            frame.add(label);
            frame.setVisible(true);
            player();

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (gameOver)
                return;

            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons[i]) {
                    if (buttons[i].getText().equals("")) {
                        if (player1) {
                            label.setText("Player O");
                            buttons[i].setText("X");
                            buttons[i].setBackground(Color.CYAN);

                        } else {
                            label.setText("Player X");
                            buttons[i].setText("O");
                            buttons[i].setBackground(Color.green);
                        }
                        player1 = !player1;
                        check();
                        if (!gameOver && draw()) {
                            label.setText("draw");
                            gameOver = true;
                            return;

                        }
                    }
                }
            }
        }

        public void check() {

            if (buttons[0].getText().equals("X") &&
                    buttons[1].getText().equals("X") &&
                    buttons[2].getText().equals("X")) {
                xwins(0, 1, 2);
                return;
            }
            if (buttons[3].getText().equals("X") &&
                    buttons[4].getText().equals("X") &&
                    buttons[5].getText().equals("X")) {
                xwins(3, 4, 5);
                return;
            }
            if (buttons[6].getText().equals("X") &&
                    buttons[7].getText().equals("X") &&
                    buttons[8].getText().equals("X")) {
                xwins(6, 7, 8);
                return;
            }
            if (buttons[0].getText().equals("X") &&
                    buttons[3].getText().equals("X") &&
                    buttons[6].getText().equals("X")) {
                xwins(0, 3, 6);
                return;
            }
            if (buttons[1].getText().equals("X") &&
                    buttons[4].getText().equals("X") &&
                    buttons[7].getText().equals("X")) {
                xwins(1, 4, 7);
                return;
            }
            if (buttons[2].getText().equals("X") &&
                    buttons[5].getText().equals("X") &&
                    buttons[8].getText().equals("X")) {
                xwins(2, 5, 8);
                return;
            }
            if (buttons[0].getText().equals("X") &&
                    buttons[4].getText().equals("X") &&
                    buttons[8].getText().equals("X")) {
                xwins(0, 4, 8);
                return;
            }
            if (buttons[2].getText().equals("X") &&
                    buttons[4].getText().equals("X") &&
                    buttons[6].getText().equals("X")) {
                xwins(2, 4, 6);
                return;
            }

            if (buttons[0].getText().equals("O") &&
                    buttons[1].getText().equals("O") &&
                    buttons[2].getText().equals("O")) {
                owins(0, 1, 2);
                return;
            }
            if (buttons[3].getText().equals("O") &&
                    buttons[4].getText().equals("O") &&
                    buttons[5].getText().equals("O")) {
                owins(3, 4, 5);
                return;
            }
            if (buttons[6].getText().equals("O") &&
                    buttons[7].getText().equals("O") &&
                    buttons[8].getText().equals("O")) {
                owins(6, 7, 8);
                return;
            }
            if (buttons[0].getText().equals("O") &&
                    buttons[3].getText().equals("O") &&
                    buttons[6].getText().equals("O")) {
                owins(0, 3, 6);
                return;
            }
            if (buttons[1].getText().equals("O") &&
                    buttons[4].getText().equals("O") &&
                    buttons[7].getText().equals("O")) {
                owins(1, 4, 7);
                return;
            }
            if (buttons[2].getText().equals("O") &&
                    buttons[5].getText().equals("O") &&
                    buttons[8].getText().equals("O")) {
                owins(2, 5, 8);
                return;
            }
            if (buttons[0].getText().equals("O") &&
                    buttons[4].getText().equals("O") &&
                    buttons[8].getText().equals("O")) {
                owins(0, 4, 8);
                return;
            }
            if (buttons[2].getText().equals("O") &&
                    buttons[4].getText().equals("O") &&
                    buttons[6].getText().equals("O")) {
                owins(2, 4, 6);
                return;
            }
        }

        public void xwins(int x, int y, int z) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
                buttons[i].setBackground(Color.gray);
            }
            buttons[x].setBackground(Color.CYAN);
            buttons[y].setBackground(Color.CYAN);
            buttons[z].setBackground(Color.CYAN);
            gameOver = true; //
        }

        public void owins(int x, int y, int z) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
                buttons[i].setBackground(Color.gray);
            }
            buttons[x].setBackground(Color.green);
            buttons[y].setBackground(Color.green);
            buttons[z].setBackground(Color.green);
            gameOver = true;
        }

        public void player() {

            int randomPlayer = random.nextInt(2);

            if (randomPlayer == 0) {

                player1 = true;
                label.setText("Player 1 (X) starts!");
                label.setBounds(0, 10, 100, 50);
                frame.add(label);
            } else {

                player1 = false;
                label.setText("Player 2 (O) starts!");
                label.setBounds(0, 10, 300, 50);
                frame.add(label);
            }
        }

        public boolean draw() {
            for (JButton but : buttons) {
                if (but.getText().equals("")) {
                    return false;
                }

            }
            return true;

        }

    }

}
