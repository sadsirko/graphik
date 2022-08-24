package com.company.elements;

import com.company.elements.invisible.Light;
import com.company.elements.invisible.Normal;
import com.company.elements.invisible.Point;
import com.company.elements.invisible.Ray;

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
    public Point getIntersection(Ray ray) {
        return null;
    }
    @Override
    public Double getLightningLevel(Point interPoint, Light light) {
        return null;
    }
}
