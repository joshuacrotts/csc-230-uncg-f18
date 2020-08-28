package assignment4_q1;

import java.awt.Color;

/**
 * This class represents a generic Shape to-be extended for
 * any other subcategories of a Shape.
 * 
 * @author Joshua Crotts
 * @date October 9, 2018
 */
public abstract class Shape {
    
    private Color color;
    
    public Shape(Color c){
        this.color = c;
    }
    
    /**
     * Abstract method to be implemented by a shape since
     * Shape is generic.
     * @return double value of area
     */
    public abstract double getArea();
    
    /**
     * 
     * @return String representation of Shape, printing
     * color.
     */
    @Override
    public String toString(){
        return "Shape color: "+this.color;
    }
}
