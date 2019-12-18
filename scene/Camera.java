package scene;

import enity.shape.Point3;
import enity.shape.Vector3;

public class Camera {
    public Point3 eye;
    public int width;
    public int height;
    public Vector3 ew;
    public Vector3 eu;
    public Vector3 ev;

    public Camera(Point3 e,int w,int h,Vector3 ew,Vector3 eu,Vector3 ev) {
        eye = e;
        width = w;
        height = h;
        this.ew = ew;
        this.eu = eu;
        this.ev = ev;
    }
}