package raster;

import enity.ARGB;
import enity.dd.Line;

public class DLine {
    public static void draw(ARGB[][] colors,Line line,ARGB color) {
        draw(colors, line.p1.x, line.p1.y, line.p2.x, line.p2.y, color);
    }


    public static void draw(ARGB[][] colors,int x1,int y1,int x2,int y2,ARGB color) {
        double k = Double.MAX_VALUE;
        if (x2 != x1) {
            k = (y2 - y1) * 1.0 / (x2 - x1);
        } 
        if (x2 == x1 || k > 1) {
            if (y1 > y2) {
                int tx = x1;
                int ty = y1;
                x1 = x2;
                y1 = y2;
                x2 = tx;
                y2 = ty;
            }
            int x = x1;
            int detx = x2 - x1, dety = y1 - y2;
            double d = dety * (x1 + 0.5) + detx * (y1 + 1) + x1 * y2 - x2 * y1;
            for (int y = y1;y <= y2;++y) {
                colors[y][x] = color;
                if (d > 0) {
                    ++x;
                    d += detx + dety;
                } else {
                    d += detx;
                }
            }
        } else if (k > 0) {
            if (x1 > x2) {
                int tx = x1;
                int ty = y1;
                x1 = x2;
                y1 = y2;
                x2 = tx;
                y2 = ty;
            }
            int y = y1;
            int detx = x2 - x1, dety = y1 - y2;
            double d = dety * (x1 + 1) + detx * (y1 + 0.5) + x1 * y2 - x2 * y1;
            for (int x = x1;x <= x2;++x) {
                colors[y][x] = color;
                if (d < 0) {
                    y++;
                    d += detx + dety;
                } else {
                    d += dety;
                }
            }
        } else if (k > -1) {
            if (x1 > x2) {
                int tx = x1;
                int ty = y1;
                x1 = x2;
                y1 = y2;
                x2 = tx;
                y2 = ty;
            }
            int y = y1;
            int detx = x2 - x1, dety = y1 - y2;
            double d = dety * (x1 + 1) + detx * (y1 - 0.5) + x1 * y2 - x2 * y1;
            for (int x = x1;x <= x2 && y >= 0;++x) {
                colors[y][x] = color;
                if (d > 0) {
                    --y;
                    d += detx + dety;
                } else {
                    d += dety;
                }
            }
        } else {
            if (y1 > y2) {
                int tx = x1;
                int ty = y1;
                x1 = x2;
                y1 = y2;
                x2 = tx;
                y2 = ty;
            }
            int x = x1;
            int detx = x2 - x1, dety = y1 - y2;
            double d = dety * (x1 + 0.5) + detx * (y1 + 1) + x1 * y2 - x2 * y1;
            for (int y = y1;y <= y2;++y) {
                colors[y][x] = color;
                if (d < 0) {
                    --x;
                    d += detx + dety;
                } else {
                    d += detx;
                }
            }
        }
    }
}