package Software;

public class TeacherExistedInClubException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeacherExistedInClubException() {
		super("Teacher has already joined the Club!");
	}


}
