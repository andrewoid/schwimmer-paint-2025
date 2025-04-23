package schwimmer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class PaintFrame extends JFrame {

    private final DrawingComponent canvas = new DrawingComponent();

    private Tool tool = new LineTool();

    public PaintFrame() {

        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);

        canvas.setTool(tool);

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                tool.dragged(g, e.getX(), e.getY());
                canvas.repaint();
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
                BufferedImage image = canvas.getImage();
                Graphics2D g = (Graphics2D) image.getGraphics();
                g.setColor(Color.BLACK);
                tool.pressed(image, g, e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                tool.released(g, e.getX(), e.getY());
                canvas.repaint();
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
