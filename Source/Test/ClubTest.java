package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Software.Club;
import Software.DateMain;
import Software.School;
import Software.Teacher;
import Software.TeacherExistedInClubException;

class ClubTest {
	
	School school = School.getInstance();

	@Test
	void test01() throws Exception{
		setOutput();		
		DateMain.createTheInstance("01-Nov-2019");
		String name = "Kenny";
		int leaves = 30;
		String clubName = "Football Club";
		school.createTeacher(name, leaves);		
		Club club = school.createClub(clubName, name);	
		assertEquals("Football Club", club.getName());
	}
	
	@Test
	void test02() throws Exception{
		setOutput();	
		String clubName = "Football Club";
		Club club = school.searchClub(clubName);
		assertEquals("Kenny", club.getLeaderName());
	}
	
	@Test
	void test03() throws Exception{
		setOutput();		
		school.listClubs();
		assertEquals("Badminton Club                Panda                         1-Nov-2019                    Football Club                 Kenny                         1-Nov-2019                    ", getOutput());
	}
	
	@Test
	void test04() throws Exception{
		setOutput();
		String clubName = "Football Club";
		String name1 = "Kenny";
		String name2 = "Candy";
		int leaves = 10;
		Club club = school.searchClub(clubName);
		Teacher teacher = school.searchTeacher(name1);
		Teacher teacher2 = school.createTeacher(name2, leaves);
		club.addClubTutor(teacher2);
		Assertions.assertThrows(TeacherExistedInClubException.class, () -> club.addClubTutor(teacher));
	}
	
	@Test
	void test05() throws Exception{
		setOutput();
		Teacher teacher = school.searchTeacher("Kenny");
		Club club = school.searchClub("Football Club");
		club.removeClubTutor(teacher);
		club.addClubTutor(teacher);
		club.removeAllClubTutor();
		assertEquals("", getOutput());
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
