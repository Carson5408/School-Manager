package Software;
public class Date implements Cloneable {

	private int year;
	private int month;
	private int day;

	private static final String MonthNames = "JanFebMarAprMayJunJulAugSepOctNovDec";

	public void set(String sDay) {
		String[] sDayParts = sDay.split("-");
		this.day = Integer.parseInt(sDayParts[0]);
		this.year = Integer.parseInt(sDayParts[2]);
		this.month = MonthNames.indexOf(sDayParts[1]) / 3 + 1;
	}

	public Date(String sDay) {
		set(sDay);
	}

	@Override
	public String toString() {
		return day + "-" + MonthNames.substring((month - 1) * 3, (month) * 3) + "-" + year;
	}

	@Override
	public Date clone() {
		Date copy = null;
		try {
			copy = (Date) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return copy;
	}

	public int getIntDay() {
		return year * 10000 + month * 100 + day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}


}
