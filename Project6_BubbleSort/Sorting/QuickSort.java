
/**
 * Description:
 * This QuickSort takes in an array of numbers and attempts to sort the numbers in ascending order.
 * The sorting is done by taking the number in the middle of the array (the pivot) and comparing the
 * rest of the numbers to that number. The number at the beginning and the number at the end is compared
 * to the pivot. If the number at the beginning is greater than or equal to the pivot AND the number at the
 * end is less than or equal to the pivot, the two numbers swap. If beginning is less than pivot, then the 
 * program will compare the number after that number. It is the same for the ending number, if the ending 
 * number is greater than the pivot, then the program will compare the number before the ending number and 
 * so on. When the array is done, the number in the middle may not sorted so the program does a check on the
 * pivot and the number after the pivot, swapping them if needed. Then the numbers are split into two sections,
 * the low numbers and the high numbers and the comparison is completed with those list of numbers. The splitting
 * of the numbers is done until there is only one number in each list. The comparison count increases every time 
 * two numbers are compared to each other. The problem I have with this program is that it is called the quicksort
 * yet it takes more comparisons than the bubble sort.
 * 
 * 
 * @author: Sandy Chau 
 * @assignment: Homework 6
 * @class: CSS 162
 * @date: 3/6/2014
 * 
 *
 */
public class QuickSort extends Sort
{

    /*
     * Description: This will sort the list of numbers by taking in parameter, a high and a low, and then sorting 
     * the numbers in between the parameters.
     * @param:
     * @return:
     */
    @Override
    public void sort(int[] data, int first, int last){        
        
        int index = selectPivot(data,first, last);//Selects the middle of the array
        int pivot = data[index];//finds the number at that index
        
        index = sortHelp(data, first,last,pivot,index);
        
        //If there is more than one number in the sections
        if(last - first >= 1){
            
            sort(data, first, index);//sorts the left half of list
            sort(data, index + 1, last);//sorts right half of list

        } 

    }

    /*
     * Description:This is helping the sort method by making the left of the list contain numbers
     * less than the pivot and the numbers right of the list be greater than the pivot. It does not sort it 
     * in ascending order. It also keeps track of the amount of time a number is compared to another
     * @param:int[] data, int first, int last, int pivot, int index
     * @return: index
     */
    public int sortHelp(int[] data, int first, int last, int pivot, int index){
        //Repeat while first is less than last. The loop will end when first and last are equal
        while(first < last){
            incrementComparisons();//increases comparison count everytime two numbers are compared
            //If the number to the left is greater than the pivot and the number to the right is less
            //than the pivot, swap them
            if(data[first] >= pivot && data[last] <= pivot){                
                swap(data,first,last);
            }

            incrementComparisons();
            //If the number is less than the pivot, move on in the list
            if(data[first] < pivot){
                first += 1;
            }

            incrementComparisons();
            //If the number is greater than the pivot, move to the number before
            if(data[last] > pivot){
                last -= 1;
            } 

        }
        
        //check the numbers in the middle
        if(index != last){
            incrementComparisons(); 
            //swap the numbers if the number is greater than the number after it
            if(data[index] > data[index + 1]){
                swap(data, index,index +1);
            }
        }

        return index;// return the index which is the middle of array
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

    /*
     * Description: This will return the index at the middle of the list of numbers.
     * If the size of the list is odd, it will return the lesser number.
     * @param: int[]data, int low, int high)
     * @return:((high - low) / 2) + low (The index of the middle of two numbers)
     */
    private int selectPivot(int[]data, int low, int high){
        return ((high - low) / 2) + low;
    }
}
