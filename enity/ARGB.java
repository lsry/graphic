package enity;

public class ARGB {
    private int alpha;
    private int red;
    private int green;
    private int blue;

    public static final ARGB GRAY = new ARGB(255, 128, 128, 128);
    public static final ARGB WHITE = new ARGB(255, 255, 255, 255);

    public ARGB(int a,int r,int g,int b) {
        alpha = a;
        red = r;
        green = g;
        blue = b;
    }

    public ARGB(double r,double g,double b) {
        this(255,(int)(clamp(r) * 255),(int)(clamp(g) * 255),(int)(clamp(b) * 255));
    }

    private static double clamp(double d) {
        return Math.max(0.0, Math.min(1.0, d));
    }

    public ARGB(int r,int g,int b) {
        this(255,r,g,b);
    }

    public ARGB() {
        this(255,255,255,255);
    }

    public ARGB(ARGB color) {
        this(color.alpha,color.red,color.green,color.blue);
    }

    public void setAlpha(int a) {
        this.alpha = a;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setRed(int r) {
        red = r;
    }

    public int getRed() {
        return red;
    }

    public double getRedIntensity() {
        return red / 255.0;
    }

    public void setGreen(int g) {
        this.green = g;
    }

    public int getGreen() {
        return green;
    }

    public double getGreenIntensity() {
        return green / 255.0;
    }

    public void setBlue(int b) {
        this.blue = b;
    }

    public int getBlue() {
        return this.blue;
    }

    public double getBlueIntensity() {
        return blue / 255.0;
    }

    public int getARGB() {
        return (alpha << 24) + (red << 16) + (green << 8) + blue;
    }
}