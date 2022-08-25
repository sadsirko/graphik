package com.company.elements;

import com.company.elements.invisible.*;

public class Sphere implements GeometryObject{
    Point center;
    Double radius;

    public Sphere(Point center, Double radius) {
        this.center = center;
        this.radius = radius;
    }

    public boolean intersectWith(Ray ray){
        Point o = ray.getOrigin();
        Point c = this.center;
        Vector k = new Vector(c,o);
        Vector d = ray.getDirection();

        Double d2 = d.scalarProduct(d);
        Double r2 = this.radius * this.radius;
        Double k2 = k.scalarProduct(k);

        Double a = d2;
        Double b = 2 * d.scalarProduct(k);
        Double cc = k2 - r2;

        double D = b * b - 4 * a * cc;
        return (D >= 0);
    }

    public Point getIntersection(Ray ray, double tMin, double tMax){
        Point o = ray.getOrigin();
        Point c = this.center;
        Vector k = new Vector(c,o);
        Vector d = ray.getDirection();

        Double d2 = d.scalarProduct(d);
        Double r2 = this.radius * this.radius;
        Double k2 = k.scalarProduct(k);

        Double a = d2;
        Double b = 2 * d.scalarProduct(k);
        Double cc = k2 - r2;

        double D = b * b - 4 * a * cc;
        if (D >= 0){
            double x1 = (-b + Math.sqrt(D))/(2*a);
            return d.multiply(x1).addToPoint(o);
        }
        return null;
    }

    public Double getLightningLevel(Point interPoint, Light light){
        Normal normalSphere = new Normal(this.center,interPoint);
        return light.scalarProduct(normalSphere);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Sphare{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
