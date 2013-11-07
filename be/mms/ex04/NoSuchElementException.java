package be.mms.ex04;

public class NoSuchElementException extends RuntimeException {

	private static final long serialVersionUID = 1;

	public NoSuchElementException (String message) {
		super(message);
	}
}
