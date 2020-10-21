package Task2;

import java.awt.*;

public class EllipseBresenham implements PixelDrawer{
    private int x;
    private int y;
    private int largeSemiAxis;//большая полуось
    private int smallerSemiAxis;//меньшая полуось
    private Color largeAxisColor;
    private Color smallerAxisColor;

    public EllipseBresenham(int largeSemiAxis, int smallerSemiAxis,Color smallerAxisColor,Color largeAxisColor) {
        this.largeSemiAxis = largeSemiAxis;
        this.smallerSemiAxis = smallerSemiAxis;
        this.largeAxisColor = largeAxisColor;
        this.smallerAxisColor = smallerAxisColor;
    }
    @Override
    public void draw(Graphics2D g, int x, int y) {
        draw_ellipse(x, y,largeSemiAxis,smallerSemiAxis,g);
    }

    void putPixel(int x, int y, Graphics2D g, Color color) // Рисование пикселя
    {
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }

    void pixel4(int x, int y, int _x, int _y, Graphics2D g, Color color) // Рисование пикселя для первого квадранта, и, симметрично, для остальных
    {
        putPixel(x + _x, y + _y, g, color);
        putPixel(x + _x, y - _y, g, color);
        putPixel(x - _x, y - _y, g, color);
        putPixel(x - _x, y + _y, g, color);
    }

    private void draw_ellipse(int x, int y, int largeSemiAxis, int SmallerSemiAxis, Graphics2D g) {
        int _x = 0; // Компонента x
        int _y = SmallerSemiAxis; // Компонента y
        int a_sqr = largeSemiAxis * largeSemiAxis; // largeSemiAxis^2, largeSemiAxis - большая полуось
        int b_sqr = SmallerSemiAxis * SmallerSemiAxis; // SmallerSemiAxis^2, SmallerSemiAxis - малая полуось
        int delta = 4 * b_sqr * ((_x + 1) * (_x + 1)) + a_sqr * ((2 * _y - 1) * (2 * _y - 1)) - 4 * a_sqr * b_sqr; // Функция координат точки (x+1, y-1/2)
        while (a_sqr * (2 * _y - 1) > 2 * b_sqr * (_x + 1)) // Первая часть дуги
        {
            pixel4(x, y, _x, _y, g, largeAxisColor);
            _x++;
            if (delta < 0) // Переход по горизонтали
            {
                delta += 4 * b_sqr * (2 * _x + 3);
            } else // Переход по диагонали
            {
                delta = delta - 8 * a_sqr * (_y - 1) + 4 * b_sqr * (2 * _x + 3);
                _y--;
            }
        }
        delta = b_sqr * ((2 * _x + 1) * (2 * _x + 1)) + 4 * a_sqr * ((_y + 1) * (_y + 1)) - 4 * a_sqr * b_sqr; // Функция координат точки (x+1/2, y-1)

        while (_y + 1 != 0) // Вторая часть дуги, если не выполняется условие первого цикла, значит выполняется largeSemiAxis^2(2y - 1) <= 2b^2(x + 1)
        {
            pixel4(x, y, _x, _y, g, smallerAxisColor);
            _y--;
            if (delta < 0) // Переход по вертикали
            {
                delta += 4 * a_sqr * (2 * _y + 3);
            } else // Переход по диагонали
            {
                delta = delta - 8 * b_sqr * (_x + 1) + 4 * a_sqr * (2 * _y + 3);
                _x++;
            }
        }

    }

}
