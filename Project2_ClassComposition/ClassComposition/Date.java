
/**
 * Author:  Sandy Chau
 * Class:   Rob Nash CSS 162
 * Title:   Homework 2
 * Description: This program will create a Date that is listed as month.day.year. The program can only create
 *              dates starting from January 1, 2014 to December 31, 2024. The program will present an error message if 
 *              an invalid date is enter. However it does not check for leap years or if months only have 30 days. For 
 *              example April has only 30 days but the program will consider April 31 a valid date. However, one should 
 *              know that April doesn't have 31 days so it would be best to input April 30 as the day.
 * 
 */
public class Date
{
    private int day; //(1-31)
    private int month; //(1-12)
    private int year; //(2014-2024)

    //Constructer
    public Date(){}

    /**
     * Description: Construter, Sets the month, day, and year 
     * @param: int m, int d, int y
     */
    public Date(int m, int d, int y){
        //makes sure there is ony 29 days in february, does not follow leap year pattern
        if(m == 2  && d > 29){
            System.err.println("February does not have more than 29 days");
            System.exit(-1);
        }
        setMonth(m);
        setDay(d);
        setYear(y);

    }

    /**
     * Description: Construter, Sets the month, day, and year
     * @param: Date newDate
     */
    public Date(Date newDate){
        setMonth(newDate.month);
        setDay(newDate.day);
        setYear(newDate.year);
    }

    /**
     * Description: Makes a copy of the whole date
     */
    public Date getDate(){
        return new Date(month,day,year);
    }

    /**
     * Description: Gets the  month as an interger
     * return: int month
     */
    public int getMonth(){

        return month;
    }

    /**
     * Description: Gets the day as an interger
     * return: int day
     */
    public int getDay(){

        return day;
    }

    /**
     * Description: Gets the year as an interger
     * return: int year
     */
    public int getYear(){

        return year;
    }

    /**
     * Description: Set the  day and makes sure it is not over 31 days
     * @param int d(date)
     * @return day;
     */
    public int setDay(int d){
        //can only have up to 31 days
        if(d < 1 || d > 31){
            System.err.println("Bad Day");
            System.exit(-1);
        }

        day = d;

        return day;

    }

    /**
     * Description: Set the  month and makes sure its only 12 months otherwise it exits 
     * @param: m(month)
     * @return month;
     */
    public int setMonth(int m ){
        //can only have 12 months
        if(m < 1 || m > 12){
            System.err.println("Bad Month");
            System.exit(-1);
        }
        month = m;

        return month;
    }

    /**
     * Description: Set the year, valid for only 20 years
     * @param: int y(year)
     * @return year;
     */
    private int setYear(int y){
        //Year must be between 2014 and 2024
        if(y < 2014 || y > 2024){
            System.err.println("Bad Year");
            System.exit(-1);
        }
        year = y;

        return year;

    }

    //Creates a String of the Date
    @Override 
    public String toString(){
        String date = month + "." + day + "." + year;
        return date;
    }

    //Checks to see if two dates are equal
    @Override
    public boolean equals(Object o){ //a vs b this = a that = b a.equals(b)
        //Checks to see if null
        if(o == null){
            return false;
        }

        Date that =(Date)o;
        return this.month == that.month && this.day == that.day && this.year == that.year; 
    }

    /**
     * Description: checks to see if one date is before the other
     * @return boolean yes(true or false);
     */
    public boolean before(Object o){ //a vs b this = a that = b a.equals(b)
        boolean yes = false;


        Date that =(Date)o;
        if(this.year < that.year){
            yes = true;
        }
        else if(this.year <= that.year && this.month < that.month){
            yes = true;
        }
        else if (this.year <= that.year && this.month <= that.month && this.day < that.day){
            yes = true;
        }
        else{
            yes = false;
        }

        return yes;
    }
}

