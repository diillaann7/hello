import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class login {
    public static void main(String[] args) {
        lo l = new lo();
    }

    public static class lo implements ActionListener {

        ArrayList<String> arr = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();

        JFrame frame = new JFrame();
        JTextField field = new JTextField();
        JTextField field2 = new JTextField();
        JButton button = new JButton();
        JLabel labelusername = new JLabel();
        JLabel labelpassowrt = new JLabel();

        public lo() {

            arr.add("dilan");
            dic.put("dilan", 1234);
            labelusername.setText("benutzername");
            labelusername.setBounds(150, 10, 100, 100);
            labelpassowrt.setText("passwort");
            labelpassowrt.setBounds(150, 60, 100, 100);

            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLayout(null);

            field.setBounds(50, 50, 100, 20);
            field2.setBounds(50, 100, 100, 20);

            button.setBounds(200, 400, 100, 100);
            button.setText("Login");

            button.addActionListener(this);

            frame.add(button);
            frame.add(field);
            frame.add(labelusername);
            frame.add(labelpassowrt);
            frame.add(field2);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = field.getText();
            String passwort = field2.getText();

            if (arr.contains(name)) {
                try {

                    int passwortInt = Integer.parseInt(passwort);
                    if (dic.get(name) == passwortInt) {

                        new d();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Falsches Passwort!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Passwort muss eine Zahl sein!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Benutzername existiert nicht!");
            }
        }
    }
}
