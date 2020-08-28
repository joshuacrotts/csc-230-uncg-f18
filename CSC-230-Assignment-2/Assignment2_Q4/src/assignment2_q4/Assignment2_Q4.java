package assignment2_q4;

/**This class/question shows the probability distribution of the sum of 
 * 2 fair (6-sided) dice. 
 *
 * @author Joshua Crotts
 */
public class Assignment2_Q4 {

    public static void main(String[] args) {
        int[] probabilities = rollDice(36000);
        
        for(int i = 0; i < probabilities.length; i++){
            System.out.println("Rolls for "+(i + 2)+": "+probabilities[i]);
        }
    }

    /**
     * Rolls two dice (numbers 1-6), calculates the sum, and 
     * dependent on how many cycles are used, determines how often
     * each sum appears. Should be a bell-curve distribution.
     * @param cycles - amt of times the two dice should be rolled.
     * @return int array with summations of 2-12 at each index (0-11).
     */
    public static int[] rollDice(int cycles) {
        //2-12 are possible summations
        int[] probabilities = new int[11]; //2 3 4 5 6 7 8 9 10 11 12

        for (int i = 0; i < cycles; i++) {
            //Generates two random numbers between [1, 6]
            //Subtracts 2 to account for not having sums of 0 and 1 in the array
            //Each time the sum appears as an index, it's incremented
            probabilities[(((int) ((Math.random() * 6) + 1)) + ((int) ((Math.random() * 6) + 1))) - 2]++;

        }
        
        return probabilities;
    }

}
