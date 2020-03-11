package quadrangle;

import quadrangle.Quadrangle;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            double firstPointCoordinateX  = sc.nextDouble();
            double firstPointCoordinateY  = sc.nextDouble();

            double secondPointCoordinateX = sc.nextDouble();
            double secondPointCoordinateY = sc.nextDouble();

            double thirdPointCoordinateY  = sc.nextDouble();
            double thirdPointCoordinateX  = sc.nextDouble();

            double fourthPointCoordinateX = sc.nextDouble();
            double fourthPointCoordinateY = sc.nextDouble();

            Vector vectorOne     = new Vector(firstPointCoordinateX, firstPointCoordinateY, secondPointCoordinateX, secondPointCoordinateY);
            Vector vectorTwo       = new Vector(secondPointCoordinateX, secondPointCoordinateY, thirdPointCoordinateX, thirdPointCoordinateY);
            Vector vectorThree = new Vector(thirdPointCoordinateX, thirdPointCoordinateY, fourthPointCoordinateX, firstPointCoordinateY);
            Vector vectorFour    = new Vector(fourthPointCoordinateX, fourthPointCoordinateY, firstPointCoordinateX, firstPointCoordinateY);

            Quadrangle quadrangle = new Quadrangle(vectorOne, vectorTwo, vectorThree, vectorFour);
            quadrangle.definition();

        } catch (ZeroCoordinateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
