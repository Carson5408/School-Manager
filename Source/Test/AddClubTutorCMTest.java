package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import Software.AddClubTutorCM;
import Software.DateMain;
import Software.School;

class AddClubTutorCMTest {

	School co = School.getInstance();

	@Test
	void test01() throws Exception {
		setOutput();
		DateMain.createTheInstance("01-Nov-2019");
		co.createTeacher("Panda", 100);
		AddClubTutorCM takeleave = new AddClubTutorCM();
		String cmdLine = "addClubTutor";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		assertEquals("Date updated: 01-Nov-2019Lack of Argurment!\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test02() throws Exception {
		setOutput();
		co.createClub("Badminton Club", "Panda");
		co.createTeacher("Gigi", 100);
		AddClubTutorCM takeleave = new AddClubTutorCM();
		String cmdLine = "addClubTutor//Badminton Club//Gigi";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		takeleave.undoMe();
		takeleave.redoMe();
		assertEquals("Added Gigi to Badminton Club.\r\n" + 
				"", getOutput());
	}
	
	
	/**************************************
	 * Note: Do not modify the following part
	 ***************************************/
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}
}
