import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author:  Sandy Chau
 * Class:   Rob Nash CSS 162
 * Title:   Homework 0
 * 
 * Description: Program will read in a list of fractions, determind if there are duplicates and keep track of the
 *              number of times a fraction shows up, then print out the results
 *              
 * Questions: 
 * Can you complete this without using arrays? What is the least number of variables you can use to solve this problem?
 *      Possibly, but I found using arrays to be the easiest. I think 3 variables: the List of fractions read in from the file, a new
 *      list to sort out the duplicates, and the number of counts of each fraction
 * Can you use just one array to solve this? What would the data type be of that array?
 *      I suppose it is possible, using a String array
 * Can you nest* one class (data type) within another, like we observe with nested loops? What is an example of this? (*compose)
 *     Yes? You can use another class when in another class. For example we are able to use the Scanner class after importing it
 *     in our classes. Not sure if that's considered nesting classes
 * What are some solutions to the reduction problem other than Euclid's GCD algorithm?
 *      Finding the decimal value ex: 2/4 = .5 and 3/6 = .5
 *      
 * 
 */
public class FractionsV1
{
    public static void main(String[] args){

        Scanner fractionList = null;        
        String[] allFractions = new String[100];
        String[] fractions = new String[100];
        int total = 0;//Total number of fractions
        int trueSize = 0;//number of fractions not including the duplicates
        
        //Tries to read in file
        try{
            fractionList = new Scanner (new FileInputStream("fractions.txt"));

        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        
        
        //Creates a list of all the fractions from the file 
        while(fractionList.hasNextLine()){
            allFractions[total] = fractionList.nextLine();
            total +=1; 

        }
        
        
        //Tries to see if there are duplicates in the list of fractions, if there is, ignore it,
        //if there isn't a duplicate, add the fraction to a new list
        for(int i = 0 ; i < total; i++){
            int num = matchingFractions(fractions, allFractions[i]);
            
            //If there isn't a duplicate, add the fraction to a new list and keeps track of number of fractions
            if( num == -1){
                fractions[trueSize] = allFractions[i];
                trueSize += 1;
            }

        }
        
        //Count how many times a fraction shows up and prints the fraction as well as the count
        for(int i = 0; i < trueSize; i++){
            int count = 0;

            for(int a = 0; a < total; a++){
                if (fractions[i].equals(allFractions[a])){
                    count++;
                }
            }
            
            System.out.println(fractions[i] + " has a count of " + count );

        }

    }
    
    /**
     * Description: Sees if a fraction is matching
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
