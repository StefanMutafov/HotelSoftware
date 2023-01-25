package Objects;

import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addMenu extends JPanel {
    JLabel counter = new JLabel();
    CustomRoundButton plus = new CustomRoundButton();
    CustomRoundButton minus = new CustomRoundButton();
        String text;
        int count =0;
        String fText;
        public addMenu(String text){
            this.text = text;
            setVisible(true);
            setLayout(null);
            setOpaque(false);
           // setBackground(new Color(70,70,70));
            buildGUI();

        }
        @Override
        public void setBounds(int x, int y, int width, int height){
            super.setBounds(x, y, width, height);
            counter.setBounds(width/4, 0, width/2,height);
            plus.setBounds(width/4*3, 0, width/4, height, width/4, height);
           minus.setBounds(0, 0, width/4, height, width/4, height);
            System.out.println(width/4);
            System.out.println(height);

        }

        public Integer getCount(){
            return count;
        }

        private void buildGUI() {
           // plus.setBounds(300, 0, 80, 80, 80, 80);
           // minus.setBounds(20, 0, 80, 80, 80, 80);
          //  JLabel counter = new JLabel();
          //  counter.setBounds(width/4, 0, width/2,height);
            counter.setOpaque(true);
            counter.setBackground(Color.YELLOW);
            counter.setHorizontalAlignment(SwingConstants.CENTER);
            fText = text + " " + count;
            counter.setText(fText);



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



                minus.setText("-");
                minus.setIdle(Color.WHITE);
                minus.setEntered(Color.BLUE);
                minus.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(count>0) {
                            count--;
                        }
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
