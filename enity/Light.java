package enity;

import enity.shape.Point3;

public class Light {
    public Point3 location;

    public ARGB color;

    /**
     * 光源强度，[0.0,1.0]
     */
    public double intensity;

    public Light(Point3 l,ARGB c,double intensity) {
        location = l;
        color = c;
        this.intensity = intensity;
    }

    public Light(Point3 l,ARGB c) {
        this(l,c,1.0);
    }
}