package enity.shape;

public class Point3{
    public double x;
    public double y;
    public double z;

    public Point3(double x,double y,double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3() {
        this(0.0,0.0,0.0);
    }
}