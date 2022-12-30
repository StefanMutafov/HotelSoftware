import Objects.*;

import javax.imageio.ImageIO;
import javax.swing.*;
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
    public LoginMenu(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,550);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground( Color.YELLOW );
        buildLoginMenu();
        setVisible(true);
    }

    private void buildLoginMenu() {


        JLabel close  = new JLabel("<html>X</html>");
        close.setOpaque(true);
        close.setBounds(435,0,15,15);
        close.setFont(new Font("Verdana", Font.BOLD, 18));
        close.setVerticalAlignment(SwingConstants.CENTER);
        close.setHorizontalAlignment(SwingConstants.CENTER);
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                close.setBackground(Color.BLUE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                close.setBackground(Color.WHITE);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
               LoginMenu.super.dispose();
            }
        });






        JLabel minimise  = new JLabel("<html>-</html>");
        minimise.setOpaque(true);
        minimise.setBounds(415,0,15,15);
        minimise.setFont(new Font("Verdana", Font.BOLD, 18));
        minimise.setVerticalAlignment(SwingConstants.CENTER);
        minimise.setHorizontalAlignment(SwingConstants.CENTER);
        minimise.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                minimise.setBackground(Color.BLUE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                minimise.setBackground(Color.WHITE);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginMenu.super.setState(Frame.ICONIFIED);
            }
        });





        JLabel loggingSign = new JLabel("<html>User Login</html>");
        loggingSign.setOpaque(true);
        loggingSign.setBounds(225/2,50,225,30);
        loggingSign.setFont(new Font("Verdana", Font.BOLD, 18));
        loggingSign.setVerticalAlignment(SwingConstants.CENTER);
        loggingSign.setHorizontalAlignment(SwingConstants.CENTER);
        loggingSign.setBackground(Color.BLUE);



       HintTextField username = new HintTextField("Username", 15);
         username.setBounds(225/2+30, 105,225-30,30 );
         username.setOpaque(false);


        JLabel uIcon = new JLabel(new ImageIcon("icons/user1.png"));
        uIcon.setOpaque(true);
        uIcon.setFont(uIcon.getFont().deriveFont(Font.ITALIC));
        uIcon.setHorizontalAlignment(JLabel.CENTER);
        // uIcon.setOpaque(true);
        uIcon.setBounds(225/2, 105, 30,30);
        //validate();


        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("icons/user1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        RoundJPanel p = new RoundJPanel( 0, 105, 38,38, 50, 50);
        p.add(picLabel);
        add(p);






        HintPassField password = new HintPassField("Password",15);
        password.setOpaque(false);
        password.setBounds(225/2+30, 145, 225-30, 30);





        JLabel pIcon = new JLabel(new ImageIcon("icons/pass.png"));
        pIcon.setOpaque(false);
        pIcon.setFont(uIcon.getFont().deriveFont(Font.ITALIC));
        pIcon.setHorizontalAlignment(JLabel.CENTER);
        // uIcon.setOpaque(true);
        pIcon.setBounds(225/2, 145, 30,30);
        //validate();


        CustomRoundButton  login = new CustomRoundButton(225/2, 180, 225, 30, 30,30);

        login.setBackground(Color.RED);
        login.setOpaque(false);


//
//        UIManager.put("Button.select", Color.red);
//        roundButton login = new roundButton("Login");
//        login.setBackground(Color.red);
//        login.setOpaque(false);
//        login.setBounds(225/2, 180, 225,30);





        JLabel reg = new JLabel("Don't have an account? Make a new one!");
        reg.setHorizontalAlignment(JLabel.CENTER);
        reg.setFont(new Font("Serif",Font.PLAIN, 12));
        reg.setBounds(225/2, 210, 225, 30);
        reg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterMenu();
               // LoginMenu.super.dispose();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
                fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                Font boldUnderline = new Font("Serif",Font.BOLD, 12).deriveFont(fontAttributes);
                reg.setFont(boldUnderline);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reg.setFont(new Font("Serif",Font.PLAIN, 12));
            }
        });




        JLabel showP = new JLabel(new ImageIcon("icons/show.png"));
        showP.setFont(showP.getFont().deriveFont(Font.ITALIC));
        showP.setHorizontalAlignment(JLabel.CENTER);
        // uIcon.setOpaque(true);
        showP.setBounds(225/2+225, 145, 32, 32);
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





    //
    //    Adding elements
    //

        add(close);
        add(minimise);
        add(loggingSign);
        add(username);
        add(uIcon);
        add(password);
        add(pIcon);
        add(login);
        add(reg);
        add(showP);
        repaint();
    }



}
