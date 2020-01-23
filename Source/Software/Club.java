package Software;
import java.util.ArrayList;
import java.util.Collections;

public class Club implements Comparable<Club> {

	private String ClubName;
	private Teacher head;
	private Date dateSetup;
	private ArrayList<Teacher> allTutors;

	public Club(String name, Teacher main) {
		this.ClubName = name;
		this.head = main;
		this.dateSetup = DateMain.getInstance().clone();
		allTutors = new ArrayList<>();
	}

	public String getName() {
		return ClubName;
	}

	public String getLeaderName() {
		return head.getName();
	}

	public static void list(ArrayList<Club> list) {
		//System.out.printf("%-30s%-30s%-30s\n", "Club Name", "Main Tutor", "Start at");
		for (Club t : list)
			System.out.printf("%-30s%-30s%-30s", t.ClubName, t.head.getName(), t.dateSetup.toString());
	}

	public void addClubTutor(Teacher e) throws TeacherExistedInClubException {
		for (Teacher e1 : allTutors)
			if (e1.getName().equals(e.getName()))
				throw new TeacherExistedInClubException();

		allTutors.add(e);
		e.addClub(this);
		Collections.sort(allTutors);
	}

	public void removeClubTutor(Teacher e) {
		allTutors.remove(e);
		e.removeClub(this);
	}

	public void removeAllClubTutor() {
		for (Teacher e : allTutors)
			e.removeClub(this);
	}

	public void listAllTutors() {
		for (Teacher e : allTutors)
			if (e.getName().equals(getLeaderName()))
				System.out.println(e.getName() + " (Main Tutor of the Club)");
			else
				System.out.println(e.getName());
	}

	@Override
	public int compareTo(Club another) {
		return this.ClubName.compareTo(another.ClubName);
	}
}
