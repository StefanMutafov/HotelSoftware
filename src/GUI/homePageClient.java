package GUI;

import Objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class homePageClient extends JFrame {

//TODO: Remove the font from the icons
int x,y;
        int selectedHotel;
        int selectedRes = -1;
        int clickedPanel = -1;
    CalendarUI cal = new CalendarUI();
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


        CustomRoundButton book =  new CustomRoundButton();
        book.setBounds(20, 60, 160,80, 10, 10 );
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




        CustomRoundButton yourBookings =  new CustomRoundButton();
        yourBookings.setBounds(20, 160, 160,80, 10, 10 );
        yourBookings.setIdle(new Color(20, 100, 145));
        yourBookings.setHorizontalAlignment(JLabel.CENTER);
        yourBookings.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setYourBookingScreen();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
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



        CustomRoundButton logout =  new CustomRoundButton();
        logout.setBounds(20, 600, 160,80, 10, 10 );
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




        public void setYourBookingScreen() throws SQLException{
            background.removeAll();



            //
            //Position tester
            //
//        cancel.addMouseListener(new MouseAdapter() {
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
//            cancel.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                cancel.setLocation (e.getXOnScreen()-x,e.getYOnScreen()-y);
//                System.out.println(cancel.getX() + " " + cancel.getY());
//            }
//        });

            CustomRoundButton cancel = new CustomRoundButton();
            LinkedList<Integer> res = db.getsReservations(user);
            LinkedList<RoundJPanel> resPane = new LinkedList<>();
            LinkedList<RoundJLabel> resInfo = new LinkedList<>();
            for(int i = 0;i<res.size();i++){
                resPane.add(new RoundJPanel(20, 20+i*210, 350, 200, 100,100));
                resPane.get(i).setLayout(null);
                resPane.get(i).setBackground(Color.BLUE);
                int finalI = i;
                resPane.get(i).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(finalI!=-1){
                            resPane.get(finalI).setBackground(Color.BLUE);
                        }
                        resPane.get(finalI).setBackground(Color.BLACK);
                        selectedRes = finalI;

                    }
                });


                cancel.setBounds(590,745,200,70,0,0);
                cancel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            db.cancelReserv(selectedRes);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        resPane.remove(selectedRes);
                        selectedRes = -1;
                        background.repaint();
                    }
                });

                RoundJLabel inf = new RoundJLabel();
                inf.setBackground(Color.BLUE);
                inf.setBounds(100, 30, 220, 140, 50, 50);
                inf.setText("<html><div style='text-align: center;'>Hotel name: " +db.getHotelName(db.getHotelFromRes(db.getsReservations(user).get(i))) + "<br/>" + "</div></html>");
                resInfo.add(inf);
                resPane.get(i).repaint();
                resPane.get(i).add(resInfo.get(i));
                background.add(resPane.get(i));
            }




            background.add(cancel);
        background.repaint();
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
        System.out.println(hotels.size());

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
                RoundJLabel r = new RoundJLabel();
                r.setBounds(10, 10, 180, 290, 100,100);
                hotelPic.add(r);
                RoundJLabel r1 = new RoundJLabel();
                r1.setBounds(0,315,200,30,200,30);
                 names.add(r1);
                names.get(i).setBackground(new Color(0,0,0, 0));
                names.get(i).setHorizontalAlignment(SwingConstants.CENTER);
                names.get(i).setVerticalAlignment(SwingConstants.CENTER);
                names.get(i).setText(db.getHotelName(hotels.get(i)));


                hotelPanel.add(new RoundJPanel(20+i*210, 10, 200, 350, 100,100));


                hotelPic.get(i).setIcon(new ImageIcon(img));

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            hotelPanel.get(i).setLayout(null);
            hotelPanel.get(i).add(hotelPic.get(i));
            hotelPanel.get(i).add(names.get(i));
            hotelPanel.get(i).setBackground(new Color(129, 166, 235));
            hotelPanel.get(i).setBorderColor(new Color(0,0,0,0));
            int finalI = i;
            clickedPanel = -1;
            hotelPanel.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(clickedPanel!=-1){hotelPanel.get(clickedPanel).setBackground(new Color(0,0,0,0));}
                    clickedPanel = finalI;
                    hotelPanel.get(finalI).setBackground(Color.black);
                    try {
                        selectedHotel = db.getHotelsIn(String.valueOf(cities.getSelectedItem())).get(finalI);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println(selectedHotel);
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
                        RoundJLabel rl = new RoundJLabel();
                    rl.setBounds(10, 10, 180, 290, 100,100);
                        hotelPic.add(rl);
                        RoundJLabel rl1 = new RoundJLabel();
                        rl1.setBounds(0,315,200,30,200,30);
                        names.add(rl1);
                        names.get(i).setBackground(new Color(0,0,0,0));
                        names.get(i).setHorizontalAlignment(SwingConstants.CENTER);
                        names.get(i).setVerticalAlignment(SwingConstants.CENTER);
                        names.get(i).setText(db.getHotelName(hotels.get(i)));

                        hotelPanel.add(new RoundJPanel(20+i*210, 10, 200, 350, 100,100));


                            hotelPic.get(i).setIcon(new ImageIcon(img));

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    hotelPanel.get(i).setLayout(null);
                    hotelPanel.get(i).add(hotelPic.get(i));
                    hotelPanel.get(i).add(names.get(i));
                    hotelPanel.get(i).setBorderColor(new Color(0,0,0,0));
                    hotelPanel.get(i).setBackground(new Color(129, 166, 235));
                    int finalI = i;
                    clickedPanel = -1;
                    hotelPanel.get(i).addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if(clickedPanel!=-1){hotelPanel.get(clickedPanel).setBackground(new Color(129, 166, 235));}
                            clickedPanel = finalI;
                            hotelPanel.get(finalI).setBackground(Color.black);
                            try {
                                selectedHotel = db.getHotelsIn(String.valueOf(cities.getSelectedItem())).get(finalI);
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                            System.out.println(selectedHotel);
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



                    hotelsSlide.add(hotelPanel.get(i));
                }
                hotelsSlide.repaint();
                hotels.clear();
            }
        });

        CustomRoundButton right = new CustomRoundButton();
        right.setBounds(760, 434, 64, 64, 100, 100);
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

                        hotelPanel.get(i).setBounds(hotelPanel.get(i).getX() - 100, 10, 200, 350);

                    }
                    hotelsSlide.repaint();

                }
            }

        });


        CustomRoundButton left = new CustomRoundButton();
        left.setBounds(690, 434, 64, 64, 100, 100);
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

                        hotelPanel.get(i).setBounds(hotelPanel.get(i).getX() + 100, 10, 200, 350);

                    }
                    hotelsSlide.repaint();
                }
            }

        });



       //Adding calendar

        cal.setBounds(20, 450, 640, 300);

        addMenu people = new addMenu("People");
        people.setBounds(20,310, 230, 50);


        addMenu rooms = new addMenu("Rooms");
        rooms.setBounds(20,380, 230, 50);


        CustomRoundButton bookNow = new CustomRoundButton();
        bookNow.setBackground(Color.BLUE);
        bookNow.setText("Book Now");
        bookNow.setBounds(898,689,320,50, 50, 50);
        bookNow.setClicked(Color.PINK);
        bookNow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Date acc;
                java.sql.Date sqlAcc;
                Date leave;
                java.sql.Date sqlLeave;
                try {
                    acc = new SimpleDateFormat("dd/MM/yyyy").parse(cal.getStartDate());
                    sqlAcc = new java.sql.Date(acc.getTime());
                    leave = new SimpleDateFormat("dd/MM/yyyy").parse(cal.getEndDate());
                    sqlLeave = new java.sql.Date(leave.getTime());
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                long diff = leave.getTime() - acc.getTime();
                int nights = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                System.out.println(nights);
                try {
                    db.book(selectedHotel, user,  people.getCount(), nights,  sqlAcc,  sqlLeave, rooms.getCount());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });






        //
        //Position tester
        //
//        bookNow.addMouseListener(new MouseAdapter() {
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
//        bookNow.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                bookNow.setLocation (e.getXOnScreen()-x,e.getYOnScreen()-y);
//                System.out.println(bookNow.getX() + " " + bookNow.getY());
//            }
//        });
        background.add(bookNow);
        background.add(welcomeScreen);
        background.add(left);
        background.add(right);
        background.add(hotelsSlide);
        background.add(cities);
        background.add(cal);
        background.add(people);
        background.add(rooms);
        repaint();
        background.repaint();
        hotelsSlide.repaint();
    }


}
