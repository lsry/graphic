package test;

import java.io.IOException;

import enity.ARGB;
import enity.dd.Point2;
import enity.dd.Triangle;
import raster.DTriangle;
import utils.ImageUtil;

public class DTriangleTest {
    public static void main(String[] args) throws IOException {
        ARGB[][] screen = new ARGB[256][256];
        for (int h = 0;h < 256;++h) {
            for (int w = 0;w < 256;++w) {
                screen[h][w] = new ARGB(ARGB.WHITE);
            }
        }
        Point2 p1 = new Point2(80, 100, new ARGB(255,0,0));
        Point2 p2 = new Point2(220, 100, new ARGB(0,255,0));
        Point2 p3 = new Point2(20, 250, new ARGB(0,0,255));
        Point2 p4 = new Point2(160, 250, new ARGB(255,0,255));
        Point2 p5 = new Point2(128, 10, new ARGB(255,255,255));
        Point2 p6 = new Point2(30, 90, new ARGB(0,0,0));
        Point2 p7 = new Point2(220, 90, new ARGB(127,127,127));
        Triangle tag1 = new Triangle(p1, p2, p3);
        DTriangle.draw(screen, tag1);
        Triangle tag2 = new Triangle(p4, p2, p3);
        DTriangle.draw(screen, tag2);
        Triangle tag3 = new Triangle(p5, p6, p7);
        DTriangle.draw(screen, tag3);
        ImageUtil img = new ImageUtil(screen[0].length, screen.length);
        img.setARGBData(screen);
        img.write("triangle.png");
    }
}