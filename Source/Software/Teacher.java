package Software;
import java.util.ArrayList;
import java.util.Collections;

public class Teacher implements Comparable<Teacher> {

	private String name;
	private int yrLeavesEntitled;
	private ArrayList<RegisterLeave> allLeaveRecord;
	private ArrayList<Club> allClub;

	public Teacher(String n, int yle) {
		this.name = n;
		this.yrLeavesEntitled = yle;
		allLeaveRecord = new ArrayList<>();
		allClub = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public int getYrLeavesEntitled() {
		return yrLeavesEntitled;
	}

	public static Teacher searchTeacher(ArrayList<Teacher> list, String nameToSearch) throws NoThisTeacherException {
		for (Teacher aList : list)
			if (aList.getName().equals(nameToSearch))
				return aList;
		throw new NoThisTeacherException();
	}

	public void addLeave(RegisterLeave r) throws RepeatedLeaveLeavesException, DateExpiredException, OverALException {
		Date currentDay = DateMain.getInstance().clone();
		if (r.getsDay() < currentDay.getIntDay())
			throw new DateExpiredException(currentDay);
		
		for (RegisterLeave r1 : allLeaveRecord)
			if ((r.getsDay() > r1.getsDay() && r.getsDay() < r1.geteDay()) || (r.geteDay() > r1.getsDay() && r.geteDay() < r1.geteDay()))
				throw new RepeatedLeaveLeavesException(r1);

		if (yrLeavesEntitled < r.daysBetween())
			throw new OverALException(yrLeavesEntitled);

		allLeaveRecord.add(r);
		yrLeavesEntitled -= r.daysBetween();
		Collections.sort(allLeaveRecord);
	}

	public void removeLeave(RegisterLeave r) {
		yrLeavesEntitled += r.daysBetween();
		allLeaveRecord.remove(r);
	}

	public void listAllLeaves() {
		if (allLeaveRecord.size() == 0)
			System.out.println("No leave record");

		for (RegisterLeave r : allLeaveRecord)
			System.out.println(r.toString());
	}

	public void addClub(Club t) {
		allClub.add(t);
		Collections.sort(allClub);
	}

	public void removeClub(Club t) {
		allClub.remove(t);
	}

	public void listRoles() {
		if (allClub.size() == 0)
			System.out.println("No role");

		for (Club t : allClub)
			if (t.getLeaderName().equals(name))
				System.out.println(t.getName() + " (Leader of Club)");
			else
				System.out.println(t.getName());
	}

	@Override
	public int compareTo(Teacher another) {
		return this.name.compareTo(another.name);
	}
}
