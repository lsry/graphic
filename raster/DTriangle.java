package raster;

import enity.ARGB;
import enity.dd.Triangle;
import enity.dd.equation.LineEquation;
import utils.MyMath;

public class DTriangle {
    public static void draw(ARGB[][] screen,Triangle tag) {
        int[] xminax = MyMath.minMax(tag.p1.x,tag.p2.x,tag.p3.x);
        int[] yminax = MyMath.minMax(tag.p1.y,tag.p2.y,tag.p3.y);

        LineEquation l12 = new LineEquation(tag.p1, tag.p2);
        double f3 = l12.getFP(tag.p3);
        LineEquation l13 = new LineEquation(tag.p1, tag.p3);
        double f2 = l13.getFP(tag.p2);
        LineEquation l23 = new LineEquation(tag.p2, tag.p3);
        double f1 = l23.getFP(tag.p1);
        for (int h = yminax[0];h <= yminax[1];++h) {
            for (int w = xminax[0];w <= xminax[1];++w) {                
                double fa = l12.getFP(w,h) / f3;
                double fb = l23.getFP(w,h) / f1;
                double fc = l13.getFP(w,h) / f2;
                if (fa >= 0 && fb >= 0 && fc >= 0) {
                    if ((fa > 0 || f3 * l12.getFP(-1, -1) > 0) && 
                        (fb > 0 || f1 * l23.getFP(-1, -1) > 0) && 
                        (fc > 0 || f2 * l13.getFP(-1, -1) > 0)) {
                        double r = fa * tag.p3.color.getRedIntensity() + fb * tag.p1.color.getRedIntensity() 
                                 + fc * tag.p2.color.getRedIntensity();
                        double g = fa * tag.p3.color.getGreenIntensity() + fb * tag.p1.color.getGreenIntensity() 
                                 + fc * tag.p2.color.getGreenIntensity();
                        double b = fa * tag.p3.color.getBlueIntensity() + fb * tag.p1.color.getBlueIntensity() 
                                 + fc * tag.p2.color.getBlueIntensity();
                        screen[h][w] = new ARGB(r, g, b);
                    } 
                }
            }
        }
    }
}