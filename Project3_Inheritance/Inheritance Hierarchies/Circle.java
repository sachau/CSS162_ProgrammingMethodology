import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * This program will draw a circle with a radius that is passed in.
 * 
 * Author:          Sandy Chau
 * Assignment:      Homework 3 i
 */
public class Circle extends Shape
{

    private int radius = 0; // initalized radius
    private double area = 0; // initalized area 

    //Construtor
    public Circle( int a, int b, int newRadius ) {

        super (a, b);
        setRadius(newRadius);
        setArea();

    }

    /**
     * Description:  Gets the area of the circle
     * @return double area
     */
    @Override
    public double getArea(){ 
        return area;
    }

    /**
     * Description:  Calculates the area of the circle using the formula
     *               PI * radius^2
     */
    public void setArea(){ 
        area = 3.14 * radius * radius;
    }

    /**
     * Description:  Draws the circle
     * 
     */
    @Override
    public void draw( Graphics g) {
        int x = getX();
        int y = getY();

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor( Color.GREEN);//Sets the outline to be green

        g2d.draw(new Ellipse2D.Double(x, y, radius, radius));
    }

    /**
     * Description:  Sets the radius 
     */
    public void setRadius(int r){
        if(r > 0){
            radius = r;
        }
    }

    /**
     * Description:  Gets the radius 
     * @return int radius
     * 
     */
    public int getRadius(){
        return radius;
    }
}
