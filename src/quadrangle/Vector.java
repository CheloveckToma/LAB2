package quadrangle;

public class Vector {

    private Point2D firstPoint;
    private Point2D secondPoint;
    private double[] vectorCoordinate;

    Vector(double x1, double y1, double x2, double y2) throws ZeroCoordinateException {
        firstPoint = new Point2D(x1, y1);
        secondPoint = new Point2D(x2, y2);
        isZeroCoordinate();
        getVectorСoordinate();

    }

    public boolean isZeroCoordinate() throws ZeroCoordinateException {
        if ((firstPoint.getX()!=0)||(firstPoint.getY()!=0)||(secondPoint.getX()!=0)||(secondPoint.getY()!=0)) {
            return true;
        }else {
            throw new ZeroCoordinateException("Координаты не могут быть равны нулю");
        }
    }

    public void setPoints(Point2D point1, Point2D point2) {
        this.firstPoint = point1;
        this.secondPoint = point2;
    }

    public double[] getVectorСoordinate() {
        vectorCoordinate = new double[]{secondPoint.getX()-firstPoint.getX() ,secondPoint.getY()- firstPoint.getY()};
        return vectorCoordinate;
    }

    public double getVectorLong() {
        return Math.sqrt(vectorCoordinate[0] * vectorCoordinate[0] + vectorCoordinate[1] * vectorCoordinate[1]);
    }

    public Point2D getPoint1(){
        return firstPoint;
    }

    public Point2D getPoint2(){
        return secondPoint;
    }

    public double getX1(){
        return firstPoint.getX();
    }

    public double getX2(){
        return secondPoint.getX();
    }

    public double getY1(){
        return firstPoint.getY();
    }

    public double getY2(){
        return secondPoint.getY();
    }


}
