package assignment2_q5;

import java.util.Scanner;

/**This class/question creates a 2D array M x N (as input from user),
 * fills it up with values from 0 to ((M * N) / 4). From here, consecutive
 * quartets of numbers are found either vertically, horizontally, or 
 * diagonally. 
 * 
 * Same process of calculating a winner to Connect-4.
 *
 * @author Joshua Crotts
 */
public class Assignment2_Q5 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your number of rows: ");
        int rows = keyboard.nextInt(); //

        System.out.print("Enter your number of columns: ");
        int columns = keyboard.nextInt();

        int quarter = (rows * columns) / 4;

        int[][] array = new int[rows][columns];

        final int TRIALS = 10;
            
        for (int times = 0; times < TRIALS; times++) {
            
            //Fills the array with random values [0, rows*col / 4)
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    array[i][j] = (int) (Math.random() * quarter);
                }
            }

            System.out.println(hasFourConsecutives(array));
            printArray(array);
        }
    }

    /**
     * Determines if there are four consecutive values within arr.
     * @param arr - 2D integer array of size M x N.
     * @return true if a consecutive quartet exists, false otherwise.
     */
    public static boolean hasFourConsecutives(int[][] arr) {

        if (arr.length < 4 || arr[0].length < 4) {
            throw new IllegalArgumentException("Rows and Columns must be >= 4");
        }

        boolean isFour = false;
        //Checks the rows for equivalency
        for (int i = 0; i < arr.length; i++) {

            //Checks all the current columns alongside the row
            for (int j = 0; j < arr[0].length - 3; j++) {
                if (arr[i][j] == arr[i][j + 1]
                        && arr[i][j] == arr[i][j + 2]
                        && arr[i][j] == arr[i][j + 3]) {
                    return true;
                }
                isFour = false;
                break;
            }
        }

        //Checks the columns for equivalency
        for (int i = 0; i < arr[0].length; i++) {

            //Checks all the current rows alongside the column
            for (int j = 0; j < arr.length - 3; j++) {
                if (arr[j][i] == arr[j + 1][i]
                        && arr[j][i] == arr[j + 2][i]
                        && arr[j][i] == arr[j + 3][i]) {
                    return true;
                }
                isFour = false;
                break;
            }
        }

        //In order to check diagonals, we have to validate one of four
        //"quadrants". That is, if any of the four corners a[x +- 3][y +- 3]
        //is valid, there could potentially be a consecutive quartet.
        //
        //Thankfully, this process is only O(M * N), but could be improved by 
        //the use of a class or something to flag already checked cells.
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                //Bottom right
                if (in2DBounds(arr, x + 3, y + 3)
                        && ((arr[x][y] == arr[x + 1][y + 1]
                        && arr[x][y] == arr[x + 2][y + 2]
                        && arr[x][y] == arr[x + 3][y + 3]))) {
                    return true;

                } //Top right
                else if (in2DBounds(arr, x + 3, y - 3)
                        && ((arr[x][y] == arr[x + 1][y - 1]
                        && arr[x][y] == arr[x + 2][y - 2]
                        && arr[x][y] == arr[x + 3][y - 3]))) {
                    return true;
                } //Bottom left
                else if (in2DBounds(arr, x - 3, y + 3)
                        && ((arr[x][y] == arr[x - 1][y + 1]
                        && arr[x][y] == arr[x - 2][y + 2]
                        && arr[x][y] == arr[x - 3][y + 3]))) {
                    return true;
                } //Top left
                else if (in2DBounds(arr, x - 3, y - 3)
                        && ((arr[x][y] == arr[x - 1][y - 1]
                        && arr[x][y] == arr[x - 2][y - 2]
                        && arr[x][y] == arr[x - 3][y - 3]))) {
                    return true;
                } else {
                    isFour = false;
                }
            }
        }

        return isFour;
    }

    /**
     * Prints the values of a 2D integer array in row-major order.
     * @param arr 2D integer array
     */
    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("[" + arr[i][j] + "]");
            }
            System.out.println("");
        }
    }

    /**
     * Determines if parameters x and y are within the boundaries of arr.
     * In essence, this is to ensure when checking for diagonals, we don't
     * go outside of the array.
     * @param arr - 2D integer array
     * @param x - row index
     * @param y - column index
     * @return true if x and y are valid indexes in the array (non-negative or > 
     *         row/col length), false otherwise.
     */
    private static boolean in2DBounds(int[][] arr, int x, int y) {
        return (x >= 0) && (y >= 0) && (x < arr.length) && (y < arr[0].length);
    }
}
