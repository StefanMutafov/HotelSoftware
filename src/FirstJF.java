import javax.swing.*;
import java.awt.*;

public class FirstJF extends JFrame {
    public FirstJF(String title){
        setVisible(true);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        // setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        buildFrame();
    }

    private void buildFrame() {
        registerFormJF rf = new registerFormJF();
       rf.setAlignmentX(this.CENTER_ALIGNMENT);
       rf.setBounds((this.getWidth() -rf.getWidth())/2, this.getHeight() -rf.getHeight())/2, rf.getWidth(), rf.getHeight() );

        add(rf);
        repaint();
    }

    public static void main(String[] args) {
        new FirstJF("Sign in or register");

    }

}
