package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import Software.Main;

class MainTest {
	@Test
	public void testMain01() throws Exception {
	    String[] args = null;
	    final java.io.InputStream original = System.in;
	    final FileInputStream fips = new FileInputStream(new File("./Path.txt"));
	    System.setIn(fips);
	    Main.main(args);
	    System.setIn(original);
	}
	
	@Test
	public void testMain02() throws Exception {
		setOutput();
	    String[] args = null;
	    final java.io.InputStream original = System.in;
	    final FileInputStream fips = new FileInputStream(new File("./FileNotFoundException.txt"));
	    System.setIn(fips);
	    Main.main(args);
	    System.setIn(original);
	    assertEquals("Please input the file pathname: File not found!\r\n" + 
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
