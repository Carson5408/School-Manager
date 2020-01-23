package Software;
public class ClubNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClubNotFoundException() {
		super("Cannot find this Club in school.");
	}

}
