package question7;

/**
 * This class uses the Monte Carlo method of approximating PI:
 *
 * A circle is placed at (0,0) and points between [-1, 1) are generated
 * randomly. PI is approximated by calculating the ratio between points located
 * inside the circle vs outside the circle. Obviously, more points connotes
 * higher accuracy.
 *
 * @author Joshua Crotts
 * @date 8/26/18
 */
public class Question7 {

    public static void main(String[] args) {

        //Accuracy increases as # of points increases tenfold
        for (int i = 10; i <= 100000000; i *= 10) {
            System.out.println("Actual PI: " + Math.PI + "\nCalculated PI with " + i + " points: " + piApproximation(i));
        }
    }

    /**
     * Method generates points in a range of [-1, 1) and determines whether or
     * not they are in a circle with origin 0,0 and radius of 1.
     *
     * @param points essentially accuracy; how precise we want pi to be.
     * @return PI approximation
     */
    public static double piApproximation(double points) {
        int pointsInCircle = 0;
        int pointsTotal = 0;

        for (int i = 0; i < points; i++) {
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;
            //Distance formula sqrt((x - 0)^2 + (y - 0)^2), origin = 0,0
            if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) < 1) {
                pointsInCircle++;
            }

            pointsTotal++;

        }
        return 4 * ((double) pointsInCircle / pointsTotal);
    }
}
