package system;

public class TwoDimArrayUtil {
	public static boolean isRagged(char[][] array) {
		for (char[] i : array) {
			if (i.length != array[0].length) {
				return true;
			}
		}
		return false;
	}

	public static void rotateTopOneRow(char[][] array) {
		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException();
		} else {
			char[] temp = new char[array.length];
			temp = array[0];
			for (int row = 0; row < array.length - 1; row++) {
				array[row] = array[row + 1];
			}
			array[array.length - 1] = temp;
		}
	}

	public static void rotateLeftOneColumn(char[][] array) {
		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException();
		} else {
			for (int row = 0; row < array.length; row++) {
				for (int col = 0; col < array[row].length - 1; col++) {
					char temp = array[row][col];
					array[row][col] = array[row][col + 1];
					array[row][col + 1] = temp;
				}
			}
		}
	}

	public static char[][] appendTopBottom(char[][] top, char[][] bottom) {
		int totalLength = top.length + bottom.length;
		char[][] combined = new char[totalLength][];
		for (int i = 0; i < top.length; i++) {
			combined[i] = top[i];
		}
		for (int i = top.length, j = 0; i < totalLength; i++) {
			combined[i] = bottom[j++];
		}

		return combined;
	}

	public static char[][] appendLeftRight(char[][] left, char[][] right) {
		int totalRow = (left.length >= right.length ? left.length : right.length);

		char[][] combined = new char[totalRow][];
		for (int i = 0; i < totalRow; i++) {
			int leftColLength = 0, rightColLength = 0;
			if (left.length > i && left[i] != null) {
				leftColLength = left[i].length;
			}
			if (right.length > i && right[i] != null) {
				rightColLength = right[i].length;
			}
			int totalCol = leftColLength + rightColLength;
			combined[i] = new char[totalCol];
		}

		for (int i = 0; i < left.length; i++) {
			for (int j = 0; j < left[i].length; j++) {
				combined[i][j] = left[i][j];
			}
		}
		for (int i = 0; i < right.length; i++) {
			for (int j = 0; j < right[i].length; j++) {
				if (left.length > i && left[i] != null) {
					combined[i][j + left[i].length] = right[i][j];
				} else {
					combined[i][j] = right[i][j];
				}
			}
		}
		return combined;
	}
}
