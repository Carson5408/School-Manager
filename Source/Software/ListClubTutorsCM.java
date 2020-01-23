package Software;
public class ListClubTutorsCM extends RecordedCommand {

	@Override
	public void run(String[] cmdParts) {
		School co = School.getInstance();
		co.listClubTutors();
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
