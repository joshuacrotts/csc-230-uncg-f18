package question3;

/**
 * This class describes the solution to Question 3, regarding a method that
 * takes in an integer and prints out the digits iteratively/mathematically.
 *
 * @author Joshua Crotts
 * @date 8/26/18
 */
public class Question3 {

    public static void main(String[] args) {
        printDigits(10);
        printDigits(250);
        printDigits(1);
        printDigits(0);
        printDigits(1578957);
        printDigits(42339);
    }

    /**
     * printDigits takes in a nonnegative integer x, and through the modulus
     * operator, it grabs the last digit, then divides it by ten to get rid of
     * the last digit. This is added to an array of all the digits
     *
     * @param x nonnegative integer
     */
    public static void printDigits(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Input must be >= 0.");
        } else if (x == 0) {
            System.out.println(0);
            return;
        }
        //The logarithm function calculates how many digits - 1 are in the number.
        //This is to alleviate ANY string functionality whatsoever even if this
        //method is very cumbersome.
        int[] digits = new int[(int) Math.log10(x) + 1];
        int counter = 0;

        //Grabs the remainder (last digit) then truncates it by division
        while (x > 0) {
            digits[counter++] = x % 10;
            x /= 10;
        }

        //Prints out the digits from the array reversed
        for (int i = digits.length - 1; i >= 0; i--) {
            System.out.print(digits[i] + "\t");
        }
        System.out.println(""); //New line 
    }

}
