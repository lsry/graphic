package enity.shape;

public class Box {
    public Point3 min;

    public Point3 max;

    public Box (Point3 p1,Point3 p2) {
        min = p1;
        max = p2;
    }
}