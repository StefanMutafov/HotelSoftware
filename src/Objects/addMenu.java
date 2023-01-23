package Objects;

import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addMenu extends JPanel {

    String text;
    int count =0;
    String fText;
    int width = 0, height = 0;
    public addMenu(String text){
        this.text = text;
        setVisible(true);
        setLayout(null);
       // setBackground(new Color(70,70,70));
        buildGUI();

    }
    @Override
    public void setBounds(int x, int y, int width, int height){
        super.setBounds(x, y, width, height);
        this.width = width;
        this.height = height;
        System.out.println(width/4);
        System.out.println(height/4);

    }

    private void buildGUI() {
        JLabel counter = new JLabel();
        counter.setBounds(width/4+0, 0, width/2+0,height+0);
        counter.setOpaque(true);
        counter.setBackground(Color.YELLOW);

        fText = text + " " + count;
        counter.setText(fText);

        CustomRoundButton plus = new CustomRoundButton(width/4*3, 0, width/4, height, width/4, height);

        plus.setText("+");
        plus.setIdle(Color.WHITE);
        plus.setEntered(Color.BLUE);
        plus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                count++;
                fText = text + " " + count;
                counter.setText(fText);
                counter.repaint();
            }
        });


        CustomRoundButton minus = new CustomRoundButton(0, 0, width/4, height, width/4, height);
        minus.setText("+");
        minus.setIdle(Color.WHITE);
        minus.setEntered(Color.BLUE);
        minus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                count--;
                fText = text + " " + count;
                counter.setText(fText);
                counter.repaint();
            }
        });



         add(counter);
         add(plus);
         add(minus);
         repaint();
    }
}
