package com.company.elements;

public class Vector {
    Point start;
    Point finish;
    Double x;
    Double y;
    Double z;
    Double length;
    boolean isPositioned;

    public Vector(Point start, Point finish) {
        this.start = start;
        this.finish = finish;
        this.x = finish.getX() - start.getX();
        this.y = finish.getY() - start.getY();
        this.z = finish.getZ() - start.getZ();
        this.isPositioned = true;
    }

    public Vector(Double x, Double y, Double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.isPositioned = false;
    }

    public Double getLength(){
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.x,2) + Math.pow(this.x,2));
    }

    public Double scalarProduct(Vector second){
        return this.getX()*second.getX() + this.getY()*second.getY() + this.getZ()*second.getZ();
    }

    public Vector multiply(Double mul){
        return new Vector(this.x * mul,this.y * mul, this.z * mul);
    }

    public Vector add(Vector added){
        return new Vector(this.x + added.getX(),this.y + added.getY(),this.z + added.getZ()) ;
    }

    public Vector subtract(Vector subtractor){
        return new Vector(this.x + subtractor.getX(),this.y - subtractor.getY(),this.z - subtractor.getZ());
    }

    public double getAngle(Vector b){
        return Math.acos(scalarProduct(b)/this.getLength()*b.getLength());
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

}
