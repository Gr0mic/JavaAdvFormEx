package be.mms.ex04;

public interface Stack {
	void push (Object o);
	Object pop();
	boolean isEmpty();
	boolean isFull();
	Iterator iterator();
}
