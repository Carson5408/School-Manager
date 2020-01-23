package Software;
public class TakeLeaveCM extends RecordedCommand {

	School co = School.getInstance();
	Teacher e;
	RegisterLeave r;

	@Override
	public void run(String[] cmdParts) {
		try {
			if (cmdParts.length < 4)
				throw new ArgException();

			e = co.searchTeacher(cmdParts[2]);
			r = new RegisterLeave(new Date(cmdParts[3]), new Date(cmdParts[4]));
			e.addLeave(r);

			addUndoCommand(this);
			clearRedoList();

			System.out.println(cmdParts[2] + " takes leave from " + cmdParts[3] + " to " + cmdParts[4] + ".(" + cmdParts[1] + ")");
		} catch ( ArgException | NoThisTeacherException | RepeatedLeaveLeavesException | DateExpiredException | OverALException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void undoMe() {
		e.removeLeave(r);
		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		try {
			e.addLeave(r);
			addUndoCommand(this);
		} catch ( RepeatedLeaveLeavesException | DateExpiredException | OverALException e) {
			System.out.println(e.getMessage());
		}
	}
}