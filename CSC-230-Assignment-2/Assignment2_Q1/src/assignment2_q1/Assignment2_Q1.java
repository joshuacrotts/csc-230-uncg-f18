package assignment2_q1;

/**This question refers to the multiplication of two matrices A and B.
 *
 * The product of A and B, assuming A is a x b and B is b x c will
 * have dimensions of a x c. B's rows MUST equal A's columns in order
 * for matrix multiplication to work.
 * 
 * @author Joshua Crotts
 */
public class Assignment2_Q1 {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{7, 8}, {9, 10}, {11, 12}};
        int[][] matrix = matrixMultiply(a, b);
        printMatrix(matrix); System.out.println("");

        int[][] c = {{2, 3, 1}, {2, -7, 4}};
        int[][] d = {{3, 4, 5}, {1, 1, 4}, {2, 1, 4}};
        int[][] matrix_two = matrixMultiply(c, d);
        printMatrix(matrix_two); System.out.println("");

        int[][] e = {{3, 4, 2}};
        int[][] f = {{13, 9, 7, 15}, {8, 7, 4, 6}, {6, 4, 0, 3}};
        int[][] matrix_three = matrixMultiply(e, f);
        printMatrix(matrix_three); System.out.println("");
    }

    /**
     * Method to multiply two 2D integer arrays
     * The row amt for B must equal the column amt for A. In other words:
     * A[0].length == b.length;
     * 
     * @param a - first 2D integer array
     * @param b - second 2D integer array
     * @return a 2D integer array containing the product of the two arrays
     */
    public static int[][] matrixMultiply(int[][] a, int[][] b) {
        if (b.length != a[0].length) {
            throw new IllegalArgumentException("B's rows must equal A's columns");
        }

        //Creates a new array using the rows of A and columns of B
        int[][] result = new int[a.length][b[0].length];

        //We iterate over the rows of a, then columns of B, then 
        //create a temporary variable that both arrays share,
        //since the formula is C[i][j] = sumOf(a[i][k] * b[k][j])
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    /**
     * Prints a 2D integer matrix 
     * @param arr 2D integer array
     */
    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
