package scene;

import java.util.ArrayList;
import java.util.List;

import enity.ARGB;
import enity.Light;
import enity.shape.HitRec;
import enity.shape.Point3;
import enity.shape.Ray;
import enity.shape.Shape;
import enity.shape.Vector3;

public class Scene {
    public List<Shape> objects;
    public List<Light> lights;
    public Camera camera;
    public Light ambient;

    public Scene(Camera camera,Light light) {
        objects = new ArrayList<>();
        lights = new ArrayList<>();
        this.camera = camera;
        ambient = light;
    }

    public void addShape(Shape shape) {
        objects.add(shape);
    }

    public void addLight(Light light) {
        lights.add(light);
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public ARGB[][] takePhoto() {
        ARGB[][] colors = new ARGB[camera.height][camera.width];
        for (int h = 0;h < camera.height;h++) {
            for (int w = 0;w < camera.width;w++) {
                double u = -128 + 255 * (w + 0.5) / 256;
                double v = -128 + 255 * (h + 0.5) / 256;
                Point3 t = new Point3(camera.eye.x + u * camera.eu.x + v * camera.ev.x,
                                      camera.eye.y + u * camera.eu.y + v * camera.ev.y,
                                      camera.eye.z + u * camera.eu.z + v * camera.ev.z);
                Ray ray = new Ray(t,camera.ew.numProduct(-1));
                double t0 = 0, t1 = 255.0;// temp
                colors[h][w] = rayColor(ray, t0, t1);  
            }
        }
        return colors;
    }

    private ARGB rayColor(Ray ray,double t0,double t1) {
        HitRec rec = hit(ray, t0, t1);
        double red = ambient.color.getRedIntensity() * ambient.intensity;
        double green = ambient.color.getGreenIntensity() * ambient.intensity;
        double blue = ambient.color.getBlueIntensity() * ambient.intensity;
        if (rec.isHit) {
            Point3 inter = ray.getPointByParam(rec.tmin);
            Vector3 un = rec.shape.getUnitNormal(inter);                   
            ARGB kd = rec.shape.material.color;
            red += kd.getRedIntensity() * ambient.intensity;
            blue += kd.getBlueIntensity() * ambient .intensity;
            green += kd.getGreenIntensity() * ambient.intensity;
            for (Light light : lights) {
                Vector3 lv = new Vector3(inter,light.location);
                HitRec srec = hit(new Ray(inter,lv), 0.0001, 1.0);
                if (!srec.isHit) {
                    Vector3 hn = lv.add(ray.direction.numProduct(-1)).unitlize();
                    red += kd.getRedIntensity() *light.intensity * un.dotProduct(lv.unitlize()) +
                        light.color.getRedIntensity() *light.intensity * Math.pow(Math.max(0,un.dotProduct(hn)), 1000);
                    green += kd.getGreenIntensity() *light.intensity * un.dotProduct(lv.unitlize()) +
                        light.color.getGreenIntensity() *light.intensity * Math.pow(Math.max(0,un.dotProduct(hn)), 1000);
                    blue += kd.getBlueIntensity() *light.intensity * un.dotProduct(lv.unitlize()) +
                        light.color.getBlueIntensity() *light.intensity * Math.pow(Math.max(0,un.dotProduct(hn)), 1000);
                }
            }
            return new ARGB(red, green, blue);
        } else {
            return new ARGB(ARGB.WHITE.getRedIntensity() * ambient.intensity,
                            ARGB.WHITE.getGreenIntensity()*ambient.intensity,
                            ARGB.WHITE.getBlueIntensity() * ambient.intensity);
        }
    }

    private HitRec hit(Ray ray,double t0,double t1) {
        HitRec rec = new HitRec(false, t0, t1, 0, null);
        for (Shape shape : objects) {
            HitRec rec2 = shape.hit(ray, t0, t1);
            if (rec2.isHit && rec.tmax > rec2.tmax) {
                rec = rec2;
            }
        }
        return rec;
    }
}