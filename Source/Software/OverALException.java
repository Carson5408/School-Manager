package Software;

public class OverALException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OverALException(int days) {
		super("This teacher cannot take anymore leave. Quota: " + days + " days left only!");
	}

}
