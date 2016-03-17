package se.liu.ida.jesjo430.tddd78.lab2;

public class Month
{
    //fields
    private String name;
    private int number, days;

    //constructor
    public Month(final String name, final int number, final int days) {
	this.name = name;
	this.number = number;
	this.days = days;
    }

    //getters
    public String getName() {
	return name;
    }

    //getters
    public int getNumber() {
	return number;
    }

    //getters
    public int getDays() {
	return days;
    }

    //getters
    public static int getMonthNumber(String name) {
	switch (name) {
	    case "jan":
		return 1;
	    case "feb":
		return 2;
	    case "mar":
		return 3;
	    case "apr":
		return 4;
	    case "may":
		return 5;
	    case "jun":
		return 6;
	    case "jul":
		return 7;
	    case "aug":
		return 8;
	    case "sep":
		return 9;
	    case "oct":
		return 10;
	    case "nov":
		return 11;
	    case "dec":
		return 12;
	    default:
		return -1;
	}
    }

    //getters
    public static int getMonthDays(String name) {
	switch (name) {
	    case "feb":
		return 28;
	    case "apr":
	    case "jun":
	    case "sep":
	    case "nov":
		return 30;
	    case "mar":
	    case "jan":
	    case "may":
	    case "jul":
	    case "aug":
	    case "oct":
	    case "dec":
		return 31;
	    default:
		return -1;
	}
    }

    //Method - is name a valid date
    public static boolean isValidDate(String name){
	if (getMonthDays(name) != -1){
	    return true;
	}
	else {
	    return false;
	}
    }

}
