package com.company;

import com.company.elements.GeometryObject;
import com.company.elements.Sphere;
import com.company.elements.invisible.Light;
import com.company.elements.invisible.Point;
import com.company.equipment.Scene;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GeometryObject [] obj = {new Sphere(new Point(10.0,10.0,10.0),10.0)};
        Scene thirdTask = new Scene(obj,30,30, new Point(20.0,0.0,20.0),
                1.0, 60.0, new Light(3.0,3.0,-3.0 ));

    }

}
