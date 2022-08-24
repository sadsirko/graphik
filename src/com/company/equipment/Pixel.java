package com.company.equipment;
import com.company.elements.invisible.Point;

public class Pixel {
    Integer matrixPositionX;
    Integer matrixPositionY;
    Point pixelCenter;
    Integer[] Colour;
    Screen screen;
    boolean intersection;

    public Pixel(Integer matrixPositionX, Integer matrixPositionY, Screen screen) {
        this.matrixPositionX = matrixPositionX;
        this.matrixPositionY = matrixPositionY;
        this.screen = screen;
        this.pixelCenter = new Point(screen.highLeftCorner.getX() + screen.pixelSize * matrixPositionX +
                screen.pixelSize/2, screen.highLeftCorner.getY(), screen.getHighLeftCorner().getZ() -
                screen.pixelSize * matrixPositionY + screen.pixelSize / 2);
    }

    public Point getPixelCenter() {
        return pixelCenter;
    }

    public boolean isIntersection() {
        return intersection;
    }

    public void setIntersection(boolean intersection) {
        this.intersection = intersection;
    }

    public Integer getMatrixPositionX() {
        return matrixPositionX;
    }

    public void setMatrixPositionX(Integer matrixPositionX) {
        this.matrixPositionX = matrixPositionX;
    }

    public Integer getMatrixPositionY() {
        return matrixPositionY;
    }

    public void setMatrixPositionY(Integer matrixPositionY) {
        this.matrixPositionY = matrixPositionY;
    }

    @Override
    public String toString() {
        return "Pixel{" +
                "matrixPositionX=" + matrixPositionX +
                ", matrixPositionY=" + matrixPositionY +
                ", pixelCenter=" + pixelCenter.toString() +
                '}';
    }
}
