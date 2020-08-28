package assignment4_q1;

import java.awt.Color;

/**
 * This class represents a Rectangle with the width
 * and height.
 * 
 * @author Joshua Crotts
 * @date October 9, 2018
 */
public class Rectangle extends Shape{
    private double width;
    private double height;
    
    public Rectangle(Color c, double w, double h){
        super(c);
        this.width = w;
        this.height = h;
        
    }
    
    /**
     * Calculates area of rectangle
     * @return width * height
     */
    @Override
    public double getArea(){
        return this.width * this.height;
    }
    
    /**
     * 
     * @return String representation of Rectangle, prints out color
     * width and height.
     */
    @Override
    public String toString(){
        return super.toString() + ", width: "+this.width+", height: "+this.height;
    }
    
}
