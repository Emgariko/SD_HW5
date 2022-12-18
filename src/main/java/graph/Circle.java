package graph;

public class Circle {
    public static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public Point point;
    public double radius;
    private String name;

    public Circle(Point point, double radius, String name) {
        this.point = point;
        this.radius = radius;
        this.name = name;
    }

    public Circle(double x, double y, double radius, String name) {
        this.point = new Point(x, y);
        this.radius = radius;
        this.name = name;
    }
}
