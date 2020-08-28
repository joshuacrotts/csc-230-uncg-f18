package assignment4_q1;

import java.awt.Color;

/**
 *
 * This question deals with the implementation of an abstract class Shape,
 * alongside two subclasses that extend Shape: Triangle and Rectangle.
 *
 * @author Joshua Crotts
 * @date October 9, 2018
 */
public class Assignment4_Q1 {

    public static void main(String[] args) {
        Shape s1, s2;

        s1 = new Triangle(Color.RED, 8, 4);
        System.out.println(s1);
        System.out.println("Area is: " + s1.getArea());

        s2 = new Rectangle(Color.BLUE, 8, 4);
        System.out.println(s2);
        System.out.println("Area is: " + s2.getArea());
    }

}
