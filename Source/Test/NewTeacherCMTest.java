package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import Software.NewTeacherCM;

class NewTeacherCMTest {

	@Test
	void test01() throws Exception {
		setOutput();
		NewTeacherCM takeleave = new NewTeacherCM();
		String cmdLine = "newTeacher//Kent//30";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		assertEquals("Hired Kent with 30 days annual leave.\r\n" + 
				"", getOutput());
		takeleave.undoMe();
		takeleave.redoMe();
		assertEquals("Hired Kent with 30 days annual leave.\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test02() throws Exception {
		setOutput();
		NewTeacherCM takeleave = new NewTeacherCM();
		String cmdLine = "newTeacher//Kent";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		assertEquals("Lack of Argurment!\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test03() throws Exception {
		setOutput();
		NewTeacherCM takeleave = new NewTeacherCM();
		String cmdLine = "newTeacher//Kent//1000";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		assertEquals("Too much Annual leaves (0-300)!\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test04() throws Exception {
		setOutput();
		NewTeacherCM takeleave = new NewTeacherCM();
		String cmdLine = "newTeacher//Kent//-10";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		assertEquals("Too much Annual leaves (0-300)!\r\n" + 
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
