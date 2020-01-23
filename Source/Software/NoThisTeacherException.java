package Software;

public class NoThisTeacherException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoThisTeacherException() {
		super("Teacher not found!");
	}

}
