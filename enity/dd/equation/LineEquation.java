package enity.dd.equation;

import enity.dd.Point2;

public class LineEquation {
    private double detx;
    private double dety;
    private double cnum;

    public LineEquation(Point2 p1,Point2 p2) {
        detx = p2.x - p1.x;
        dety = p1.y - p2.y;
        cnum = p1.x * p2.y - p2.x * p1.y;
    }

    public double getFP(Point2 p) {
        return dety * p.x + detx * p.y + cnum;
    }

    public double getFP(int x,int y) {
        return dety * x + detx * y + cnum;
    }
}