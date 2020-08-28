package assignment6_q4;

import java.util.Comparator;

/**
 * Circle class for Assignment 6, has a default class that implements the
 * Comparator interface specifically for this object (Circle).
 *
 * @author Joshua Crotts
 * @date November 17, 2018
 */
public class Circle {

    //Radius for the circle
    private int r;

    /**
     * Constructs a Circle object
     *
     * @param r int, denotes radius of circle
     */
    public Circle(int r) {
        this.r = r;
    }

    /**
     * Sets the radius of a Circle object
     *
     * @param r int
     */
    public void setRadius(int r) {
        this.r = r;
    }

    /**
     * Returns the radius of a Circle object
     *
     * @return int, radius
     */
    public int getRadius() {
        return r;
    }

    /**
     * Returns a String version of the Circle by printing the radius.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Radius: " + r;
    }

    /**
     * Static method to format/print an array of Circles.
     *
     * @param a
     */
    public static void printCircles(Circle[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }

        System.out.println(a[a.length - 1] + ".");
    }
}

/**
 * This class is a helper class that implements the Comparator interface.
 * Overrides one method: compare(Object o1, Object o2) with the Circle versions.
 *
 * @author Joshua Crotts
 * @date November 17, 2018
 */
class OrderByRadius implements Comparator<Circle> {

    /**
     * Comparator's compare(...) method overridden.
     *
     * @param o1 Circle object
     * @param o2 Circle object
     * @return signum value denoting which circle is smaller; if value > 0, o1
     * is bigger. If value less than 0, o2 is bigger. If value == 0, they are
     * equivalent.
     */
    @Override
    public int compare(Circle o1, Circle o2) {
        return o1.getRadius() - o2.getRadius();
    }

}
