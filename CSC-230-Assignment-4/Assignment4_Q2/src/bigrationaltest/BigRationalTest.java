package bigrationaltest;

import java.math.BigInteger;

/**
 * This is a test class to test BigRational class
 * 
 * For Assignment 4 Question 2, there is a separate class
 * called "Assignment4_Q2.java".
 */
public class BigRationalTest {

    public static void main(String[] args) {
        BigRational br1 = new BigRational(BigInteger.ONE, BigInteger.TEN);
        System.out.println(br1.toString());
        
        BigRational br2 = new BigRational("1/0");
        System.out.println(br2.toString());
        
        BigRational br3 = new BigRational("-1/0");
        System.out.println(br3.toString());
        
        BigRational result = (new BigRational("2/10")).multiply(new BigRational("2/5"));
        System.out.println(result.toString());
        
    }

}
