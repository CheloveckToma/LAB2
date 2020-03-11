package shadow;

import java.util.List;



public class Shadow {
    public double calcShadow(List<Vector> snippets) {

        for (int i = 0; i < snippets.size(); i++) {
            for (int j = 0; j < snippets.size(); j++) {
                if (isMerge(snippets.get(i), snippets.get(j))) {
                    merge(snippets.get(i), snippets.get(j));
                    removeSnippet(snippets.get(j), snippets);
                }

                if (isRemoveSnippet(snippets.get(i), snippets.get(j))) {
                    removeSnippet(snippets.get(j), snippets);
                }
            }
        }

        double sizeShadow = 0;

        for (Vector snippet : snippets) {
            sizeShadow += snippet.calcLength();
        }

        return sizeShadow;
    }

    public boolean isMerge(Vector snippet1, Vector snippet2) {
        return (snippet1.getPoint1().x < snippet2.getPoint1().x && snippet2.getPoint1().x < snippet1.getPoint2().x) ||
                (snippet1.getPoint1().x < snippet2.getPoint2().x && snippet2.getPoint2().x < snippet1.getPoint2().x);
    }

    public boolean isRemoveSnippet(Vector snippet1, Vector snippet2) {
        return (snippet1.getPoint1().x < snippet2.getPoint1().x && snippet2.getPoint1().x < snippet1.getPoint2().x) &&
                (snippet1.getPoint1().x < snippet2.getPoint2().x && snippet2.getPoint2().x < snippet1.getPoint2().x);
    }

    public void merge(Vector snippet1, Vector snippet2) {
        double maxPoint = snippet1.getPoint1().x;
        double minPoint = snippet1.getPoint1().x;

        double[] xPoints = {snippet1.getPoint1().x, snippet1.getPoint2().x, snippet2.getPoint1().x, snippet2.getPoint2().x};

        for (double xPoint : xPoints) {
            if (maxPoint < xPoint)
                maxPoint = xPoint;

            if (minPoint > xPoint)
                minPoint = xPoint;
        }

        Point2D point1 = new Point2D(minPoint, snippet1.getPoint1().y);
        Point2D point2 = new Point2D(maxPoint, snippet1.getPoint2().y);

        snippet1.setPoints(point1, point2);
    }

    public void removeSnippet(Vector snippet, List<Vector> snippets) {
        snippets.remove(snippet);
    }
}
