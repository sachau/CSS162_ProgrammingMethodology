import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;


/**
 * Program will create a cube by drawing two squares(using the side length passed in) and four lines
 * 
 * Author:          Sandy Chau
 * Assignment:      Homework 3 
 */
public class Cube extends Shape
{

    private int side  = 0;
    private int volume = 0;
    
    //Construtor
    public Cube( int a, int b, int s) {

        super (a, b);
        setSide(s);
        setVolume();

    }
    
    /**
     * Description:  Gets the volume of the cube
     */
    public double getVolume(){ 
        return volume;
    }

    /**
     * Description:  Calculates and sets the volume of the cube using the formula for finding the volume of a cube
     *               which is volume = length * heigth * width 
     */
    public void setVolume(){ 
        volume = side * side * side;
    }

    /**
     * Description:  Draws a cube by drawing two squares and four lines connecting the corners 
     */
    @Override
    public void draw( Graphics g) {
        int x = getX();
        int y = getY();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor( Color.BLUE );//Sets the outline to blue
        
        //Draws rhe two two squares 
        g2d.draw(new Rectangle2D.Double(x + (side/2), y + (side/2), side, side));
        g2d.draw(new Rectangle2D.Double(x, y, side, side));
        
        //Draws the four lines connecting the corners to make it into a cube
        g2d.draw(new Line2D.Double(x, y, x + (side/2), y + (side/2)));
        g2d.draw(new Line2D.Double(x + side, y + side, x + (side) + (side/2), y + (side)+ (side/2)));
        g2d.draw(new Line2D.Double(x, y + side, x + (side/2), y + side + (side/2)));
        g2d.draw(new Line2D.Double(x + side, y, x + side + (side/2), y + (side/2)));
    }

    /**
     * Description: Sets the side length of the cube
     * @param int s 
     */
    public void setSide(int s){
        if(s > 0){
            side = s;
        }
    }

    /**
     * Description: Gets the side length
     * @return int side
     */
    public int getSide(){
        return side;
    }
}
