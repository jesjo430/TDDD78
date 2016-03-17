package se.liu.ida.jesjo430.tddd78.lab2;

public class TimePoint
{
    //fields
    private String time;
    private int hour;
    private int minute;

    //getters
    public int getHour() {
    	return hour;
    }

    //getters
    public int getMinute() {
	return minute;
    }

    //constructor
    public TimePoint(final String time) {
    	this.time = time;
    	String[] parts = time.split(":");
    	this.minute = Integer.parseInt(parts[1]);
    	this.hour = Integer.parseInt(parts[0]);
    }

    //toString
    @Override public String toString() {
    	return time;
    }

    //Method - is timepoint a valid time
    public static boolean isValidDate(String timepoint){
	String[] parts = timepoint.split(":");

	int minute = Integer.parseInt(parts[1]);
	int hour = Integer.parseInt(parts[0]);

	if (0<=hour && hour<=23 && 0<=minute && minute <= 59){
	    return true;
	    }
	return false;
    }


}