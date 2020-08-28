package assignment6_q3;

import java.util.Comparator;

/**
 * Insertion Sort for Assignment 6 - Question 3
 *
 * @author Joshua Crotts
 * @date November 17, 2018
 */
public class Assignment6_Q3 {

    public static void main(String[] args) {
        Comparator<Circle> orderByRadius = new OrderByRadius();
        Circle[] circles = {new Circle(5), new Circle(1), new Circle(3), new Circle(4), new Circle(2)};

        insertion_sort(circles, orderByRadius);

        System.out.print("Small array: ");
        Circle.printCircles(circles);

        Circle[] circlesBig = new Circle[10000];
        for (int i = 0; i < circlesBig.length; i++) {
            circlesBig[i] = new Circle((int) (Math.random() * 10000 + 1));
        }

        insertion_sort(circlesBig, orderByRadius);

        System.out.print("Large array: ");
        Circle.printCircles(circlesBig);
    }

    /**
     * Sorts the array using insertion sort; efficient on very small arrays.
     * O(n^2)
     *
     * @param <T> Generic array type
     * @param a Array of generic type
     * @param c Comparator object of subtype T or of type T
     */
    public static <T> void insertion_sort(T[] a, Comparator<? super T> c) {
        for (int i = 1; i < a.length; i++) {
            T key = a[i];
            int j = i - 1;
            while (j >= 0 && c.compare(a[j], key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

}
