package Software;
public class NewTeacherCM extends RecordedCommand {

	Teacher e;
	School co = School.getInstance();
	int annualLeaves;

	@Override
	public void run(String[] cmdParts) {
		try {
			if (cmdParts.length < 3)
				throw new ArgException();

			annualLeaves = Integer.parseInt(cmdParts[2]);
			if (annualLeaves < 0 || annualLeaves > 300)
				throw new TooMuchALException();

			e = co.createTeacher(cmdParts[1], annualLeaves);

			addUndoCommand(this);
			clearRedoList();

			System.out.println("Hired " + cmdParts[1] + " with " + annualLeaves + " days annual leave.");
		} catch (ArgException | TeacherExistedException | TooMuchALException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void undoMe() {
		co.removeTeacher(e);
		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		co.addTeacher(e);
		addUndoCommand(this);
	}
}
