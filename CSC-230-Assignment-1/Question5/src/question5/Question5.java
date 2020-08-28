package question5;

/**
 * This class finds all pairs of integers (a, b) that satisfy the equation: (a ^
 * 2 + b ^ 2 + 1) / (a + b)
 *
 * Satisfying the above equation means the quotient is an integer i.e. they are
 * divisible.
 *
 * A pattern was found with this ruleset: b = Math.round(a * 2.618), although I
 * was unsure how to make this more efficient USING this pattern.
 *
 * Runtime analysis is approximately O(n^2/2)
 *
 * @author Joshua Crotts
 * @date 8/26/18
 */
public class Question5 {

    public static void main(String[] args) {
        System.out.println("Pairs for 34:");
        printPairs(34);

        System.out.println("\n\nPairs for 25:");
        printPairs(25);

        System.out.println("\n\nPairs for 100:");
        printPairs(100);

        System.out.println("\n\nPairs for 1000:");
        printPairs(1000);

        System.out.println("\n\nPairs for 10000:");
        printPairs(10000);

        System.out.println("\n\nPairs for 37885:");
        printPairs(37885);
    }

    public static void printPairs(int n) {
        if (n <= 1) {
            return;
        }
        int pairs = 0;
        for (double a = 1; a < n; a++) {
            for (double b = a + 1; b < n; b++) {
                double x = ((a * a) + (b * b) + 1) / (a * b);
                if (x == (int) x) {
                    System.out.println("Pair " + (++pairs) + ": (" + a + ", " + b + ")");
                }
            }
        }
    }

}
