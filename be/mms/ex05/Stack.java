package be.mms.ex05;

public interface Stack<O> {
	void push (O o);
	O pop();
	boolean isEmpty();
	boolean isFull();
	Iterator<O> iterator();
}
