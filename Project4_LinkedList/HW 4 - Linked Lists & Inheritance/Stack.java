
/**
 * Description:  This is a Stack that uses method in the LinkedList class. This program will add to the head and remove from the head.
 *               This creates the first in last out effect.
 * 
 * @author:      Sandy Chau 
 * @assignment:  Homework 4
 */
public class Stack extends LinkedList
{
     /**
     * Description: Method that uses the insert method in LinkedList to add an object to the head of the list
     *              by setting indext to 0. This makes the list be pushed to the right as more items are added
     * @param Object data
     */
    public void push(Object data){
        super.insert(data,0);
    }
    
     /**
     * Description: This method removeds from head as well by using the remove method in LinkedList and setting the 
     *              index as 0
     */
    public Object pop(){
        
        return super.remove(0);
    }
    
    //Tester
    public static void main(String[] args){
        Stack a = new Stack();

        a.push('a');
        a.push('b');
        a.push('c');


        System.out.print(a.pop());
        System.out.print(a.pop());
        System.out.print(a.pop());
    }

}
