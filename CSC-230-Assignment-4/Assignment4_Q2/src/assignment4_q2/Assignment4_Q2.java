package assignment4_q2;

import bigrationaltest.BigRational;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This question deals with BigRationals, and performing operations on them.
 *
 * @author Joshua Crotts
 * @date October 5, 2018
 */
public class Assignment4_Q2 {

    public static void main(String[] args) {
        
        //Tests 0/0 to make sure it doesn't throw exception
        BigRational indeterminate = new BigRational(new BigInteger("0"), new BigInteger("0"));
        
        /**
         * *****Raising BigRational to Power******
         */
        //Test pow(n)
        BigRational powTest = new BigRational(new BigInteger("12"), new BigInteger("3"));
        BigRational powTest2 = powTest.pow(3);
        System.out.println(powTest + ", raised to a power of 3: " + powTest2);
        //Tests pow(n) with irreducable fraction
        BigRational powTest_ = new BigRational(new BigInteger("7"), new BigInteger("4"));
        BigRational powTest_2 = powTest_.pow(3);
        System.out.println(powTest_ + ", raised to a power of 3: " + powTest_2);
        
        
        /**
         * *****BigInteger Casting******
         */
        //Test BigInteger toBigInteger()
        BigInteger toBigInt = powTest.toBigInteger();
        System.out.println(toBigInt + ", is BigInteger: " + (toBigInt instanceof BigInteger));

        //Throws exception since the denominator of this BigRational isn't 1
        try {
            BigInteger toBigInt2 = new BigRational(new BigInteger("7"), new BigInteger("3")).toBigInteger();
        } catch (ClassCastException e) {
            System.out.println("This should error: " + e + "\n\n");
        }

        /**
         * *****Integer Casting******
         */
        //Test integer "casting"
        int intTest1 = powTest.toInteger();
        System.out.println("Int value: " + intTest1);

        //Fails integer "casting"
        BigRational tooBig = new BigRational(new BigInteger("3719371293719139212"), new BigInteger("7"));
        try {
            int intTest2 = tooBig.toInteger();
        } catch (ClassCastException e) {
            System.out.println("This should error: " + e + "\n\n");
        }

        /**
         * *****Indefinable/indeterminate fractions******
         */
        //Tests several undefined/indeterminate/0 fractions
        BigRational doubleZero = new BigRational(BigInteger.ZERO, BigInteger.ZERO);
        BigRational numWithZero = new BigRational(new BigInteger("4"), BigInteger.ZERO);
        BigRational zeroWithNum = new BigRational(BigInteger.ZERO, new BigInteger("4"));

        System.out.println("0/0 = " + doubleZero); //Indeterminate
        System.out.println("4/0 = " + numWithZero); //Undefined
        System.out.println("0/4 = " + zeroWithNum); //0

        /**
         * *****Sorting BigRationals******
         */
        //Tests Collections.sort()
        ArrayList<BigRational> values = new ArrayList<>();
        values.add(new BigRational(new BigInteger("1"), new BigInteger("3")));
        values.add(new BigRational(new BigInteger("1"), new BigInteger("5")));
        values.add(new BigRational(new BigInteger("1"), new BigInteger("8")));
        values.add(new BigRational(new BigInteger("2"), new BigInteger("8")));
        values.add(new BigRational(new BigInteger("3"), new BigInteger("8")));
        System.out.println("Before sorting: " + values);
        Collections.sort(values);
        System.out.println("After sorting: " + values);
    }

}
