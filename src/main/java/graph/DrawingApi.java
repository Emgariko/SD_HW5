package graph;

public interface DrawingApi {
    public static double CIRCLE_RAD = 300;
    public static double NODE_RAD = 15;
    long getDrawingAreaWidth();
    long getDrawingAreaHeight();
    void drawCircle(Circle circle);
    void drawLine(Circle.Point from, Circle.Point to);
}
