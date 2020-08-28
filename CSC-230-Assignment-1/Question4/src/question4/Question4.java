package question4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Math.sqrt;

/**
 * This class solves the quadratic equation per Question 4.
 *
 * Test cases are included via a file "test.in", 13 cases are provided.
 *
 * This calculator does not solve via radicals; it only gives the decimal
 * approximations.
 *
 * @author Joshua Crotts
 * @date 8/26/18
 */
public class Question4 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your a variable: ");
        double a = keyboard.nextDouble();

        System.out.print("\nEnter your b variable: ");
        double b = keyboard.nextDouble();

        System.out.print("\nEnter your c variable: ");
        double c = keyboard.nextDouble();

        System.out.println("1. Roots for a = " + a + ", b = " + b + ", c = " + c + ":");
        for (Double d : quadraticEquation(a, b, c)) {
            System.out.println(d);
        }
        keyboard.close();

        //TEST CASES BELOW
        System.out.println("BELOW ARE EXAMPLES AND TEST CASES:\n");

        Scanner file = null;
        try {
            file = new Scanner(new File("testdata.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i = 1;

        while (file.hasNext()) {
            double x = file.nextDouble(), y = file.nextDouble(), z = file.nextDouble();

            System.out.println("\n" + (i++) + ": Roots for a = " + x + ", b = " + y + ", c = " + z + ": ");
            for (Double d : quadraticEquation(x, y, z)) {
                System.out.println(d);
            }

            //Causes the escape char \n to be ignored from the inputstream
            file.nextLine();
        }

    }

    public static double[] quadraticEquation(double a, double b, double c) {

        double discriminant = (b * b) - (4 * a * c);
        double rootOne = 0.0, rootTwo = 0.0;
        double[] roots;

        /*Calculates discriminate root possibilities
        * Zero roots or a == 0
        *
        * Throws an exception if the discriminant returns something less
        * than 0 or the user enters 0 for a*/
        try {
            if (discriminant < 0 || a == 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("NO REAL ROOTS");
            return new double[0]; //Since we have to return SOMETHING
        }

        //If there exists only 1 valid root i.e. rootOne == rootTwo
        if (discriminant == 0) {
            rootOne = (-b + sqrt((b * b) - (4 * a * c))) / (2 * a);
            roots = new double[]{rootOne};
        } //If both roots are valid
        else {
            rootOne = (-b + sqrt((b * b) - (4 * a * c))) / (2 * a);
            rootTwo = (-b - sqrt((b * b) - (4 * a * c))) / (2 * a);
            roots = new double[]{rootOne, rootTwo};
        }
        return roots;
    }

}
