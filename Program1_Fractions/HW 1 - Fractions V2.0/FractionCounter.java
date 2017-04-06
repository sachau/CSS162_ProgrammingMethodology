

/**
 * Author:  Sandy Chau
 * Class:   Rob Nash CSS 162
 * Title:   Homework 1
 * 
 * Description: This Class compares one fraction to another and keeps track of how many times the fraction shows up
 * 
 */
public class FractionCounter
{
    Fraction allFractions = new Fraction();// Gets access to the fraction class
    private int count = 0;//total numer of times the fraction shows up
    private int numerator;
    private int denominator;
    private String fraction;//fraction as a string 

    FractionCounter(String theFraction){
        fraction = theFraction;       
    }
    
    /**
     * Description: compares one fraction to another and keeps track of the number of times the fraction is shown
     * @param  String newFraction the target fraction
     * @return true or false
     */
    public boolean compareAndIncrement(String newFraction){
        if(fraction.equals(newFraction)){
            count++;
            return true;
        }
        
        return false;
    }
    
    /**
     * Description: Gets the number of counts the fraction shows up
     * @return int count
     */
    public int getCounts(){
        return count;
    }

}
