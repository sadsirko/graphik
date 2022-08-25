package com.company.elements;

import com.company.elements.invisible.*;

public class Triangle implements GeometryObject{
    public Point firstAngle;
    public Point secondAngle;
    public Point thirdAngle;

    public Normal firstNormal;
    public Normal secondNormal;
    public Normal thirdNormal;



    public Normal normal;

    public Triangle(Point firstAngle, Point secondAngle, Point thirdAngle,Normal f,Normal s, Normal t) {
        this.firstAngle = firstAngle;
        this.secondAngle = secondAngle;
        this.thirdAngle = thirdAngle;
        this.firstNormal = f;
        this.secondNormal = s;
        this.thirdNormal = t;
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

    public Vector getNormalInPos(Point pos){
        double allArea = getPos(this.firstAngle, this.secondAngle, this.thirdAngle);
        double secondArea = getPos(secondAngle,firstAngle,pos);
        double thirdArea = getPos(firstAngle,thirdAngle,pos);
        double third = thirdArea / allArea;
        double second = secondArea / allArea;

        Vector res = this.secondNormal.multiply(third).add(this.thirdNormal.multiply(second).add(this.firstNormal.multiply(1 - third - second)));
        res.normalize();
        return res;
    };

    public double getPos(Point f, Point s, Point t){
      Vector firstV = new Vector(f,s);
      Vector secondV = new Vector(f,t);
      Vector r = firstV.cross(secondV);
      return r.getLength() / 2;
    };


    @Override
    public Double getLightningLevel(Point interPoint, Light light) {
        Vector normalTriangleUp = getNormalInPos(interPoint);
        normalTriangleUp.normalize();
        double lightLev = light.scalarProduct(normalTriangleUp);
        return lightLev;
    }
}
