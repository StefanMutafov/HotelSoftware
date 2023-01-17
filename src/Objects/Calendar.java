package Objects;

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;

public class Calendar extends JPanel {


    public Calendar(){
        setSize(750,300);
        setVisible(true);
        setBackground(new Color(0,0,0,15));
        buildGUI();

    }

    private void buildGUI(){
        RoundJLabel daysStart[][] = new RoundJLabel[7][6];
        RoundJLabel wDaysStart[] = new RoundJLabel[7];
        RoundJLabel daysEnd[][] = new RoundJLabel[7][6];
        RoundJLabel wDaysEnd[] = new RoundJLabel[7];

        RoundJLabel head = new RoundJLabel(92,10, 185, 40, 0, 0);
        head.setBackground(Color.BLUE);
        head.setOpaque(true);
        for(int i =0;i<7;i++){
           // wDaysStart[i].setBounds();
        }

        for(int i =0; i<6;i++){
            for(int j = 0; j<7;j++){
                wDaysStart[i].setBounds();

            }

        }


        add(head);
        repaint();
    }
    public static void main(String[] av) {
        JFrame f = new JFrame("Cal");
        f.setSize(1000,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


        Calendar cal = new Calendar();
        cal.setBounds(1,1,750,300);
        f.add(cal);

        f.repaint();
    }
}

