import Objects.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Written by Stefan Mutafov
public class LoginMenu extends JFrame {
    //Setting LoginMenu values
    public LoginMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520,670);
        setLayout(new BorderLayout());
       // setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        //getContentPane().setBackground( Color.YELLOW );
        buildLoginMenu();
        setVisible(true);
    }

    private void buildLoginMenu() {



//        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("icons/background.jpg"));
        add(background);
        //background.setLayout(new FlowLayout());
        background.setLayout(null);


        JLabel close  = new JLabel("<html>✕</html>");
        close.setBackground(null);
        close.setForeground(Color.LIGHT_GRAY);
        close.setOpaque(true);
        close.setBounds(460,0,60,30);
        close.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
        close.setVerticalAlignment(SwingConstants.CENTER);
        close.setHorizontalAlignment(SwingConstants.CENTER);
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                close.setBackground(Color.RED); close.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                close.setBackground(null); close.setForeground(Color.LIGHT_GRAY);
            }
            @Override
            public void mousePressed(MouseEvent e) {
               close.setBackground(new Color(115, 6, 26));
            }

            @Override
            public void mouseReleased(MouseEvent e){
                LoginMenu.super.dispose();
            }
        });






        JLabel minimise  = new JLabel("<html>-</html>");
        minimise.setForeground(Color.LIGHT_GRAY);
        minimise.setBackground(null);
        minimise.setOpaque(true);
        minimise.setBounds(400,0,60,30);
        minimise.setFont(new Font("Verdana", Font.BOLD, 18));
        minimise.setVerticalAlignment(SwingConstants.CENTER);
        minimise.setHorizontalAlignment(SwingConstants.CENTER);
        minimise.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                minimise.setBackground(Color.LIGHT_GRAY);minimise.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                minimise.setBackground(null);minimise.setForeground(Color.LIGHT_GRAY);
            }
            @Override
            public void mousePressed(MouseEvent e) {
               minimise.setBackground(new Color(189, 153, 159));
            }

            @Override
            public void mouseReleased(MouseEvent e){
                LoginMenu.super.setState(Frame.ICONIFIED);
            }
        });





        JLabel loggingSign = new JLabel("<html>SIGN IN</html>");
        loggingSign.setOpaque(false);
        loggingSign.setBounds(65,100,100,30);
        loggingSign.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
        loggingSign.setVerticalAlignment(SwingConstants.CENTER);
        //loggingSign.setHorizontalAlignment(SwingConstants.CENTER);
        loggingSign.setForeground(Color.WHITE);
        loggingSign.setBackground(null);


        ///Spacer for the textarea
        RoundJLabel spacerU = new RoundJLabel(125, 150, 330, 50, 50, 50);
        spacerU.setOpaque(false);
        spacerU.setBackground(new Color(0,0,0,75));
        background.add(spacerU);


        HintTextField username = new HintTextField("Username", 50, 50);
        username.setBackground(new Color(0,0,0,0));
        //username.setForeground(Color.WHITE);
        username.setBounds(15, 0, 370, 50); // relative to spacerU
        username.setOpaque(false);



        JLabel uIcon = new JLabel(new ImageIcon("icons/icons8-user-641.png"));
        uIcon.setOpaque(false);
        uIcon.setFont(uIcon.getFont().deriveFont(Font.ITALIC));
        uIcon.setHorizontalAlignment(JLabel.CENTER);
        uIcon.setVerticalAlignment(JLabel.CENTER);
        // uIcon.setOpaque(true);
        uIcon.setBounds(65, 145, 60,60);
        //validate();


        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("icons/user1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        RoundJPanel p = new RoundJPanel( 0, 150, 38,38, 50, 50);
        p.add(picLabel);
        //add(p);



        //Spacer for password
        RoundJLabel spacerP = new RoundJLabel(125, 230, 330, 50, 50, 50);
        spacerP.setOpaque(false);
        spacerP.setBackground(new Color(0,0,0,70));
        background.add(spacerP);

        HintPassField password = new HintPassField("Password",50, 50);
        password.setBackground(new Color(0,0,0,0));
        password.setBounds(15, 0, 370, 50); //Relative to spacerP
        password.setOpaque(false);





        JLabel pIcon = new JLabel(new ImageIcon("icons/icons8-secure-60.png"));
        pIcon.setOpaque(false);
        pIcon.setFont(uIcon.getFont().deriveFont(Font.ITALIC));
        pIcon.setHorizontalAlignment(JLabel.CENTER);
        pIcon.setVerticalAlignment(JLabel.CENTER);
        // uIcon.setOpaque(true);
        pIcon.setBounds(65, 225, 60,60);
        //validate();




        JLabel showP = new JLabel(new ImageIcon("icons/show.png"));
        showP.setFont(showP.getFont().deriveFont(Font.ITALIC));
        showP.setHorizontalAlignment(JLabel.CENTER);
        // uIcon.setOpaque(true);
        showP.setBounds(455, 230, 32, 32);
        showP.addMouseListener(new MouseAdapter() {
        });
        //validate();

        showP.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                password.setEchoChar((char) 0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                password.setEchoChar(HintPassField.getDefaultt());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }
        });


        CustomRoundButton  login = new CustomRoundButton(65, 330, 390, 50, 50,50);
        login.setIdle(new Color(16, 88, 204));
        login.setEntered(new Color(7, 51, 122));
        login.setBackground(new Color(16, 88, 204));
        login.setForeground(null);
        login.setFont(new Font("Arial", Font.PLAIN, 18));
        login.setText("<html><font color='white'>Login</font></html>");
        login.setOpaque(false);


//
//        UIManager.put("Button.select", Color.red);
//        roundButton login = new roundButton("Login");
//        login.setBackground(Color.red);
//        login.setOpaque(false);
//        login.setBounds(225/2, 180, 225,30);



        JLabel reg = new JLabel("<html>SIGN UP</html>");
        reg.setOpaque(false);
        reg.setBounds(195,100,120,30);
        reg.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
        reg.setVerticalAlignment(SwingConstants.CENTER);
        reg.setForeground(Color.WHITE);
        reg.setBackground(null);








    //
    //    Adding elements
    //
        background.add(close);
        background.add(minimise);
        background.add(loggingSign);
        spacerU.add(username);
        background.add(uIcon);
        spacerP.add(password);
        background.add(pIcon);
        background.add(login);
        background.add(reg);
        background.add(showP);
        repaint();
        background.repaint();

    }



}
