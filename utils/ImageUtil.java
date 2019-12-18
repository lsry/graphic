package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import enity.ARGB;

public class ImageUtil {
    private BufferedImage bi;

    private int width;
    private int height;

    public ImageUtil(int width, int height) {
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.width = width;
        this.height = height;
    }

    public void setRGBData(int[] rgbs) {
        int index = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixiv = 255 << 24;
                pixiv += rgbs[index++] << 16;
                pixiv += rgbs[index++] << 8;
                pixiv += rgbs[index++];
                bi.setRGB(j, i, pixiv);
            }
        }
    }

    public void setARGBData(int[] argbs) {
        int index = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixiv = argbs[index++] << 24;
                pixiv += argbs[index++] << 16;
                pixiv += argbs[index++] << 8;
                pixiv += argbs[index++];
                bi.setRGB(j, i, pixiv);
            }
        }
    }

    public void setARGBData(ARGB[][] colors) {
        bi = new BufferedImage(colors[0].length,colors.length,BufferedImage.TYPE_INT_ARGB);
        for (int h = 0;h < colors.length;h++) {
            for (int w = 0;w < colors[0].length;w++) {
                bi.setRGB(w, h, colors[h][w].getARGB());
            }
        }
    }

    public void write(String filePath) throws IOException {
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png"); 
        ImageWriter writer = it.next();

        try (ImageOutputStream ios = ImageIO.createImageOutputStream(new File(filePath))) {
            writer.setOutput(ios);
            writer.write(bi);
            bi.flush();
            ios.flush();
        }      
    }

    public static void main(String[] args) throws IOException {
        ARGB[][] argb = new ARGB[256][256];
        for (int i = 0;i < 256;i++) {
            for (int j = 0;j < 256;j++) {
                argb[i][j] = new ARGB(i,j,128);
            }
        }
        ImageUtil img = new ImageUtil(256,256);
        img.setARGBData(argb);
        img.write("test.png");
    }
}