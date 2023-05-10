package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import photomanager.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {

	@Test
	public void PhotoTestPhotoConsToString() {
		String answer = "";
		Photo photo1 = new Photo("umcp/college200.jpg", 202, 2, "11/15/2001-15:05");
		answer += photo1;
		assertTrue(answer.equals("umcp/college200.jpg,202,2,11/15/2001-15:05"));
	}

	@Test
	public void PhotoTestGetMethods() {
		String answer = "";
		Photo photo1 = new Photo("umcp/college131.jpg", 140, 216, "05/28/2003-13:39");
		String key = "";
		key += photo1;
		answer += photo1.getPhotoSource() + ',';
		answer += photo1.getWidth() + ",";
		answer += photo1.getHeight() + ",";
		answer += photo1.getDate();
		assertTrue(answer.equals(key));
	}

	@Test
	public void PhotoTestComments() {
		String answer = "";
		Photo photo1 = new Photo("umcp/math140.jpg", 4, 300, "04/12/2020-18:00");

		photo1.addComments("Problem3");
		photo1.addComments("Solved");
		answer += "Comments: " + photo1.getComments();
		assertTrue(answer.equals("Comments: Problem3,Solved"));
	}

	@Test
	public void PhotoTestCopyCons() {
		String answer = "";
		Photo photo1 = new Photo("umcp/chem135.jpg", 100, 200, "10/28/2021-11:00");
		photo1.addComments("Exam Day");
		Photo photo2 = new Photo(photo1);
		photo2.addComments("Finished");
		answer += photo1.getComments();
		answer += photo2.getComments();
		assertTrue(answer.equals("Exam DayExam Day,Finished"));
	}

	@Test
	public void PhotoTestCompareTo() {
		long answer;
		Photo photo1 = new Photo("umcp/engl101.jpg", 100, 100, "01/12/2020-00:00");
		Photo photo2 = new Photo("umcp/cpss100.jpg,", 150, 300, "06/17/2016-15:00");
		answer = photo1.compareTo(photo2);
		assertTrue(answer > 0);
	}

	@Test
	public void PMTestAddPhotoToString() {
		String answer = "";
		PhotoManager photomanager1 = new PhotoManager();
		photomanager1.addPhoto("umcp/engl101.jpg", 100, 100, "01/12/2020-00:00");
		photomanager1.addPhoto("umcp/cpss100.jpg,", 150, 300, "06/17/2016-15:00");
		answer += photomanager1;
		assertTrue(answer.equals(photomanager1.toString()));
	}

	@Test
	public void PMTestFindPhoto() {
		int answer;
		PhotoManager photomanager1 = new PhotoManager();
		photomanager1.addPhoto("umcp/chem135.jpg", 100, 200, "10/28/2021-11:00");
		photomanager1.addPhoto("umcp/math140.jpg", 4, 300, "04/12/2020-18:00");
		answer = photomanager1.findPhoto("umcp/cmsc131.jpg");
		assertTrue(answer == -1);
	}

	@Test
	public void PMTestComments() {
		boolean answer;
		PhotoManager photomanager1 = new PhotoManager();
		photomanager1.addPhoto("umcp/cmsc131.jpg", 100, 100, "10/31/2013-17:38");
		answer = photomanager1.addComment("umcp/math140.jpg", "LOL");
		assertFalse(answer);
	}

	@Test
	public void PMTestRemoveAll() {
		PhotoManager photomanager1 = new PhotoManager();
		photomanager1.addPhoto("umcp/chem135.jpg", 100, 200, "10/28/2021-11:00");
		photomanager1.addComment("umcp/chem135.jpg", "Nelson is God");
		photomanager1.removeAllPhotos();
		assertTrue(photomanager1.toString().isBlank());
	}

	@Test
	public void PMTestRemoveOne() {
		boolean answer;
		PhotoManager photomanager1 = new PhotoManager();
		photomanager1.addPhoto("umcp/chem135.jpg", 100, 200, "10/28/2021-11:00");
		photomanager1.addPhoto("umcp/math140.jpg", 4, 300, "04/12/2020-18:00");
		answer = photomanager1.removePhoto("umcp/chem135.jpg");
		assertTrue(answer);
	}

	@Test
	public void PMTestRemoveNull() {
		boolean answer;
		PhotoManager photomanager1 = new PhotoManager();
		photomanager1.addPhoto("umcp/chem135.jpg", 100, 200, "10/28/2021-11:00");
		photomanager1.addPhoto("umcp/math140.jpg", 4, 300, "04/12/2020-18:00");
		answer = photomanager1.removePhoto("null");
		assertFalse(answer);
	}

	@Test
	public void PMTestLoad() {
		boolean answer;
		PhotoManager photomanager1 = new PhotoManager();
		answer = photomanager1.loadPhotos("RandomFileName.txt");
		assertFalse(answer);
	}

	@Test
	public void PMTestSort() {
		String answer = "";
		PhotoManager photomanager1 = new PhotoManager();
		photomanager1.addPhoto("umcp/chem135.jpg", 100, 200, "10/28/2021-11:00");
		photomanager1.addPhoto("umcp/math140.jpg", 4, 300, "04/12/2020-18:00");
		photomanager1.addPhoto("umcp/cmsc131.jpg", 100, 100, "10/31/2013-17:38");
		photomanager1.addPhoto("umcp/engl101.jpg", 100, 100, "01/12/2020-00:00");
		photomanager1.addPhoto("umcp/cpss100.jpg,", 150, 300, "06/17/2016-15:00");
		photomanager1.addPhoto("umcp/college131.jpg", 140, 216, "05/28/2003-13:39");
		photomanager1.addPhoto("umcp/college200.jpg", 202, 2, "11/15/2001-15:05");
		photomanager1.sortPhotosByDate();
		answer += photomanager1;
		System.out.println(answer);
		assertTrue(answer.equals(
				"umcp/college200.jpg,202,2,11/15/2001-15:05\n"
				+ "umcp/college131.jpg,140,216,05/28/2003-13:39\n"
				+ "umcp/cmsc131.jpg,100,100,10/31/2013-17:38\n"
				+ "umcp/cpss100.jpg,,150,300,06/17/2016-15:00\n"
				+ "umcp/engl101.jpg,100,100,01/12/2020-00:00\n"
				+ "umcp/math140.jpg,4,300,04/12/2020-18:00\n"
				+ "umcp/chem135.jpg,100,200,10/28/2021-11:00\n"));
	}
}