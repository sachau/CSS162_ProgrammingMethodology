
/**
 * This program will take in a list and a word and search through the list one word at a time to look for a match
 * 
 * @author Sandy Chau
 * @assign Homework 5
 */
public class LinearSearch extends SearchAlgorithm
{
   /*
     * Define: This method will take in a list of words, the word wanting to be found. It would then go through the
     *         list one word at a time to find a match to the word passed in. it will also keep track of how
     *         many times it compared words.
     * 
     * @param String[] words, String wordToFind, 
     * @return return retVal, index where the word was found
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException{
        
        int retVal = -1;//initalize retVal to -1 
        //Checks every word in the list
        for(int i = 0; i < words.length; i ++){
            
            //if the word is found
            if(wordToFind.equals(words[i])){
                retVal = i;//make retVal equal to the index at which the word is found 
                i = words.length + 1;//breaks out of loop when it finds the word
            }
            
            incrementCount();//keep track of how many times word was compared
            
        }
        
        //if word was not found, throw exception
        if(retVal == -1){
            throw new ItemNotFoundException();
        }
        
        return retVal;//return the index 
    }
}
