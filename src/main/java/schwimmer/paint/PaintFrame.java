package schwimmer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintFrame extends JFrame {

    private final DrawingComponent canvas = new DrawingComponent();

    public PaintFrame() {

        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent event) {
                canvas.drawFromMouse(event.getX(), event.getY());
            }

            @Override
            public void mouseMoved(MouseEvent event) {

            }
        });

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public static void main(String[] args) {
        new PaintFrame().setVisible(true);
    }

}
