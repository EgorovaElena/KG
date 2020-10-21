package Task2;

import java.awt.*;

public class LineDDA implements LineDrawer {
    Color color;

    public LineDDA(Color color) {
        this.color = color;
    }

    @Override
    public void drawLine(Graphics2D g, int x1, int y1, int x2, int y2) {
        g.setColor(color);
        double x = x1;
        double y = y1;
        int L = Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
        double dx = (x2 - x1) / (double) L;
        double dy = (y2 - y1) / (double) L;

        for (int i = 0; i <= L; i++) {
            g.fillRect((int) x, (int) y, 1, 1);
            x += dx;
            y += dy;
        }
    }

}
