/**
 ** HW3.java: Simple driver to test Money, Date, and Bill classes
 * @author Rob Nash, borrowed from cfolsen
 *
 * Name:    Sandy Chau
 * Class:   Rob Nash CSS 162
 * Title:   Homework 2
 * 
 * Description: Driver for the Money, Date, and Bill classes. Will test all the methods in each class.
 *              

 */
public class BillMoneyDateDriver
{

    /**
    main driver function
    pre:  none
    post: exercises the methods in Bill, Money, and Date
     */
    public static void main(String[] args)
    {

        //Construct some money
        Money money1 = new Money(10,0);
        Money money2 = new Money(money1);        
        Money money3 = new Money(10.99);
        Money money4 = new Money(3,50);
        Money money5 = new Money(10.50);

        //Test getters and Settters
        int dollars3 = money3.getDollars();
        int cents3 = money3.getCents();
        money1.setMoney(30,50);

        //Test additions and subtractions
        money4.subtract(.5);//Should equal 3
        money5.add(money3);//Should equal 21.49
        
        //Print out all the Money objects
        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);
        System.out.println(money3 + " should be the same as: " + dollars3 + "." + cents3);
        System.out.println(money4);
        System.out.println(money5);
        System.out.println(money5 + " is less than " + money4 + " : " + money5.lessThan(money4));
        System.out.println();
        
        //Construct some bills
        Money amount = new Money(20);
        Date dueDate = new Date(4, 30, 2014);
        Bill bill1 = new Bill(amount, dueDate, "The phone company");
        Date paidDate = new Date(2, 27, 2014);
        bill1.setPaid(paidDate);

        Bill bill2 = new Bill(bill1);
        bill2.setDueDate(new Date(5, 30, 2015));
        bill2.setPaid(paidDate);

        amount.setMoney(31, 99);
        dueDate.setDay(29);       
        Bill bill3 = new Bill(amount, dueDate, "The record company");
        paidDate.setDay(29);
        paidDate.setMonth(4);
        bill3.setPaid(paidDate);
        
        Bill bill4 = new Bill(amount, dueDate, "The record company");
        bill4.setDueDate(new Date(4, 29, 2014));
        paidDate = new Date(4, 29, 2014);
        bill4.setPaid(paidDate);
        
        //Tests the bills
        System.out.println("Bill objects output:");
        System.out.println(bill1 + "\n");
        System.out.println(bill2 + "\n");        
        System.out.println(bill3 + "\n");
        System.out.println(bill4 + "\n");
        System.out.println("bill3 is equal to bill4: " + bill3.equals(bill4));

    }
}
