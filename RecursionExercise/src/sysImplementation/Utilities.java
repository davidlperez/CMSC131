package sysImplementation;

import java.util.ArrayList;

public class Utilities {

	public static String addDelimiter(String str, char delimeter) {
		String newStr = "";
		if (str.length() > 1) {
			newStr += "" + str.charAt(0) + delimeter;
			newStr += addDelimiter(str.substring(1), delimeter);
		} else {
			return str;
		}
		return newStr;
	}

	public static String getDigits(String str) {
		String digStr = "";
		if (str.length() > 0) {
			if (Character.isDigit(str.charAt(0))) {
				digStr += str.charAt(0);
				digStr += getDigits(str.substring(1));
			} else {
				digStr += getDigits(str.substring(1));
			}
		}
		return digStr;
	}

	public static void replaceCharacter(char[] array, char target, char replacement) {
		replaceCharacterAux(array, 0, target, replacement);
	}

	private static char[] replaceCharacterAux(char[] array, int index, char target, char replacement) {
		if (index >= array.length) {
			return array;
		} else {
			if (array[index] == target) {
				array[index] = replacement;
			}
			return replaceCharacterAux(array, index + 1, target, replacement);
		}
	}

	public static int getSumEven(int[] array) {
		return getSumEvenAux(array, 0);
	}

	private static int getSumEvenAux(int[] array, int index) {
		int answer = 0;
		if (index >= array.length) {
			return answer;
		} else {
			if (array[index] % 2 == 0) {
				answer += array[index];
			}
			return answer + getSumEvenAux(array, index + 1);
		}
	}

	public static ArrayList<Integer> getListRowIndices(int[][] array, int rowLength) {
		return getListRowIndicesAux(array, 0, rowLength, new ArrayList<>());
	}

	private static ArrayList<Integer> getListRowIndicesAux(int[][] array, int index, int rowLength,
			ArrayList<Integer> answer) {
		if (index < array.length) {
			if (array[index].length == rowLength) {
				answer.add(index);
			}
			getListRowIndicesAux(array, index + 1, rowLength, answer);
		}
		return answer;

	}

	public static int replaceCells(char[][] array, int x, int y, char target, char replacement) {
		return replaceCellsAux(array, x, y, target, replacement, 0);
	}

	private static int replaceCellsAux(char[][] array, int x, int y, char target, char replacement, int count) {
		if (isValidIndex(array, x, y) && array[x][y] == target) {
			array[x][y] = replacement;
			count = count + 1;
			count = replaceCellsAux(array, x - 1, y, target, replacement, count);
			count = replaceCellsAux(array, x + 1, y, target, replacement, count);
			count = replaceCellsAux(array, x - 1, y - 1, target, replacement, count);
			count = replaceCellsAux(array, x, y - 1, target, replacement, count);
			count = replaceCellsAux(array, x + 1, y - 1, target, replacement, count);
			count = replaceCellsAux(array, x - 1, y + 1, target, replacement, count);
			count = replaceCellsAux(array, x, y + 1, target, replacement, count);
			count = replaceCellsAux(array, x + 1, y + 1, target, replacement, count);
		}
		return count;
	}

	private static boolean isValidIndex(char[][] array, int x, int y) {
		if (x >= 0 && y >= 0 && x < array.length && y < array[x].length) {
			return true;
		}
		return false;
	}
}
