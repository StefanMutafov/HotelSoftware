package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class RoundJLabel extends JLabel {
    private Shape shape;
    int roundX=0, roundY=0, x=0, y=0, wight=0, height=0;


    public RoundJLabel (){
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        //this.setBounds(x, y, wight, height);
//        this.x = x;
//        this.y = y;
//        this.wight = wight;
//        this.height = height;
//        this.roundX = roundX;
//        this.roundY = roundY;
    }

    public void setBounds(int x, int y, int width, int height, int roundX, int roundY){
        super.setBounds(x, y, width, height);
        this.roundX = roundX;
        this.roundY = roundY;


    }



    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, roundX, roundY);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
//        g.setColor(getForeground());
//        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, roundX, roundY);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, roundX, roundY);
        }
        return shape.contains(x, y);
    }
}
