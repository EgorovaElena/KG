package Task2;

import java.awt.*;

public class CircleWu implements PixelDrawer {
    private int radius;

    public CircleWu(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g, int x, int y) {
        int x_ = radius;
        int y_ = 0;
        int radiusError = 1 - x_;
        float gradient = 0.5f;
        while (x_ >= y_) {
            drawPx(x_ + x, y_ + y, g);
            drawPx(y_ + x, x_ + y, g);
            drawPx(-x_ + x, y_ + y, g);
            drawPx(-y_ + x, x_ + y, g);
            drawPx(-x_ + x, -y_ + y, g);
            drawPx(-y_ + x, -x_ + y, g);
            drawPx(x_ + x, -y_ + y, g);
            drawPx(y_ + x, -x_ + y, g);

            drawGradientPx(x_ + x, y_ + y +1,gradient, g);
            drawGradientPx(y_ + x, x_ + y +1,gradient, g);
            drawGradientPx(-x_ + x, y_ + y +1,gradient, g);
            drawGradientPx(-y_ + x, x_ + y +1,gradient, g);
            drawGradientPx(-x_ + x, -y_ + y +1,gradient, g);
            drawGradientPx(-y_ + x, -x_ + y +1,gradient, g);
            drawGradientPx(x_ + x, -y_ + y +1,gradient, g);
            drawGradientPx(y_ + x, -x_ + y +1,gradient, g);
            y_++;
            if (radiusError < 0) {
                radiusError += 2 * y_ + 1;
            } else {
                x_--;
                radiusError += 2 * (y_ - x_ + 1);
            }
        }
    }

    void drawPx(int x, int y, Graphics2D g) {
        g.fillRect(x, y, 1, 1);
    }

    //brightness value from 0 to 1
    private void drawGradientPx(int x, int y, float brightness, Graphics2D g) {
        g.setColor(new Color(Color.HSBtoRGB(0, 1, brightness)));
        g.fillRect(x, y, 1, 1);
    }

    //дробная часть
    private int fractionalPart(Float number) {
        String fractional = number.toString().split("\\.")[1];
        if (fractional.length() > 6) fractional = fractional.substring(0, 6);
        return Integer.parseInt(fractional);
    }

    //дробная часть
    private int fractionalPart(Double number) {
        String fractional = number.toString().split("\\.")[1];
        if (fractional.length() > 8) fractional = fractional.substring(0, 8);
        return Integer.parseInt(fractional);
    }

    //целая часть
    private int intPart(Float number) {
        String fractional = number.toString().split("\\.")[0];
        if (fractional.length() > 8) fractional = fractional.substring(0, 8);
        return Integer.parseInt(fractional);
    }

    //целая часть
    private int intPart(Double number) {
        String fractional = number.toString().split("\\.")[0];
        if (fractional.length() > 8) fractional = fractional.substring(0, 8);
        return Integer.parseInt(fractional);
    }
}
