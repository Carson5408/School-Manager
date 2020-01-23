package Software;
public class DateUpdateCM extends RecordedCommand {

	Date oDay, nDay;

	@Override
	public void run(String[] cmdParts) {
		oDay = DateMain.getInstance().clone();
		DateMain.getInstance().set(cmdParts[1]);

		addUndoCommand(this);
		clearRedoList();

		System.out.println("Date updated: "+ cmdParts[1]);
	}

	@Override
	public void undoMe() {
		nDay = DateMain.getInstance().clone();
		DateMain.getInstance().set(oDay.toString());

		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		DateMain.getInstance().set(nDay.toString());

		addUndoCommand(this);
	}
}
