package com.company.elements.invisible;

public class Normal extends Vector{

    public Normal(Double x, Double y, Double z) {
        super(x, y, z);
        this.normalize();
    }

    public Normal(Point start, Point finish) {
        super(start,finish);
        this.normalize();
    }

}
