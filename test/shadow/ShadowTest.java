package shadow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShadowTest {
    @Test
    public void shadowLengthCount() {
        Vector vector1 = new Vector(new Point2D(5, 6), new Point2D(5, 10));
        Vector vector2 = new Vector(new Point2D(6, 9), new Point2D(10, 10));
        Vector vector3 = new Vector(new Point2D(15, 10), new Point2D(17, 10));
        Vector vector4 = new Vector(new Point2D(8, 9), new Point2D(13, 9));
        Vector vector5 = new Vector(new Point2D(7, 7), new Point2D(15, 7));
        Vector vector6 = new Vector(new Point2D(15, 8), new Point2D(22, 8));

        List<Vector> vectors = new ArrayList<>();
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        vectors.add(vector6);

        Shadow sizeShadow = new Shadow();
        double result = sizeShadow.findShadowLenght(vectors);

        assertEquals(21, result, 1);
    }

    @Test
    public void segmentMergeCheck() {
        Vector vector1 = new Vector(new Point2D(5, 9), new Point2D(10, 10));
        Vector vector2 = new Vector(new Point2D(8, 8), new Point2D(13, 8));

        Shadow sizeShadow = new Shadow();
        assertTrue(sizeShadow.isMerge(vector1, vector2));
    }

    @Test
    public void deletionCheck() {
        Vector vector1 = new Vector(new Point2D(5, 9), new Point2D(10, 9));
        Vector vector2 = new Vector(new Point2D(6, 10), new Point2D(7, 10));

        Shadow sizeShadow = new Shadow();
        assertTrue(sizeShadow.isRemoveVector(vector1, vector2));
    }
}