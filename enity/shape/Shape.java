package enity.shape;

import enity.Material;

abstract public class Shape {
    public Material material;

    public void setMaterial(Material material) {
        this.material = material;
    }

    abstract public HitRec hit(Ray ray,double t0,double t1);

    abstract public Box boundingBox();

    abstract public Vector3 getUnitNormal(Point3 p);
}