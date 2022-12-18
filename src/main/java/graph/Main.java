package graph;

import java.io.FileNotFoundException;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        BiFunction<DrawingApi, String, Graph> getGraph;
        if (args[0].equals("matrix")) {
            getGraph = AdjMatrixGraph::new;
        } else {
            getGraph = ListGraph::new;
        }

        if (args[1].equals("javafx")) {
            new JavaFxDrawingApp(getGraph, "graph.txt").run();
        } else {
            new AwtDrawingApp(getGraph, "graph.txt").run();
        }
    }
}
