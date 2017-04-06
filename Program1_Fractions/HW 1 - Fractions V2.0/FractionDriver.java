
/**
 * Author:  Sandy Chau
 * Class:   Rob Nash CSS 162
 * Title:   Homework 1
 * 
 * Description: This is the driver that will call functions from other classes and print the output. The output is a list
 *              of fractions that have been reduced and it will show how many times that specific fraction showed up.  
 * 
 */
public class FractionDriver
{
    public static void main(String[] args){        
        CreateFractionList fractionsList = new CreateFractionList();//Creates a new list of fractions
        int[] numerators = fractionsList.numeratorList(); // Gets the list of numerators
        int[] denominators = fractionsList.denominatorList();//Gets the list of denominators
     
        int size = numerators.length;//Sixe of the array
        int trueSize = 0;//the real size of the list of fractions without duplicates
                
        String[] list = new String[size];//List of all the fractions
        String[] listOfFractions = new String[size];//List of the unigue fractions
        int[] counts = new int[size];//List of the counts relating to the fractions
        
        String firstFraction;//unique fraction
        String secondFraction;//target fraction used to see if there are similar fractions


        for(int i = 0; i < size; i++){
            
            Fraction theFraction = new Fraction(numerators[i], denominators[i]);//Passes a numerator and denominator
            
            firstFraction = theFraction.getWholeFraction();//Gets the fraction as a string
            
            FractionCounter targetFraction = new FractionCounter(firstFraction);//passes a string

            list[i] = firstFraction;//puts the fraction in a string list of fractions
            
            //Creates a new fraction to be compared to the first fraction
            for(int a = 0; a < size; a++){
                Fraction newFraction = new Fraction(numerators[a], denominators[a]);//passes in a new fraction
                secondFraction = newFraction.getWholeFraction();//changes fraction into a string
                targetFraction.compareAndIncrement(secondFraction);//compares and increases the count if it is the same

                counts[i] = targetFraction.getCounts();//gets the count
            }

        }
        
        
        //Sees if there are duplicates in the list of fractions 
        for(int i = 0 ; i < size; i++){

            int num = matchingFractions(listOfFractions, list[i]);
            //If there isn't a duplicate, add the fraction to a new list and keeps track of number of fractions
            if( num == -1){

                listOfFractions[trueSize] = list[i];             
                System.out.println(list[i] + " has a count of: " + counts[i]);//prints out the fractions
                
                trueSize += 1;// keeps track of the size of offical list

            }

        }

    }

    /**
     * Description: Sees if a fraction is matching to make sure duplicates are not printied out
     * @param: String[] a, String target
     * @return -1 which means there is not matching, 1 which means it is matching
     */

    public static int matchingFractions(String[] a, String target){

        for (int i = 0; i < a.length; i++){

            if(target.equals(a[i])){
                return 1;
            }

        }

        return -1;

    }
}
