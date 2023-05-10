package tests;

import static org.junit.Assert.*;
import sysImplementation.*;
import org.junit.Test;

public class StudentTests {

	@Test
	public void testGetArrayString() {
		int[] arr = { 1, 2, 3, 4, 5 };
		String answer = Utilities.getArrayString(arr, ',');
		assertTrue(answer.equals("1,2,3,4,5"));
	}

	@Test
	public void testGetInstances() {
		int[] arr = { 9, 3, 6, 7, 3, 1 };
		int answer = Utilities.getInstances(arr, 2, 7);
		assertTrue(answer == 4);
	}

	@Test
	public void testFilter() {
		int[] arr = { 9, 3, 6, 7, 3, 1 };
		int[] answer = Utilities.filter(arr, 2, 7);
		String result = Utilities.getArrayString(answer, '#');
		assertTrue(result.equals("3#6#7#3"));
	}

	@Test
	public void testLeftRotate() {
		String answer = "";
		int[] nums = { 9, 3, 7, 5, 4, 6, 1 };
		int move = 2;
		Utilities.rotate(nums, true, move);
		answer += Utilities.getArrayString(nums, '$');
		assertTrue(answer.equals("7$5$4$6$1$9$3"));
	}

	@Test
	public void testRightRotate() {
		String answer = "";
		int[] nums = { 9, 3, 7, 5, 4, 6, 1 };
		int move = 2;
		Utilities.rotate(nums, false, move);
		answer += Utilities.getArrayString(nums, ',');
		assertTrue(answer.equals("6,1,9,3,7,5,4"));
	}

	@Test
	public void testGetArrayStringsLongerThan() {
		String answer1 = "";
		String answer2 = "";
		StringBuffer[] animals = { new StringBuffer("dog"), new StringBuffer("cat"), new StringBuffer("elephant"),
				new StringBuffer("dolphin"), new StringBuffer("lion"), new StringBuffer("tiger") };
		answer1 += getArrayStringBuffer(Utilities.getArrayStringsLongerThan(animals, 3),'%');
		answer2 += getArrayStringBuffer(Utilities.getArrayStringsLongerThan(animals, 4),',');
		assertTrue(answer1.equals("elephant%dolphin%lion%tiger") && answer2.equals("elephant,dolphin,tiger"));
	}
	
	private static String getArrayStringBuffer(StringBuffer[] array, char separator) {
		String answer = "";

		if (array == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < array.length; i++) {
				answer += array[i];
				if (i < array.length - 1) {
					answer += separator;
				}
			}
		}
		return answer;
	}
}
