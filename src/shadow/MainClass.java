package shadow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vector> listSnippets = new ArrayList<>();

        System.out.println("Введите количество отрезков:");
        int numSnippets = sc.nextInt();
        for (int i = 0; i < numSnippets; i++) {
            System.out.println("Введите отрезок №" + (i + 1));
            System.out.println("Введите координаты первой точки отрезка через пробел:");
            Point2D point1 = new Point2D(sc.nextDouble(), sc.nextDouble());

            System.out.println("Введите координаты второй точки отрезка через пробел:");
            Point2D point2 = new Point2D(sc.nextDouble(), sc.nextDouble());

            Vector snippet = new Vector(point1, point2);

            listSnippets.add(snippet);
        }

        Shadow shadow = new Shadow();
        System.out.println(shadow.calcShadow(listSnippets));
    }
}
