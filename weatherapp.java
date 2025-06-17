import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class weatherapp {
    public static void main(String[] args) {
        WeatherFrame fr = new WeatherFrame();
    }

    public static class WeatherFrame extends JFrame {
        private int y = 100;
        private int x1 = 10;
        private ArrayList<String> arr = new ArrayList<>();
        private JTextField field;
        private JButton button;

        public WeatherFrame() {
            setSize(500, 500);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);

            JLabel label = new JLabel("TO-DO-LISTE");
            label.setBounds(200, 10, 200, 50);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setForeground(Color.BLACK);

            field = new JTextField();
            field.setBounds(10, 50, 400, 50);

            button = new JButton("Search");
            button.setBounds(400, 50, 75, 50);

            add(label);
            add(field);
            add(button);

            setVisible(true);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action();
                }
            });
        }

        public void action() {
            try {
                String input = field.getText().trim();

                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Das Eingabefeld darf nicht leer sein!");
                    return;
                }

                if (arr.contains(input)) {
                    throw new Exception("Bereits vorhanden");
                }

                arr.add(input);

                JLabel newLabel = new JLabel(input);
                newLabel.setBounds(x1, y, 400, 20);
                newLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                add(newLabel);

                y += 30;

                if (y > getHeight()) {
                    x1 += 20;
                    y = 100;
                }

                revalidate();
                repaint();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Dieser Wert ist schon vorhanden!");
            }
        }
    }
}
