import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class t {
    public static void main(String[] args) {

        String[] arr = { "dilan", "sonya", "sima", "selina" };
        String[] arr2 = { "1234" };

        JFrame frame = new JFrame();
        frame.setTitle("Login");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel label = new JLabel();
        label.setText("Gebe deine Login-Daten ein");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setBounds(50, 20, 400, 50);
        label.setOpaque(true);

        JLabel usernameLabel = new JLabel("Benutzername:");
        usernameLabel.setBounds(50, 100, 150, 30);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(200, 100, 200, 30);

        JLabel passwordLabel = new JLabel("Passwort:");
        passwordLabel.setBounds(50, 150, 150, 30);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 150, 200, 30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(200, 200, 100, 30);

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String name1 = usernameField.getText();
                String pass = new String(passwordField.getPassword());
                boolean succes = false;

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals(name1)) {
                        if (arr2[0].equals(pass)) {
                            succes = true;
                            break;

                        }
                    }

                }
                if (succes) {

                    JFrame f = new JFrame();
                    f.setTitle("porn");
                    f.setSize(500, 500);
                    f.getContentPane().setBackground(Color.BLACK);
                    f.setResizable(false);
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JLabel jj = new JLabel();
                    jj.setForeground(Color.WHITE);
                    jj.setText("willkommen auf der pornoseite");
                    jj.setVerticalAlignment(SwingConstants.CENTER);
                    jj.setHorizontalAlignment(SwingConstants.CENTER);

                    f.add(jj);
                    f.setVisible(true);

                }

            }

        });

        frame.setLayout(null);
        frame.add(label);
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);

        frame.setVisible(true);
    }
}
