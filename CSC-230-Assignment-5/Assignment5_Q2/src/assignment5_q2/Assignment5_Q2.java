package assignment5_q2;

/**This question asks to create a recursive palindrome tester.
 *
 * @author Joshua Crotts
 * @date October 22, 2018
 */
public class Assignment5_Q2 {

    public static void main(String[] args) {
        String x = "BgagagB";
        String y = "AGAgaghagAGA";
        String z = "ZYXWXXYZ";
        String xx = "neveroddoreven";
        String yy = "onlyonceecnoylno";
        String zz = "CSC-230-032-CSC";

        System.out.println(isPalindrome(x));//true
        System.out.println(isPalindrome(y));//false
        System.out.println(isPalindrome(z));//false
        System.out.println(isPalindrome(xx));//true
        System.out.println(isPalindrome(yy)); //true
        System.out.println(isPalindrome(zz)); //true
    }

    /**
     * Recursively determines if a string s can be spelled the same
     * backwards as forwards (therefore a palindrome).
     * @param s string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        //If the string has lengths 0 or 1, we know it's a palindrome
        if (s.length() == 1 || s.length() == 0) {
            return true;
        //Check the front and back chars for equality
        } else if (!(s.charAt(0) == s.charAt(s.length() - 1))) {
            return false;
        }
        //If the front and back chars are equal, chop them off and return
        //the new string to test.
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}
