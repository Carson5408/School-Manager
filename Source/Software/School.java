package Software;
import java.util.ArrayList;
import java.util.Collections; //Provides sorting

public class School {

	private ArrayList<Teacher> allTeachers;
	private ArrayList<Club> allClubs;

	private static School instance = new School();

	public School() {
		allTeachers = new ArrayList<>();
		allClubs = new ArrayList<>();
	}

	public static School getInstance() {
		return instance;
	}

	public void listClubs() {
		Club.list(allClubs);
	}

	public Teacher createTeacher(String name, int annualLeaves) throws TeacherExistedException {
		for (Teacher allTeacher : allTeachers)
			if (allTeacher.getName().equals(name))
				throw new TeacherExistedException();

		Teacher e = new Teacher(name, annualLeaves);
		allTeachers.add(e);
		Collections.sort(allTeachers);
		return e;
	}

	public Club createClub(String tName, String hName) throws ClubExistedException, NoThisTeacherException, TeacherExistedInClubException {
		Teacher e = Teacher.searchTeacher(allTeachers, hName);

		for (Club allClubs : allClubs)
			if (allClubs.getName().equals(tName))
				throw new ClubExistedException();

		Club t = new Club(tName, e);
		t.addClubTutor(e);
		allClubs.add(t);
		Collections.sort(allClubs);
		return t;
	}

	public void addClub(Club t) {
		allClubs.add(t);
		Collections.sort(allClubs);
	}

	public void removeClub(Club t) {
		t.removeAllClubTutor();
		allClubs.remove(t);
	}

	public void addTeacher(Teacher e) {
		allTeachers.add(e);
		Collections.sort(allTeachers);
	}

	public void removeTeacher(Teacher e) {
		allTeachers.remove(e);
	}

	public void listTeacher() {
		for (Teacher e : allTeachers)
			System.out.printf("%s (Leaves: %d days)", e.getName(), e.getYrLeavesEntitled());
	}

	public void listLeaves() {
		for (Teacher e : allTeachers) {
			System.out.println(e.getName() + ":");
			e.listAllLeaves();
		}
	}

	public void listClubTutors() {
		for (Club t: allClubs) {
			System.out.println(t.getName() + ":");
			t.listAllTutors();
			System.out.println();
		}
	}

	public Teacher searchTeacher(String name) throws NoThisTeacherException {
		return Teacher.searchTeacher(allTeachers, name);
	}

	public Club searchClub(String tName) throws ClubNotFoundException {
		for (Club allClubs : allClubs)
			if (allClubs.getName().equals(tName))
				return allClubs;
		throw new ClubNotFoundException();
	}

}
