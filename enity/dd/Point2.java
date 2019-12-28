package enity.dd;

import enity.ARGB;

public class Point2 {
    public int x;
    public int y;
    public ARGB color;

    public Point2(int x,int y,ARGB color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Point2(int x,int y) {
        this(x, y, ARGB.BLACK);
    }

    public Point2() {
        this(0,0,ARGB.BLACK);
    }
}