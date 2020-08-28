package assignment5_q3;

/**
 * This question asks to reverse a digit.
 *
 * @author Joshua Crotts
 * @date October 22, 2018
 */
public class Assignment5_Q3 {

    public static void main(String[] args) {
        System.out.print("55442233 reversed: "); reverse(55442233);
        System.out.print("6493050 reversed: "); reverse(6493050);
        System.out.print("1234567890 reversed: "); reverse(1234567890);
        System.out.print("987654321 reversed: "); reverse(987654321);
        System.out.print("0 reversed: "); reverse(0);
        System.out.print("9 reversed: "); reverse(9);


    }


    //Original method with print out statements
    /**
     * Reverses a number recursively, prints out each digit as the recursive
     * calls continue.
     *
     * @param x
     */
    public static void reverse(int x) {
        if (x > 10) {
            //We grab the digit itself by the modulo operation,
            //print it, then recursively call the remaining of 
            //the number by dividing it by 10.
            System.out.print(x % 10);
            reverse(x / 10);
        } else {
            //If we're on the last digit we still need to print it,
            //also returns to the next line for simplicity
            System.out.println(x); 
        }
    }
    
    
    /**
     * DOES NOT WORK IF THE LAST DIGIT IS 0, and there is no mathematical way
     * FOR it to work if the last digit is 0 with integers; strings MUST be
     * used. Stilladded in for effort of showing
     *
     *
     * Reverses a number mathematically and recursively. Grabs the last digit in
     * the number by modulo, multiplies it by how many digits are still in the
     * number at the time prior to recursion, then, by order of addition, the
     * lower numbers will be tacked onto the result, which in the recursion call
     * is divided by 10.
     *
     * For instance: if the number is 1234, we modulo the number by 10 to get 4,
     * multiply this result by 10 ^ log(1234), which, when casted to an int is
     * 1000. So, 4 * 1000 = 4000. At this point, this is added to the recursive
     * call, and we divide the original number by 10 within the recursive call.
     *
     * @param num
     * @return reversed number
     */
//    public static int reverseInteger(int num) {
//        if(num == 0) return 0;
//        
//        //This grabs the last digit in the number by modulo, multiplies it by how many digits are 
//        //still in the number at the time prior to recursion, then, by order of addition,
//        //the lower numbers will be tacked onto the result. 
//        //
//        return num % 10 * (int) Math.pow(10, (double) (int) Math.log10(num)) + reverse(num / 10);
//
//    }

}
