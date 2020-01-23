package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import Software.CreateClubCM;
import Software.School;

class CreateClubCMTest {

	School co = School.getInstance();

	@Test
	void test01() throws Exception {
		setOutput();
		CreateClubCM takeleave = new CreateClubCM();
		String cmdLine = "createClub";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		assertEquals("Lack of Argurment!\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test02() throws Exception {
		setOutput();
		CreateClubCM takeleave = new CreateClubCM();
		String cmdLine = "createClub//Gym Club//Panda";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		takeleave.undoMe();
		takeleave.redoMe();
		assertEquals("Gym Club has been set up and Panda is the Main Tutor.\r\n" + 
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
