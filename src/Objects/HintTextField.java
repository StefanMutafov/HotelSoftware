package Objects;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;

public class HintTextField extends JTextField {

    int w, l;
    private Shape shape;
    Font gainFont = new Font("Tahoma", Font.PLAIN, 17);
    Font lostFont = new Font("Tahoma", Font.ITALIC, 17);

    public HintTextField(final String hint, int w, int l) {
        this.w = w;
        this.l = l;
        setOpaque(false);
        setFocusable(false);
        setText(hint);
        setFont(lostFont);
        setForeground(Color.WHITE);



        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setFocusable(true);
                requestFocusInWindow();
            }
        });

        this.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                    setFont(gainFont);
                    setForeground(Color.white);
                } else {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.white);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint)|| getText().length()==0) {
                    setText(hint);
                    setFont(lostFont);
                    setForeground(Color.white);
                } else {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.white);
                }
            }
        });

    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, w, l);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
//        g.setColor(getForeground());
//        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, w, l);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, w, l);
        }
        return shape.contains(x, y);
    }
}

