package graph;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.function.BiFunction;

public class JavaFxDrawingApp {
    private final BiFunction<DrawingApi, String, Graph> getGraph;
    String fileName;

    public JavaFxDrawingApp(BiFunction<DrawingApi, String, Graph> getGraph, String fileName) {
        this.getGraph = getGraph;
        this.fileName = fileName;
    }

    public static class JavaFxApp extends Application {
        static BiFunction<DrawingApi, String, Graph> getGraph;

        public static void run() {
            launch();
        }

        @Override
        public void start(Stage primaryStage) throws FileNotFoundException {
            primaryStage.setTitle("Graph");
            Group root = new Group();
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            Canvas canvas = new Canvas(screenBounds.getWidth(), screenBounds.getHeight());
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.LIGHTPINK);
            var api = new JavaFxDrawingApi((int) screenBounds.getWidth(), (int) screenBounds.getHeight(), primaryStage);
            var graph = getGraph.apply(api, "graph.txt");
            graph.readGraph();
            graph.drawGraph();
            root.getChildren().add(canvas);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    }

    public void run() {
        JavaFxApp.getGraph = getGraph;
        JavaFxApp.run();
    }
}
