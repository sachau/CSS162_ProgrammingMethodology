
/**
 * This program searches for a word in a list of words by taking in a word and the list.
 * The program does a binary search recursively by using a helper method that contains parameters that are used to 
 * make the method able to run recursively as there cannot be changes to the driver. 
 * 
 * @Author: Sandy Chau
 * @Assign: Homework 5
 */
public class BinarySearch extends SearchAlgorithm
{
    /*
     * Define: Overrides the search method in the SearchAlgorithm class. It takes in a list of words and the word to be found.
     * It then figures out the high, low, and mid index and calls the helper class using these numbers.
     * 
     * @param String[] words, String wordToFind
     * @return return searchHelp(words, wordToFind, high, low, mid) which would be a number
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException{
        int high = words.length - 1;//index at the end of the list
        int low = 0;//beginning of the list
        int mid =  high / 2;// the middle of the list

        return searchHelp(words, wordToFind, high, low, mid);

    }

    /*
     * Define: This method will take in a list of words, the word wanting to be found, and three numbers. The three numbers indicate where the method
     *         should compare for the words. The mid number indicates the location at where the word to compare to which is found by finding the middle 
     *         of the high and low number.
     * 
     * @param String[] words, String wordToFind, int high, int low, int mid
     * @return return searchHelp(words, wordToFind, high, low, mid) or midIndex
     *         it either calls itself again or return a number at which the word was found,
     *         or it throws an exception
     */
    public int searchHelp(String[] words, String wordToFind, int high, int low, int mid) throws ItemNotFoundException{
        int lowIndex = low;//index at the low end       
        int highIndex = high;//index at the high end
        int midIndex = mid;//mid point
        
        //Takes care of the stackoverfull problem when the item is not found
        if(highIndex < lowIndex){
            throw new ItemNotFoundException();// if not found throw exception
        }
        //if the word is equal to the word at the midpoint
        else if(wordToFind.equals(words[midIndex])){
            incrementCount();//add one to count
            return midIndex;// return the index at the midpoint
        }
        //If the word is before the midpoint
        else if(wordToFind.compareTo(words[midIndex]) < 0){
            highIndex = midIndex - 1;// the high point becomes the midpoint - 1
            midIndex = ((highIndex - lowIndex) / 2) + lowIndex;//calculates the mid point
            incrementCount();//add one to count
            return searchHelp(words, wordToFind, highIndex, lowIndex, midIndex);//calls the method again//add one to count

        }
        //If the word is after the midpoint 
        else if(wordToFind.compareTo(words[midIndex]) > 0){
            lowIndex = midIndex + 1;//low point becomes the mid -1
            midIndex = ((highIndex - lowIndex) / 2) + lowIndex;//calculates the mid point
            incrementCount();//add one to count
            return searchHelp(words, wordToFind, highIndex, lowIndex, midIndex);//calls method again//add one to count
        } 

        throw new ItemNotFoundException();//if not found throw exception

    }

}