package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import sysImplementation.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentTests {

	@Test
	public void testAddDelimiter() {
		String answer = "";
		String str = "spring";
		char delimeter = '*';
		answer += Utilities.addDelimiter(str, delimeter);

		assertTrue(answer.equals("s*p*r*i*n*g"));
	}

	@Test
	public void testGetDigits() {
		String answer = "";
		String str = "c2o3l4le6ge";
		answer += Utilities.getDigits(str);

		assertTrue(answer.equals("2346"));
	}

	@Test
	public void testReplaceCharacter() {
		String answer = "";
		char[] array = { 'r', 'a', 'c', 'e', 'c', 'a', 'r' };
		char target = 'r', replacement = '*';
		Utilities.replaceCharacter(array, target, replacement);
		answer = Arrays.toString(array);

		assertTrue(answer.equals("[*, a, c, e, c, a, *]"));
	}

	@Test
	public void testGetSumEven() {
		int[] intArray = { 1, 5, 2, 3, 10 };
		int answer = Utilities.getSumEven(intArray);

		assertTrue(answer == 12);
	}

	@Test
	public void testGetListRowIndices() {
		int[][] twoDimArray = { { 4, 5 }, { 1, 2, 3, 4, 5, 6, 7, 10, 11, 14 }, { 2, 4, 6, 8 },
				{ 10, 21, 31, 45, 51, 62, 71, 12, 13, 14 } };
		int rowLength = 10;
		ArrayList<Integer> answer = Utilities.getListRowIndices(twoDimArray, rowLength);
		assertTrue(answer.toString().equals("[1, 3]"));
	}

	@Test
	public void testReplaceCells() {
		char[][] charArray = { { 'R', 'Y', 'R', 'Y', 'Y' }, { 'R', 'Y', 'R', 'Y', 'Y' }, { 'R', 'M', 'R', 'Y', 'Y' },
				{ 'R', 'Y', 'Y', 'Y', 'Y' }, { 'R', 'Y', 'R', 'Y', 'Y' }, { 'R', 'Y', 'R', 'Y', 'P' }, };
		int answer = Utilities.replaceCells(charArray, 1, 3, 'Y', '*');
		System.out.println(answer);
		assertTrue(answer == 15);
	}
}