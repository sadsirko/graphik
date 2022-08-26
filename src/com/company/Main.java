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
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws IOException {

//
//        ObjParse objParse = new ObjParse();
//        ArrayList<Triangle> allTriangles = objParse.parseData( ObjParse.getData("cow.obj"));
////
//        Matrix3D m1 = new Matrix3D();
//        m1.move(0, 0, 0);
//        m1.rotateY(275);
//        m1.rotateX(230);
//        m1.scale(400, 400, 400);
//
//        for (Triangle tr : allTriangles) {
//            tr.transform(m1);
//        }
//
////        allTriangles.add(new Triangle(new Point(-200,-200,-200),new Point(-200,-200,-200),
////                new Point(300,200,100),new Normal(0.0,0.0,1.0),new Normal(0.0,0.0,1.0),
////                new Normal(0.0,0.0,1.0)));
//
//        GeometryObject[] obj = new GeometryObject[allTriangles.size()];
//        for (int i = 0; i < allTriangles.size(); i++){
//            obj[i] = allTriangles.get(i);
//        }

//        Scene scene = new Scene(obj,200,200, new Point(0.0,-200.0,0.0),
//                1.0, 60.0, new Light(-3.0,-3.0,-3.0 ));

        GeometryObject[] obj = {

            new Triangle(new Point(120,500,200),new Point(120,0,-100),new Point(120,0,100),
                    new Normal(1.0,0.0,0.0),new Normal(1.0,0.0,1.0),new Normal(1.0,1.0,1.0)),
            new Sphere(new Point(20,200,200),100.0)
        };

        Scene scene = new Scene(obj,300,300, new Point(0.0,-50.0,0.0),
                0.75, 60.0, new Light(3.0,3.0,3.0 ));

        new PPMWriter().write(scene.getScreen(),"file.ppm");


//        System.out.print(thirdTask.getPicture());
    }

}
