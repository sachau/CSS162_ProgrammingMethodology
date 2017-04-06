
/**
 * Description: This is a Queue that uses the methods in LinkedList. Insead of being able to insert and 
 *              remove at any place, it inserts in the tail and removes from the head
 * @author:      Sandy Chau 
 * @assignment:  Homework 4
 */
public class Queue extends LinkedList
{
     /**
     * Description: Adds an object to the tail using the insert method in LinkedList 
     * @param Object data
     */
    public void enqueue(Object data){
        int index = super.size + 1;//Makes the index at the end
        super.insert(data,index);//uses the insert method to put object at the tail of the list
    }

     /**
     * Description: Deletes from the head using the remove method in LinkedList
     * @return data value at head of the list 
     */
    public Object dequeue(){
        return super.remove(0);
    }

    //Tester
    public static void main(String[] args){
        Queue a = new Queue();

        a.enqueue('a');
        a.enqueue('b');
        a.enqueue('c');

        System.out.print(a.dequeue());
        System.out.print(a.dequeue());
        System.out.print(a.dequeue());
    }

}
