package Software;
public class AddClubTutorCM extends RecordedCommand {

	School sc = School.getInstance();
	Teacher t;
	Club c;

	@Override
	public void run(String[] cmdParts) {
		try {
			if (cmdParts.length < 3)
				throw new ArgException();

			c = sc.searchClub(cmdParts[1]);
			t = sc.searchTeacher(cmdParts[2]);

			c.addClubTutor(t);

			addUndoCommand(this);
			clearRedoList();

			System.out.println("Added " + cmdParts[2] + " to " + cmdParts[1] + ".");
		} catch ( ArgException | NoThisTeacherException | TeacherExistedInClubException | ClubNotFoundException t) {
			System.out.println(t.getMessage());
		}
	}

	@Override
	public void undoMe() {
		c.removeClubTutor(t);
		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		try {
			c.addClubTutor(t);
			addUndoCommand(this);
		} catch ( TeacherExistedInClubException t) {
			System.out.println(t.getMessage());
		}
	}
}