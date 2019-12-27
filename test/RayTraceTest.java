package test;

import java.io.IOException;

import enity.ARGB;
import enity.Light;
import enity.Material;
import enity.shape.Point3;
import enity.shape.Sphere;
import enity.shape.Vector3;
import scene.Camera;
import scene.Scene;
import utils.ImageUtil;

public class RayTraceTest {
    public static void main(String[] args) throws IOException {
        Camera camera = new Camera(new Point3(0.0,0.0,150.0), 256, 256,
                        new Vector3(0,0,1),new Vector3(0,1,0),new Vector3(1,0,0));
        Light l1 = new Light(new Point3(0,0,0),new ARGB(255, 255, 255), 0.2);
        Light l2 = new Light(new Point3(0,-150,100), new ARGB(255,255,255), 0.8);
        Light l3 = new Light(new Point3(0,70,100), new ARGB(255,255,255), 0.6);
        Scene scene = new Scene(camera,l1);
        scene.addLight(l2);
        scene.addLight(l3);
        Sphere sphere = new Sphere(new Point3(0.0,70.0,0.0),50);
        Material material = new Material(new ARGB(255,255,255,255));
        sphere.setMaterial(material);
        scene.addShape(sphere);
        Sphere sphere2 = new Sphere(new Point3(0.0,-110.0,30.0),80);
        sphere2.setMaterial(new Material(new ARGB(255,255,255,255)));
        scene.addShape(sphere2);
        Sphere sphere3 = new Sphere(new Point3(0.0,0.0,0.0),15);
        sphere3.setMaterial(new Material(new ARGB(255,255,255)));
        scene.addShape(sphere3);
        ARGB[][] res = scene.takePhoto();
        ImageUtil img = new ImageUtil(res[0].length, res.length);
        img.setARGBData(res);
        img.write("trace13.png");
    }
}