
/**
 * Description: This is the super class that has the methods insert and remove that can be used on lists.
 *              It also has a toString and size function. This program allows for the user to create a list of objects
 *              using nodes. The insert function allows for nodes to be inserted at any point and the remove function
 *              also allows for removal of nodes at any point. It is a list program that uses nodes instead of arrays.
 * 
 * @author:      Sandy Chau 
 * @assignment:  Homework 4
 */
public class LinkedList
{
    Node head = null;//Declears a node that is null, no object or link
    int size = 0;// keeps track of the size of the list
    
     /**
     * Description: This function takes in an object and outs the object at the head of the list
     * @param: Object data
     */
    public void append(Object data){
        insert(data,0);
    }
    

    /**
     * Description: This function takes in an object and an index to create a node containing the object while connecting it
     *              at the location given by the index. For example if the index is 0, a node is created at head and it will 
     *              then be linked to the rest of the list. If the index is greater than 0, it will always be added to the 
     *              tail of the list
     * @param: Object data, int index
     */
    public void insert(Object data, int index){
        //if the list is empty, the head would be null therefore a node is inserted at the beginning and connected to head which is null
        if(head == null){
            head = new Node(data,head);
            size++; //Increases the size of the list
        }
        //If size equals 1, it means that there is only one node in the list therefore anything added is in the head or tail
        //if the size is not 1 but the index is 0, the new node would still be added to the head
        else if(size == 1 || index == 0){
            //If there is only one object existing and the index is 0, the new object will be added to the head
            //If the index is 0, no matter the size, it will be added to the head
            if(index == 0){
                Node prev = head;
                head = new Node(data, prev);
                size++;//Increases the size of the list
            }
            //If there is only one object but the index is higher than a 0, the Object will be added onto the end
            //or the "tail" regardless of the index number
            else{
                head.next = new Node(data, null);
                size++;//Increases the size 
            }

        }
        //If the size is bigger than 2 and the index isn't 0, the program has to figure out where to put the node
        else if(size >= 2 && index <= size){
            int i = 0;//keeps track of which index the current node is at
            Node prev = null;//keeps track of the previous node

            Node current = head;// the current node that will go through the list until it reached the index

            //Helps the current node go through the list until it reaches the index
            while(i < index ){
                prev = current;//keeps track of the node before the current
                current = current.next;

                //Break out of the loop if current is null,which means it is the end of list
                if(current == null){
                    i = index;
                }

                i++;//increases to make sure it doesn't reach the index
            }

            //Creates a new node that contains the object passed in and connects to the node after it in the list
            Node newNode = new Node(data, current);
            prev.next = newNode;//makes the node before the new node connebt to it

            size++;//Increases the size 

        }else{
             //If the index is outside of the size, it cannot add it
            throw new ListException("Error when trying to insert to list");
        }
    }

    /**
     * Description: This function takes in an index to remove the node from the list. It will then return the object in the node
     *              that was removed but does not return the refrence
     * @param: int index
     * @return: Object retVal - the Object that was in the node that was removed
     * 
     */
    public Object remove(int index){
        Object retVal = null;//declears the object that will be returned

        //If the head is null that means there is an empty list therefore a nodes cannot be removed
        if(head == null){
            throw new ListException("List is empty therfore cannot delete from it");
        }
        //If the size is 1, can only delete from the head 
        else if(size == 1 ){

            retVal = head.data;
            head = null;//causes the head to become null and the list is empty
            size--;//decreases the size of the list

        }
        //if the list is greater than 1, need to decided where to delete the node depending on the index
        //unless the index is greater than the size of the list, it will create an error
        else if(size >= 2 && index < size){
            //Declears nodes to travel through the list to find the node at the index
            Node prev = null;
            Node current = head;
            int i = 0;

            //if the index is 0, delete from the head
            if(index == 0){
                retVal = head.data;
                head = head.next;//causes head to be next in line 
                size--;//decreases size
            }
            else {

                //find the node at the index 
                while(i < index){
                    prev = current;
                    current = current.next;                    
                    i++;
                }

                retVal = current.data;//Saves the data at the current node

                //If node after current isn't null, move the leash
                if(current.next != null){
                    prev.next = current.next;
                }
                //otherwise it deletes from the tail
                else{

                    prev.next = null; // If there is no more nodes, set next node to null to delete the last node or "tail"

                }

                size--;//decreases size

            }
        }else{
            //If the index is outside of the size, it cannot delete it
            throw new ListException("Error when trying to remove from list");
        }

        return retVal;
    }

    /**
     * Description: Gives the size of the list
     * @return: int size
     * 
     */
    public int size(){
        return size;
    }

    /**
     * Description: Gives all of the data in the list
     * @return: String retVal which is all the data in the list as a string
     * 
     */
    @Override
    public String toString(){
        String retVal = "";
        Node current = head;
        //if the current is null that means an empty list, print out nothing
        if (current == null){
            System.out.print("");
        }else{
            //Print out each object in nodes while there is still an object
            while(current != null ){
                retVal = retVal + current.data;
                current = current.next;
            }
        }
        return retVal;

    }
    
    /** 
     * Description: If size is 0, the list is empty
     * @return true or false
     */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    /**
     * Description: Node class that has an object and a refrence to the next node 
     */
    private class Node{
        private Object data; 
        private Node next;
        
        //Constructor that create null object and node
        public Node(){
            data = null;
            next = null;
        }
        
        //Constructor that takes in an object and node to set the variables
        public Node(Object newItem, Node linkValue){
            data = newItem;
            next = linkValue;
        }

    }

    /**
     * Description: Creates the error messages
     */
    public class ListException extends RuntimeException{
        
        //Takes in a String message and uses it as the error message
        public ListException(String msg){
            super(msg);
        }

        public ListException(){
            super("Error in List");
        }
    }

}
