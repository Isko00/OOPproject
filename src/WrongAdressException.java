public class WrongAdressException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8891500159720144797L;

	public WrongAdressException(String message) {
		super(message);
	}
	
	public WrongAdressException(String message, Throwable cause) {
		super(message, cause);
	}
	 
}
