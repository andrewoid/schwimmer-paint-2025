package schwimmer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Tool {
    void pressed(BufferedImage image, Graphics2D g, int x, int y);

    void dragged(Graphics2D g, int x, int y);

    /**
     * Draws a preview of the tool's operation if released is called
     * @param g
     */
    void preview(Graphics2D g);

    void released(Graphics2D g, int x, int y);
}
