package pl.javastart.task;

import java.util.Locale;
import java.util.Scanner;

public class CoordinateSystem {
    String part;
    // uzupełnij metodę. Używaj scannera przekazanego w parametrze.
    void run(Scanner scanner) {
        scanner.useLocale(Locale.US);
        System.out.println("Podaj X");
        int x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj Y");
        int y = scanner.nextInt();
        Point point = new Point(x, y);

        if (isZero(point.x)) {
            if (isZero(point.y)) {
                part = "na środku układu współrzędnych";
            } else {
                part = "na osi Y";
            }
        } else if (isZero(point.y) && !isZero(point.x)) {
            part = "na osi X";
        } else if (lessThanZero(point.x)) {
            if (lessThanZero(point.y)) {
                part = "w III ćwiartce układu współrzędnych";
            } else {
                part = "w II ćwiartce układu współrzędnych";
            }
        } else if (!lessThanZero(point.x)) { //warunek x / y == 0 został już obsłużony, więc w tej części będą brane tylko punkty != 0
            if (!lessThanZero(point.y)) {
                part = "w I ćwiartce układu współrzędnych";
            } else {
                part = "w IV ćwiartce układu współrzędnych";
            }
        }

        System.out.printf(Locale.US, "Punkt (%d, %d) leży %s", point.x, point.y, part);
    }

    boolean isZero(double number) {
        return (number == 0);
    }

    boolean lessThanZero(double number) {
        return (number < 0);
    }

}
