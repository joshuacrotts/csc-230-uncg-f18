package assignment2_q3;

/**This class/question determines all of the prime numbers 2 <= x < 1000 using 
 * the Sieve of Eratosthenes method.
 *
 * @author Joshua Crotts
 */
public class Assignment2_Q3 {

    public static void main(String[] args) {
        boolean[] primeValues = getPrimes();

        for (int i = 2; i < primeValues.length; i++) {
            if (primeValues[i]) {
                System.out.println(i);
            }
        }
    }

    /**
     * Determines all of the prime indexes in a boolean array below 1000.
     * @return 1D array of boolean values with prime indexes marked as true.
     */
    private static boolean[] getPrimes() {
        boolean[] primes = new boolean[1000];

        //initialize all to be true/prime
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        
        //We iterate over each index in primes starting at 2,
        //then, starting at i + i (because we don't need to start at 
        //i itself since i itself might be prime unless marked by
        //an earlier iteration), we go up by increments of i (multiplies of i
        //essentially), to each index < 1000 and mark it as non-prime (false).
        for (int i = 2; i < primes.length; i++) {
            for (int j = i + i; j < primes.length; j += i) {
                primes[j] = false;
            }
        }

        return primes;
    }

}
