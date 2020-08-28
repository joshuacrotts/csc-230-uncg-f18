package assignment4_q1;

import java.awt.Color;

/**
 * This class represents a Triangle with a base and height
 * that extends Shape
 * 
 * @author Joshua Crotts
 * @date October 9, 2018
 */
public class Triangle extends Shape{
    private double base;
    private double height;
    
    public Triangle(Color c, double b, double h){
        super(c);
        this.base = b;
        this.height = h;
    }
    
    /**
     * Returns double representation of area
     * @return area 0.5 * base * height
     */
    @Override
    public double getArea(){
        return 0.5 * base * height;
    }
    
    /**
     * 
     * @return String representation of Triangle,
     * printing the color, base and height
     */
    @Override
    public String toString(){
        return super.toString() + ", base: "+base+", height: "+height;
    }
}
