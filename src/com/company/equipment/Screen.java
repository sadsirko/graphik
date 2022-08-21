package com.company.equipment;

import com.company.elements.Point;

public class Screen {
    Double width;
    Double height;
    Point highLeftCorner;


    public Screen(Double width, Double height, Point highLeftCorner) {
        this.width = width;
        this.height = height;
        this.highLeftCorner = highLeftCorner;
    }

}
