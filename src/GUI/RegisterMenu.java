package GUI;

import Objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.*;

public class RegisterMenu extends JFrame {
    LoginMenu lg;
    LinkedList<String> usernames;
    String user, pass,  thirCont;
    Database db = new Database();
    //Setting GUI.RegisterMenu values
    public RegisterMenu(LoginMenu lg){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520,670);
        setLayout(new BorderLayout());
        setResizable(false);
        this.lg = lg;
        setUndecorated(true);
        setLocationRelativeTo(null);
        //getContentPane().setBackground( Color.YELLOW );
        buildRegisterMenu();
        setVisible(false);
    }

    private void buildRegisterMenu() {
        ToolTipManager.sharedInstance().setInitialDelay(0);
        ToolTipManager.sharedInstance().setDismissDelay(10000);






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
                lg.dispose();
                RegisterMenu.super.dispose();

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
                RegisterMenu.super.setState(Frame.ICONIFIED);
            }
        });


        JLabel logo = new JLabel(new ImageIcon("icons/Logo.png"));
        logo.setOpaque(false);
        logo.setFont(logo.getFont().deriveFont(Font.ITALIC));
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setBounds(145, 50, 230,130);
        //validate();



        JLabel log = new JLabel("<html>SIGN IN</html>");
        log.setOpaque(false);
        log.setBounds(75,100,100,30);;
        log.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
        log.setVerticalAlignment(SwingConstants.CENTER);
        //loggingSign.setHorizontalAlignment(SwingConstants.CENTER);
        log.setForeground(new Color(201, 194, 193));
        log.setBackground(null);
        log.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               lg.setVisible(true);
               lg.requestFocus();
               setVisible(false);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                log.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
                log.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                log.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
                log.setForeground(new Color(201, 194, 193));
            }
        });




        JLabel registerSign = new JLabel("<html>SIGN UP</html>");
        registerSign.setForeground(Color.WHITE);
        registerSign.setOpaque(false);
        registerSign.setBounds(205,100,120,30);
        registerSign.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
        registerSign.setVerticalAlignment(SwingConstants.CENTER);
        //registerSign.setHorizontalAlignment(SwingConstants.CENTER);
        registerSign.setBackground(null);


        RoundJLabel spacerU = new RoundJLabel();
        spacerU.setBounds(65, 140, 390, 40, 40, 40);
        spacerU.setOpaque(false);
        spacerU.setBackground(new Color(0,0,0,75));


        HintTextField username = new HintTextField("Username", 40,40);
        username.setBackground(new Color(0,0,0,0));
        //username.setForeground(Color.WHITE);
        username.setOpaque(false);
        username.setBounds(15, 0, 360, 40); // relative to spacerU
        spacerU.add(username);

        RoundJLabel userE = new RoundJLabel();
        userE.setBounds(355, 5, 30, 30, 30,30);
        userE.setIcon(new ImageIcon("icons/icons8-high-importance-26.png"));
        userE.setBackground(Color.WHITE);
        userE.setOpaque(false);
        userE.setFont(userE.getFont().deriveFont(Font.ITALIC));
        userE.setHorizontalAlignment(JLabel.CENTER);
        userE.setVerticalAlignment(JLabel.CENTER);





        RoundJLabel spacerP = new RoundJLabel();
        spacerP.setBounds(65, 200, 390, 40, 40, 40);
        spacerP.setOpaque(false);
        spacerP.setBackground(new Color(0,0,0,70));


        HintPassField password = new HintPassField("Password",40, 40);
        password.setBackground(new Color(0,0,0,0));
        password.setBounds(15, 0, 360, 40); //Relative to spacerP
        password.setOpaque(false);
       // spacerP.add(password);



        RoundJLabel spacerPC = new RoundJLabel();
        spacerPC.setBounds(65, 260, 390, 40, 40, 40);
        spacerPC.setOpaque(false);
        spacerPC.setBackground(new Color(0,0,0,70));


        HintPassField passwordC = new HintPassField("Confirm Password",40, 40);
        passwordC.setBackground(new Color(0,0,0,0));
        passwordC.setBounds(15, 0, 360, 40); //Relative to spacerPC
        passwordC.setOpaque(false);
        spacerPC.add(passwordC);

        RoundJLabel passE = new RoundJLabel();
        passE.setBounds(355, 5, 30, 30, 30,30);
        passE.setIcon(new ImageIcon("icons/icons8-high-importance-26.png"));
        passE.setBackground(Color.WHITE);
        passE.setOpaque(false);
        passE.setFont(userE.getFont().deriveFont(Font.ITALIC));
        passE.setHorizontalAlignment(JLabel.CENTER);
        passE.setVerticalAlignment(JLabel.CENTER);
        passE.setToolTipText("This field can't be empty");







        RoundJLabel showP = new RoundJLabel();
        showP.setBounds(353, 9, 32, 22, 32,32);
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




        RoundJLabel spacerFN = new RoundJLabel();
        spacerFN.setBounds(65, 320, 190, 40, 40, 40);
        spacerFN.setOpaque(false);
        spacerFN.setBackground(new Color(0,0,0,70));



        HintTextField fName = new HintTextField("First Name", 40,40);
        fName.setOpaque(false);
        fName.setBackground(new Color(0,0,0,0));
        fName.setBounds(15, 0, 160, 40);
        spacerFN.add(fName);

        RoundJLabel fnameE = new RoundJLabel();
        fnameE.setBounds(155, 5, 30, 30, 30,30);
        fnameE.setIcon(new ImageIcon("icons/icons8-high-importance-26.png"));
        fnameE.setBackground(Color.WHITE);
        fnameE.setOpaque(false);
        fnameE.setFont(userE.getFont().deriveFont(Font.ITALIC));
        fnameE.setHorizontalAlignment(JLabel.CENTER);
        fnameE.setVerticalAlignment(JLabel.CENTER);






        RoundJLabel spacerLN = new RoundJLabel();
        spacerLN.setBounds(265, 320, 190, 40, 40, 40);
        spacerLN.setOpaque(false);
        spacerLN.setBackground(new Color(0,0,0,70));


        HintTextField lName = new HintTextField("Last Name", 40,40);
        lName.setOpaque(false);
        lName.setBackground(new Color(0,0,0,0));
        lName.setBounds(15, 0, 160, 40);
        spacerLN.add(lName);

        RoundJLabel lnameE = new RoundJLabel();
        lnameE.setBounds(155, 5, 30, 30, 30,30);
        lnameE.setIcon(new ImageIcon("icons/icons8-high-importance-26.png"));
        lnameE.setBackground(Color.WHITE);
        lnameE.setOpaque(false);
        lnameE.setFont(userE.getFont().deriveFont(Font.ITALIC));
        lnameE.setHorizontalAlignment(JLabel.CENTER);
        lnameE.setVerticalAlignment(JLabel.CENTER);






        RoundJLabel spacerEM = new RoundJLabel();
        spacerEM.setBounds(65, 380, 390, 40, 40, 40);
        spacerEM.setOpaque(false);
        spacerEM.setBackground(new Color(0,0,0,70));


        HintTextField eMail = new HintTextField("E_Mail",40,40);
        eMail.setOpaque(false);
        eMail.setBackground(new Color(0,0,0,0));
        eMail.setBounds(15, 0, 360, 40);
        spacerEM.add(eMail);

        RoundJLabel emailE = new RoundJLabel();
        emailE.setBounds(355, 5, 30, 30, 30,30);
        emailE.setIcon(new ImageIcon("icons/icons8-high-importance-26.png"));
        emailE.setBackground(Color.WHITE);
        emailE.setOpaque(false);
        emailE.setFont(userE.getFont().deriveFont(Font.ITALIC));
        emailE.setHorizontalAlignment(JLabel.CENTER);
        emailE.setVerticalAlignment(JLabel.CENTER);






        RoundJLabel spacerPH = new RoundJLabel();
        spacerPH.setBounds(65, 440, 390, 40, 40, 40);
        spacerPH.setOpaque(false);
        spacerPH.setBackground(new Color(0,0,0,70));


        HintTextField phone = new HintTextField("Phone Number",40,40);
        phone.setOpaque(false);
        phone.setBackground(new Color(0,0,0,0));
        phone.setBounds(15, 0, 360, 40);
        spacerPH.add(phone);

        RoundJLabel phoneE = new RoundJLabel();
        phoneE.setBounds(355, 5, 30, 30, 30,30);
        phoneE.setIcon(new ImageIcon("icons/icons8-high-importance-26.png"));
        phoneE.setBackground(Color.WHITE);
        phoneE.setOpaque(false);
        phoneE.setFont(userE.getFont().deriveFont(Font.ITALIC));
        phoneE.setHorizontalAlignment(JLabel.CENTER);
        phoneE.setVerticalAlignment(JLabel.CENTER);






        RoundJLabel spacerSC = new RoundJLabel();
        spacerSC.setBounds(65, 500, 390, 40, 40, 40);
        spacerSC.setOpaque(false);
        spacerSC.setBackground(new Color(0,0,0,70));


        HintTextField secCont = new HintTextField("Third Contact", 40,40);
        secCont .setOpaque(false);
        secCont .setBackground(new Color(0,0,0,0));
        secCont .setBounds(15, 0, 370, 40);
        spacerSC.add(secCont);



        CustomRoundButton register = new CustomRoundButton();
        register.setBounds(65, 580, 390, 40, 40,40);
        register.setIdle(new Color(16, 88, 204));
        register.setEntered(new Color(7, 51, 122));
        register.setBackground(new Color(16, 88, 204));
        register.setForeground(null);
        register.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        register.setText("<html><font color='white'>SIGN UP</font></html>");
        register.setOpaque(false);
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Pressed reg");
                spacerU.remove(userE);
                spacerU.repaint();
                spacerPC.remove(passE);
                spacerPC.repaint();
                spacerFN.remove(fnameE);
                spacerFN.repaint();
                spacerLN.remove(lnameE);
                spacerLN.repaint();
                spacerPH.remove(phoneE);
                spacerPH.repaint();
                spacerEM.remove(emailE);
                spacerEM.repaint();
                try {
                    System.out.println("Entered try");
                    usernames = db.getUsernames();
                    System.out.println("connection succesfull");
                    boolean checkU = true, checkP = false, checkN = false, checkPH = false, checkEM = false;
                    if(username.getText().isBlank() || username.getText().equals("Username") ){
                        checkU = false;
                        userE.setToolTipText("This field can't be empty");
                        spacerU.add(userE);
                        System.out.println("Nothing entered in users");

                    }else{
                        for (int i = 0; i < usernames.size(); i++) {
                            System.out.println("Enterd for");
                            System.out.println(usernames.get(i));

                            if (Objects.equals(username.getText(), usernames.get(i))) {
                                checkU = false;
                                userE.setToolTipText("This username is already taken");
                                spacerU.add(userE);
                                System.out.println("User alreasy exists");
                                break;
                            }

                        }
                        if(checkU){
                            checkP = true;
                            pass = String.valueOf(password.getPassword());
                            System.out.println(pass);
                            System.out.println(String.valueOf(passwordC.getPassword()));

                            if(String.valueOf(passwordC.getPassword()).equals("Confirm Password") || String.valueOf(passwordC.getPassword()).isBlank() ){
                                checkP = false;
                                passE.setToolTipText("This field can't be empty");
                                spacerPC.add(passE);
                            }else if(!String.valueOf(passwordC.getPassword()).equals(pass)){
                                checkP = false;
                                passE.setToolTipText("Passwords don't match");
                                spacerPC.add(passE);

                            }

                            if(checkP) {
                                checkN = true;
                                if (fName.getText().isBlank() || fName.getText().equals("First Name")) {
                                    checkN = false;
                                    fnameE.setToolTipText("This field can't be empty");
                                    spacerFN.add(fnameE);

                                } else if (lName.getText().isBlank() || lName.getText().equals("Last Name")) {
                                    checkN = false;
                                    lnameE.setToolTipText("This field can't'be empty");
                                    spacerLN.add(lnameE);

                                }
                                if(checkN){
                                    checkEM = true;
                                    if(eMail.getText().isBlank()||eMail.getText().equals("E_Mail")){
                                        checkEM = false;
                                        emailE.setToolTipText("This field can't'be empty");
                                        spacerEM.add(emailE);

                                    }
                                    if (checkEM) {
                                        checkPH = true;
                                        if (phone.getText().equals("Phone") || phone.getText().isBlank()) {
                                            checkPH = false;
                                            phoneE.setToolTipText("This field can't be empty");
                                            spacerPH.add(phoneE);

                                        } else if (phone.getText().length() != 10) {
                                            checkPH = false;
                                            phoneE.setToolTipText("Please enter a valid number");
                                            spacerPH.add(phoneE);
                                        }
                                        if (checkPH) {
                                            if(secCont.getText().equals("Third Contact")){
                                                thirCont = "";
                                            }else{
                                                thirCont = secCont.getText();
                                            }
                                            long millis = System.currentTimeMillis();
                                            java.sql.Date date = new java.sql.Date(millis);
                                            System.out.println(date);
                                            System.out.println("Trying to rec");
                                            db.register(username.getText(), pass, fName.getText(), lName.getText(), phone.getText(), eMail.getText(), thirCont, String.valueOf(date));
                                            System.out.println("databse rec suc");
                                        }
                                    }
                                }

                            }

                        }



                    }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });







        //
        //    Adding elements
        //

        background.add(close);
        background.add(minimise);
        background.add(log);
        background.add(registerSign);
        background.add(spacerU);
        //background. add(exUser);
        background.add(spacerP);
        spacerP.add(password);
        background.add(spacerPC);
        background.add(spacerFN);
        background.add(spacerLN);
        background.add(spacerPH);
        background.add(spacerEM);
        background.add(spacerSC);
        background.add(register);
        repaint();
        background.repaint();
    }

}
