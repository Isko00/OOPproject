package main;

public class UserAuthorizationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4107700939520503368L;
	public UserAuthorizationException(String message) {
		super(message);
	}
	public UserAuthorizationException(String message, Throwable cause) {
		super(message, cause);
	}
}
