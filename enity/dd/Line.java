package enity.dd;

public class Line {
    public Point2 p1;
    public Point2 p2;

    public Line(Point2 p1,Point2 p2) {
        this.p1 = p1;
        this.p2 = p2;
        xNormal();
    }

    public void xNormal() {
        if (p1.x > p2.x) {
            Point2 p = p1;
            p1 = p2;
            p2 = p;
        }
    }

    public void yNormal() {
        if (p1.y > p2.y) {
            Point2 p = p1;
            p1 = p2;
            p2 = p;
        }
    }
}