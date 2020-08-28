package question6;

/**
 * Question 6 demonstrates an iterative solution to figuring out the area of a
 * circle without Calculus or A = PI*r*r.
 *
 * Rectangles are generated under the top-right quadrant of the circle (1/4th)
 * with a width marked by a precision value (the smaller they are, the more
 * accurate the area will be to the true value). This value is then multiplied
 * by 4 to get the entire area.
 *
 * @author Joshua Crotts
 */
public class Question6 {

    public static void main(String[] args) {

        System.out.println("R = 1, Actual area: " + (Math.PI * 1 * 1) + ", Calculated Area: " + calcArea(1, 0.0001));
        System.out.println("R = 10, Actual area: " + (Math.PI * 10 * 10) + ", Calculated Area: " + calcArea(10, 0.00001));
        System.out.println("R = 100, Actual area: " + (Math.PI * 100 * 100) + ", Calculated Area: " + calcArea(100, 0.00001));
        System.out.println("R = 1000, Actual area: " + (Math.PI * 1000 * 1000) + ", Calculated Area: " + calcArea(1000, 0.00001));
        System.out.println("R = 23, Actual area: " + (Math.PI * 23 * 23) + ", Calculated Area: " + calcArea(23, 0.00001));
        System.out.println("R = 5, Actual area: " + (Math.PI * 5 * 5) + ", Calculated Area: " + calcArea(5, 0.00001));
        System.out.println("R = 345, Actual area: " + (Math.PI * 345 * 345) + ", Calculated Area: " + calcArea(345, 0.00001));
        System.out.println("R = 0.5, Actual area: " + (Math.PI * 0.5 * 0.5) + ", Calculated Area: " + calcArea(0.5, 0.00001));
        System.out.println("R = 43, Actual area: " + (Math.PI * 43 * 43) + ", Calculated Area: " + calcArea(43, 0.00001));
        System.out.println("R = 200, Actual area: " + (Math.PI * 200 * 200) + ", Calculated Area: " + calcArea(200, 0.00001));

        //As demonstrated, if the value of R is huge, it's worthwhile to make the precision value > 0
        System.out.println("R = 158000, Actual area: " + (Math.PI * 158000 * 158000) + ", Calculated Area: " + calcArea(158000, 10));

        System.out.println("\n\nDemonstration of Precision Gain As P -> 0 With r = PI:");

        for (double i = 1; i >= 0.00001; i *= 0.1) {
            System.out.println("Actual area: " + Math.PI + ", Calculated Area with Precision of " + (Math.round(i * 100000.0) / 100000.0) + ": " + calcArea(1, i));
        }
    }

    /**
     * calcArea iteratively calculates the area of a quarter of a circle given
     * the radius through rectangles with a specified precision "p", area is
     * equal to this quarter_area * 4.
     *
     * @param r radius of circle
     * @param p precision value, the width of each rectangle, range 0 < p < 1,
     * the closer to 0, the more accurate the area calculation will be. @return
     * calculated area
     */
    public static double calcArea(double r, double p) {
        if (r <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        double y = 0; //y is the top-right position of each rectangle; a point on the circles
        double increment = p; //Precision value, also width of rectangles

        double area = 0.0; //Accumulating area of each rectangle
        for (double x = 0; x < r; x += increment) {
            /*
            Through each iteration, x is being incremented by our precision value;
            it marks the width of each rectangle created as aforesaid. The lower
            it is, the higher the precision of the calculated area. 
            
            x^2 + y^2 = r^2, since x and r are known, y can be solved for.
             */
            y = Math.sqrt(r * r - x * x);
            area += (increment) * y; //l * w = formula for rectangle
        }
        return area * 4;
    }
}
