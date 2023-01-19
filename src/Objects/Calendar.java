package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;

public class Calendar extends JPanel {
        int[] clicked = {-1,-1};

        String[] wDays ={"M", "T", "W", "T", "F", "S", "S"};
    public Calendar(){
        setSize(750,300);
        setVisible(true);
        setLayout(null);
        setBackground(new Color(0,0,0,15));
        buildGUI();

    }

    private void buildGUI(){
        RoundJLabel daysStart[][] = new RoundJLabel[6][7];
        RoundJLabel wDaysStart[] = new RoundJLabel[7];
        RoundJLabel daysEnd[][] = new RoundJLabel[6][7];
        RoundJLabel wDaysEnd[] = new RoundJLabel[7];

        RoundJLabel head = new RoundJLabel(92,10, 185, 40, 0, 0);
        head.setBackground(Color.BLUE);
        head.setOpaque(true);
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
                int finalI = i;
                int finalJ = j;
                daysStart[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        daysStart[finalI][finalJ].setBackground(Color.BLACK);
                        if(clicked[0] == -1){
                            clicked[0] = finalI;
                            clicked[1] = finalJ;

                        }else {
                            daysStart[clicked[0]][clicked[1]].setBackground(Color.BLUE);
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        daysStart[finalI][finalJ].setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if(daysStart[finalI][finalJ].getBackground() != Color.BLACK) {
                            daysStart[finalI][finalJ].setBackground(Color.BLUE);
                        }
                    }
                });
                add(daysStart[i][j]);


            }

        }


        add(head);
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


        Calendar cal = new Calendar();
        cal.setBounds(1,1,750,300);
        f.add(cal);

        f.repaint();
    }
}

