package com.company.equipment;

import com.company.elements.invisible.Point;

public class Screen {

    Double width;
    Double height;
    Point center;
    Point highLeftCorner;
    Point highRightCorner;
    Point bottomLeftCorner;
    Double pixelSize;
    Integer resolutionX;
    Integer resolutionY;
    Pixel[][] pixelMatrix;

    public Screen(Integer resolutionX, Integer resolutionY, Point center, Double pixelSize) {

        this.center = center;
        this.pixelSize = pixelSize;
        this.resolutionX = resolutionX ;
        this.resolutionY = resolutionY ;
        this.width = pixelSize * resolutionX;
        this.height = pixelSize * resolutionY;
        this.highLeftCorner = new Point(-this.width / 2 + center.getX(), center.getY(), this.height / 2 + center.getZ());
        this.highRightCorner = new Point(this.width / 2 + center.getX(), center.getY(), this.height / 2 + center.getZ());
        this.bottomLeftCorner = new Point(-this.width / 2 + center.getX(), center.getY(), -this.height / 2 + center.getZ());
        this.pixelMatrix = new Pixel[resolutionY][resolutionX];

        for (int i = 0; i < resolutionX; i++){
            pixelMatrix[i] = new Pixel[resolutionX];
            for (int j = 0; j < resolutionY; j++)
            {

                pixelMatrix[i][j]=new Pixel(i,j,this);
            }
        }
    }

    public Pixel[][] getPixelMatrix() {
        return pixelMatrix;
    }

    public Point getHighLeftCorner() {
        return highLeftCorner;
    }

    public void setHighLeftCorner(Point highLeftCorner) {
        this.highLeftCorner = highLeftCorner;
    }

    public Point getHighRightCorner() {
        return highRightCorner;
    }

    public void setHighRightCorner(Point highRightCorner) {
        this.highRightCorner = highRightCorner;
    }

    public Point getBottomLeftCorner() {
        return bottomLeftCorner;
    }

    public void setBottomLeftCorner(Point bottomLeftCorner) {
        this.bottomLeftCorner = bottomLeftCorner;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public Point getCenter() {
        return center;
    }

}
