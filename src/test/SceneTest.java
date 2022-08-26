package test;

import com.company.elements.GeometryObject;
import com.company.elements.Plane;
import com.company.elements.Sphere;
import com.company.elements.Triangle;
import com.company.elements.invisible.Light;
import com.company.elements.invisible.Normal;
import com.company.elements.invisible.Point;
import com.company.equipment.Scene;
import org.junit.jupiter.api.Test;

public class SceneTest {

    @Test
    void intersectsWith() {
        GeometryObject[] obj = {
                new Triangle(new Point(20,5,20 ),new Point(20,5,0 ),new Point(0,5,0 ),
                        null, null, null),

                new Triangle(new Point(10,25,5 ),new Point(40,10,10 ),new Point(40,15,50 ),
                        null,null,null),

                new Sphere(new Point(40.0,11.0,40.0),10.0)
        };

        Scene thirdTask = new Scene(obj,20,20, new Point(20.0,0.0,20.0),
                1.0, 60.0, new Light(3.0,3.0,-3.0 ));

        System.out.print(thirdTask.getPicture());  // make tests
    }

    @Test
    void intersectsWithPlane() {
        GeometryObject[] obj = {
                new Plane(new Normal(0.0,-1.0,0.0),new Point(10,2,12))
        };

        Scene thirdTask = new Scene(obj,20,20, new Point(20.0,0.0,20.0),
                1.0, 60.0, new Light(3.0,3.0,-3.0 ));

        System.out.print(thirdTask.getPicture());  // make tests
    }

    //testproblem
    @Test
    void intersectsWithPlaneSphare() {
        GeometryObject[] obj = {
                new Plane(new Normal(0.0,-1.0,1.0),new Point(8,8,8)),
                new Sphere(new Point(40.0,11.0,40.0),10.0)
        };

        Scene thirdTask = new Scene(obj,200,200, new Point(20.0,0.0,20.0),
                0.1, 60.0, new Light(3.0,3.0,-3.0 ));

        System.out.print(thirdTask.getPicture());  // make tests
    }

    @Test
    void intersectsWithPlaneAngle() {
        GeometryObject[] obj = {
                new Plane(new Normal(0.0,1.0,-2.0),new Point(0,5,0))
        };

        Scene thirdTask = new Scene(obj,20,20, new Point(20.0,0.0,20.0),
                1.0, 60.0, new Light(3.0,3.0,-3.0 ));

        System.out.print(thirdTask.getPicture());  // make tests
    }

}
