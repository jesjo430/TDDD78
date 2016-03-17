package se.liu.ida.jesjo430.tddd78.lab2;

import java.time.LocalDate;
import java.time.Period;

public class Person
{
    //fealds
    public String name;
    public LocalDate birthDay;

    //constructor
    public Person(String name, LocalDate birthDay) {
	this.name = name;
	this.birthDay = birthDay;
    }

    //main - testcases, print
    public static void main(String[] args) {
	Person Jesper = new Person("Jesper", LocalDate.of(1996, 8, 3));
	Person Björn = new Person("Björn", LocalDate.of(1964, 9, 15));
	Person Natalie = new Person("Natalie", LocalDate.of(1993, 2, 24));

	System.out.println(Jesper);
	System.out.println(Björn);
	System.out.println(Natalie);

    }

    //method - return age in years
    public int getAge() {
	return Period.between(birthDay, LocalDate.now()).getYears();
    }

    //toString - makes string
    @Override public String toString() {
	return name + " " + getAge();
    }

}
