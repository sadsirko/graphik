package com.company.elements.invisible;

public class Point  {
    Double x;
    Double y;
    Double z;

    public Point(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point(Integer x, Integer y, Integer z) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
    }
    
    public Point getPoint(Vector plus){
        return new Point(plus.getX() + this.getX(),
                plus.getY() + this.getY(),
                plus.getZ() + this.getZ());
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
