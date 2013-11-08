package be.mms.ex05;

public interface Iterator<I> {
	
	I next() throws NoSuchElementException;
	boolean hasNext();

}
