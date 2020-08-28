package assignment6_q1;

import java.util.Comparator;

/**
 * "Better" Bubble Sort Algorithm from CSC-230, sorts a generic array.
 *
 * @author Joshua Crotts
 * @date November 17, 2018
 */
public class Assignment6_Q1 {

    public static void main(String[] args) {
        Comparator<Circle> orderByRadius = new OrderByRadius();
        Circle[] circles = {new Circle(5), new Circle(1), new Circle(3), new Circle(4), new Circle(2)};

        bubble_sort(circles, orderByRadius);

        System.out.print("Small array: ");
        Circle.printCircles(circles);

        Circle[] circlesBig = new Circle[10000];
        for (int i = 0; i < circlesBig.length; i++) {
            circlesBig[i] = new Circle((int) (Math.random() * 10000 + 1));
        }

        bubble_sort(circlesBig, orderByRadius);

        System.out.print("Large array: ");
        Circle.printCircles(circlesBig);
    }

    /**
     * Uses a more-efficient (but still O(n^2)) bubble sorting technique.
     *
     * @param <T> generic type parameters
     * @param a array of type T
     * @param c Comparator object denoting how to compare two objects of type T
     */
    public static <T> void bubble_sort(T[] a, Comparator<? super T> c) {
        boolean swapped = true;
        int last = a.length;

        while (swapped) {
            swapped = false;

            for (int i = 1; i < last; i++) {
                if (c.compare(a[i], a[i - 1]) < 0) {
                    T temp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temp;
                    swapped = true;
                }
            }
            last--;
        }
    }
}
