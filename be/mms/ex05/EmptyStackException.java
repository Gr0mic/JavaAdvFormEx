package be.mms.ex05;

public class EmptyStackException extends RuntimeException {

	private static final long serialVersionUID = 1;

	public EmptyStackException (String message) {
		super(message);
	}
	
}
