package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import Software.School;
import Software.TakeLeaveCM;

class TakeLeaveCMTest {

	School co = School.getInstance();

	@Test
	void test01() throws Exception {
		setOutput();
		co.createTeacher("Sharon", 100);
		TakeLeaveCM takeleave = new TakeLeaveCM();
		String cmdLine = "takeLeave//NoPayLeave//Sharon//3-Nov-2019//4-Nov-2019";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		assertEquals("Sharon takes leave from 3-Nov-2019 to 4-Nov-2019.(NoPayLeave)\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test02() throws Exception{
		setOutput();
		TakeLeaveCM takeleave = new TakeLeaveCM();
		String cmdLine = "takeLeave";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		assertEquals("Lack of Argurment!\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test03() throws Exception{
		setOutput();
		TakeLeaveCM takeleave = new TakeLeaveCM();
		String cmdLine = "takeLeave//NoPayLeave//Sharon//6-Nov-2019//7-Nov-2020";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		takeleave.undoMe();
		takeleave.run(cmdLineParts);
		takeleave.redoMe();
		assertEquals("This teacher cannot take anymore leave. Quota: 98 days left only!\r\n" + 
				"Sharon takes leave from 6-Nov-2019 to 7-Nov-2020.(NoPayLeave)\r\n" + 
				"This teacher cannot take anymore leave. Quota: 98 days left only!\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test04() throws Exception{
		setOutput();
		TakeLeaveCM takeleave = new TakeLeaveCM();
		String cmdLine = "takeLeave//NoPayLeave//Sharon//6-Nov-2019//7-Nov-2020";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		takeleave.undoMe();
		takeleave.redoMe();
		assertEquals("This teacher cannot take anymore leave. Quota: 98 days left only!\r\n" + 
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
