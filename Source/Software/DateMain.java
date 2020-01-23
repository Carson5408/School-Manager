package Software;
public class DateMain extends Date {

	private static DateMain instance;

	private DateMain(String sDay) {
		super(sDay);
	}

	public static DateMain getInstance() {
		return instance;
	}

	public static void createTheInstance(String sDay) {
		if (instance == null) {
			instance = new DateMain(sDay);
			System.out.print("Date updated: "+ sDay);
		}
		
		else
			System.out.println("Cannot create one more system date instance.");
	}
}
