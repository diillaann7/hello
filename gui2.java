
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gui2{
    public static void main(String[] args) {
        
    }

    public static class gui{
        JFrame frame=new JFrame();
        JLabel label=new JLabel();
        JPanel panel=new JPanel();
        JButton[] button=new JButton[9];
        
        
        
        public gui(){
            frame.setSize(200,200);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.setVisible(true);


        
        }
    }

    
}