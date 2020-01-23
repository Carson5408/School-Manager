package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Software.Club;
import Software.ClubExistedException;
import Software.ClubNotFoundException;
import Software.School;
import Software.Teacher;
import Software.TeacherExistedException;

class SchoolTest {

	School school = School.getInstance();
	
	@Test
	void test01() throws Exception{
		setOutput();
		String name = "Kenny";
		int leaves = 30;
		Assertions.assertThrows(TeacherExistedException.class, () -> school.createTeacher(name, leaves));
	}
	
	@Test
	void test02() throws Exception{
		setOutput();
		String name = "Candy";
		String clubName = "Football Club";
		Assertions.assertThrows(ClubExistedException.class, () -> school.createClub(clubName, name));
	}
	
	@Test
	void test03() throws Exception{
		setOutput();
		String name = "Candy";
		String clubName = "Chess Club";
		school.createClub(clubName, name);
		assertEquals("", getOutput());
	}
	
	@Test
	void test04() throws Exception{
		setOutput();
		String name = "Jacky";
		String clubName = "Golf Club";
		int leaves = 20;
		Teacher teacher = school.createTeacher(name, leaves);
		Club club = school.createClub(clubName, name);
		school.removeClub(club);
		school.addClub(club);
		school.removeTeacher(teacher);
		school.addTeacher(teacher);
		assertEquals("", getOutput());
	}
	
	@Test
	void test05() throws Exception{
		setOutput();
		school.listTeacher();
		assertEquals("Candy (Leaves: 8 days)"
				+ "Carson (Leaves: 30 days)"
				+ "Gigi (Leaves: 100 days)"
				+ "Jacky (Leaves: 20 days)"
				+ "Ken (Leaves: 50 days)"
				+ "Kenny (Leaves: 30 days)"
				+ "Kent (Leaves: 30 days)"
				+ "Panda (Leaves: 100 days)"
				+ "Vincent (Leaves: 30 days)", getOutput());
	}
	
	@Test
	void test06() throws Exception{
		setOutput();
		school.listLeaves(); 
		assertEquals("Candy:\r\n" + 
				"3-Nov-2019 to 4-Nov-2019\r\n" + 
				"Carson:\r\n" + 
				"No leave record\r\n" + 
				"Gigi:\r\n" + 
				"No leave record\r\n" + 
				"Jacky:\r\n" + 
				"No leave record\r\n" + 
				"Ken:\r\n" + 
				"No leave record\r\n" + 
				"Kenny:\r\n" + 
				"No leave record\r\n" + 
				"Kent:\r\n" + 
				"No leave record\r\n" + 
				"Panda:\r\n" + 
				"No leave record\r\n" + 
				"Vincent:\r\n" + 
				"No leave record\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test07() throws Exception{
		setOutput();
		school.listClubTutors();
		assertEquals("Badminton Club:\r\n" + 
				"Gigi\r\n" + 
				"Panda (Main Tutor of the Club)\r\n" + 
				"\r\n" + 
				"Chess Club:\r\n" + 
				"Candy (Main Tutor of the Club)\r\n" + 
				"\r\n" + 
				"E-sports Club:\r\n" + 
				"Carson (Main Tutor of the Club)\r\n" + 
				"Vincent\r\n" + 
				"\r\n" + 
				"Football Club:\r\n" + 
				"Candy\r\n" + 
				"Kenny (Main Tutor of the Club)\r\n" + 
				"\r\n" + 
				"Golf Club:\r\n" + 
				"Jacky (Main Tutor of the Club)\r\n" + 
				"\r\n" + 
				"Gym Club:\r\n" + 
				"Panda (Main Tutor of the Club)\r\n" + 
				"\r\n" + 
				"Volleyball Club:\r\n" + 
				"Vincent (Main Tutor of the Club)\r\n" + 
				"\r\n" + 
				"", getOutput());
	}
	
	@Test
	void test08() throws Exception{
		setOutput();
		String name = "Jacky";
		school.searchTeacher(name);
		assertEquals("", getOutput());
	}
	
	@Test
	void test09() throws Exception{
		setOutput();
		String name = "Golf Club";
		school.searchClub(name);
		assertEquals("", getOutput());
	}
	
	@Test
	void test10() throws Exception{
		setOutput();
		String name = "Basketball Club";
		Assertions.assertThrows(ClubNotFoundException.class, () -> school.searchClub(name));
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
