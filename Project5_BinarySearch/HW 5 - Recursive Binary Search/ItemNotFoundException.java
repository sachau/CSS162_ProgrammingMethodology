

/**
 *Exception class to show message when a word is not found in list
 * 
 * @author (Sandy Chau
 * @Assign: Homework 5
 */
public class ItemNotFoundException extends RuntimeException
{

        //Takes in a String message and uses it as the error message
        public ItemNotFoundException(String msg){
            super(msg);
        }

        public ItemNotFoundException(){
            super("Word was not found in list");
        }
    
}
