package Task1;

import Common.Drawable;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fir implements Drawable {
    private static final int LIGHT_TRIANGLE_COUNT = 3;
    private static final int DARK_TRIANGLE_COUNT = 3;

    private int x;
    private int y;
    private int w;
    private int h;

    ArrayList<double[]> trianglesX = new ArrayList<>();
    ArrayList<double[]> trianglesY = new ArrayList<>();

    public Fir(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.w = width;
        this.h = height;

        // dark
        trianglesX.add(new double[]{0.25 * w, 0.5 * w, 0.5 * w});
        trianglesY.add(new double[]{0.3 * h, 0, 0.3 * h});

        trianglesX.add(new double[]{0.125 * w, 0.5 * w, 0.5 * w});
        trianglesY.add(new double[]{0.6 * h, 0.2 * h, 0.6 * h});

        trianglesX.add(new double[]{0, 0.5 * w, 0.5 * w});
        trianglesY.add(new double[]{h, 0.5 * h, h});

        // light
        trianglesX.add(new double[]{0.75 * w, 0.5 * w, 0.5 * w});
        trianglesY.add(new double[]{0.3 * h, 0, 0.3 * h});

        trianglesX.add(new double[]{0.875 * w, 0.5 * w, 0.5 * w});
        trianglesY.add(new double[]{0.6 * h, 0.2 * h, 0.6 * h});

        trianglesX.add(new double[]{w, 0.5 * w, 0.5 * w});
        trianglesY.add(new double[]{h, 0.5 * h, h});
    }

    @Override
    public void draw(Graphics2D g) {
        int[] currentTriangleX = new int[3];
        int[] currentTriangleY = new int[3];
        int startX = (int) (x);
        int startY = (int) (y);
        int endX = (int) ((x + w / 2));
        int endY = (int) (y);

        GradientPaint gradient = new GradientPaint(startX, startY, new Color(120,70, 110), endX, endY, Color.black);
        g.setPaint(gradient);

        //g.setColor(Color.darkGray);
        for (int triangleIdx = 0; triangleIdx < DARK_TRIANGLE_COUNT; triangleIdx++) {
            for (int pointIdx = 0; pointIdx < currentTriangleX.length; pointIdx++) {
                currentTriangleX[pointIdx] = (int) ( (trianglesX.get(triangleIdx)[pointIdx] + x));
                currentTriangleY[pointIdx] = (int) ( (trianglesY.get(triangleIdx)[pointIdx] + y));
            }
            g.fillPolygon(currentTriangleX, currentTriangleY, 3);
        }
        startX = endX;
        endX = (int) ((x + w));

        gradient = new GradientPaint(startX, startY, Color.black, endX, endY,new Color(120,70, 110) );
        g.setPaint(gradient);

        for (int triangleIdx = DARK_TRIANGLE_COUNT; triangleIdx < DARK_TRIANGLE_COUNT + LIGHT_TRIANGLE_COUNT; triangleIdx++) {
            for (int pointIdx = 0; pointIdx < currentTriangleX.length; pointIdx++) {
                currentTriangleX[pointIdx] = (int) ((trianglesX.get(triangleIdx)[pointIdx] + x));
                currentTriangleY[pointIdx] = (int) ((trianglesY.get(triangleIdx)[pointIdx] + y));
            }
            g.fillPolygon(currentTriangleX, currentTriangleY, 3);
        }

    }


}
