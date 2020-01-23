package Software;
public class ListRolesCM extends RecordedCommand {

	@Override
	public void run(String[] cmdParts) {
		try {
			if (cmdParts.length < 2)
				throw new ArgException();

			School co = School.getInstance();
			Teacher e = co.searchTeacher(cmdParts[1]);

			e.listRoles();
		} catch ( ArgException | NoThisTeacherException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
