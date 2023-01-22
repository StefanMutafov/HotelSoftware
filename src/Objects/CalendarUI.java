package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUI extends JPanel {
    Calendar c = new GregorianCalendar();
    //Calendar c = Calendar.getInstance();

    JLabel daysStart[][] = new RoundJLabel[6][7];
    RoundJLabel wDaysStart[] = new RoundJLabel[7];
    RoundJLabel daysEnd[][] = new RoundJLabel[6][7];
    RoundJLabel wDaysEnd[] = new RoundJLabel[7];


    RoundJLabel headR = new RoundJLabel(472,10, 185, 40, 0, 0);
    RoundJLabel headL = new RoundJLabel(92,10, 185, 40, 0, 0);
        int[] clicked = {-1,-1};
        int[] clickedEnd = {-1,-1};

        String[] wDays ={"M", "T", "W", "T", "F", "S", "S"};
    String[] months ={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "December"};
    public CalendarUI(){
        setSize(750,300);
        setVisible(true);
        setLayout(null);
        setBackground(new Color(70,70,70));
        buildGUI();

    }

        private void updateCal(){
        headL.setText(months[c.get(Calendar.MONTH)]);
        headR.setText(months[c.get(Calendar.MONTH)+1]);
        c.set(Calendar.DATE,1);



        }

    private void buildGUI(){

        headR.setBackground(Color.BLUE);
        headR.setOpaque(false);
        for(int i =0;i<7;i++){
            wDaysEnd[i] = new RoundJLabel(460+i*30,70,30,30,30,30);
            wDaysEnd[i].setBackground(Color.RED);
            wDaysEnd[i].setText(wDays[i]);
            add(wDaysEnd[i]);

        }

        for(int i =0; i<6;i++){
            for(int j = 0; j<7;j++){
                daysEnd[i][j]= new RoundJLabel(460+j*30, 110+i*30, 30,30,30,30);
                daysEnd[i][j].setOpaque(false);
                daysEnd[i][j].setBackground(Color.BLUE);
                add(daysEnd[i][j]);
                int finalI1 = i;
                int finalJ1 = j;
                daysEnd[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JLabel label = (RoundJLabel)e.getSource();
                        label.setBackground(Color.BLACK);

                       // System.out.println("Mouse clicked,  backgroung for" + finalI1 + " " +finalJ1 + "is BLACK" );
                        if(clickedEnd[0] == -1){
                            clickedEnd[0] = finalI1;
                            clickedEnd[1] = finalJ1;

                        }else {
                            daysEnd[clickedEnd [0]][clickedEnd [1]].setBackground(Color.BLUE);
                            daysEnd[clickedEnd [0]][clickedEnd [1]].repaint();
                          //  System.out.println("Mouse clicked,  backgroung for" + finalI1 + " " +finalJ1 + "is BLUE" );
                            clickedEnd [0] = finalI1;
                            clickedEnd [1] = finalJ1;
                        }
                        label.repaint();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        RoundJLabel label = (RoundJLabel)e.getSource();
                        if(label.getBackground() != Color.BLACK) {
                            label.setBackground(Color.LIGHT_GRAY);
                            label.repaint();
                         //   System.out.println("Mouse entered, backgroung for" + finalI1 + " " + finalJ1 + "is Light Gray");
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        RoundJLabel label = (RoundJLabel)e.getSource();
                        if(label.getBackground() != Color.BLACK) {
                            label.setBackground(Color.BLUE);
                            label.repaint();
                           // System.out.println("Mouse exited,  backgroung for" + finalI1 + " " +finalJ1 + "is BLUE" );
                        }
                    }
                });




            }

        }



        headL.setBackground(Color.BLUE);
        headL.setOpaque(false);
        for(int i =0;i<7;i++){
            wDaysStart[i] = new RoundJLabel(80+i*30,70,30,30,30,30);
            wDaysStart[i].setBackground(Color.RED);
            wDaysStart[i].setText(wDays[i]);
            add(wDaysStart[i]);

        }

        for(int i =0; i<6;i++){
            for(int j = 0; j<7;j++){
                daysStart[i][j]= new RoundJLabel(80+j*30, 110+i*30, 30,30,30,30);
                daysStart[i][j].setOpaque(false);
                daysStart[i][j].setBackground(Color.BLUE);
                add(daysStart[i][j]);
                int finalI = i;
                int finalJ = j;
                daysStart[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JLabel label = (RoundJLabel)e.getSource();
                        label.setBackground(Color.BLACK);

                        //System.out.println("Mouse clicked,  backgroung for" + finalI + " " +finalJ + "is BLACK" );
                        if(clicked[0] == -1){
                            clicked[0] = finalI;
                            clicked[1] = finalJ;

                        }else {
                            daysStart[clicked[0]][clicked[1]].setBackground(Color.BLUE);
                            daysStart[clicked[0]][clicked[1]].repaint();
                          //  System.out.println("Mouse clicked,  backgroung for" + finalI + " " +finalJ + "is BLUE" );
                            clicked[0] = finalI;
                            clicked[1] = finalJ;
                        }
                        label.repaint();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        RoundJLabel label = (RoundJLabel)e.getSource();
                        if(label.getBackground() != Color.BLACK) {
                            label.setBackground(Color.LIGHT_GRAY);
                            label.repaint();
                            //System.out.println("Mouse entered, backgroung for" + finalI + " " + finalJ + "is Light Gray");
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        RoundJLabel label = (RoundJLabel)e.getSource();
                        if(label.getBackground() != Color.BLACK) {
                            label.setBackground(Color.BLUE);
                            label.repaint();
                            //System.out.println("Mouse exited,  backgroung for" + finalI + " " +finalJ + "is BLUE" );
                        }
                    }
                });




            }

        }

        add(headR);
        add(headL);
        updateCal();
        repaint();
    }
    public static void main(String[] av) {
        JFrame f = new JFrame("Cal");
        f.setSize(1000,400);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


        CalendarUI cal = new CalendarUI();
        cal.setBounds(1,1,750,300);
        f.add(cal);

        f.repaint();
    }
}

