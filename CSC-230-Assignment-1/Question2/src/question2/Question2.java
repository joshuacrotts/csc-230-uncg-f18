package question2;

import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * This class solves Question 2:
 *
 * Evaluate the function x^4 + y^3 + z + (x+y)^4 * z
 *
 * @author Joshua Crotts
 * @date 8/26/18
 */
public class Question2 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your x variable: ");
        double x = keyboard.nextDouble();

        System.out.print("\nEnter your y variable: ");
        double y = keyboard.nextDouble();

        System.out.print("\nEnter your z variable: ");
        double z = keyboard.nextDouble();

        System.out.println("Evaluating f(x, y, z) = x^4 + y^3 + z + (x + y)^4 * z");
        System.out.println(x + " ^ 4 + " + y + " ^ 3 + " + z + "+ (" + x + " + " + y + ")^4 * " + z + ": " + quarticFunction(x, y, z));

        System.out.println("\n\nBelow are other test cases:");
        System.out.println("-3 ^ 4 + 2 ^ 3 + 12 + (-3 + 2)^4 * 12+: " + quarticFunction(-3, 2, 12));

        System.out.println("-7 ^ 4 + 0 ^ 3 + 1 + (-7 + 0)^4 * 1+: " + quarticFunction(-7, 0, 1));

        System.out.println("-16 ^ 4 + -3 ^ 3 + -8 + (-16 + -3)^4 * -8+: " + quarticFunction(-16, -3, -8));

        System.out.println("25 ^ 4 + 0 ^ 3 + 0 + (25 + 0)^4 * 0+: " + quarticFunction(25, 0, 0));
    }

    /**
     * Method to solve the quartic function: f(x, y, z): x ^ 4 + y ^ 3 + z + (x
     * + y) ^ 4 * z;
     *
     * @param x first variable
     * @param y second variable
     * @param z third variable
     * @return result of equation
     */
    public static double quarticFunction(double x, double y, double z) {
        return (pow((x), 4) + pow(y, 3) + z + (pow(x + y, 4) * z));
    }
}
