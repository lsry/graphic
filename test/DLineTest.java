package test;

import java.io.IOException;

import enity.ARGB;
import raster.DLine;
import utils.ImageUtil;

public class DLineTest {
    public static void main(String[] args) throws IOException {
        ARGB[][] colors = new ARGB[256][256];
        for (int h = 0;h < 256;++h) {
            for (int w = 0;w < 256;++w) {
                colors[h][w] = new ARGB(ARGB.WHITE);
            }
        }
        DLine.draw(colors, 0, 0, 255,255,ARGB.BLACK);
        DLine.draw(colors, 255, 0, 0, 255, ARGB.BLACK);
        DLine.draw(colors, 127, 0, 127, 255, ARGB.BLACK);
        DLine.draw(colors, 0, 127, 255, 127, ARGB.BLACK);
        DLine.draw(colors, 127, 0, 0, 127, ARGB.BLACK);
        DLine.draw(colors, 127, 0, 255, 127, ARGB.BLACK);
        DLine.draw(colors, 0, 127, 127, 255, ARGB.BLACK);
        DLine.draw(colors, 127, 255, 255, 127, ARGB.BLACK);
        ImageUtil img = new ImageUtil(colors[0].length, colors.length);
        img.setARGBData(colors);
        img.write("line.png");
    }
}