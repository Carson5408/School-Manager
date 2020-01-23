package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import Software.ListRolesCM;

class ListRolesCMTest {

	@Test
	void test01() throws Exception {
		setOutput();
		ListRolesCM takeleave = new ListRolesCM();
		String cmdLine = "listRoles";
		String[] cmdLineParts = cmdLine.split("\\//");
		takeleave.run(cmdLineParts);
		takeleave.undoMe();
		takeleave.redoMe();
		assertEquals("Lack of Argurment!\r\n" + 
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
