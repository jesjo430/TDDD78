package se.liu.ida.jesjo430.tddd78.lab2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Queue
{
    public static void main(String[] args) {
	Queue myQue = new Queue();

	        for (int i = 0; i < 5 ; i++) {
	            myQue.enqueue(new Person("Jesper" + i, LocalDate.of(1996 - i, 8, 3)));
	        }

	        while(!myQue.isEmpty()) {
	            System.out.println(myQue.dequeue());
	        }
    }

    private List<Person> elements = new ArrayList<Person>();

    public int size() {return elements.size();}

    public boolean isEmpty() {return elements.isEmpty();}

    public boolean contains(final Object o) {return elements.contains(o);}

    public void clear() {elements.clear();}

    public void enqueue(Person person) { elements.add(person); }

    public Person dequeue() { return elements.remove(0); }
}
