package com.company.equipment;

import com.company.elements.GeometryObject;
import com.company.elements.invisible.Light;
import com.company.elements.invisible.Point;

public class Scene {
    public Screen screen;
    public Camera camera;
    public GeometryObject[] objects;
    public Scene(GeometryObject[] objects, Integer resolutionX, Integer resolutionY, Point screenCenter,
                 Double pixelSize, Double angle , Light light) {
        this.screen = new Screen(resolutionX,resolutionY, screenCenter, pixelSize );
        this.camera = new Camera(this.screen,angle,light);
        this.objects = objects;
//        this.camera.getStartRay(objects);
        this.camera.getConstantLightRay(objects);
    }


    }
