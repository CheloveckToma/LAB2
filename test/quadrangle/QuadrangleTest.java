package quadrangle;

import static org.junit.Assert.*;

public class QuadrangleTest {
    Vector vectorOne;
    Vector vectorTwo;
    Vector vectorThree;
    Vector vectorFour;
    Quadrangle quadrangle;

    @org.junit.Test
    public void isSquare() throws ZeroCoordinateException {
        vectorOne = new Vector(1,1,1,2);
        vectorTwo = new Vector(1,2,2,2);
        vectorThree = new Vector(2,2,2,1);
        vectorFour =  new Vector(2,1,1,1);
        quadrangle = new Quadrangle(vectorOne,vectorTwo,vectorThree,vectorFour);
        assertTrue(quadrangle.isSquare(vectorOne,vectorTwo,vectorThree,vectorFour));
    }

    @org.junit.Test
    public void isRectangle() throws ZeroCoordinateException {
        vectorOne = new Vector(1,1,1,3);
        vectorTwo = new Vector(1,3,3,3);
        vectorThree = new Vector(3,3,3,1);
        vectorFour =  new Vector(3,1,1,1);
        quadrangle = new Quadrangle(vectorOne,vectorTwo,vectorThree,vectorFour);
        assertTrue(quadrangle.isRectangle(vectorOne,vectorTwo,vectorThree,vectorFour));
    }
}