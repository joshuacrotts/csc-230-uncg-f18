package assignment6_q5;

import java.util.Comparator;
import java.util.Random;

/**
 * Quick Sort Java Implementation for Assignment 6
 *
 * The random "pivot" is generated in the q_sort helper method, then is swapped
 * with the far right to make pivoting easier, and since the partition method
 * only partitions elements to the left of the "pivot".
 *
 * @author Joshua Crotts
 * @date November 17, 2018
 */
public class Assignment6_Q5 {

    private static final Random RAND = new Random();

    public static void main(String[] args) {
        Comparator<Circle> orderByRadius = new OrderByRadius();
        Circle[] circles = {new Circle(5), new Circle(1), new Circle(3), new Circle(4), new Circle(2)};

        quick_sort(circles, orderByRadius);

        System.out.print("Small array: ");
        Circle.printCircles(circles);

        Circle[] circlesBig = new Circle[10000];
        for (int i = 0; i < circlesBig.length; i++) {
            circlesBig[i] = new Circle((int) (Math.random() * 10000 + 1));
        }

        quick_sort(circlesBig, orderByRadius);

        System.out.print("Large array: ");
        Circle.printCircles(circlesBig);

    }

    /**
     * Quick Sorts an array of type T with Comparator c
     *
     * @param <T> generic type array
     * @param a array of generic type T
     * @param c Comparator object showing how to compare a T
     */
    public static <T> void quick_sort(T[] a, Comparator<? super T> c) {
        q_sort(a, 0, a.length - 1, c);
    }

    /**
     * Recursively partitions the array based on random pivots and sorts them.
     *
     * @param <T> Generic type T
     * @param a array of generic type T
     * @param left left position of array
     * @param right right position of array
     * @param c Comparator object showing how to sort objects of type T
     */
    public static <T> void q_sort(T[] a, int left, int right, Comparator<? super T> c) {
        if (left < right) {
            //Below creates a random pivot in the range of left and right,
            //swaps the random element with the far right 
            //to make it easier in the partition method to determine
            //where the "pivot" is in the array
            int randomPivot = (int) (left + RAND.nextInt(right - left));
            T temp = a[randomPivot];
            a[randomPivot] = a[right];
            a[right] = temp;

            //Calls partition and gets the pivot location
            int q = partition(a, left, right, c);
            //Recursively breaks the array down and sorts it with new
            //pivots
            q_sort(a, left, q - 1, c);
            q_sort(a, q + 1, right, c);
        }
    }

    /**
     * Partitions the array based on the random pivot stored in the right
     * variable
     *
     * @param <T> generic type
     * @param a array of generic type objects
     * @param left Far left of the array currently partitioning
     * @param right Random pivot
     * @param c comparator object showing how to compare objects of type T
     * @return new pivot
     */
    private static <T> int partition(T[] a, int left, int right, Comparator<? super T> c) {
        T pivot = a[right]; //Random pivot element 
        int leftSide = left - 1; //Keeps track of the left side's far right element
        for (int j = left; j < right; j++) {
            //Compares the current element to the pivot and swaps if it is smaller
            //so as to keep the elements smaller than the pivot to the left of it.
            if (c.compare(a[j], pivot) <= 0) {
                leftSide++;

                T temp = a[leftSide];
                a[leftSide] = a[j];
                a[j] = temp;

            }
        }
        T temp = a[leftSide + 1];
        a[leftSide + 1] = a[right];
        a[right] = temp;
        return leftSide + 1;
    }
}
