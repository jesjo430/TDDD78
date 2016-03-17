package se.liu.ida.jesjo430.tddd78.lab2;

public class Date
{
    //fields
    private int year;
    private String month;
    private int day;

    //constructor
    public Date(final int year, final String month, final int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //getters
    @Override public String toString() {
	return month + " " + day + " " + year;
    }
}
