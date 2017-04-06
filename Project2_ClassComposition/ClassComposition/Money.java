
/**
 * Author:  Sandy Chau
 * Class:   Rob Nash CSS 162
 * Title:   Homework 2
 * Description: This program will take in an amount and separate it into dollars and cents to represent money. The amount is stored as intergers
 *              and the dollar value will increase if the cent value is over 100. The program will not print out a 0 at the end, for example,
 *              $1.50 will only be printed at $1.5
 * 
 */
public class Money
{
    private int dollars;
    private int cents;//0-99 

    /**
     * Description: Constructer, initalizes the dollars and cents to 0
     */
    public Money(){
        dollars = 0;
        cents = 0;
    }

    /**
     * Description: Constructer, Sets dollars and cents with values taken in
     * @param: int newDollars, int newCents
     */
    public Money(int newDollars, int newCents){
        setDollars(newDollars);
        setCents(newCents);
    }

    /**
     * Description: Constructer, Sets dollars and cents with values taken in
     *              Splits the double taken in into intergers
     *  @param: double newDollarsAndCents
     */
    public Money (double newDollarsAndCents){
        Double newAmount = newDollarsAndCents;
        int d = newAmount.intValue();//store the int value

        Double newCents = newAmount - d;//get the decimal part       

        newCents = newCents * 100;// change into whole number
        int c = newCents.intValue();//change into int valuse

        //Set values as the dollar and cents
        setDollars(d);
        setCents(c);
    }

    /**
     * Description: Constructer, Sets dollars and cents with values taken in
     *  @param: Money otherMoney (objects)
     */
    Money(Money otherMoney){
        setDollars(otherMoney.dollars);
        setCents(otherMoney.cents);
    }

    /**
     * Description: Return the dollars
     * @return; int dollars
     */
    public int getDollars(){

        return dollars;
    }

    /**
     * Description: Gets the cents
     * @return; int cents
     */
    public int getCents(){

        return cents;
    }

    /**
     * Description: Sets the dollars with valid values
     * @param: newDollars
     */
    private void setDollars(int newDollars){
        //if it is not a negative number then store it into dollars
        //else report an error
        if(newDollars >= 0){
            dollars = newDollars;
        }else {
            System.err.println("Invalid dollar value");
            System.exit(-1);
        }

    }

    /**
     * Description: Sets the cents with valid values
     * @param: int newCents
     */
    private void setCents(int newCents){

        //if cents is between 0 and 99, its valid therefor set cent as the value
        if(newCents >= 0 && newCents <= 99){
            cents = newCents;

        }else if(newCents > 99)
        {
            //it increases the dollar value by amount gotten by diving it by 100
            int addToDollars = newCents/100;
            dollars = dollars + addToDollars;

            //find the remainder and set it as the cents
            int addToCents = newCents%100;
            cents = addToCents;

        }
        else if(newCents < 0){
            //if cents are a negative number(such as when subtracting)
            newCents = Math.abs(newCents);//find the absolute number
            dollars = dollars - 1; //subtract 1 from dollars

            cents = 100 - newCents;//gets the new cent value

            //if a negative number, it means too much was subtracted
            if(dollars < 0){
                System.err.println("Invalid cent value");
                System.exit(-1);
            }
        }
    }

    /**
     * Description: Creates new Money object
     * @param: int d (dollars), int c (cents)
     */
    public void setMoney(int d, int c){
        setDollars(d);
        setCents(c);
        Money newMoney = new Money(dollars,cents);//Creates new object
    }

    /**
     * Description: Adds money together if two intergers are passed in
     * @param: int  newDollars), int newCent
     */
    public void add(int newDollars, int newCents){
        setDollars(newDollars + dollars);
        setCents(newCents + cents);

    }

    /**
     * Description: Adds money together when an object is passed in
     * @param: Money otherMoney
     */
    public void add(Money otherMoney){
        add(otherMoney.dollars, otherMoney.cents);
    }

    /**
     * Description: Adds money together when they are decimals 
     * @param: double dollarsAndCents
     */
    public void add(double dollarsAndCents){
        Money newAmount = new Money(dollarsAndCents);//Creates an object with intergers
        add(newAmount.dollars, newAmount.cents);
    }

    /**
     * Description: Subtracts money if it is given two intergers
     * @param: int  newDollars, int newCent
     */
    public void subtract(int newDollars, int newCents){

        setDollars(dollars - newDollars);
        setCents(cents - newCents);
    }

    /**
     * Description: Subtracts money if a double is passed in
     * @param: double dollarsAndCents
     */
    public void subtract(double dollarsAndCents){
        Money newAmount = new Money(dollarsAndCents);
        subtract(newAmount.dollars, newAmount.cents);
    }

    /**
     * Description: Subtracts money if an money object is passed in 
     * @param: Money otherMoney
     */
    public void subtract(Money otherMoney){
        subtract(otherMoney.dollars, otherMoney.cents); 

    }

    /**
     * Description: Compares money if one is less than another
     * @param: Object otherObject
     * @return true or false
     */
    public boolean lessThan(Object otherObject){
        Money that = (Money)otherObject;

        if(this.dollars < that.dollars){
            return true;
        }
        else 
        if(this.dollars == that.dollars && this.cents < that.cents){
            return true;

        }
        return false;

    }
    
    //Creates a string with the amount and the money symbol infront
    @Override 
    public String toString(){

        String money = "$" + dollars + "." + cents;
        return money;
    }

    @Override 
    public boolean equals(Object otherObject){
        Money that =(Money)otherObject;
        //Checks to see if null
        if(otherObject == null){
            return false;
        }


        return this.dollars == that.dollars && this.cents == that.cents; 
    }
}
