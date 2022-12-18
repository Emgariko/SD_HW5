package graph;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFxDrawingApi implements DrawingApi {
    private final double RADIUS = 15;
    private final Stage stage;
    private final Canvas canvas;
    private final GraphicsContext gc;
    private final int width;
    private final int height;

    public JavaFxDrawingApi(int width, int height, Stage stage) {
        this.width = width;
        this.height = height;
        this.stage = stage;
        this.canvas = new Canvas(width, height);
        this.gc = canvas.getGraphicsContext2D();
    }

    @Override
    public long getDrawingAreaWidth() {
        return width;
    }

    @Override
    public long getDrawingAreaHeight() {
        return height;
    }

    @Override
    public void drawCircle(Circle circle) {
        gc.setFill(Color.GRAY);
        gc.fillOval(circle.point.x - circle.radius, circle.point.y - circle.radius, circle.radius, circle.radius);
    }

    @Override
    public void drawLine(Circle.Point from, Circle.Point to) {
        gc.setStroke(Color.BLACK);
        gc.strokeLine(from.x, from.y, to.x, to.y);
    }
}
