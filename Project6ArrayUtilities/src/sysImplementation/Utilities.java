package sysImplementation;

public class Utilities {
	public static String getArrayString(int[] array, char separator) {
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

	public static int getInstances(int[] array, int lowerLimit, int upperLimit) {
		int answer = 0;
		if (array == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i] >= lowerLimit && array[i] <= upperLimit) {
					answer++;
				}
			}
		}
		return answer;
	}

	public static int[] filter(int[] array, int lowerLimit, int upperLimit) {
		int size = 0;
		if (array == null || lowerLimit > upperLimit) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i] >= lowerLimit && array[i] <= upperLimit) {
					size++;
				}
			}
		}
		int[] filtered = new int[size];
		for (int i = 0, j = 0; i < array.length; i++) {
			if (array[i] >= lowerLimit && array[i] <= upperLimit) {
				filtered[j++] = array[i];
			}
		}
		return filtered;
	}

	public static void rotate(int[] array, boolean leftRotation, int positions) {
		if (array == null) {
			throw new IllegalArgumentException();
		} else {
			if (leftRotation == true) {
				int[] rotated = leftRotate(array, positions);
				for (int i = 0; i < array.length; i++) {
					array[i] = rotated[i];
				}
			}
			if (leftRotation == false) {
				int[] rotated = rightRotate(array, positions);
				for (int i = 0; i < array.length; i++) {
					array[i] = rotated[i];
				}
			}
		}
	}

	public static StringBuffer[] getArrayStringsLongerThan(StringBuffer[] array, int length) {
		int size = 0;
		if (array == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i].length() > length) {
					size++;
				}
			}
		}
		StringBuffer[] copy = new StringBuffer[size];
		for (int i = 0, j = 0; i < array.length; i++) {
			if (array[i].length() > length) {
				copy[j++] = array[i];
			}
		}
		return copy;
	}

	private static int[] leftRotate(int[] array, int positions) {
		int[] rotated = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			if (i - positions >= 0) {
				rotated[i - positions] = array[i];
			} else {
				rotated[i - positions + array.length] = array[i];
			}
		}

		return rotated;
	}

	private static int[] rightRotate(int[] array, int positions) {
		int[] rotated = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			rotated[(positions + i) % array.length] = array[i];
		}

		return rotated;
	}

}