package com.company.elements;

import com.company.elements.invisible.*;

public class Plane implements GeometryObject{
    Normal normal;
    Point point;

    public Plane(Normal normal, Point point) {
        this.normal = normal;
        this.point = point;
    }

    public Normal getNormal() {
        return normal;
    }

    public void setNormal(Normal normal) {
        this.normal = normal;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public boolean intersectWith(Ray ray) {

        return false;
    }

    @Override
    public Point getIntersection(Ray ray, double tMin, double tMax) {
        Point o = ray.getOrigin();
        Point c = this.getPoint();
        Vector k = new Vector(c,o);
        Vector d = ray.getDirection();
        Normal n = this.getNormal();
        double z = d.scalarProduct(n);

        if (z == 0) {
            return null;
        }

        double t = k.scalarProduct(n) / z;
        return d.multiply(t).addToPoint(o);
    }

    @Override
    public Double getLightningLevel(Point interPoint, Light light) {
        return light.scalarProduct(this.getNormal());
    }
}
