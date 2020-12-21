package main;

public class CourseOperationException extends Exception {

	/**
	 * Any exception caused by Course object. Has short description.
	 */
	private static final long serialVersionUID = -9011294321211371628L;

	public CourseOperationException(String message) {
		super(message);
	}

}
