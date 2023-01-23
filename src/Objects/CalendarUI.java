package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarUI extends JPanel {
    Calendar c = new GregorianCalendar();

   // Calendar c = Calendar.getInstance();

    JLabel daysStart[][] = new RoundJLabel[6][7];
    RoundJLabel wDaysStart[] = new RoundJLabel[7];
    RoundJLabel daysEnd[][] = new RoundJLabel[6][7];
    RoundJLabel wDaysEnd[] = new RoundJLabel[7];

    RoundJLabel year = new RoundJLabel(270,10, 90, 40, 0, 0);
    RoundJLabel headR = new RoundJLabel(395,10, 185, 40, 0, 0);
    RoundJLabel headL = new RoundJLabel(55,10, 185, 40, 0, 0);
        int[] clicked = {-1,-1};
        int[] clickedEnd = {-1,-1};

        String[] wDays ={"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};
    String[] months ={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October","November" ,"December"};
    public CalendarUI(){
        setSize(640,300);
        setVisible(true);
        setLayout(null);
        setBackground(new Color(70,70,70));
        buildGUI();

    }


        public String getStartDate()  {
            String date = new String(daysStart[clicked[0]][clicked[1]].getText());
            String month = new String(String.valueOf(c.get(Calendar.MONTH)+1));
            String year = new String(String.valueOf(c.get(Calendar.YEAR)));

            return new String(date + " " + month + " " + year);


        }

    public String getEndDate()  {
        c.add(Calendar.MONTH,1);
        String date = new String(daysEnd[clickedEnd[0]][clickedEnd[1]].getText());
        String month = new String(String.valueOf(c.get(Calendar.MONTH)+1));
        String year = new String(String.valueOf(c.get(Calendar.YEAR)));
        c.add(Calendar.MONTH,-1);
        return new String(date + " " + month + " " + year);


    }


        private void updateCal(){



            clicked[0] = -1;
            clicked[1] = -1;
            clickedEnd[0] = -1;
            clickedEnd[1] = -1;
        headL.setText(months[c.get(Calendar.MONTH)]);
        if(c.get(Calendar.MONTH)<11) {
            headR.setText(months[c.get(Calendar.MONTH) + 1]);
        }else{
            headR.setText(months[0]);
        }
        year.setText(String.valueOf(c.get(Calendar.YEAR)));
        c.set(Calendar.DATE,1);
            for(int i =0; i<6;i++){
                for(int j = 0; j<7;j++) {
                    daysStart[i][j].setText("");
                    daysEnd[i][j].setText("");
                    daysStart[i][j].setBackground(Color.BLUE);
                    daysEnd[i][j].setBackground(Color.BLUE);

                }
                }



            //
            //Left Cal
            //

//        if( c.get(Calendar.DAY_OF_WEEK)-2>=0) {
//            for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) - 2; i++) {
//
//
//                    daysStart[0][i].removeMouseListener(daysStart[0][i].getMouseListeners()[0]);
//
//
//            }
//        }else{
//
//            for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) +5; i++) {
//
//                daysStart[0][i].removeMouseListener(daysStart[0][i].getMouseListeners()[0]);
//
//            }
//        }

        for(int i = c.get(Calendar.DAY_OF_WEEK)-2; i<7;i++){
            if(i<0){i+=7;}
            daysStart[0][i].setText(String.valueOf(c.get(Calendar.DATE)));
            c.add(Calendar.DATE, 1);

        }
            for(int i =1; i<6;i++){
                for(int j = 0; j<7;j++) {
                    if(c.get(Calendar.DATE) <= c.getActualMaximum(Calendar.DAY_OF_MONTH) && c.get(Calendar.DATE) !=1){
                        daysStart[i][j].setText(String.valueOf(c.get(Calendar.DATE)));

                            c.add(Calendar.DATE, 1);

                    }else{
                       // daysStart[i][j].removeMouseListener(daysStart[i][j].getMouseListeners()[0]);

                    }

                }

                }
            //c.add(Calendar.MONTH, -1);


            //
            ///Builging right cal
            //

//            if( c.get(Calendar.DAY_OF_WEEK)-2>=0) {
//                for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) - 2; i++) {
//
//                    daysEnd[0][i].removeMouseListener(daysEnd[0][i].getMouseListeners()[0]);
//
//                }
//            }else{
//
//                for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) +5; i++) {
//
//                    daysEnd[0][i].removeMouseListener(daysEnd[0][i].getMouseListeners()[0]);
//
//                }
//            }

            for(int i = c.get(Calendar.DAY_OF_WEEK)-2; i<7;i++){
                if(i<0){i+=7;}
                daysEnd[0][i].setText(String.valueOf(c.get(Calendar.DATE)));
                c.add(Calendar.DATE, 1);

            }
            for(int i =1; i<6;i++){
                for(int j = 0; j<7;j++) {
                    if(c.get(Calendar.DATE) <= c.getActualMaximum(Calendar.DAY_OF_MONTH) && c.get(Calendar.DATE) !=1){
                        daysEnd[i][j].setText(String.valueOf(c.get(Calendar.DATE)));

                        c.add(Calendar.DATE, 1);

                    }else{
               //         daysEnd[i][j].removeMouseListener(daysEnd[i][j].getMouseListeners()[0]);

                    }

                }

            }
            c.add(Calendar.MONTH, -2);



        }

    private void buildGUI(){
        removeAll();

        CustomRoundButton next = new CustomRoundButton(590,10, 40, 40, 40, 20);
        next.setText(">");
        next.setClicked(Color.BLUE);
        next.setIdle(Color.WHITE);
        next.setEntered(Color.GRAY);
        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(c.get(Calendar.MONTH)<11) {
                    c.add(Calendar.MONTH, 1);
                }else{
                    c.set(Calendar.MONTH,0);
                    c.add(Calendar.YEAR,1);
                }
                updateCal();
            }
        });
        CustomRoundButton prev = new CustomRoundButton(10,10, 40, 40, 40, 20);
        prev.setText("<");
        prev.setClicked(Color.BLUE);
        prev.setIdle(Color.WHITE);
        prev.setEntered(Color.GRAY);
        prev.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(c.get(Calendar.MONTH)>0) {
                    c.add(Calendar.MONTH, -1);
                }else{
                    c.set(Calendar.MONTH,11);
                    c.add(Calendar.YEAR,-1);
                }
                updateCal();
            }
        });
        year.setForeground(Color.WHITE);
        year.setBackground(Color.BLUE);
        headR.setBackground(Color.BLUE);
        headR.setForeground(Color.WHITE);
        headR.setOpaque(false);
        for(int i =0;i<7;i++){
            wDaysEnd[i] = new RoundJLabel(385+i*30,70,30,30,30,30);
            wDaysEnd[i].setHorizontalAlignment(SwingConstants.CENTER);
            wDaysEnd[i].setVerticalAlignment(SwingConstants.CENTER);
            wDaysEnd[i].setBackground(Color.RED);
            wDaysEnd[i].setText(wDays[i]);
            add(wDaysEnd[i]);

        }

        for(int i =0; i<6;i++){
            for(int j = 0; j<7;j++){
                daysEnd[i][j]= new RoundJLabel(385+j*30, 110+i*30, 30,30,30,30);
                daysEnd[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                daysEnd[i][j].setVerticalAlignment(SwingConstants.CENTER);
                daysEnd[i][j].setOpaque(false);
                daysEnd[i][j].setBackground(Color.BLUE);
                daysEnd[i][j].setForeground(Color.WHITE);
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
                        System.out.println(getEndDate());
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
        headL.setForeground(Color.WHITE);
        headL.setOpaque(false);
        for(int i =0;i<7;i++){
            wDaysStart[i] = new RoundJLabel(45+i*30,70,30,30,30,30);
            wDaysStart[i].setHorizontalAlignment(SwingConstants.CENTER);
            wDaysStart[i].setVerticalAlignment(SwingConstants.CENTER);
            wDaysStart[i].setBackground(Color.RED);
            wDaysStart[i].setText(wDays[i]);
            add(wDaysStart[i]);

        }

        for(int i =0; i<6;i++){
            for(int j = 0; j<7;j++){
                daysStart[i][j]= new RoundJLabel(45+j*30, 110+i*30, 30,30,30,30);
                daysStart[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                daysStart[i][j].setVerticalAlignment(SwingConstants.CENTER);
                daysStart[i][j].setOpaque(false);
                daysStart[i][j].setBackground(Color.BLUE);
                daysStart[i][j].setForeground(Color.WHITE);
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
                        System.out.println(getStartDate());
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
        add(year);
        add(next);
        add(prev);
        add(headR);
        add(headL);
        updateCal();
        repaint();
    }
//    public static void main(String[] av) {
//        JFrame f = new JFrame("Cal");
//        f.setSize(1000,400);
//        f.setLayout(null);
//        f.setResizable(false);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//
//
//        CalendarUI cal = new CalendarUI();
//        cal.setBounds(1,1,750,300);
//        f.add(cal);
//
//        f.repaint();
//    }
}

