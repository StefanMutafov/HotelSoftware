package GUI;

import Objects.CustomRoundButton;
import Objects.Database;
import Objects.RoundJLabel;
import Objects.RoundJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.LinkedList;

public class homePageClient extends JFrame {

//TODO: Remove the font from the icons
int x,y;
    Database db = new Database();
    int posX=0,posY=0;
    JLabel background;
    String user;

    public homePageClient(String username){
        user = username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1480,884);
        setLayout(new BorderLayout());
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        background=new JLabel(new ImageIcon("icons/pexels-boonkong-boonpeng-1134176.jpg"));
        background.setBounds(200, 30, 1280, 854);
        add(background);
        background.setLayout(null);
       
        buildHomePageCl();
        setVisible(true);


    }

    private void buildHomePageCl() {
        JPanel titlebar = new JPanel();
        titlebar.setOpaque(true);
        titlebar.setBounds(0,0, 1480, 30);
        titlebar.setFocusable(true);
        titlebar.setBackground(Color.BLACK);
        titlebar.setLayout(null);
        titlebar.addMouseListener(new MouseAdapter() {


            @Override
            public void mousePressed(MouseEvent e){

                posX = e.getX();
                posY = e.getY();

            }
        });
        titlebar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                homePageClient.super.setLocation (e.getXOnScreen()-posX,e.getYOnScreen()-posY);
            }
        });


        JLabel close  = new JLabel("<html>✕</html>");
        close.setBackground(null);
        close.setForeground(Color.WHITE);
        close.setOpaque(true);
        close.setBounds(1420,0,60,30);
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
                close.setBackground(null); close.setForeground(Color.WHITE);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                close.setBackground(new Color(115, 6, 26));
            }

            @Override
            public void mouseReleased(MouseEvent e){
                homePageClient.super.dispose();

            }
        });
        titlebar.add(close);



        JLabel minimise  = new JLabel("<html>-</html>");
        minimise.setForeground(Color.WHITE);
        minimise.setBackground(null);
        minimise.setOpaque(true);
        minimise.setBounds(1360,0,60,30);
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
                minimise.setBackground(null);minimise.setForeground(Color.WHITE);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                minimise.setBackground(new Color(189, 153, 159));
            }

            @Override
            public void mouseReleased(MouseEvent e){
                homePageClient.super.setState(Frame.ICONIFIED);
            }
        });
        titlebar.add(minimise);



        JPanel dashboard = new JPanel();
        dashboard.setLayout(null);
        dashboard.setBounds(0,30, 200,854);
        dashboard.setBackground(new Color(20, 100, 145));


        CustomRoundButton book =  new CustomRoundButton(20, 60, 160,80, 10, 10 );
        book.setIdle(new Color(20, 100, 145));
        book.setHorizontalAlignment(JLabel.CENTER);
        JLabel bookIcon = new JLabel(new ImageIcon("icons/booking.png"));
        bookIcon.setBounds(10, 24, 32, 32);
        bookIcon.setOpaque(false);
        bookIcon.setHorizontalAlignment(JLabel.CENTER);
        bookIcon.setVerticalAlignment(JLabel.CENTER);
        book.add(bookIcon);
        book.setText("   Book now");
        book.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setBookScreen();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //book.setBorderColor(Color.YELLOW);
        dashboard.add(book);




        CustomRoundButton yourBookings =  new CustomRoundButton(20, 160, 160,80, 10, 10 );
        yourBookings.setIdle(new Color(20, 100, 145));
        yourBookings.setHorizontalAlignment(JLabel.CENTER);
        JLabel bookingsIcon = new JLabel(new ImageIcon("icons/luggage.png"));
        bookingsIcon.setBounds(10, 24, 32, 32);
        bookingsIcon.setOpaque(false);
        // bookIcon.setFont(bookIcon.getFont().deriveFont(Font.ITALIC));
        bookingsIcon.setHorizontalAlignment(JLabel.CENTER);
        bookingsIcon.setVerticalAlignment(JLabel.CENTER);
        yourBookings.add(bookingsIcon);
        yourBookings.setText("   Your Bookings");
        //book.setBorderColor(Color.YELLOW);
        dashboard.add(yourBookings);



        CustomRoundButton logout =  new CustomRoundButton(20, 600, 160,80, 10, 10 );
        logout.setIdle(new Color(20, 100, 145));
        logout.setHorizontalAlignment(JLabel.CENTER);
        JLabel logoutIcon = new JLabel(new ImageIcon("icons/logout.png"));
        logoutIcon.setBounds(10, 24, 32, 32);
        logoutIcon.setOpaque(false);
        logoutIcon.setHorizontalAlignment(JLabel.CENTER);
        logoutIcon.setVerticalAlignment(JLabel.CENTER);
        logout.add(logoutIcon);
        logout.setText("   Logout");
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginMenu();
                homePageClient.super.dispose();
            }
        });

        dashboard.add(logout);


        JLabel welcomeSign = new JLabel();
       // welcomeSign.setOpaque(true);
        welcomeSign.setBackground(Color.WHITE);
        welcomeSign.setHorizontalAlignment(JLabel.CENTER);
        welcomeSign.setVerticalAlignment(JLabel.CENTER);
        try {
            welcomeSign.setText("<html><div style='text-align: center;'>Welcome back, <br/> " + db.getFirstName(user) + "</div></html>" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        welcomeSign.setBounds(10, 10, 200, 100);

        //TODO: Welcome screen
        //TODO: MBY Button hotel overview(prices, images, etc.)
        //TODO: Button new res
        //TODO: Button see res
        //TODO: Button logout
        //TODO: Later Button settings


        add(titlebar);
        add(dashboard);
        background.add(welcomeSign);
        repaint();
        background.repaint();
        titlebar.repaint();

    }

    public void setBookScreen() throws SQLException {
        background.removeAll();

        JLabel welcomeScreen = new JLabel();

        welcomeScreen.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeScreen.setVerticalAlignment(SwingConstants.CENTER);
        welcomeScreen.setText("<html><div style='text-align: center;'>Where would yo like to go, <br/> " + db.getFirstName(user) + "?</div></html>" );
        welcomeScreen.setBounds(20,50,230,100);
        welcomeScreen.setBackground(new Color(0,0,0,50));
        welcomeScreen.setOpaque(true);

        RoundJPanel hotelsSlide = new RoundJPanel(260, 27, 1000, 400, 40,30);
        hotelsSlide.setBackground(Color.WHITE);
        hotelsSlide.setLayout(null);

        JComboBox cities = new JComboBox();
        cities.setFocusable(false);
        for(int i =0; i<db.getCities().size();i++){
            cities.addItem(db.getCities().get(i));
        }

        cities.setOpaque(true);
        cities.setBounds(20,200, 230, 100);
        hotelsSlide.removeAll();
        LinkedList<Integer> hotels = db.getHotelsIn(String.valueOf(cities.getSelectedItem()));

        LinkedList<RoundJPanel> hotelPanel = new LinkedList<>();
        LinkedList<RoundJLabel> hotelPic = new LinkedList<>();
        LinkedList<RoundJLabel> names = new LinkedList<>();


        for(int i = 0; i<hotels.size();i++){
            try {
                //TODO:Inserm missing images image
                Image img = Toolkit.getDefaultToolkit().createImage("icons/icons8-user-641.png");
                Blob b=db.getHotelIcon(hotels.get(i));
                if(b!= null) {
                    byte bt[] = b.getBytes(1, (int) b.length());
                    img = Toolkit.getDefaultToolkit().createImage(bt);
                }
                hotelPic.add(new RoundJLabel(1, 1, 200, 300, 100,100));
                 names.add(new  RoundJLabel(0,315,200,30,200,30));
                names.get(i).setBackground(new Color(0,0,0,0));
                names.get(i).setHorizontalAlignment(SwingConstants.CENTER);
                names.get(i).setVerticalAlignment(SwingConstants.CENTER);
                names.get(i).setText(db.getHotelName(hotels.get(i)));

                hotelPanel.add(new RoundJPanel(20+i*210, 10, 200, 350, 100,100));


                hotelPic.get(i).setIcon(new ImageIcon(img));

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            hotelPanel.get(i).add(hotelPic.get(i));
            hotelPanel.get(i).add(names.get(i));
            hotelPanel.get(i).setBorderColor(new Color(0,0,0,0));
            hotelsSlide.add(hotelPanel.get(i));
        }
        hotelsSlide.repaint();
        hotels.clear();

        cities.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                //Updating slide menu
                hotelsSlide.removeAll();



                try {
                    for(int i=0;i<db.getHotelsIn(String.valueOf(cities.getSelectedItem())).size(); i++ ){
                        hotels.add(db.getHotelsIn(String.valueOf(cities.getSelectedItem())).get(i));
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                hotelPic.clear();
                names.clear();
                hotelPanel.clear();


                for(int i = 0; i<hotels.size();i++){
                    try {
                        //TODO:Inserm missing images image
                        Image img = Toolkit.getDefaultToolkit().createImage("icons/icons8-user-641.png");
                    Blob b=db.getHotelIcon(hotels.get(i));
                    if(b!= null) {
                        byte bt[] = b.getBytes(1, (int) b.length());
                         img = Toolkit.getDefaultToolkit().createImage(bt);
                    }
                        hotelPic.add(new RoundJLabel(1, 1, 200, 300, 100,100));
                        names.add(new  RoundJLabel(0,315,200,30,200,30));
                        names.get(i).setBackground(new Color(0,0,0,0));
                        names.get(i).setHorizontalAlignment(SwingConstants.CENTER);
                        names.get(i).setVerticalAlignment(SwingConstants.CENTER);
                        names.get(i).setText(db.getHotelName(hotels.get(i)));

                        hotelPanel.add(new RoundJPanel(20+i*210, 10, 200, 350, 100,100));


                            hotelPic.get(i).setIcon(new ImageIcon(img));

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    hotelPanel.get(i).add(hotelPic.get(i));
                    hotelPanel.get(i).add(names.get(i));
                    hotelPanel.get(i).setBorderColor(new Color(0,0,0,0));
                    hotelsSlide.add(hotelPanel.get(i));
                }
                hotelsSlide.repaint();
                hotels.clear();
            }
        });

        CustomRoundButton right = new CustomRoundButton(760, 434, 64, 64, 100, 100);
        //right.setOpaque(true)
        right.setIcon(new ImageIcon("icons/next.png"));
        right.setClicked(new Color(0,0,0,20));
        right.setIdle(new Color(0,0,0,0));
        right.setEntered(new Color(0,0,0,0));
        right.setBackground(new Color(20,0,0,15));
        right.setBorderColor(new Color(0,0,0,0));
        right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                right.setIcon(new ImageIcon("icons/nextWHITE.png"));
                right.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                right.setIcon(new ImageIcon("icons/next.png"));
                right.repaint();
            }
        });




        right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (hotelPanel.getLast().getX()+200>hotelsSlide.getWidth()) {

                    for (int i = 0; i < hotelPic.size(); i++) {

                        hotelPanel.get(i).setBounds(hotelPanel.get(i).getX() - 20, 10, 200, 350);

                    }
                    hotelsSlide.repaint();

                }
            }

        });


        CustomRoundButton left = new CustomRoundButton(690, 434, 64, 64, 100, 100);
        //right.setOpaque(true)
        left.setIcon(new ImageIcon("icons/previous.png"));
        left.setClicked(new Color(0,0,0,20));
        left.setIdle(new Color(0,0,0,0));
        left.setEntered(new Color(0,0,0,0));
        left.setBackground(new Color(20,0,0,15));
        left.setBorderColor(new Color(0,0,0,0));
        left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                left.setIcon(new ImageIcon("icons/previousWHITE.png"));
                left.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                left.setIcon(new ImageIcon("icons/previous.png"));
                left.repaint();
            }
        });


        left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(hotelPanel.getFirst().getX()<5) {

                    for (int i = 0; i < hotelPic.size(); i++) {

                        hotelPanel.get(i).setBounds(hotelPanel.get(i).getX() + 20, 10, 200, 350);

                    }
                    hotelsSlide.repaint();
                }
            }

        });





        //
        //Position tester
        //
//        right.addMouseListener(new MouseAdapter() {
//
//
//            @Override
//            public void mousePressed(MouseEvent e){
//
//                x = e.getX();
//                y = e.getY();
//
//            }
//        });
//        right.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                right.setLocation (e.getXOnScreen()-x,e.getYOnScreen()-y);
//                System.out.println(right.getX() + " " + right.getY());
//            }
//        });

        background.add(welcomeScreen);
        background.add(left);
        background.add(right);
        background.add(hotelsSlide);
        background.add(cities);
        repaint();
        background.repaint();
        hotelsSlide.repaint();
    }


}
