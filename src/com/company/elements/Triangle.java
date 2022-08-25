package com.company.elements;

import com.company.elements.invisible.*;

public class Triangle implements GeometryObject{
    public Point firstAngle;
    public Point secondAngle;
    public Point thirdAngle;

    public Normal normal;

    public Triangle(Point firstAngle, Point secondAngle, Point thirdAngle) {
        this.firstAngle = firstAngle;
        this.secondAngle = secondAngle;
        this.thirdAngle = thirdAngle;
    }


    @Override
    public boolean intersectWith(Ray ray) {
        double epsilon = 0.0000001;
        Vector edge1 = new Vector(this.firstAngle,this.secondAngle);
        Vector edge2 = new Vector(this.firstAngle,this.thirdAngle);

        Vector h = ray.getDirection().cross(edge2);

        double a = edge1.scalarProduct(h);

        if (a > -epsilon && a < epsilon ) {
            return false;
        }

        double f = 1/a;

        Vector s = new Vector(this.firstAngle,ray.getOrigin());
        double u = f * ( s.scalarProduct(h));
        if(u < 0.0 || u > 1.0){
            return false;
        }

        Vector q = s.cross(edge1);
        double v = f * ray.getDirection().scalarProduct(q);
        if(v < 0.0 || v + u > 1.0) {
            return false;
        }
        double t = f * edge2.scalarProduct(q);

        if (t > epsilon)
        {
            return true;
        }

        else {
            return false;
        }
    }

    @Override
    public Point getIntersection(Ray ray, double tMin, double tMax) {
        double epsilon = 0.000001;
        Vector edge1 = new Vector(this.firstAngle,this.secondAngle);
        Vector edge2 = new Vector(this.firstAngle,this.thirdAngle);

        Vector h = ray.getDirection().cross(edge2);

        double a = edge1.scalarProduct(h);

        if (a < epsilon && a > - epsilon) {
            return null;
        }

        double f = 1/a;

        Vector s = new Vector(this.firstAngle,ray.getOrigin());
        double u = f * s.scalarProduct(h);
        if(u < 0.0 || u > 1.0){
            return null;
        }

        Vector q = s.cross(edge1);
        double v = f * ray.getDirection().scalarProduct(q);
        if(v < 0.0 || v + u > 1.0) {
            return null;
        }
        double t = f * edge2.scalarProduct(q);
        if (t > epsilon)
        {
            return ray.getDirection().multiply(t).addToPoint(ray.getOrigin());
        }

        else {
            return null;
        }
    }

    public Normal getNormalUp(){
        Vector edge1 = new Vector(this.firstAngle,this.thirdAngle);
        Vector edge2 = new Vector(this.firstAngle,this.secondAngle);
        Vector normal = edge1.cross(edge2);
        return new Normal(normal.getX(),normal.getY(),normal.getZ());
    }

    public Normal getNormalDown(){
        Vector edge1 = new Vector(this.firstAngle,this.thirdAngle);
        Vector edge2 = new Vector(this.firstAngle,this.secondAngle);
        Vector normal = edge2.cross(edge1);
        return new Normal(normal.getX(),normal.getY(),normal.getZ());
    }

    @Override
    public Double getLightningLevel(Point interPoint, Light light) {
        Normal normalTriangleUp = getNormalDown();
        Normal normalTriangleDown = getNormalUp();
        double up = light.scalarProduct(normalTriangleUp);
        double down = light.scalarProduct(normalTriangleDown);
        return Math.max(up, down);
    }
}
