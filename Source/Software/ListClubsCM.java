package Software;
public class ListClubsCM extends RecordedCommand {

	@Override
	public void run(String[] cmdParts) {
		School school = School.getInstance();
		school.listClubs();
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
