package test;

import com.company.elements.Triangle;
import com.company.elements.invisible.Point;
import com.company.elements.invisible.Ray;
import com.company.elements.invisible.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private final Triangle triangle= new Triangle(new Point(0, 0, 0), new Point(0, 15, 0)
            , new Point(0, 0, 15));
    @Test
    void intersectsWith() {
        Vector a = new Vector(-1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5, 0, 0), a);

        assertTrue(triangle.intersectWith(ray1));
    }
    @Test
    void intersectsWithY() {
        Vector a = new Vector(-1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5, -1, 1), a);

        assertFalse(triangle.intersectWith(ray1));
    }

    @Test
    void intersectsWithX() {
        Vector a = new Vector(-1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(-5, 1, 0), a);

        assertFalse(triangle.intersectWith(ray1));
    }

    @Test
    void intersectsWithZ() {
        Vector a = new Vector(-1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5, 0, -5), a);

        assertFalse(triangle.intersectWith(ray1));
    }

    @Test
    void noIntersectsWith() {
        Vector a = new Vector(1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5, 0, 0), a);
        assertFalse(triangle.intersectWith(ray1));
    }
    @Test
    void IntersectsWith() {
        Vector a = new Vector(-1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5, 15, 0), a);
        assertTrue(triangle.intersectWith(ray1));
    }
    @Test
    void notIntersectsWith() {
        Vector a = new Vector(-1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5.0, 15.1, 0.0), a);
        assertFalse(triangle.intersectWith(ray1));
    }
    @Test
    void intersectsWithRes() {
        Vector a = new Vector(-1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5, 0, 0), a);
        System.out.print(triangle.getIntersection(ray1,0,10000).toString());
        assertNotNull(triangle.getIntersection(ray1,0,10000));
    }
    @Test
    void noIntersectsWithRes() {
        Vector a = new Vector(1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5, 0, 0), a);

        assertNull(triangle.getIntersection(ray1,0,10000));
    }
    @Test
    void IntersectsWithRes() {
        Vector a = new Vector(-1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5, 15, 0), a);

        System.out.print(triangle.getIntersection(ray1,0,10000).toString());
        assertNotNull(triangle.getIntersection(ray1,0,10000));
    }
    @Test
    void notIntersectsWithRes() {
        Vector a = new Vector(-1, 0, 0);
        a.normalize();
        Ray ray1 = new Ray(new Point(5.0, 15.1, 0.0), a);
        assertNull(triangle.getIntersection(ray1,0,10000));
    }

    @Test
    void notIntersectsParallel() {
        Vector a = new Vector(0, -1, -1);
        a.normalize();
        Ray ray1 = new Ray(new Point(5.0, 0.0, 0.0), a);
        assertNull(triangle.getIntersection(ray1,0,10000));
    }
}