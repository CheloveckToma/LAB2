package shadow;

import java.util.List;



public class Shadow {

    public double findShadow(List<Vector> vectors) {

        for (int i = 0; i < vectors.size(); i++) {
            for (int j = 0; j < vectors.size(); j++) {
                if (isMerge(vectors.get(i), vectors.get(j))) {
                    mergeVectors(vectors.get(i), vectors.get(j));
                    removeSnippet(vectors.get(j), vectors);
                }

                if (isRemoveVector(vectors.get(i), vectors.get(j))) {
                    removeSnippet(vectors.get(j), vectors);
                }
            }
        }

        double sizeShadow = 0;

        for (Vector snippet : vectors) {
            sizeShadow += snippet.calcLength();
        }

        return sizeShadow;
    }

    public boolean isMerge(Vector vector1, Vector vector2) {
        return (vector1.getPoint1().x < vector2.getPoint1().x && vector2.getPoint1().x < vector1.getPoint2().x) ||
                (vector1.getPoint1().x < vector2.getPoint2().x && vector2.getPoint2().x < vector1.getPoint2().x);
    }

    public boolean isRemoveVector(Vector vector1, Vector vector2) {
        return (vector1.getPoint1().x < vector2.getPoint1().x && vector2.getPoint1().x < vector1.getPoint2().x) &&
                (vector1.getPoint1().x < vector2.getPoint2().x && vector2.getPoint2().x < vector1.getPoint2().x);
    }

    public void mergeVectors(Vector vector1, Vector vector2) {
        double maxPoint = vector1.getPoint1().x;
        double minPoint = vector1.getPoint1().x;

        double[] xPoints = {vector1.getPoint1().x, vector1.getPoint2().x, vector2.getPoint1().x, vector2.getPoint2().x};

        for (double xPoint : xPoints) {
            if (maxPoint < xPoint)
                maxPoint = xPoint;

            if (minPoint > xPoint)
                minPoint = xPoint;
        }

        Point2D point1 = new Point2D(minPoint, vector1.getPoint1().y);
        Point2D point2 = new Point2D(maxPoint, vector1.getPoint2().y);

        vector1.setPoints(point1, point2);
    }

    public void removeSnippet(Vector vector, List<Vector> vectors) {
        vectors.remove(vector);
    }
}
