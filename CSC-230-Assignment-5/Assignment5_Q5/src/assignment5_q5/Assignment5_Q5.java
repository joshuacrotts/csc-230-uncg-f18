package assignment5_q5;

/**
 * This question asks to create a recursive string reverser, then, to apply the
 * same logic to a StringBuffer.
 *
 * @author Joshua Crotts
 * @date October 22, 2018
 */
public class Assignment5_Q5 {

    public static void main(String[] args) {
        //Tests String reverse
        System.out.println(reverseString("Joshua"));
        System.out.println(reverseString("CSC-230-03"));
        
        //Tests StringBuffer reverse
        System.out.println(reverseStringBuffer(reverseStringBuffer("APComputerScienceA"))); //Reverses a reversed string
        System.out.println(reverseStringBuffer("APComputerScienceA"));
        
    }

    /**
     * O(n), but uses a lot more space due to the additional memory allocated to
     * new Strings
     *
     * Reverses a string s by grabbing the last char in the string, then
     * recursively calling the method on the entire string with the last char
     * chopped off.
     *
     * @param s string
     * @return reversed string
     */
    public static String reverseString(String s) {
        if (s.length() <= 0) {
            return "";
        } else {
            //The far-right char is concatenated with the contents of 
            //the recursive call on the string without the far right char.
            return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
        }
    }

    /**
     * Runs in n / 2 + 1 but due to big O rules it's O(n)
     *
     * Driver method to reverse a StringBuffer from a String object. Constructs
     * a new StringBuffer object based off the String, with 0 and the length - 1
     * as parameters to the private method.
     *
     * @param s String object
     * @return reversed String
     */
    public static String reverseStringBuffer(String s) {
        return new String(reverse(new StringBuffer(s), 0, s.length() - 1));
    }

    /**
     * This method reverses a string method in a different way; it takes the
     * left and right chars, saves them, then swaps them. Then, the method is
     * called recursively on the string with two flag variables marking where to
     * begin saving the chars.
     *
     * @param sb StringBuffer object
     * @param left integer variable keeping track of the left char
     * @param right integer variable keeping track of the right char
     * @return reversed StringBuffer object, sb
     */
    private static StringBuffer reverse(StringBuffer sb, int left, int right) {
        /* If the sb length is 0 or 1, we can't reverse it
         * If the left flag is ever >= right flag, we know that there is nothing
         * left to reverse so we return the object */
        if (sb.length() == 0 || sb.length() == 1 || left >= right) {
            return sb;
        } else {
            char l = sb.charAt(left); //Grabs the left char
            char r = sb.charAt(right); //Grabs the right char
            sb.setCharAt(left, r); //Assigns the left char in the sb to the right char
            sb.setCharAt(right, l); //Assigns the right char in the sb to the left char, swapping the two
            return reverse(sb, ++left, --right); //left is incremented and right is decremented to set the limits for the edges of the sb
        }
    }

}
