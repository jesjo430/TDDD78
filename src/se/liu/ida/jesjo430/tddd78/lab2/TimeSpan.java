package se.liu.ida.jesjo430.tddd78.lab2;

public class TimeSpan
{
    //fields
    private TimePoint start;
    private TimePoint end;

    //getters
    public TimePoint getEnd() {
	return end;
    }

    //getters
    public TimePoint getStart() {
    	return start;
    }

    //constructor
    public TimeSpan(final TimePoint start, final TimePoint end) {
    	this.start = start;
    	this.end = end;
    }

    //toString
    @Override public String toString() {
	return start + "-" + end;
    }
}
