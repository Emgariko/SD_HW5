package graph;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AwtDrawingApi implements DrawingApi {
    protected Frame frame;
    protected Graphics g;
    protected Graphics2D ga;
    protected double width;
    protected double height;

    public AwtDrawingApi(Frame frame, Graphics g, double width, double height) {
        this.frame = frame;
        this.g = g;
        ga = (Graphics2D) g;
        this.width = width;
        this.height = height;
    }

    @Override
    public long getDrawingAreaWidth() {
        return frame.getWidth();
    }

    @Override
    public long getDrawingAreaHeight() {
        return frame.getHeight();
    }

    @Override
    public void drawCircle(Circle circle) {
        ga.fill(new Ellipse2D.Float((float) (circle.point.x - circle.radius), (float) (circle.point.y - circle.radius), (float) (2 * circle.radius), (float) (2 * circle.radius)));
    }

    @Override
    public void drawLine(Circle.Point from,  Circle.Point to) {
        ga.drawLine((int) from.x, (int) from.y, (int) to.x, (int) to.y);
    }
}
