package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import system.TwoDimArrayUtil;

public class StudentTests {

	@Test
	public void testIsRagged() {
		char[][] test = new char[][] { new char[] { 'a', 'b', 'c' }, new char[] { 'd', 'e', 'f', 'g' },
				new char[] { 'h', 'j', 'i' } };
		assertTrue(TwoDimArrayUtil.isRagged(test));
	}

	@Test
	public void testAppendLeftRight() {
		String answer = "";
		char[][] left = new char[][] { new char[] { 'a', 'b', 'c' }, new char[] { 'd', 'e', 'f', 'g' },
				new char[] { 'h', 'j', 'i' } };
		char[][] right = new char[][] { new char[] { 'k' }, new char[] { 'l' }, new char[] { 'm', 'n', 'o', 'p' },
				new char[] { 'q', 'r', 's', 't' } };
		char[][] combined = TwoDimArrayUtil.appendLeftRight(left,right);
		for(int i = 0; i < combined.length; i++) {
			for(int j = 0; j < combined[i].length; j++) {
				answer += combined[i][j];
			}
		}
		System.out.println(answer);
		assertEquals(answer, "abckdefglhjimnopqrst");
	}
}
