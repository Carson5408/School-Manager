package Software;
public class CreateClubCM extends RecordedCommand {

	Club t;
	Teacher e;
	School co = School.getInstance();

	@Override
	public void run(String[] cmdParts) {
		try {
			if (cmdParts.length < 3)
				throw new ArgException();

			t = co.createClub(cmdParts[1], cmdParts[2]);
			e = co.searchTeacher(cmdParts[2]);

			addUndoCommand(this);
			clearRedoList();

			System.out.println(cmdParts[1] + " has been set up and " + cmdParts[2] + " is the Main Tutor.");
		} catch ( ArgException | ClubExistedException | NoThisTeacherException | TeacherExistedInClubException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void undoMe() {
		co.removeClub(t);

		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		co.addClub(t);
		e.addClub(t);

		addUndoCommand(this);
	}
}
