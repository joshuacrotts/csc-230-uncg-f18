package assignment5_q1;

/**This question asks to create a recursive string length finder.
 *
 * @author Joshua Crotts
 * @date October 22, 2018
 */
public class Assignment5_Q1 {

    public static void main(String[] args) {
        System.out.println("\"Hello World\" length (11): " + length("Hello World"));//Should print 11
        System.out.println("Empty string length (0): " + length(""));//Should be 0
        System.out.println("\"CSC-230-03\" length (10): " + length("CSC-230-03"));//Should print 10
    }

    /**
     * Recursively finds the length of string s
     * 
     * @param s string
     * @return int length of string, whitespaces included
     */
    public static int length(String s) {
        if (s.equals("")) {
            return 0;
        }
        //Continue returning the string with the front chopped
        //off until there is no longer a string present
        return length(s.substring(1)) + 1;
    }

}
