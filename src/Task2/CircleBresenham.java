package Task2;

import java.awt.*;

public class CircleBresenham implements PixelDrawer {
    private int radius;

    public CircleBresenham(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g, int x, int y) {
        int dx = radius;
        int dy = 0;
        int radiusError = 1 - dx;
        while (dx >= dy) {
            g.fillRect(dx + x, dy + y, 1, 1);
            g.fillRect(dy + x, dx + y, 1, 1);
            g.fillRect(-dx + x, dy + y, 1, 1);
            g.fillRect(-dy + x, dx + y, 1, 1);
            g.fillRect(-dx + x, -dy + y, 1, 1);
            g.fillRect(-dy + x, -dx + y, 1, 1);
            g.fillRect(dx + x, -dy + y, 1, 1);
            g.fillRect(dy + x, -dx + y, 1, 1);

            dy++;
            if (radiusError < 0) {
                radiusError += 2 * dy + 1;
            } else {
                dx--;
                radiusError += 2 * (dy - dx + 1);
            }
        }
    }
}
