package enity.shape;

public class Vector3 {
    public static final double SMALL = 2.220446e-16;

    public double x;
    public double y;
    public double z;

    public Vector3(double x,double y,double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3() {
        this(0.0,0.0,0.0);
    }

    public Vector3(Vector3 v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public Vector3(Point3 p1,Point3 p2) {
        this(p2.x - p1.x,p2.y - p1.y,p2.z - p1.z);
    }

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double magnitudeSquare() {
        return x * x + y * y + z * z;
    }

    public Vector3 unitlize() {
        double magnitude = getMagnitude();
        if (magnitude <= SMALL) {
            return new Vector3(0.0, 0.0, 0.0);
        }
        return new Vector3(x / magnitude, y / magnitude, z / magnitude);
    }

    public Vector3 add(Vector3 v) {
        return new Vector3(this.x + v.x,this.y + v.y,this.z + v.z);
    }

    public Vector3 minius(Vector3 v) {
        return new Vector3(this.x - v.x,this.y - v.y,this.z - v.z);
    }

    public Vector3 numProduct(double scale) {
        return new Vector3(x * scale, y * scale, z * scale);
    }

    public double dotProduct(Vector3 v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector3 crossProduct(Vector3 v) {
        return new Vector3(this.y * v.z - this.z * v.y, this.z * v.x - this.x * v.z, this.x * v.y - this.y * v.x);
    }
}