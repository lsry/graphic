package enity.shape;

public class HitRec {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    public boolean isHit;

    public double tmin;

    public double tmax;

    public int num;

    public Shape shape;

    public HitRec(boolean hit,double t0,double t1,int num,Shape s) {
        isHit = hit;
        tmin = t0;
        tmax = t1;
        this.num = num;
        shape = s;
    }
}