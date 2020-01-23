package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import Software.ListLeavesCM;
import Software.School;

class ListLeavesCMTest {

	@Test
	void test01() throws Exception {
		setOutput();
		ListLeavesCM takeleave = new ListLeavesCM();
		String cmdLine = "listLeaves//Jacky";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		takeleave.undoMe();
		takeleave.redoMe();
		assertEquals("Teacher not found!\r\n" + 
				"", getOutput());
		
	}
	
	@Test
	void test02() throws Exception {
		setOutput();
		School co = School.getInstance();
		co.createTeacher("Ken", 50);
		ListLeavesCM takeleave = new ListLeavesCM();
		String cmdLine = "listLeaves//Ken";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		takeleave.undoMe();
		takeleave.redoMe();
		assertEquals("No leave record\r\n" + 
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
