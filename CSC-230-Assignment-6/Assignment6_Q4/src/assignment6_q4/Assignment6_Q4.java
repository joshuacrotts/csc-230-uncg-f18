package assignment6_q4;

import java.util.Comparator;

/**
 * Merge Sort implementation for Assignment 6 - Question 4.
 *
 * @author Joshua Crotts
 * @date November 17, 2018
 */
public class Assignment6_Q4 {

    public static void main(String[] args) {
        Comparator<Circle> orderByRadius = new OrderByRadius();
        Circle[] circles = {new Circle(5), new Circle(1), new Circle(3), new Circle(4), new Circle(2)};

        merge_sort(circles, orderByRadius);

        System.out.print("Small array: ");
        Circle.printCircles(circles);

        Circle[] circlesBig = new Circle[10000];
        for (int i = 0; i < circlesBig.length; i++) {
            circlesBig[i] = new Circle((int) (Math.random() * 10000 + 1));
        }

        merge_sort(circlesBig, orderByRadius);

        System.out.print("Large array: ");
        Circle.printCircles(circlesBig);
    }

    /**
     * Abstracted method to merge sort an array of type T.
     *
     * @param <T> generic type array
     * @param arr array of generic type T
     * @param c Comparator object showing how to compare a T
     */
    public static <T> void merge_sort(T[] arr, Comparator<? super T> c) {
        merge_sort_algorithm(arr, 0, arr.length - 1, c);
    }

    /*
     * Below this point are all helper [and therefore private] methods called by
     * the merge_sort method to abstract the core details of said methods from the
     * user.
     */
    /**
     * Recursive merge sort part of the Merge Sort algorithm.
     *
     * Divides the array until it no longer can, then merges all the pieces
     * together.
     *
     * @param <T> Generic type parameters
     * @param arr Array of type T
     * @param left far left position of current subarray
     * @param right far right position of current subarray
     * @param c Comparator object showing how to compare objects of type T
     */
    private static <T> void merge_sort_algorithm(T[] arr, int left, int right, Comparator<? super T> c) {
        if (left < right) {
            int middle = (left + right) / 2;
            merge_sort_algorithm(arr, left, middle, c); //Sorts 0 to mid
            merge_sort_algorithm(arr, middle + 1, right, c); //Sorts mid + 1 to right
            merge(arr, left, middle, right, c); //Merges arr with given position flags, depends on where the algorithm currently is in the merge process
        }
    }

    /**
     * Merges two subarrays into one giant one, a part of the Merge Sort
     *
     * @param <T> Generic type parameters
     * @param arr array of type T
     * @param left left side of array
     * @param mid marks the middle point of where to divide the subarray
     * @param right far right of second half of array (second subarray)
     * @param c Comparator object denoting how to compare objects of type T
     */
    private static <T> void merge(T[] arr, int left, int mid, int right, Comparator<? super T> c) {
        int lowHalfSize = mid - left + 1; //Calculates the left
        int highHalfSize = right - mid; //Calculates right

        T[] lowHalf = (T[]) new Object[lowHalfSize]; //Creates array based on left & right side sizes
        T[] highHalf = (T[]) new Object[highHalfSize];

        for (int i = 0; i < lowHalfSize; ++i) {
            lowHalf[i] = arr[left + i];
        }

        for (int j = 0; j < highHalfSize; ++j) {
            highHalf[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        //Sorts the array based on what is in the two
        //lowHalf and highHalf sized arrays. Whichever 
        //elements are being tracked, the smaller of 
        //the two are placed into the merged array,
        //with markers/placeholders denoting the current
        //iteration in each subarray.
        while (i < lowHalfSize && j < highHalfSize) {
            if (c.compare(lowHalf[i], highHalf[j]) <= 0) {
                arr[k++] = lowHalf[i++];
            } else {
                arr[k++] = highHalf[j++];
            }
        }

        //Copies any remaining elements from the half arrays to the merged.
        while (i < lowHalfSize) {
            arr[k] = lowHalf[i];
            i++;
            k++;
        }
        while (j < highHalfSize) {
            arr[k] = highHalf[j];
            j++;
            k++;
        }
    }

}
