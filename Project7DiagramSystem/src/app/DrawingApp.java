package app;

import java.util.Random;

public class DrawingApp {
	public static String getRectangle(int maxRows, int maxCols, char symbol) {
		String drawing = "";

		if (maxRows < 1 || maxCols < 1) {
			return null;
		} else {
			for (int i = 1; i <= maxRows; i++) {
				for (int j = 1; j <= maxCols; j++) {

					drawing += symbol;
				}
				if (i < maxRows) {
					drawing += "\n";
				}
			}
			return drawing;
		}

	}

	public static String getFlag(int size, char color1, char color2, char color3) {

		String flag = "";
		int col = 5 * size;

		if (size < 3) {
			return null;
		} else {

			for (int i = 1; i <= size; i++) {
				for (int j = 1; j <= col; j++) {
					if (j <= i) {
						flag += color1;
					} else if (i == 1 || i == size) {
						flag += color2;
					} else {
						flag += color3;
					}
				}
				flag += "\n";
			}
			for (int i = size; i >= 1; i--) {
				for (int j = 1; j <= col; j++) {
					if (j <= i) {
						flag += color1;
					} else if (i == size || i == 1) {
						flag += color2;
					} else {
						flag += color3;
					}
				}
				if (i > 1) {
					flag += "\n";
				}
			}
		}
		return flag;

	}

	public static String getHorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {

		String horizBars = "";
		int k = (maxRows / bars);

		if (k < 1 || isValidColor(color1) == false || isValidColor(color2) == false || isValidColor(color3) == false) {
			return null;
		} else {
			for (int b = 1; b <= bars; b++) {
				if (b % 3 == 1) {
					for (int i = 1; i <= k; i++) {
						for (int j = 1; j <= maxCols; j++) {
							horizBars += color1;
						}
						if (b != bars || i != k) {
							horizBars += "\n";
						}
					}
				} else if (b % 3 == 2) {
					for (int i = 1; i <= k; i++) {
						for (int j = 1; j <= maxCols; j++) {
							horizBars += color2;
						}
						if (b != bars || i != k) {
							horizBars += "\n";
						}
					}
				} else {
					for (int i = 1; i <= k; i++) {
						for (int j = 1; j <= maxCols; j++) {
							horizBars += color3;
						}
						if (b != bars || i != k) {
							horizBars += "\n";
						}
					}
				}
			}
		}
		return horizBars;
	}

	public static String getVerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {

		String verBars = "";
		int k = (maxCols / bars);

		if (k < 1 || isValidColor(color1) == false || isValidColor(color2) == false || isValidColor(color3) == false) {
			return null;
		} else {
			for (int b = 1; b <= maxRows; b++) {
				for (int j = 1; j <= bars; j++) {
					if (j % 3 == 1) {
						for (int i = 1; i <= k; i++) {
							verBars += color1;
						}
					} else if (j % 3 == 2) {
						for (int i = 1; i <= k; i++) {
							verBars += color2;
						}
					} else {
						for (int i = 1; i <= k; i++) {
							verBars += color3;
						}
					}
				}
				if (b < maxRows) {
					verBars += "\n";
				}

			}

		}
		return verBars;
	}

	public static char getRandomColor(Random random) {
		int rand = random.nextInt(6);
		char color;
		if (rand == 0) {
			color = 'R';
		} else if (rand == 1) {
			color = 'G';
		} else if (rand == 2) {
			color = 'B';
		} else if (rand == 3) {
			color = 'Y';
		} else if (rand == 4) {
			color = '*';
		} else if (rand == 5) {
			color = '.';
		} else {
			color = 'X';
		}
		return color;
	}

	private static boolean isValidColor(char color) {
		boolean validColor = false;

		if (color == 'R') {
			validColor = true;
		} else if (color == 'G') {
			validColor = true;
		} else if (color == 'B') {
			validColor = true;
		} else if (color == 'Y') {
			validColor = true;
		} else if (color == '*') {
			validColor = true;
		} else if (color == '.') {
			validColor = true;
		} else {
			validColor = false;
		}
		return validColor;
	}
}