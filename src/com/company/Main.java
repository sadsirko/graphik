package com.company;

import com.company.elements.GeometryObject;
import com.company.elements.Triangle;
import com.company.elements.invisible.Light;
import com.company.elements.invisible.Point;
import com.company.equipment.Scene;

public class Main {

    public static void main(String[] args) {
        GeometryObject [] obj = {
                new Triangle(new Point(20,5,20 ),new Point(20,5,0 ),new Point(0,5,0 )),
                new Triangle(new Point(10,25,5 ),new Point(40,10,10 ),new Point(40,15,50 )),
        };

        Scene thirdTask = new Scene(obj,20,20, new Point(20.0,0.0,20.0),
                1.0, 60.0, new Light(3.0,3.0,-3.0 ));

        System.out.print(thirdTask.getPicture());
    }

}
