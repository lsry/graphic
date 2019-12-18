package enity.shape;

public class Ray {
    public Point3 origin;
    public Vector3 direction;

    public Ray(Point3 point,Vector3 vec) {
        this.origin = point;
        this.direction = vec;
    }

    public Point3 getPointByParam(double t) {
        return new Point3(origin.x + t * direction.x,origin.y + t * direction.y,origin.z + t * direction.z);
    }

    public double paramofPoint(Point3 p) {
        return (p.x - origin.x) / direction.x;
    }
}