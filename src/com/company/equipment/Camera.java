package com.company.equipment;

import com.company.elements.GeometryObject;
import com.company.elements.invisible.Light;
import com.company.elements.invisible.Point;
import com.company.elements.invisible.Ray;
import com.company.elements.invisible.Vector;

public class Camera {
private Screen screen;
private Double angle;
private Point position;
private Vector screenNormal;
private Light light;

    public Camera(Screen screen, Double angle, Light light) {
        this.angle = angle;
        this.position = new Point(screen.center.getX(),screen.center.getY() -
                Math.tan(Math.toRadians(angle/2))*screen.getHeight()/2, screen.center.getZ());
        this.screen = screen;
        this.screenNormal = new Vector(screen.getCenter(),this.position);
        this.screenNormal.normalize();
        this.light = light;
    }

    public void getStartRay(GeometryObject[] objects){

        Ray[] rays;
        Pixel[][] pixels = this.screen.pixelMatrix;
        for (Pixel[] pixelArr:pixels)
        {
            for (Pixel pixel:pixelArr){
                Vector k = new Vector(position,pixel.getPixelCenter());
                k.normalize();
                Ray r = new Ray(this.position,k);
                for (GeometryObject object:objects){
                    if(object.intersectWith(r))
                        System.out.print("#");
                    else System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    public void getConstantLightRay(GeometryObject[] objects){
        Ray[] rays;
        Pixel[][] pixels = this.screen.pixelMatrix;
        for (Pixel[] pixelArr:pixels)
        {
            for (Pixel pixel:pixelArr){
                Vector k = new Vector(position,pixel.getPixelCenter());
                k.normalize();
                Double lightLevel = 0.0;
                Ray r = new Ray(this.position,k);
                for (GeometryObject object:objects){
                    Point interPoint = object.getIntersection(r);
                    if(interPoint != null) {
                        lightLevel = object.getLightningLevel(interPoint,this.light);
                        if (lightLevel < 0)
                        System.out.print(" ");
                        if (lightLevel >= 0 && lightLevel < 0.2)
                            System.out.print(".");
                        if (lightLevel >= 0.2 && lightLevel < 0.5)
                            System.out.print("*");
                        if (lightLevel >= 0.5 && lightLevel < 0.8)
                            System.out.print("0");
                        if (lightLevel >= 0.8)
                            System.out.print("#");
                    }
                    else System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }


    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
