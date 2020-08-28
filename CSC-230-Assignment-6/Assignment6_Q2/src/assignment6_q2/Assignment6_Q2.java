package assignment6_q2;

import java.util.Comparator;

/**
 * Selection Sorts an array of Circles for Assignment 6 - Question 2.
 *
 * @author Joshua Crotts
 * @date November 17, 2018
 */
public class Assignment6_Q2 {

    public static void main(String[] args) {
        Comparator<Circle> orderByRadius = new OrderByRadius();
        Circle[] circles = {new Circle(5), new Circle(1), new Circle(3), new Circle(4), new Circle(2)};

        selection_sort(circles, orderByRadius);

        System.out.print("Small array: ");
        Circle.printCircles(circles);

        Circle[] circlesBig = new Circle[10000];
        for (int i = 0; i < circlesBig.length; i++) {
            circlesBig[i] = new Circle((int) (Math.random() * 10000 + 1));
        }

        selection_sort(circlesBig, orderByRadius);

        System.out.print("Large array: ");
        Circle.printCircles(circlesBig);
    }

    /**
     * Selection Sorts an array of type T.
     *
     * Runs in O(n^2) time.
     *
     * @param <T> Generic type parameter
     * @param a Array of type T
     * @param c Comparator object denoting how to compare objects of type T
     */
    public static <T> void selection_sort(T[] a, Comparator<? super T> c) {
        for (int i = 0; i < a.length; i++) {
            int min_index = i;

            //Finds the minimum element, and puts it at the front.
            for (int j = i; j < a.length; j++) {
                if (c.compare(a[j], a[min_index]) < 0) {//a[j] < a[min_index]) {
                    min_index = j;
                }

            }

            T temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;

        }
    }

}
