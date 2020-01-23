package Software;
public class ClubExistedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClubExistedException() {
		super("This Club already existed! Cannot create one more.");
	}


}
