package be.mms.ex04;

public class EmptyStackException extends RuntimeException {

	private static final long serialVersionUID = 1;

	public EmptyStackException (String message) {
		super(message);
	}
	
}
