package com.company.elements;

import com.company.elements.invisible.Light;
import com.company.elements.invisible.Point;
import com.company.elements.invisible.Ray;

public interface GeometryObject {
    public boolean intersectWith(Ray ray);

    public String toString();

    Point getIntersection(Ray ray, double tMin, double tMax);

    public Double getLightningLevel(Point interPoint, Light light);

}


