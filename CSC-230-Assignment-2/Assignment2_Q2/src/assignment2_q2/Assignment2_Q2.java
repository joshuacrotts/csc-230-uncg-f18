package assignment2_q2;
/*
 * This question refers to finding duplicate values in two integer arrays.
 * 
 * This is the same as finding the union of two sets. Though, these are NOT sets,
 * so we have to account for duplicates within one of the arrays themselves 
 * i.e. A = {2, 4, 5, 3, 2} contains two twice, and B = {1, 3}. This does NOT count as a 
 * "duplicate"; it is marked as such if and only if 2 exists in B.
 *
 * @author Joshua Crotts
 */

public class Assignment2_Q2 {

    public static void main(String[] args) {
        int[] a = {7, 4, 8, 0, 2, 1};
        int[] b = {8, 6, 4, 9, 26, 4, 0};
        findIntersection(a, b); // {7, 8, 0}

        int[] c = {6, 4, 7, 6};
        int[] d = {6, 2, 1, 9, 7, 4};
        findIntersection(c, d); // {6, 4, 7}

        int[] e = {3, 2, 4, 6, 8, 4};
        int[] f = {2, 4, 6};
        findIntersection(e, f); // {2, 4, 6}

        int[] g = {65, 12, 143};
        int[] h = {32, 41, 65, 4, 12, 36, 143, 99};
        findIntersection(g, h); // {65, 12, 143}

        int[] i = {0, 12, 143, 0, 36, 12};
        int[] j = {32, 41, 65, 1, 12, 36, 0, 99};
        findIntersection(i, j); //{0, 12, 36}

        int[] k = {4513, -12, 143, 4, 36};
        int[] l = {32, 41, 65, 1, -12, 36, 123, 99};
        findIntersection(k, l); // {-12, 36}

        int[] m = {4513, -12, 143, 4, 36};
        int[] n = {4, 4513, 36, -12, 143, 36, 123, 99};
        findIntersection(m, n); // {4513, -12, 143, 4, 36}

        int[] o = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] p = {0, 0, 0, 0, 0, 0, 0};
        findIntersection(o, p); // {0}

        int[] q = {0, 0, 0, 0, 1, 0, 0, 0, 0, 2};
        int[] r = {0, 0, 0, 6 / 3, 0, 0, 1};
        findIntersection(q, r); // {0, 1, 2}
    }

    /**
     * findIntersection(...) takes two primitive int arrays a and b and
     * calculates the intersection (AND) of the two i.e. finding duplicate
     * values BETWEEN the two (not within themselves). These duplicate values
     * are then printed to the console.
     *
     * Repeating elements within the arrays themselves (if x is a member of A
     * and x appears more than once within A) are only printed once.
     *
     * Duplicate values are marked in an Integer object array, so that the
     * number 0 can be inside of a and/or b (if a primitive int array is used,
     * this will not work because primitive int arrays are instantiated with
     * default values of 0, whereas arrays of [reference] objects are
     * instantiated with null. 0 != null)
     *
     * @param a - 1D int array
     * @param b - 1D int array
     *
     */
    public static void findIntersection(int[] a, int[] b) {
        //A set would be VERY useful for this...
        //The maximum amount of duplicates for an intersection will be the size of the minimum value;
        //In other words, if A is a subset of B.
        //This maximum amt is only true/fully-filled IF there exist no duplicate values within A.
        Integer[] duplicates = new Integer[Math.min(a.length, b.length)];

        //Index to keep track of how many duplicate values are present
        int duplicate_index = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                //Check to see if the current element of a equals the current
                //element of B.
                //
                //isMember takes a 1D Integer array arr alongside an element and 
                //returns a boolean stating whether or not it's in arr
                //
                if (a[i] == b[j] && !isMember(duplicates, a[i])) {
                    //If a duplicate is found, we assign it to the next
                    //available index in the duplicates array. 
                    //break is used to leave the current iteration as 
                    //since we already found the repeating element
                    //there is no need to continue searching for one that 
                    //matches a[i].
                    duplicates[duplicate_index++] = a[i];
                    break;
                }
            }
        }
        //Prints the duplicated values to the console.
        for (int i = 0; i < duplicate_index; i++) {
            System.out.print(duplicates[i] + "\t");
        }
        System.out.println();
    }

    /**
     * Determines if a particular element is within a 1D Integer array.
     *
     * @param a - 1D Integer (object) array
     * @param element - some element possibly within a
     * @return true if element exists in a, false otherwise.
     */
    private static boolean isMember(Integer[] a, int element) {

        Integer x = element;
        for (int i = 0; i < a.length; i++) {
            //If an element is null we know we're either at the 
            //"end" of the array i.e. no further elements 
            //or the array is empty
            if (a[i] == null || a.length == 0) {
                return false;
            } else if (x.intValue() == a[i]) {
                return true;
            }
        }
        return false;
    }
}
