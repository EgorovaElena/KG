package Task2;

import java.awt.*;

public class LineWu implements LineDrawer {
    Color color;

    public LineWu(Color color) {
        this.color = color;
    }

    @Override
    public void drawLine(Graphics2D g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        if (dx == 0 || dy == 0) {
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
            return;
        }


        int r = color.getRed();
        int gr = color.getGreen();
        int b = color.getBlue();

        float z = 0;
        if (dx > dy) {
            z = (float) dy / dx;
            float i = y1 + z;
            g.setColor(color);
            g.drawLine(x1, y1, x1, y1);
            for (int x = x1; x < x2; ++x) {
                g.setColor(new Color(r, gr, b, (int) (255 - fractionalPart(i) * 255))); //Меняем прозрачность
                g.drawLine(x, (int) i, x, (int) i);
                g.setColor(new Color(r, gr, b, (int) (fractionalPart(i) * 255)));
                g.drawLine(x, (int) i + 1, x, (int) i + 1);
                i += z;
            }
            g.setColor(color);
            g.drawLine(x2, y2, x2, y2);
        } else {
            z = (float) dx / dy;
            float i = x1 + z;
            g.setColor(color);
            g.drawLine(x1, y1, x1, y1);
            for (int y = y1; y < y2; ++y) {
                g.setColor(new Color(r, gr, b, (int) (255 - fractionalPart(i) * 255)));
                g.drawLine((int) i, y, (int) i, y);
                g.setColor(new Color(r, gr, b, (int) (fractionalPart(i) * 255)));
                g.drawLine((int) i + 1, y, (int) i + 1, y);
                i += z;
            }
            g.setColor(color);
            g.drawLine(x2, y2, x2, y2);
        }
    }

    private float fractionalPart(float x) {
        int p = (int) x;
        return x - p;
    }
}
