package com.company.elements;

public class Sphare {
    Point center;
    Double radius;

    public Sphare(Point center, Double radius) {
        this.center = center;
        this.radius = radius;
    }

    public boolean IntersectWith(Ray ray,Double tMin, Double tMax){
        Point o = ray.getOrigin();
        Point c = this.center;
        Vector k = new Vector(o,c);
        Vector d = ray.getDirection();

        Double d2 = d.getLength();
        Double r2 = this.radius * this.radius;
        Double k2 = k.getLength();

        Double a = d2;
        Double b = 2 * d.scalarProduct(k);
        Double cc = k2 - r2;

        double D = b * b - 4 * a * cc;


        return D >= 0;
    }


}
