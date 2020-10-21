package Task2;

import Common.Drawable;

import java.awt.*;

public class LineBresenham implements LineDrawer {
    Color color;

    public LineBresenham(Color color) {
        this.color = color;
    }

    @Override
    public void drawLine(Graphics2D g, int x1, int y1, int x2, int y2) {
        g.setColor(color);
        int deltax = Math.abs(x2 - x1);
        int deltay = Math.abs(y2 - y1);
        if (deltax < deltay) {
            if (y1 > y2) { // x1 должен быть слева
                int tmp = x1;
                x1 = x2;
                x2 = tmp;

                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            drawVertical(g, x1, y1, x2, y2);
        } else {
            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;

                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            drawHorizontal(g, x1, y1, x2, y2);
        }
    }

    private static void drawHorizontal(Graphics2D g, int x1, int y1, int x2, int y2)
    {
        int deltax = Math.abs(x2 - x1);
        int deltay = Math.abs(y2 - y1);
        int error = 0;
        int deltaerr = (deltay + 1);
        int y = y1;
        int diry = y2 - y1;
        if (diry > 0)
            diry = 1;
        if (diry < 0)
            diry = -1;

        for (int x = x1; x <= x2; x++) {
            g.fillOval(x, y, 2, 2);
            error += deltaerr;
            if (error >= (deltax + 1)) {
                y += diry;
                error -= (deltax + 1);
            }
        }
    }

    private static void drawVertical(Graphics2D g, int x1, int y1, int x2, int y2) {
        int deltax = Math.abs(x2 - x1);
        int deltay = Math.abs(y2 - y1);
        int error = 0;
        int deltaerr = (deltax + 1);
        int x = x1;
        int dirx = x2 - x1;
        if (dirx > 0)
            dirx = 1;
        if (dirx < 0)
            dirx = -1;

        for (int y = y1; y <= y2; y++) {
            g.fillOval(x, y, 2, 2);
            error += deltaerr;
            if (error >= (deltay + 1)) {
                x += dirx;
                error -= (deltay + 1);
            }
        }
    }

}
