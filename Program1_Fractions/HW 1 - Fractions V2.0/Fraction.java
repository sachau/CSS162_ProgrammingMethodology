

/**
 * Author:  Sandy Chau
 * Class:   Rob Nash CSS 162
 * Title:   Homework 1
 * 
 * Description: This Class seperates the numerator and denominator to have it used to count up the fractions.      
 *              The fraction is passsed through from the driver and a numerator and denominator is returned
 * 
 */
public class Fraction
{
    
    private int newNumerator;
    private int newDenominator;
        
    //Constructor
    public Fraction(){       
        
    }

    //Constructor that sets the numerator and denominator
    public Fraction(int top, int bottom){
        setNumerator(top);
        setDenominator(bottom);
        
    }
    
    
    /**
     * Description: compares one fraction to another
     * @param  object target
     * @return true or false
     */
    @Override 
    public boolean equals(Object target){
        Fraction that = (Fraction)target;

        return this.newNumerator == that.newNumerator && this.newDenominator == that.newDenominator;
    }

    public int getNumerator(){
        return newNumerator;
    }

    public int getDenominator(){
        return newDenominator;
    }
    
    /**
     * Description: Sets the interger passed in to one used in this class
     * @param  int n
     * @return the numerator as an int
     */
    public int setNumerator(int n){
        newNumerator = n;
        return newNumerator;
    }
    
    /**
     * Description: Sets the interger passed in to one used in this class
     * @param  int d
     * @return the denominator as an int
     */
    public int setDenominator(int d){       
        newDenominator = d;
        return newDenominator;
    }
    
    /**
     * Description: My version of the toString method
     * @return a String containing the fraction
     */
    public String getWholeFraction(){
        String theFraction = newNumerator + "/" + newDenominator;
        return theFraction;
    }

}
