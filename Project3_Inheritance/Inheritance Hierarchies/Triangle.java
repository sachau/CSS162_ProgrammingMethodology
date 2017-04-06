import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Program will create an equilateral triangle. It can also calculate the area of the triangle and the perimeter
 * 
 * Author:          Sandy Chau
 * Assignment:      Homework 3 
 */
public class Triangle extends Shape
{
    private int a = 0;// length of the side
    private double area = 0;
    private int perimeter = 0;

    //Constructor
    public Triangle( int x, int y, int newA) {
        super (x, y);

        setSides(newA);
        setPerimeter();
        setArea();

    }

    /**
     * Description: Gets the area of the triangle
     * @return area
     */
    @Override
    public double getArea(){ 
        return area;
    }

    /**
     * Description: Sets the area of the Triangle using the Heron's formula
     */
    public void setArea(){ 
        double p = (double)perimeter / 2;

        double tempVal = p * (p - a) * (p - a) * (p - a) ;

        area = Math.sqrt(tempVal);
    }

    /**
     * Description: Draws the triangle using three lines
     * @param Graphics g
     */
    @Override
    public void draw( Graphics g) {
        int x = getX();
        int y = getY();

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor( Color.BLACK );//sets the color to black

        g2d.draw(new Line2D.Double(x, y, x + a, y + a));// right side of triangle
        g2d.draw(new Line2D.Double(x - a, y + a, x + a, y + a));//base of triangle
        g2d.draw(new Line2D.Double(x, y, x - a, y + a));//left side of triangle 
    }

    /**
     * Description: Sets the sides of the triangle and since it is a equilateral triangle, all sides are the same length
     * @param int newA
     */
    public void setSides(int newA){
        if( newA > 0 ){
            a = newA;
        }
    }

    /**
     * Description: Gets the side length
     * @return a 
     */
    public int getSides(int newA){
        return a;
    }

    /**
     * Description:  Calculates the perimeter of the triangle and sets it
     * 
     */
    public void setPerimeter(){
        if(a > 0 ){
            perimeter = 3 * a;// Formula for the perimeter is a + b + c
        }
    }

    /**
     * Description: Gets the perimeter of the triangle 
     */
    public int getPerimeter(){
        return perimeter;
    }
}
