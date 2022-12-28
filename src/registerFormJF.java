import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class registerFormJF extends JPanel{





    public registerFormJF(){
        setSize(400,500);
        setOpaque(true);
        setVisible(true);
        setBackground(Color.black);
//            setTitle(title);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //setSize(1920,1080);
//            setExtendedState(JFrame.MAXIMIZED_BOTH);
//            setLocationRelativeTo(null);
           // setUndecorated(true);
            setLayout(null);
            setVisible(true);
            buildPain();
//            setResizable(false);
        }



    private void buildPain(){


            JLabel userL = new JLabel("Your username");
            userL.setBounds(1,  1, 100, 100);
            userL.setBackground(Color.WHITE);
            userL.setOpaque(true);






            repaint();
           add(userL);
        }



//        public static void main(String[] args) {
//            new registerFormJF("Log-In or Register");
//
//        }

}
