package com.company.elements.invisible;

public class Light extends Vector{

    public Light(Double x, Double y, Double z) {
        super(x, y, z);
        this.normalize();
    }

    @Override
    public Light multiply(Double mul) {
        Vector res = super.multiply(mul);
        res.normalize();
        return new Light(res.getX(), res.getY(), res.getZ());
    }
}
