package GUI;

import Objects.CustomRoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class homePageClient extends JFrame {


    int posX=0,posY=0;
    JLabel background;

    public homePageClient(){
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
        JLabel bookIcon = new JLabel(new ImageIcon("icons/booking.png"));
        bookIcon.setBounds(10, 10, 32, 32);
        bookIcon.setOpaque(false);
       // bookIcon.setFont(bookIcon.getFont().deriveFont(Font.ITALIC));
        bookIcon.setHorizontalAlignment(JLabel.CENTER);
        bookIcon.setVerticalAlignment(JLabel.CENTER);
        book.add(bookIcon);
        book.setText("Book now");
        //book.setBorderColor(Color.YELLOW);
        dashboard.add(book);




        CustomRoundButton yourBookings =  new CustomRoundButton(20, 160, 160,80, 10, 10 );
        yourBookings.setIdle(new Color(20, 100, 145));
        JLabel bookingsIcon = new JLabel(new ImageIcon("icons/luggage.png"));
        bookingsIcon.setBounds(10, 10, 32, 32);
        bookingsIcon.setOpaque(false);
        // bookIcon.setFont(bookIcon.getFont().deriveFont(Font.ITALIC));
        bookingsIcon.setHorizontalAlignment(JLabel.CENTER);
        bookingsIcon.setVerticalAlignment(JLabel.CENTER);
        yourBookings.add(bookingsIcon);
        yourBookings.setText("Your Bookings");
        //book.setBorderColor(Color.YELLOW);
        dashboard.add(yourBookings);



        CustomRoundButton logout =  new CustomRoundButton(20, 600, 160,80, 10, 10 );
        logout.setIdle(new Color(20, 100, 145));
        JLabel logoutIcon = new JLabel(new ImageIcon("icons/logout.png"));
        logoutIcon.setBounds(10, 10, 32, 32);
        logoutIcon.setOpaque(false);
        logoutIcon.setHorizontalAlignment(JLabel.CENTER);
        logoutIcon.setVerticalAlignment(JLabel.CENTER);
        logout.add(logoutIcon);
        logout.setText("Logout");
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginMenu();
                homePageClient.super.dispose();
            }
        });

        dashboard.add(logout);





        //TODO: Make the background JPanel exact size(for the dashboard and title-bar)
        //TODO: MBY Button hotel overview(prices, images, etc.)
        //TODO: Button new res
        //TODO: Button see res
        //TODO: Button logout
        //TODO: Later Button settings


        add(titlebar);
        add(dashboard);


        repaint();
        background.repaint();
        titlebar.repaint();


    }


}
