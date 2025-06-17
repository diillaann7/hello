import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class t {
    public static void main(String[] args) {
        todo to = new todo();
    }

    public static class todo implements ActionListener {
        ArrayList<String> arr = new ArrayList<>();
        JFrame frame = new JFrame();
        JButton button = new JButton();
        JTextField field = new JTextField();
        JLabel titleLabel = new JLabel();
        JPanel todoPanel = new JPanel();
        int yOffset = 0;

        public todo() {

            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLayout(null);

            field.setBounds(100, 50, 200, 30);

            titleLabel.setText("To-Do-Liste");
            titleLabel.setBounds(200, 10, 100, 30);

            button.setText("Add");
            button.setBounds(320, 50, 80, 30);
            button.addActionListener(this);

            todoPanel.setBounds(100, 100, 300, 300);
            todoPanel.setLayout(null);
            todoPanel.setBackground(Color.LIGHT_GRAY);

            frame.add(field);
            frame.add(titleLabel);
            frame.add(button);
            frame.add(todoPanel);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = field.getText();

            if (!text.isEmpty() && !arr.contains(text)) {
                arr.add(text);

                JLabel todoLabel = new JLabel(text);
                todoLabel.setBounds(10, yOffset, 280, 30);
                todoPanel.add(todoLabel);

                yOffset += 35;

                todoPanel.repaint();
                todoPanel.revalidate();

                field.setText("");
            }
        }
    }
}
