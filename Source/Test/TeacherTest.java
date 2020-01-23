package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Software.Club;
import Software.Date;
import Software.DateExpiredException;
import Software.NoThisTeacherException;
import Software.OverALException;
import Software.RegisterLeave;
import Software.School;
import Software.Teacher;
import Software.RepeatedLeaveLeavesException;


class TeacherTest {

	School school = School.getInstance();
	
	@Test
	void test01() throws Exception{
		Assertions.assertThrows(NoThisTeacherException.class, () -> school.createClub("Jockey Club", "Louis"));
	}
	
	@Test
	void test02() throws Exception{
		setOutput();		
		Teacher teacher = school.searchTeacher("Jacky");
		RegisterLeave leave = new RegisterLeave(new Date("3-Nov-2019"), new Date("7-Nov-2019"));
		teacher.addLeave(leave);
		assertEquals("", getOutput());
	}
	
	@Test
	void test03() throws Exception{
		Teacher teacher = school.searchTeacher("Jacky");
		RegisterLeave leave = new RegisterLeave(new Date("15-Oct-2019"), new Date("7-Nov-2019"));
		Assertions.assertThrows(DateExpiredException.class, () -> teacher.addLeave(leave));
	}
	
	@Test
	void test04() throws Exception{
		Teacher teacher = school.searchTeacher("Candy");
		RegisterLeave leave = new RegisterLeave(new Date("2-Nov-2019"), new Date("30-Nov-2019"));
		Assertions.assertThrows(OverALException.class, () -> teacher.addLeave(leave));
	}
	
	
	@Test
	void test05() throws Exception{
		Teacher teacher = school.searchTeacher("Jacky");
		RegisterLeave leave = new RegisterLeave(new Date("4-Nov-2019"), new Date("8-Nov-2019"));
		Assertions.assertThrows(RepeatedLeaveLeavesException.class, () -> teacher.addLeave(leave));
	}
	

	@Test
	void test06() throws Exception{
		Teacher teacher = school.searchTeacher("Jacky");
		RegisterLeave leave = new RegisterLeave(new Date("4-Nov-2019"), new Date("6-Nov-2019"));
		Assertions.assertThrows(RepeatedLeaveLeavesException.class, () -> teacher.addLeave(leave));
	}
	
	@Test
	void test07() throws Exception{
		Teacher teacher = school.searchTeacher("Jacky");
		RegisterLeave leave = new RegisterLeave(new Date("2-Nov-2019"), new Date("6-Nov-2019"));
		Assertions.assertThrows(RepeatedLeaveLeavesException.class, () -> teacher.addLeave(leave));
	}
	
	@Test
	void test08() throws Exception{
		setOutput();		
		Teacher teacher = school.searchTeacher("Jacky");
		RegisterLeave leave = new RegisterLeave(new Date("8-Nov-2019"), new Date("10-Nov-2019"));
		teacher.addLeave(leave);
		teacher.removeLeave(leave);
		assertEquals("", getOutput());
	}

	@Test
	void test09() throws Exception{
		setOutput();		
		Teacher teacher = school.searchTeacher("Jacky");
		teacher.listAllLeaves();
		assertEquals("3-Nov-2019 to 7-Nov-2019\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test10() throws Exception{
		setOutput();		
		Teacher teacher = school.createTeacher("Kingson", 15);
		teacher.listRoles();
		assertEquals("No role\r\n" + 
				"", getOutput());
		teacher = school.searchTeacher("Candy");
		teacher.listRoles();
		assertEquals("No role\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test11() throws Exception{
		setOutput();		
		Teacher teacher = school.searchTeacher("Candy");
		teacher.listRoles();
		assertEquals("Chess Club (Leader of Club)\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test12() throws Exception{
		setOutput();		
		Teacher teacher = school.searchTeacher("Kingson");
		Club club = school.searchClub("Chess Club");
		club.addClubTutor(teacher);
		teacher.listRoles();
		assertEquals("Chess Club\r\n" + 
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
