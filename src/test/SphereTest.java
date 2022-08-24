package test;

import com.company.elements.Sphere;
import com.company.elements.invisible.Point;
import com.company.elements.invisible.Ray;
import com.company.elements.invisible.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SphereTest {

    private final Sphere sphere = new Sphere(new Point(0, 0, 0), 5.0);

    @Test
    void intersectsWith() {
        Vector a = new Vector(2, 3, 2);
        a.normalize();
        Ray ray = new Ray( new Point(-10, -3, -5),a);
        assertFalse(sphere.intersectWith(ray));
    }

    @Test
    void notIntersectsWith() {

        Vector a = new Vector(2, 3, 2);
        a.normalize();
        Ray ray = new Ray( new Point(-5, -3, -5),a);
        assertTrue(sphere.intersectWith(ray));
    }

    @Test
    void IntersectsInside() {
        Vector a = new Vector(2, 3, 2);
        a.normalize();
        Ray ray = new Ray( new Point(0,0,0),a);
        assertTrue(sphere.intersectWith(ray));
    }

}