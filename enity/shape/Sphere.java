package enity.shape;

public class Sphere extends Shape {
    public Point3 center;
    public double radius;

    public Sphere(Point3 c,double r) {
        this.center = c;
        this.radius = r;
    }

    public Vector3 getUnitNormal(Point3 p) {
        Vector3 v = new Vector3(center,p);
        return v.numProduct(1 / radius);
    }

    @Override
    public HitRec hit(Ray ray, double t0, double t1) {
        double A = ray.direction.magnitudeSquare();
        Vector3 ec = new Vector3(center,ray.origin);
        double B = 2 * ray.direction.dotProduct(ec);
        double C = ec.magnitudeSquare() - radius * radius;
        double discrim = B * B - 4 * A * C;
        if (discrim < 0) {
            return new HitRec(false, 0, 0,HitRec.ZERO,this);
        }
        double x1 = (B * (-1) + Math.sqrt(discrim)) / (2 * A);
        double x2 = (B * (-1) - Math.sqrt(discrim)) / (2 * A);
        if (x1 < t0 && x2 < t0 || x1 > t1 && x2 > t1) {
            return new HitRec(false, 0, 0,HitRec.ZERO,this);
        }
        if (x1 == x2) {
            return new HitRec(true, x1, x2, HitRec.ONE,this);
        }
        if (x1 > x2) {
            double temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (x1 < t0) {
            return new HitRec(true, x2, x2, HitRec.ONE,this);
        }
        if (x2 > t1) {
            return new HitRec(true, x1, x1, HitRec.ONE,this);
        }
        return new HitRec(true,x1,x2,HitRec.TWO,this);
    }

    @Override
    public Box boundingBox() {
        return new Box(new Point3(center.x - radius,center.y - radius,center.z - radius), 
                       new Point3(center.x + radius,center.y + radius,center.z + radius));
    }
}