package Software;

public class RepeatedLeaveLeavesException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepeatedLeaveLeavesException(RegisterLeave r) {
		super("This teacher has already took leave from " + r.toString() + "!");
	}

}