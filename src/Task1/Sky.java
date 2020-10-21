package Task1;

import Common.Drawable;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Sky implements Drawable {

    private int w;
    private int h;

    public Sky(int width, int height) {
        this.w = width;
        this.h = height;
    }

    @Override
    public void draw(Graphics2D g) {
        Color startColor = new Color(20, 30, 60);
        Color endColor = new Color(50, 160, 190 );

        int startX = 0, startY = 0, endX = 0, endY = (int)(0.75 * h);

        GradientPaint gradient = new GradientPaint(startX, startY, startColor, endX, endY, endColor);
        g.setPaint(gradient);

        g.fill(new Rectangle(0, 0, (int)(w), (int)(h)));
    }
}
