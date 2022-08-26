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

        String input = null;
        String output = null;

        // arguments without space
        for (String a : args) {
            if (a.startsWith("--source=")) {
                input = a.split("=")[1];
            } else if (a.startsWith("--output")) {
                output = a.split("=")[1];
            }
        }


        ObjParse objParse = new ObjParse();
        ArrayList<Triangle> allTriangles = objParse.parseData( ObjParse.getData(input));

        allTriangles.add( new Triangle(new Point(0,-200,0),new Point(-200,1000,0),new Point(200,1200,40),
                        new Normal(1.0,0.0,0.0),new Normal(1.0,0.0,1.0),new Normal(1.0,1.0,1.0)));


        Matrix3D m1 = new Matrix3D();
        m1.move(0, 0, 0);
        m1.rotateY(275);
        m1.rotateX(230);
        m1.scale(400, 400, 400);

        for (Triangle tr : allTriangles) {
            tr.transform(m1);
        }

        GeometryObject[] obj = new GeometryObject[allTriangles.size()];
        for (int i = 0; i < allTriangles.size(); i++){
            obj[i] = allTriangles.get(i);
        }

        Scene scene = new Scene(obj,100,100, new Point(0.0,-200.0,0.0),
                2.0, 60.0, new Light(-3.0,-3.0,-3.0 ));



//        Scene scene = new Scene(obj,300,300, new Point(0.0,-30.0,0.0),
//                0.1, 60.0, new Light(0.0,1.0,2.0 ));
//        GeometryObject[] obj = {
//                new Triangle(new Point(20,5,20 ),new Point(20,5,0 ),new Point(0,5,0 ),
//                        new Normal(1.0,0.0,0.0),new Normal(1.0,0.0,1.0),new Normal(1.0,1.0,1.0)),
//
//                new Triangle(new Point(10,15,5 ),new Point(40,15,10 ),new Point(40,25,50 ),
//                        new Normal(1.0,0.0,0.0),new Normal(1.0,0.0,1.0),new Normal(1.0,1.0,1.0)),
//
//                new Sphere(new Point(40.0,11.0,40.0),10.0)
//        };
//
//        Scene scene = new Scene(obj,200,200, new Point(20.0,0.0,20.0),
//                0.1, 60.0, new Light(0.0,0.0,1.0 ));

        new PPMWriter().write(scene.getScreen(),output);


//        System.out.print(thirdTask.getPicture());
    }

}
