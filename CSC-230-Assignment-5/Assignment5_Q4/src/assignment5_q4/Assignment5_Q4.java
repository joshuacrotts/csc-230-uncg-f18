package assignment5_q4;

/**
 * This questions asks to create a recursive decimal-to-binary calculator.
 *
 * @author Joshua Crotts
 * @date October 22, 2018
 */
public class Assignment5_Q4 {

    public static void main(String[] args) {
        System.out.print("17 to binary: ");
        toBinary(17); //10001 

        System.out.print("\n240 to binary: ");
        toBinary(240); //11110000

        System.out.print("\n254 to binary: ");
        toBinary(254); //11111110

        System.out.print("\n0 to binary: ");
        toBinary(0); //0

        System.out.print("\n255 to binary: ");
        toBinary(255); //11111111

        System.out.print("\n127 to binary: ");
        toBinary(127); //01111111

    }

    /**
     * Recursively converts a decimal number into binary.
     *
     * The number is recursively chopped in half by 2, then once the calls are
     * over, the print statements print the individual 1's or 0's in order from
     * one's digit to whatever the max may be.
     *
     * @param x some integer
     */
    public static void toBinary(int x) {
        if (x >= 2) {
            toBinary(x / 2);
            System.out.print(x % 2);
        } else {
            System.out.print(x);
        }
    }
//    //TECHNICALLY WORKS, uses string representation
//    private static String toBinary(int x) {
//        return (x < 2) ? Integer.toString(x) : Integer.toString((x % 2)) + toBinary(x / 2);
//        if (x < 2) {
//            return Integer.toString(x);
//        } else {
//            return Integer.toString((x % 2)) + toBinary(x / 2);
//            //System.out.print(x % 2);
//        }
//    }
}
