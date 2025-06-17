import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class e {
    public static void main(String[] args) {
        taschen ta = new taschen();
    }

    public static class taschen implements ActionListener {
        JFrame frame = new JFrame();
        JTextField field = new JTextField();
        JButton[] numberButtons = new JButton[10];
        JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
        JPanel panel = new JPanel();

        double num1 = 0, num2 = 0, result = 0;
        char operator;

        public taschen() {
            frame.setSize(500, 500);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.getContentPane().setBackground(Color.BLACK);
            frame.setLayout(null);

            field.setBounds(0, 0, 500, 50);
            field.setEditable(false);
            frame.add(field);

            addButton = new JButton("+");
            subButton = new JButton("-");
            mulButton = new JButton("*");
            divButton = new JButton("/");
            eqButton = new JButton("=");
            clrButton = new JButton("C");

            for (int i = 0; i < 10; i++) {
                numberButtons[i] = new JButton(String.valueOf(i));
                numberButtons[i].addActionListener(this);
            }

            addButton.addActionListener(this);
            subButton.addActionListener(this);
            mulButton.addActionListener(this);
            divButton.addActionListener(this);
            eqButton.addActionListener(this);
            clrButton.addActionListener(this);

            panel.setLayout(new GridLayout(4, 4, 10, 10));
            panel.setBounds(50, 70, 400, 350);
            panel.setBackground(Color.DARK_GRAY);

            panel.add(numberButtons[1]);
            panel.add(numberButtons[2]);
            panel.add(numberButtons[3]);
            panel.add(addButton);

            panel.add(numberButtons[4]);
            panel.add(numberButtons[5]);
            panel.add(numberButtons[6]);
            panel.add(subButton);

            panel.add(numberButtons[7]);
            panel.add(numberButtons[8]);
            panel.add(numberButtons[9]);
            panel.add(mulButton);

            panel.add(clrButton);
            panel.add(numberButtons[0]);
            panel.add(eqButton);
            panel.add(divButton);

            frame.add(panel);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    field.setText(field.getText() + i);
                }
            }

            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(field.getText());
                operator = '+';
                field.setText("");
            } else if (e.getSource() == subButton) {
                num1 = Double.parseDouble(field.getText());
                operator = '-';
                field.setText("");
            } else if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(field.getText());
                operator = '*';
                field.setText("");
            } else if (e.getSource() == divButton) {
                num1 = Double.parseDouble(field.getText());
                operator = '/';
                field.setText("");
            } else if (e.getSource() == eqButton) {
                num2 = Double.parseDouble(field.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                    case '/':
                        result = num1 / num2;
                    default:
                        throw new AssertionError();
                }
                field.setText("");

                field.setText(String.valueOf(result));
                num1 = result;

            } else if (e.getSource() == clrButton) {
                field.setText("");
                num1 = num2 = result = 0;
            }

        }

    }

}
