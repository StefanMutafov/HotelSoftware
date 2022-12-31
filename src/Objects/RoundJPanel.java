package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundJPanel extends JPanel {
    Shape shape;
    int roundX, roundY;
    public RoundJPanel(int x,int y,int width1,int height1 , int roundX,  int roundY){
        setBounds(x, y, width1, height1);
        this.roundX = roundX;
        this.roundY = roundY;


        setOpaque(false);
    }


    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, roundX, roundY);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, roundX, roundY);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, roundX, roundY);
        }
        return shape.contains(x, y);
    }


//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Dimension arcs = new Dimension(roundX,roundY);
//        int width = getWidth();
//        int height = getHeight();
//        Graphics2D graphics = (Graphics2D) g;
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//
//        //Draws the rounded opaque panel with borders.
//        graphics.setColor(getBackground());
//        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
////        graphics.setColor(getForeground());
//        graphics.setColor(getBackground());
//        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
//    }


}
