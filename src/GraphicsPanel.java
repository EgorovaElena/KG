import Common.Drawable;
import Task1.Fir;
import Task1.Sky;
import Task2.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel {
        Dimension prevSize = new Dimension();
        ArrayList<LineDrawer> lines = new ArrayList<>();
        Dimension baseSize = new Dimension(1000, 1000);

        public GraphicsPanel() {
            //figures.add(new Sky((int)baseSize.getWidth(),(int)baseSize.getHeight()));
           // figures.add(new Task1.Fir(450,250, 400, 500));
            //figures.add(new Fir(700,200, 100, 300));
            //figures.add(new LineBresenham(100, 100, 100, 400));
            //figures.add(new LineBresenham(100, 100, 400, 100));
           // figures.add(new LineBresenham(100, 100, 200, 400));
            setSize(baseSize);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            LineDDA lineDDA = new LineDDA(Color.red);
            LineBresenham bresenhamLine = new LineBresenham(Color.blue);
            LineWu lineWu = new LineWu(Color.green);

            bresenhamLine.drawLine(g2d,100, 550, 400, 100);
            bresenhamLine.drawLine(g2d,400, 100, 700, 550);
            lineDDA.drawLine(g2d,100, 250, 400, 700);
            lineDDA.drawLine(g2d, 400, 700, 700, 250);
            lineWu.drawLine(g2d,100, 250, 700, 250);
            lineWu.drawLine(g2d,100, 550, 700, 550);

            ArcBresenham arcBresenham = new ArcBresenham(200, 100, Color.black, Color.blue);
            arcBresenham.draw(g2d, 300, 300);

            CircleBresenham circleBresenham = new CircleBresenham(300);
            circleBresenham.draw(g2d, 400, 400);

            EllipseBresenham ellipseBresenham =
                    new EllipseBresenham(200, 100, Color.ORANGE, Color.yellow);

            ellipseBresenham.draw(g2d,400, 400);

            CircleWu circleWu = new CircleWu(350);
            circleWu.draw(g2d,400, 400);

        }
}
