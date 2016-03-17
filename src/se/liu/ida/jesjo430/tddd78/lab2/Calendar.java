package se.liu.ida.jesjo430.tddd78.lab2;

import java.util.ArrayList;
import java.util.List;

public class Calendar
{
    public static void main(String[] args) {
	book(2020, "jan", 13, "12:00", "13:00", "Example meeting");
	book(2016, "mar", 12, "10:00", "15:00", "Test1!");
	//book(2000, "feb", 10, "14:00", "18:00", "test 2");
    }

    //fields
    private List<Appointment> appointments;


    //constructor
    public Calendar(List<Appointment> appointments) {
	this.appointments = appointments;
	appointments = new ArrayList<>();
    }


    //method - prints appointments
    public void show(){
           for (Appointment appointment : appointments) {
               System.out.println("> " + appointment);
           }
    }


    //method - checks for error inputs and then books meetings
    public static void book(int year, String month, int day,
                     String start, String end, String subject) {
	if (year < 2013) {
	    throw new IllegalArgumentException("Felaktigt årtal.");
	}

	if (!TimePoint.isValidDate(start) || !TimePoint.isValidDate(end)) {
	    throw new IllegalArgumentException("FElaktig start- eller slut-tid.");
	}

	if (day > Month.getMonthDays(month)) {
	    throw new IllegalArgumentException("Det det angivna datumet existerar ej.");
	}

	if (!Month.isValidDate(month)) {
	    throw new IllegalArgumentException("Angiven månad existerar ej.");
	}

	TimeSpan time = new TimeSpan(new TimePoint(start), new TimePoint(end));


	Date date = new Date(year, month, day);
	Appointment meeting = new Appointment(subject, date, time);

	//this.appointments.add(meeting);

	System.out.println(meeting);
    }
}
