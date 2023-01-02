package GUI;

import Objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;

//Written by Stefan Mutafov
public class LoginMenu extends JFrame {
    //Setting GUI.LoginMenu values
    LinkedList<String> users;
    Database db = new Database();
        RegisterMenu rg;
    public LoginMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520,670);
        setLayout(new BorderLayout());
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
       rg = new RegisterMenu(LoginMenu.this);
        //getContentPane().setBackground( Color.YELLOW );
        buildLoginMenu();
        setVisible(true);
    }


    private void buildLoginMenu() {


        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("icons/background5.jpg"));
        add(background);
        //background.setLayout(new FlowLayout());
        background.setLayout(null);


        JLabel close  = new JLabel("<html>✕</html>");
        close.setBackground(null);
        close.setForeground(Color.BLACK);
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
                close.setBackground(null); close.setForeground(Color.BLACK);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                close.setBackground(new Color(115, 6, 26));
            }

            @Override
            public void mouseReleased(MouseEvent e){
                rg.dispose();
                LoginMenu.super.dispose();

            }
        });






        JLabel minimise  = new JLabel("<html>-</html>");
        minimise.setForeground(Color.BLACK);
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
                minimise.setBackground(null);minimise.setForeground(Color.BLACK);
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




        JLabel logo = new JLabel(new ImageIcon("icons/Logo.png"));
        logo.setOpaque(false);
        logo.setFont(logo.getFont().deriveFont(Font.ITALIC));
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setBounds(145, 50, 230,130);
        //validate();


        JLabel loggingSign = new JLabel("<html>SIGN IN</html>");
        loggingSign.setOpaque(false);
        loggingSign.setBounds(75,100,100,30);
        loggingSign.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
        loggingSign.setVerticalAlignment(SwingConstants.CENTER);
        //loggingSign.setHorizontalAlignment(SwingConstants.CENTER);
        loggingSign.setForeground(Color.WHITE);
        loggingSign.setBackground(null);



        JLabel reg = new JLabel("<html>SIGN UP</html>");
        reg.setOpaque(false);
        reg.setBounds(205,100,120,30);
        reg.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
        reg.setVerticalAlignment(SwingConstants.CENTER);
        reg.setForeground(new Color(201, 194, 193));
        reg.setBackground(null);
        reg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rg.setVisible(true);
                rg.requestFocus();
                setVisible(false);

               // GUI.LoginMenu.super.dispose();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                reg.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
                reg.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reg.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
                reg.setForeground(new Color(201, 194, 193));
            }
        });



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


        JLabel wrongUP = new JLabel();
        wrongUP.setText("<html><font color='red'>Incorrect username or password</font></html>");
        wrongUP.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        wrongUP.setBounds(125, 112, 330, 50);
        wrongUP.setForeground(null);
        wrongUP.setBackground(new Color(0,0,0,0));
        wrongUP.setHorizontalAlignment(JLabel.CENTER);
        wrongUP.setVerticalAlignment(JLabel.CENTER);
        background.add(wrongUP);
        wrongUP.setVisible(false);




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




        JLabel showP = new RoundJLabel(295, 9, 32, 32, 32,32);
        showP.setIcon(new ImageIcon("icons/icons8-blind-32.png"));
        showP.setBackground(Color.WHITE);
        showP.setOpaque(false);
        showP.setFont(showP.getFont().deriveFont(Font.ITALIC));
        showP.setHorizontalAlignment(JLabel.CENTER);
        showP.setVerticalAlignment(JLabel.CENTER);
        showP.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if(!password.getText().equals("Password")){password.setEchoChar((char) 0);}
                showP.setIcon(new ImageIcon("icons/icons8-eye-32.png"));
                showP.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(!password.getText().equals("Password")){password.setEchoChar(HintPassField.getDefaultt());}
                showP.setIcon(new ImageIcon("icons/icons8-blind-32.png"));
                showP.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                showP.setBackground(new Color(209, 192, 190));
                showP.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                showP.setBackground(Color.WHITE);
                showP.repaint();
            }
        });

        spacerP.add(showP);
        //validate();



        CustomRoundButton  login = new CustomRoundButton(65, 330, 390, 50, 50,50);
        login.setIdle(new Color(16, 88, 204));
        login.setEntered(new Color(7, 51, 122));
        login.setClicked(new Color(10, 31, 46));
        login.setBackground(new Color(16, 88, 204));
        login.setForeground(null);
        login.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        login.setText("<html><font color='white'>Login</font></html>");
        login.setOpaque(false);
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)  {
                boolean check = false;
                wrongUP.setVisible(false);
                try {
                    users = db.getUsernames();
                    for(int i =0;i<users.size();i++){
                        if(username.getText().equals(users.get(i))){
                            check = true;
                            break;
                        }
                    }

                    if(check){
                        if(String.valueOf(password.getPassword()).equals(db.getPass(username.getText()))){
                            //LOGIN CODE
                            System.out.println("Logged in");
                        }else{
                            wrongUP.setVisible(true);
                            System.out.println("Wrong pass");
                        }
                    }else {
                        wrongUP.setVisible(true);
                        System.out.println("wrong user");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });





        JLabel fPas = new JLabel("Forgot Password?");
        fPas.setOpaque(false);
        fPas.setBounds(65, 390, 390, 50);
        fPas.setHorizontalAlignment(JLabel.CENTER);
        fPas.setVerticalAlignment(JLabel.CENTER);
        fPas.setForeground(Color.WHITE);
        fPas.setBackground(new Color(0,0,0,0));
        Font font = new Font("Arial Rounded MT Bold", Font.PLAIN, 14);
        fPas.setFont(font);

        fPas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                fPas.setFont(font.deriveFont(attributes));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, -1);
                fPas.setFont(font.deriveFont(attributes));
            }
        });



        //
        //    Adding elements
        //
        //  background.add(logo);
        background.add(close);
        background.add(minimise);
        background.add(loggingSign);
        spacerU.add(username);
        background.add(uIcon);
        spacerP.add(password);
        background.add(pIcon);
        background.add(login);
        background.add(reg);
        background.add(fPas);
        background.add(spacerU);
        background.add(spacerP);

        repaint();
        background.repaint();

    }





}
