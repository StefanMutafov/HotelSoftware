package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class CustomRoundButton extends JLabel {
    Color Idle = Color.GRAY, entered = Color.GRAY, clicked = Color.GRAY;
    private Shape shape;
    int roundX, roundY, x, y, wight, height;

    public void setIdle(Color idle) {
        Idle = idle;
    }

    public void setEntered(Color entered) {
        this.entered = entered;
    }

    public void setClicked(Color clicked) {
        this.clicked = clicked;
    }

    public CustomRoundButton (int x, int y, int wight, int height, int roundX, int roundY){
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        this.setBackground(Idle);

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
                setBackground(entered);

            }
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(clicked);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(entered);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Idle);
            }
        });
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
}
