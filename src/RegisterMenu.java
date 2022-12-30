import Objects.HintPassField;
import Objects.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class RegisterMenu extends JFrame {

    //Setting LoginMenu values



    public RegisterMenu(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,550);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground( Color.YELLOW );
        buildRegisterMenu();
        setVisible(true);
    }

    private void buildRegisterMenu() {



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
                RegisterMenu.super.dispose();
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
                RegisterMenu.super.setState(Frame.ICONIFIED);
            }
        });





        JLabel registerSign = new JLabel("<html>Register</html>");
        registerSign.setOpaque(true);
        registerSign.setBounds(225/2,50,225,30);
        registerSign.setFont(new Font("Verdana", Font.BOLD, 18));
        registerSign.setVerticalAlignment(SwingConstants.CENTER);
        registerSign.setHorizontalAlignment(SwingConstants.CENTER);
        registerSign.setBackground(Color.BLUE);



        HintTextField username = new HintTextField("Username", 15);
        username.setOpaque(false);
        username.setBounds(225/2, 105,225,30 );


        JLabel exUser = new JLabel("This username is already taken");
        exUser.setBounds(225/2, 75, 225, 30);
        exUser.setHorizontalAlignment(JLabel.CENTER);
        exUser.setForeground(Color.RED);




        HintPassField password = new HintPassField("Password", 15);
        password.setOpaque(false);
        password.setBounds(225/2, 145, 225, 30);


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



        HintTextField fName = new HintTextField("First Name", 15);
        fName.setOpaque(false);
        fName.setBounds(225/2, 185,225,30 );



        HintTextField lName = new HintTextField("Last Name", 15);
        lName.setOpaque(false);
        lName.setBounds(225/2, 225,225,30 );



        HintTextField eMail = new HintTextField("E_Mail",15);
        eMail.setOpaque(false);
        eMail.setBounds(225/2, 265,225,30 );



        HintTextField phone = new HintTextField("Phone Number",15);
        phone.setOpaque(false);
        phone.setBounds(225/2, 305,225,30 );



        HintTextField secCont = new HintTextField("Second Contact", 15);
        secCont.setOpaque(false);
        secCont.setBounds(225/2, 345,225,30 );



        JButton register = new JButton("Register");
        register.setBounds(450/3, 400, 450/3, 40);



        JLabel log = new JLabel("Already have an account? Log-in!");
        log.setHorizontalAlignment(JLabel.CENTER);
        log.setFont(new Font("Serif",Font.PLAIN, 12));
        log.setBounds(225/2, 450, 225, 30);
        log.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginMenu();
                //RegisterMenu.super.dispose();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
                fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                Font boldUnderline = new Font("Serif",Font.BOLD, 12).deriveFont(fontAttributes);
                log.setFont(boldUnderline);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                log.setFont(new Font("Serif",Font.PLAIN, 12));
            }
        });




        //
        //    Adding elements
        //

        add(close);
        add(minimise);
        add(registerSign);
        add(username);
        add(exUser);
        add(password);
        add(showP);
        add(fName);
        add(lName);
        add(phone);
        add(eMail);
        add(secCont);
        add(register);
        add(log);
        repaint();
    }

}
