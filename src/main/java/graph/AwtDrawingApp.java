package graph;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.function.BiFunction;

public class AwtDrawingApp {
    private final BiFunction<DrawingApi, String, Graph> getGraph;
    String fileName;

    public AwtDrawingApp(BiFunction<DrawingApi, String, Graph> getGraph, String fileName) {
        this.getGraph = getGraph;
        this.fileName = fileName;
    }

    public static class AwtApp extends Frame {
        static BiFunction<DrawingApi, String, Graph> getGraph;
        @Override
        public void paint(Graphics g) {
            Graphics2D ga = (Graphics2D)g;
            ga.setPaint(Color.green);
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            var api = new AwtDrawingApi(this, g, screenBounds.getHeight(), screenBounds.getWidth());
            var graph = getGraph.apply(api, "graph.txt");
        }

        public static void run() {
            Frame frame = new AwtApp();
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            });
            frame.setSize(700, 700);
            frame.setVisible(true);
        }
    }

    public void run() {
        AwtApp.getGraph = getGraph;
        AwtApp.run();
    }
}
