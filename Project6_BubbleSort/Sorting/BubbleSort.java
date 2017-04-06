
/**
 * Description:
 * The BubbleSort takes in an array of numbers and sorts them in ascending order. This is done by
 * comparing the first two numbers, switching them if the second number is less than the first number, 
 * then moving to the second and third number and comparing them, again switching the numbers if the first number is less than the second number.
 * The comparison is done until the end of the array and then repeated starting from the second number. This is repeated 
 * until the all the numbers are in ascending order.
 * 
 * @author: Sandy Chau 
 * @assignment: Homework 6
 * @class: CSS 162
 * @date: 3/6/2014
*/
public class BubbleSort extends Sort
{
    @Override
    /*
     * Description: This will sort the numbers in ascending order by using two loops. The other loop keeps track
     * of the the amount of time the program has to compare the numbers and the inner loop keeps track of the 
     * two numbers being compared to each other
     * @param: int[]data, int first, int last
     */
    public void sort(int[] data, int first, int last){
        //Outter loop that repeats until it reaches the last number
        for(int i = first; i <= last; i++){ 
            //inner loop that compares two numbers next to each other
            for(int a = 0; a <= last - 1 -i ; a++){ 
                //If the number before is greater than the number after it 
               //swap them
                if(data[a] > data[a + 1]){
                    swap(data,a,a+1);
                }
                
                incrementComparisons();//Keeps track at the amount of time a number haa been compared to another
            }

        }

    }

    @Override
     /*
     * Description: This will swap two numbers when called by created a new spot to hold a number and then
     * making one number equal to the other while the other number is equal to the temporary one.
     * @param: int[] data, int idx1, int idx2
     */
    public void swap(int[] data, int idx1, int idx2){
        int temp = data[idx1];//creates a temporary spot
        
        //switches the two numbers
        data[idx1] = data[idx2];
        data[idx2] = temp;
    }
}
