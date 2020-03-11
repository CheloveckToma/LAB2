package quadrangle;

public class Quadrangle {

    Vector vectorOne;
    Vector vectorTwo;
    Vector vectorThree;
    Vector vectorFour;
    double cos;

    public Quadrangle(Vector vectorOne, Vector vectorTwo, Vector vectorThree, Vector vectorFour)  {
        this.vectorOne = vectorOne;
        this.vectorTwo = vectorTwo;
        this.vectorThree = vectorThree;
        this.vectorFour = vectorFour;

    }

    public void definition() throws ZeroCoordinateException {
        if (isRectangle(vectorOne, vectorTwo, vectorThree, vectorFour)){
            System.out.println("Это прямоугольник?");
        }
        if (isSquare(vectorOne, vectorTwo,vectorThree,vectorFour)){
            System.out.println("Это квадрат?");
        }
        if(isParallelogram(vectorOne, vectorThree)){
            System.out.println("Это параллелограмм");
        }
        if(isTrapeze(vectorOne, vectorThree)){
            System.out.println("Это трапеция?");
        }
    }

    public boolean isSquare(Vector vectorOne, Vector vectorTwo, Vector vectorThree, Vector vectorFour) {
        if ((vectorOne.getVectorLong() == vectorTwo.getVectorLong()) &&
                (vectorOne.getVectorLong() == vectorThree.getVectorLong()) && (vectorOne.getVectorLong() == vectorFour.getVectorLong())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRectangle(Vector vectorOne, Vector vectorTwo, Vector vectorThree, Vector vectorFour) {
        if ((vectorOne.getVectorLong() == vectorThree.getVectorLong()) && (vectorTwo.getVectorLong() == vectorFour.getVectorLong())&& (isCosZero(vectorOne, vectorTwo) == true)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isParallelogram(Vector vectorOne, Vector vectorThree) {
        if ((((vectorOne.getVectorLong() == vectorTwo.getVectorLong()) && (vectorThree.getVectorLong() == vectorFour.getVectorLong())
                && (vectorOne.getVectorLong() != vectorThree.getVectorLong())) ||
                ((vectorOne.getVectorLong() == vectorThree.getVectorLong()) && (vectorTwo.getVectorLong() == vectorFour.getVectorLong())
                        && (vectorOne.getVectorLong() != vectorTwo.getVectorLong())) ||
                ((vectorOne.getVectorLong() == vectorFour.getVectorLong()) && (vectorTwo.getVectorLong() == vectorThree.getVectorLong()))
                        && (vectorOne.getVectorLong() != vectorThree.getVectorLong())) && (isCosZero(vectorOne, vectorTwo) == false)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTrapeze(Vector vectorOne, Vector vectorThree) throws ZeroCoordinateException {
        Vector middleLine = new Vector((vectorOne.getX1() + vectorOne.getX2()) / 2, (vectorOne.getY1() + vectorOne.getY2()) / 2, (vectorThree.getX1() + vectorThree.getX2()) / 2, (vectorThree.getY1() + vectorThree.getY2()) / 2);
        if ((middleLine.getVectorLong() == ((vectorTwo.getVectorLong() + vectorFour.getVectorLong()) / 2)) && !isCosZero(vectorOne, vectorThree)) {

            return true;
        } else {
            return false;
        }
    }

    public boolean isCosZero(Vector vectorOne, Vector vectorTwo) {
        double[] firstVectorСoordinate = vectorOne.getVectorСoordinate();
        double[] secondVectorCoordinate = vectorTwo.getVectorСoordinate();
        cos = ((firstVectorСoordinate[0] * secondVectorCoordinate[0] + firstVectorСoordinate[1] * secondVectorCoordinate[1])
                / (Math.sqrt(firstVectorСoordinate[0] * firstVectorСoordinate[0] + firstVectorСoordinate[1] * firstVectorСoordinate[1]) *
                Math.sqrt(secondVectorCoordinate[0] * secondVectorCoordinate[0] + secondVectorCoordinate[1] * secondVectorCoordinate[1])));
        if (cos == 0) {
            return true;
        } else {
            return false;
        }

    }
}
