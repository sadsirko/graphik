package com.company.elements;

import com.company.elements.invisible.Light;
import com.company.elements.invisible.Point;
import com.company.elements.invisible.Ray;

public interface GeometryObject {
public boolean intersectWith(Ray ray);
public Point getIntersection(Ray ray);

public String toString();

public Double getLightningLevel(Point interPoint, Light light);

}


