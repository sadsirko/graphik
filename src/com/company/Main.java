package com.company;

import com.company.elements.GeometryObject;
import com.company.elements.Sphere;
import com.company.elements.Triangle;
import com.company.elements.invisible.Light;
import com.company.elements.invisible.Normal;
import com.company.elements.invisible.Point;
import com.company.equipment.Scene;
import data.ObjParse;
import data.PPMWriter;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        ObjParse objParse = new ObjParse();


        GeometryObject[] obj = {

//            new Triangle(new Point(20,250,20),new Point(20,250,20),new Point(20,250,20),
//                    new Normal())
            new Sphere(new Point(20,250,20),200.0)
        };

        Scene scene = new Scene(obj,300,300, new Point(20.0,0.0,20.0),
                1.0, 60.0, new Light(3.0,3.0,-3.0 ));

        new PPMWriter().write(scene.getScreen(),"file.txt");

//        System.out.print(thirdTask.getPicture());
    }

}
