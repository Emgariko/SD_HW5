package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListGraph extends Graph {
    ArrayList<Edge> edges;
    int verticesCount;

    private static class Edge{
        public int from;
        public int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public ListGraph(DrawingApi drawingApi, String fileName) {
        super(drawingApi, fileName);
    }

    @Override
    public int getVerticesCount() {
        return verticesCount;
    }

    @Override
    public void readGraph() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            edges.add(new Edge(from, to));
        }
    }

    @Override
    protected void drawEdges() {
        for (Edge edge : edges) {
            drawingApi.drawLine(circles[edge.from].point, circles[edge.to].point);
        }
    }

}
