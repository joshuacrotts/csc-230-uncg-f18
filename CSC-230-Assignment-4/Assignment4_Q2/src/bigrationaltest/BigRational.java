package bigrationaltest;

import java.math.BigInteger;

/**
 * This class represents rational numbers. A rational number stores a numerator
 * and denominator, and we will use BigIntegers to represent the numerator and
 * denominator. Thus our class will be aptly named BigRational
 *
 * Following concepts haven used. public static final constants use of an
 * existing class, namely BigInteger (composition) multiple constructors
 * throwing exceptions implementing a set of accessors implementing equals and
 * toString
 *
 * @date October 9, 2018
 */
public class BigRational implements Comparable<BigRational> {

    public static final BigRational ZERO = new BigRational();
    public static final BigRational ONE = new BigRational("1");

    private BigInteger num; // only this can be negative
    private BigInteger den; // never negative
    private boolean indeterminate = false;

    public BigRational() {
        this(BigInteger.ZERO);
    }

    public BigRational(BigInteger n) {
        this(n, BigInteger.ONE);
    }

    public BigRational(BigInteger num, BigInteger den) {
        this.num = num;
        this.den = den;

        /* Changed this in case both the numerator and denominator are zero, 
         * it doesn't throw a hissy fit.
         * 
         * In the case that both are zero, all operations will no longer work
         * on the BigRational since 0/0 is indeterminate, and n/0 for some integer
         * n is undefined.
         */
        if (!(this.num.equals(BigInteger.ZERO) && this.den.equals(BigInteger.ZERO))) {
            check00();
            fixSigns();
            reduce();
        }else{
            this.indeterminate = true;
        }
    }

    public BigRational(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("empty string");
        }

        int slashIndex = str.indexOf('/');
        if (slashIndex == -1) {
            num = new BigInteger(str.trim());
            den = BigInteger.ONE; // den = 1
        } else {
            num = new BigInteger(str.substring(0, slashIndex).trim());
            den = new BigInteger(str.substring(slashIndex + 1).trim());
            check00();
            fixSigns();
            reduce();
        }
    }

    private void check00() {
        if (num.equals(BigInteger.ZERO) && den.equals(BigInteger.ZERO)) {
             this.indeterminate = true;
        }
    }

    private void fixSigns() {
        if (den.compareTo(BigInteger.ZERO) < 0) {
            num = num.negate();
            den = den.negate();
        }
    }

    private void reduce() {
        BigInteger gcd = num.gcd(den);
        num = num.divide(gcd);
        den = den.divide(gcd);

    }

    /**
     * Get the absolute value
     *
     * @return
     */
    public BigRational abs() {
        return new BigRational(num.abs(), den);
    }

    /**
     * Negate the number
     *
     * @return
     */
    public BigRational negate() {
        return new BigRational(num.negate(), den);
    }

    /**
     * Add two numbers
     *
     * @param other
     * @return
     */
    public BigRational add(BigRational other) {
        BigInteger newNumerator = this.num.multiply(other.den).add(other.num.multiply(this.den));
        BigInteger newDenominator = this.den.multiply(this.num);
        return new BigRational(newNumerator, newDenominator);
    }

    /**
     * Subtract two numbers
     *
     * @param other
     * @return
     */
    public BigRational subtract(BigRational other) {
        return add(other.negate());
    }

    /**
     * Multiply two numbers
     *
     * @param other
     * @return
     */
    public BigRational multiply(BigRational other) {
        BigInteger newNumerator = this.num.multiply(other.num);
        BigInteger newDenominator = this.den.multiply(other.den);
        return new BigRational(newNumerator, newDenominator);
    }

    /**
     * Divide two numbers
     *
     * @param other
     * @return
     */
    public BigRational divide(BigRational other) {
        BigInteger newNumerator = this.num.multiply(other.den);
        BigInteger newDenominator = this.den.multiply(other.num);
        return new BigRational(newNumerator, newDenominator);
    }

    /**
     * Raises BigRational's numerator and denominator to power of exp
     *
     * Throws exception if exp < 0
     *
     * @param exp - int value to raise numerator & denominator to
     * @return new BigRational with raised power exp, returns 1 if exp is 0.
     */
    public BigRational pow(int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Exponent must be positive!");
        } else if (exp == 0) {
            return ONE;
        }

        return new BigRational(this.num.pow(exp), this.den.pow(exp));
    }

    /**
     * Returns the reciprocal of the BigRational
     *
     * @return new BigRational containing the previous denominator over the
     * numerator
     */
    public BigRational reciprocal() {
        return new BigRational(this.den, this.num);
    }

    /**
     * Attempts to convert current BigRational to a BigInteger
     *
     * Throws exception if denominator is not 1
     *
     * @return BigInteger form of numerator
     */
    public BigInteger toBigInteger() {
        if (!this.den.equals(new BigInteger("1"))) {
            throw new ClassCastException("Denominator must be one!");
        }

        return this.num;

    }

    /**
     * Attempts to convert current BigRational to a int by multiplying the
     * denominator by the LCM of the two, which is Integer.MAX_VALUE.
     *
     * If the numerator is then greater than Integer.MAX_VALUE, it throws an
     * exception, since any number greater than the max possible value for ints
     * cannot be treated as such.
     *
     * @return int version of numerator
     */
    public int toInteger() {
        this.reduce();

        Integer biggest = Integer.MAX_VALUE;
        Integer smallest = Integer.MIN_VALUE;

        /*Determines if the BigRational is bigger or smaller than the biggest integer
        * value or smallest integer value*/
        if (this.num.compareTo(this.den.multiply(new BigInteger(biggest.toString()))) > 0) {
            throw new ClassCastException("BigRational is bigger than int's max value");
        } else if (this.num.compareTo(this.den.multiply(new BigInteger(smallest.toString()))) < 0) {
            throw new ClassCastException("BigRational is smaller than int's min value");
        }

        /**
         * If the fraction is irreducable (387/4 for instance) where the
         * denominator is not 1, the values are divided using BigInteger's
         * divide() method and that is then casted to an int.
         */
        if (this.den.compareTo(BigInteger.ONE) != 0) {
            return (this.num.divide(this.den)).intValue();
        }
        return this.num.intValue();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof BigRational) {
            BigRational rhs = ((BigRational) other);
            return num.equals(rhs.num) && den.equals(((BigRational) other).den);
        }
        return false;
    }

    @Override
    public int compareTo(BigRational obj) {
        BigRational tempValue = obj;
        BigInteger num1 = this.num.multiply(tempValue.den); //Multiply this num by the temmpValue's den to get LCM
        BigInteger num2 = tempValue.num.multiply(this.den); //Multiply tempValue's num by this den to get LCM   

        return num1.compareTo(num2);
    }

    @Override
    public String toString() {
        //Only if the denominator is zero
        if (den.equals(BigInteger.ZERO)) {
            //If the numerator is a negative
            if (num.compareTo(BigInteger.ZERO) < 0) {
                return "-Infinity";
            } //If the numerator is greater than zero it's undefined
            else if (num.compareTo(BigInteger.ZERO) > 0) {
                return "Undefined";
            } //If they're both zero it's an indeterminate solution
            else {
                return "Indeterminate";
            }
        } //If the numerator is 0 and the denominator is a non zero
        else if (num.equals(BigInteger.ZERO) && den.compareTo(BigInteger.ZERO) > 0) {
            return "0";
        } //Only if the denominator is one
        else if (den.equals(BigInteger.ONE)) {
            return num.toString();
        } //If the numerator and denominator is a non-zero value
        else {
            return num + " / " + den;
        }
    }
}
