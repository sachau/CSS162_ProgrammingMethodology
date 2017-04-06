import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

/**
 * Author:  Sandy Chau
 * Class:   Rob Nash CSS 162
 * Title:   Homework 1
 * 
 * Description: This creates a list of fractions that is read into from a file. It then finds the Greatest common denominator to simplify the fraction. 
 *              The fraction is separated by nuemrators and denominators
 * 
 */
public class CreateFractionList
{
    private int[] numerator;
    private int[] denominator;
    private int counter = 0;//size of the fraction list
    private int[] commonDenominators;//Greates common denominator

    /**
     * Description: constructor that creates the list of numerators and denominators as well as the list of greates common denominators
     */
    public CreateFractionList(){
        counter();//gets the count to get the size of the list of fractions

        numerator = new int[counter];
        denominator = new int[counter];
        commonDenominators = new int [counter];

        createList();//creates the list
        reducedFractions();//reduces the fraction


    }

    /**
     * Description: Counter that gets the exact size of the fraction list with duplicates included
     */
    private int counter(){
        Scanner a = null;

        try{
            a = new Scanner (new FileInputStream("fractions.txt"));

        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        while(a.hasNextLine()){
            counter++;
            a.nextLine();
        }

        return counter;

    }

    /**
     * Description: Reduces the fractions by dividing them by their greatest common denominator gotten from the numerators and denominators
     */
    private void reducedFractions(){
        for(int i = 0; i < counter; i++){

            numerator[i] = (numerator[i] / commonDenominators[i]);
            denominator[i] = (denominator[i] / commonDenominators[i]);

        }

    }

    /**
     * Description: Creates the full list of fractions
     */
    private void createList(){
        Scanner fractionList = null;

        //Tries to read in file
        try{
            fractionList = new Scanner (new FileInputStream("fractions.txt"));

        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        
        //Puts a numerator and a denominator in the list 
        for(int i = 0; i < counter; i++){
            String wholeFraction =  fractionList.nextLine();//reads in first fraction as a string
            String delimiter = "/\\n";//uses these delimiter
            StringTokenizer newFraction = new StringTokenizer(wholeFraction,delimiter);
            String top = newFraction.nextToken();//first token is the numerator
            int a = Integer.parseInt(top);//changes it into an integer
            numerator[i] = a;
            String bottom = newFraction.nextToken();//next token is the denominator
            int b = Integer.parseInt(bottom);//changes it into an interget
            denominator[i] = b;

        }

        findGCD();//calls function to find the greatest common denominator

    }
    
    /**
     * Description: Finds the greatest common denominator by dividing a number into both the numerator and denominator.
     *              If both answers results in a 0 in remainder then it is a common denominator
     */
    private void findGCD(){
        int GCD = 0;//common denominators
        int higherNumber = 0;//the greates one or higher one

        for(int i = 0; i < counter; i++){
            //if the denominator is a 0 return a 1 so that it will not divide by 0
            if (denominator[i] == 0){
                higherNumber = 1;
            }else if//checks to see if either the numerator or denominator is greater 
            (numerator[i] > denominator[i]){
                higherNumber = numerator[i];
            }
            else {
                higherNumber = denominator[i];
            }
            
            //uses the higher number from denominators and numerators to find the greatest common denominator
            for (int a = 1; a <= higherNumber; a++){
                //if there is a remainder of 0 then it is a common denominator, increases to find the greatest one
                if (numerator[i]%a == 0 && denominator[i]%a == 0){
                    GCD = a;

                }
            }

            commonDenominators[i] = GCD;

        }


    }
    
    /**
     * Description: Gets the numerator
     */
    public int[] numeratorList(){
        return numerator;
    }
    
    /**
     * Description: Gets the denominator
     */
    public int[] denominatorList(){
        return denominator;
    }

}
