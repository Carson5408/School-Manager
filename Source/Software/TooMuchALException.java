package Software;
public class TooMuchALException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TooMuchALException() {
		super("Too much Annual leaves (0-300)!");
	}

}
