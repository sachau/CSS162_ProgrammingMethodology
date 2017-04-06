import java.awt.*;
import java.awt.geom.Rectangle2D;


/**
 * Program will create a rectangle using sides lengths passed in 
 * 
 * Author:          Sandy Chau
 * Assignment:      Homework 3 
 */
public class Rectangle extends Shape
{

    private int side = 0;
    private int side2 = 0;
    private int area = 0;
    
    //Constructor 
    public Rectangle( int a, int b, int s, int s2 ) {

        super (a, b);
        setSide(s, s2);
        setArea();

    }
    
    /**
     * Description:  Gets the area of the rectangle
     * @return int area
     */
    @Override
    public double getArea(){ 
        return area;
    }

    /**
     * Description: Calculates the area of the rectangle
     */ 
    public void setArea(){ 
        area = side * side2;
    }
    
    /**
     * Description:  Draws the rectangle with the side passed in 
     * @Param Graphics g
     */
    @Override
    public void draw( Graphics g) {
        int x = getX();
        int y = getY();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor( Color.RED );
        
        g2d.draw(new Rectangle2D.Double(x, y, side, side2));
    }

    /**
     * Description:  Sets the sides of the rectangle 
     */
    public void setSide(int s, int s2){
        if(s > 0){
            side = s;
            side2 = s2;
        }
    }
    
}
