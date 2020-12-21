package main;

public class UserDataException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4107700939520503368L;
	public UserDataException(String message) {
		super(message);
	}
	public UserDataException(String message, Throwable cause) {
		super(message, cause);
	}
}
