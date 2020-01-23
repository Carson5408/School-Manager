package Software;
public class ListLeavesCM extends RecordedCommand {

	School co = School.getInstance();

	@Override
	public void run(String[] cmdParts) {
		if (cmdParts.length > 1) {
			try {
				Teacher e = co.searchTeacher(cmdParts[1]);
				e.listAllLeaves();
			} catch ( NoThisTeacherException e) {
				System.out.println(e.getMessage());
			}
		} else
			co.listLeaves();
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
