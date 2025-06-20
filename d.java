import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class d {
    public static void main(String[] args) {
        d outerClass = new d();
        Calculator ca = outerClass.new Calculator();

    }

    public class Calculator implements ActionListener {
        JFrame frame = new JFrame();
        JTextField field = new JTextField();
        JButton[] numberButtons = new JButton[10];
        JButton[] functionButtons = new JButton[8];
        JButton addButton, subButton, mulButton, divButton;
        JButton decButton, eqButton, delButton, clrButton;
        JPanel panel;

        Font myFont = new Font("Ink Free", Font.BOLD, 30);

        double num1 = 0, num2 = 0, result = 0;
        char operator;

        Calculator() {
            frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420, 550);
            frame.setLayout(null);
            field = new JTextField();
            field.setBounds(50, 25, 300, 50);
            field.setFont(myFont);
            field.setEditable(false);
            addButton = new JButton("+");
            subButton = new JButton("-");
            mulButton = new JButton("*");
            divButton = new JButton("/");
            decButton = new JButton(".");
            eqButton = new JButton("=");
            delButton = new JButton("delete");
            clrButton = new JButton("clr");
            functionButtons[0] = addButton;
            functionButtons[1] = subButton;
            functionButtons[2] = mulButton;
            functionButtons[3] = divButton;
            functionButtons[4] = decButton;
            functionButtons[5] = eqButton;
            functionButtons[6] = delButton;
            functionButtons[7] = clrButton;

            for (int i = 0; i < 8; i++) {
                functionButtons[i].addActionListener(this);
                functionButtons[i].setFont(myFont);
                functionButtons[i].setFocusable(false);

            }
            for (int i = 0; i < 10; i++) {
                numberButtons[i] = new JButton(String.valueOf(i));
                numberButtons[i].addActionListener(this);
                numberButtons[i].setFont(myFont);
                numberButtons[i].setFocusable(false);
            }
            delButton.setBounds(50, 430, 145, 50);
            clrButton.setBounds(205, 430, 145, 50);
            panel = new JPanel();
            panel.setBounds(50, 100, 300, 300);
            panel.setLayout(new GridLayout(4, 4, 10, 10));
            panel.setBackground(Color.gray);
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
            panel.add(decButton);
            panel.add(numberButtons[0]);
            panel.add(eqButton);
            panel.add(divButton);

            frame.add(panel);
            frame.add(clrButton);
            frame.add(delButton);
            frame.add(field);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    field.setText(field.getText().concat(String.valueOf(i)));

                }

            }
            if (e.getSource() == decButton) {
                field.setText(field.getText().concat(String.valueOf(".")));
            }
            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(field.getText());
                operator = '+';
                field.setText("");
            }
            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(field.getText());
                operator = '-';
                field.setText("");
            }
            if (e.getSource() == divButton) {
                num1 = Double.parseDouble(field.getText());
                operator = '/';
                field.setText("");
            }
            if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(field.getText());
                operator = '*';
                field.setText("");
            }
            if (e.getSource() == eqButton) {
                num2 = Double.parseDouble(field.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                }
                field.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource() == clrButton) {
                field.setText("");
            }
            if (e.getSource() == delButton) {
                String string = field.getText();
                field.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    field.setText(field.getText() + string.charAt(i));

                }
            }
        }
    }
}
