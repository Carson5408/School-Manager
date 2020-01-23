package Software;
public class ListTeachersCM extends RecordedCommand {

	@Override
	public void run(String[] cmdParts) {
		School school = School.getInstance();
		school.listTeacher();
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
