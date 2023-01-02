package GUI;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class homePageAdmin extends JFrame {
    int posX=0,posY=0;
    JLabel background;

    public homePageAdmin(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,854);
        setLayout(new BorderLayout());
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
         background=new JLabel(new ImageIcon("icons/pexels-pixabay-326333.jpg"));
        add(background);
        //background.setLayout(new FlowLayout());
        background.setLayout(null);
        buildHomePageAd();
        setVisible(true);

    }


    private void buildHomePageAd() {

//        this.addMouseListener(new MouseAdapter()
//        {
//            public void mousePressed(MouseEvent e)
//            {
//                posX=e.getX();
//                posY=e.getY();
//            }
//        });
//        this.addMouseMotionListener(new MouseAdapter()
//        {
//            public void mouseDragged(MouseEvent evt)
//            {
//                //sets frame position when mouse dragged
//                setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
//
//            }
//        });

        JPanel titlebar = new JPanel();
        titlebar.setOpaque(true);
        titlebar.setBounds(0,0, 1280, 30);
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
                homePageAdmin.super.setLocation (e.getXOnScreen()-posX,e.getYOnScreen()-posY);
            }
        });


        JLabel close  = new JLabel("<html>✕</html>");
        close.setBackground(null);
        close.setForeground(Color.WHITE);
        close.setOpaque(true);
        close.setBounds(1220,0,60,30);
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
                homePageAdmin.super.dispose();

            }
        });
        titlebar.add(close);



        JLabel minimise  = new JLabel("<html>-</html>");
        minimise.setForeground(Color.WHITE);
        minimise.setBackground(null);
        minimise.setOpaque(true);
        minimise.setBounds(1160,0,60,30);
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
                homePageAdmin.super.setState(Frame.ICONIFIED);
            }
        });
        titlebar.add(minimise);


        background.add(titlebar);
        repaint();
        background.repaint();
        titlebar.repaint();
    }
}
