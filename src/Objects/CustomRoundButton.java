package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class CustomRoundButton extends JLabel {
    private Shape shape;
    int roundX, roundY, x, y, wight, height;
    public CustomRoundButton (int x,int y,int wight, int height,int roundX,int roundY){

        this.setBounds(x, y, wight, height);
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.height = height;
        this.roundX = roundX;
        this.roundY = roundY;
//TODO: Make it usable in every case
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){

            }
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.RED);
            }
        });
    }


    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
