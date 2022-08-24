package com.company.elements.invisible;

public class Light extends Vector{

    public Light(Double x, Double y, Double z) {
        super(x, y, z);
        this.normalize();
    }

}
