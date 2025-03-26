package schwimmer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingComponent extends JComponent {

    private final BufferedImage image = new BufferedImage(
            800,
            600,
            BufferedImage.TYPE_INT_RGB
    );
    private int oldx=-1;
    private int oldy=-1;

    public DrawingComponent() {
        // Set the image to be all white
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0, image.getWidth(), image.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, null);
    }

    public void drawFromMouse(int x, int y) {

        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);
        if (oldx != -1 && oldy != -1) {
            g.drawLine(oldx, oldy, x, y);
        }
        oldx = x;
        oldy = y;

        repaint();
    }
}
