package se.liu.ida.jesjo430.tddd78.lab2;

public class Appointment
{
    //fields
    private String subject;
    private Date date;
    private TimeSpan timespan;

    //getters
    public Date getDate() {
	return date;
    }

    //getters
    public String getSubject() {
	return subject;
    }

    //getters
    public TimeSpan getTimespan() {
	return timespan;
    }

    //constructor
    public Appointment(final String subject,
		       final Date date,
		       final TimeSpan timespan) {
	this.subject = subject;
	this.date = date;
	this.timespan = timespan;
    }

    //toString
    @Override public String toString() {
	return date + " | " + timespan + " | " + subject;
    }
}