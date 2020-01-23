package Software;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegisterLeave implements Comparable<RegisterLeave> {

	private Date sDay;
	private Date eDay;

	public RegisterLeave(Date sDay, Date eDay) {
		this.sDay = sDay;
		this.eDay = eDay;
	}

	public Integer getsDay() {
		return sDay.getIntDay();
	}

	public Integer geteDay() {
		return eDay.getIntDay();
	}

	public int daysBetween() {
		Calendar c1 = new GregorianCalendar(sDay.getYear(), sDay.getMonth(), sDay.getDay());
		Calendar c2 = new GregorianCalendar(eDay.getYear(), eDay.getMonth(), eDay.getDay());

		return (int) ((c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 * 60 * 24)) + 1;
	}

	@Override
	public String toString() {
		return sDay.toString() + " to " + eDay.toString();
	}

	@Override
	public int compareTo(RegisterLeave another) {
		return this.getsDay().compareTo(another.getsDay());
	}
}
