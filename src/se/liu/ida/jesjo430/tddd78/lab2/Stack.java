package se.liu.ida.jesjo430.tddd78.lab2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Stack
{
    public static void main(String[] args) {
        Stack myStack = new Stack();

        myStack.Pop();

        for (int i = 0; i < 5 ; i++) {
            myStack.Push(new Person("Jesper" + i, LocalDate.of(1996- i, 8, 3)));
        }

        while(!myStack.isEmpty()) {
            System.out.println(myStack.Pop());
        }
    }

    private List<Person> elements = new ArrayList<>();

    public int size() {return elements.size();}

    public boolean isEmpty() {return elements.isEmpty();}

    public boolean contains(final Object o) {return elements.contains(o);}

    public void clear() {elements.clear();}

    public void Push(Person person) { elements.add(0, person); }

    public Person Pop() {
	return elements.remove(0);
    }
}
