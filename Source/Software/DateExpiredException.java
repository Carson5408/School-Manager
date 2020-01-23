package Software;
public class DateExpiredException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateExpiredException(Date currDay) {
		super("It is " + currDay.toString() + " already!");
	}


}
