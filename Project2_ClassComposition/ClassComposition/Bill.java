/**
 * Author:  Sandy Chau
 * Class:   Rob Nash CSS 162
 * Title:   Homework 2
 * Description: This program create a bill that will tell if the bill has or has not been paid. The program will output
 *              the amount, due date, paid daye(if it has been paid) and the company it is paid to. If the paid date is 
 *              after the due date, it will have on error that dates the bill was pass due and exit. 
 * 
 */
public class Bill
{
    Money amount;// amount of money
    Date dueDate;// the due date
    Date paidDate = null;//if paid then the date it was paid
    String originator;//paid to whom
    String paidOrUnpaid = "Not Paid";//initalized as not paid

    /**
     * Description: Constructer, initalizes the amount, due date, and who to pay
     */
    public Bill(Money newAmount, Date newDueDate, String newOriginator){
        setAmount(newAmount);
        setDueDate(newDueDate);
        setOriginator(newOriginator);
    }

    /**
     * Description: Constructer, creates a new bill with an amount, due date, and who to pay
     */
    public Bill(Bill toCopy){
        setAmount(toCopy.amount);
        setDueDate(toCopy.dueDate);
        setOriginator(toCopy.originator);
    }

    /**
     * Description: Gets a copy of the amount of money
     * @return: Money copyAmount
     */
    public Money getAmount(){
        Money copyAmount = new Money(amount);
        return copyAmount;
    }

    /**
     * Description: Gets a copy of the due date, uses the Date program
     * @return: Date dueDate
     */
    public Date getDueDate(){
        Date copyDate = new Date(dueDate);
        return copyDate;
    }

    /**
     * Description: Gets the originator
     * @return: String originator
     */
    public String getOriginator(){
        return originator;
    }

    /**
     * Description: Sees if it has been paid, if it has but was overdue, exit out of program
     * @return: boolean true or false
     */
    public boolean isPaid() {
        boolean paid = false;
        //if paid date is before due date, it has been paid 
        //if it is not before, it was paid too late
        //if not paid date then it hasn't been paid
        if(paidDate.equals(dueDate) || paidDate.before(dueDate)){
            paid = true;
        }else   
        if(paidDate.before(dueDate) == false){
            System.err.println("Payment date is passed due date");
            System.exit(-1);
        }else         
        if(paidDate == null){
            paid = false;
        }

        return paid;
    }

    /**
     * Description: Sees if the bill has been paid and saves the date as a copy
     */
    public void setPaid(Date onDay) { 
        paidDate = new Date(onDay);
        if (isPaid()){
            paidOrUnpaid = "Paid";
        }
    }

    /**
     * Description: Sees if the bill has not paid and then sets as unpaid
     */
    public void setUnpaid() {

        if (paidDate == null){
            paidOrUnpaid = "Not Paid";
        }
    }

    /**
     * Description: Changes the copy of the date
     * */
    public void setDueDate(Date newDate){
        dueDate = new Date(newDate);
    }

    /**
     * Description: Changes the copy of amount and makes a new Money 
     */
    public void setAmount(Money newAmount) {
        amount = new Money(newAmount);
    }

    /**
     * Description: Changes originator
     */
    public void setOriginator(String newOriginator){
        originator = new String(newOriginator);
    }

    /**
     * Description: Builds a string that reports the amount, when its due, to whom, and if paid, the date paid.  
     * @return: String report
     */
    public String toString() {
        String report;
        //if paid date is null then it has not been paid
        //otherwise it has and so print out the paid date
        if (paidDate == null){
            report = "Amount: " + amount + "\nDue Date: "  +  dueDate + "\nPay to: " + originator + "\nPaid?: " + paidOrUnpaid;
        }
        else {
            report = "Amount: " + amount + "\nDue Date: "  +  dueDate + "\nPay to: " + originator + "\nPaid Date: " + paidDate;
        }

        return report;
    }

    /**
     * Description: determine if the two bills are the sam
     * @return: boolean true or false
     */
    public boolean equals(Bill toCompare) {

        //Checks to see if null
        if(toCompare == null){
            return false;
        }

        Bill that =(Bill)toCompare;

        return this.amount.equals(that.amount) && this.dueDate.equals(that.dueDate) && this.paidDate.equals(that.paidDate) && this.originator.equals(that.originator); 
    }

}
