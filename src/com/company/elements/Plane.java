package com.company.elements;

public class Plane {
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
}
