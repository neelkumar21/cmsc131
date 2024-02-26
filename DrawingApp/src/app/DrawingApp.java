	package app;

import java.util.Random;

public class DrawingApp {
	/*
	 * For every method remove the line with "throw ..." and implement the method.
	 * We are using "throw..." so your code does not display any compilation errors
	 * when you import the zip file. Also, if you don't implement a method you will
	 * see a white square (instead of green) in the submit server
	 */
	public static String getRectangle(int maxRows, int maxCols, char symbol) {
		if(maxRows < 1 || maxCols <1 ) {
			return null;
		}
		String rectangle = "";
		for (int row = 1; row <= maxRows; row++) {
			for (int col = 1; col <= maxCols; col++) {
				rectangle += symbol;
			}
			rectangle += "\n";
		}
		rectangle = rectangle.trim();
		return rectangle;
	}

	public static String getFlag(int size, char color1, char color2, char color3) {
		if (size < 3) {
			return null;
		}
		String flag = "";
		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size * 5; col++) {
				if (row == 1) {
					if (col == 1) {
						flag += color1;
					} else {
						flag += color2;
					}
				} else if (row == size) {
					if (col <= size) {
						flag += color1;
					} else {
						flag += color2;
					}
				} else {

					if (col <= row) {
						flag += color1;
					} else {
						flag += color3;
					}
				}

			}
			flag += "\n";
		}

		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size * 5; col++) {
				if (row == size) {
					if (col == 1) {
						flag += color1;
					} else {
						flag += color2;
					}
				} else if (row == 1) {
					if (col <= size) {
						flag += color1;
					} else {
						flag += color2;
					}
				} else {
					if (col - 1 <= size - row) {
						flag += color1;
					} else {
						flag += color3;
					}
				}

			}
			flag += "\n";
		}
		flag = flag.trim();
		return flag;
	}

	public static String getHorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		if (maxRows < bars || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		}
		char color = color1;
		int size = maxRows / bars;
		String horizontalBars = "";
		for (int row = 1; row <= size * bars; row++) {
			for (int col = 1; col <= maxCols; col++) {
				horizontalBars += color;
			}
			horizontalBars += "\n";
			if (row % size == 0) {
				if (color == color1) {
					color = color2;
				} else if (color == color2) {
					color = color3;
				} else {
					color = color1;
				}
			}

		}
		horizontalBars = horizontalBars.trim();
		return horizontalBars;
	}

	public static String getVerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		if (maxCols < bars || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		}
		char color = color1;
		int size = maxCols / bars;
		String verticalBars = "";

		for (int row = 1; row <= maxRows; row++) {
			color = color1;
			for (int col = 1; col <= size * bars; col++) {
				verticalBars += color;
				if (col % size == 0) {
					if (color == color1) {
						color = color2;
					} else if (color == color2) {
						color = color3;
					} else {
						color = color1;
					}
				}

			}
			verticalBars += "\n";
		}
		verticalBars = verticalBars.trim();
		return verticalBars;
	}

	public static char getRandomColor(Random random) {
		int colorValue = random.nextInt(6);

		if (colorValue == 0) {
			return 'R';
		} else if (colorValue == 1) {
			return 'G';
		} else if (colorValue == 2) {
			return 'B';
		} else if (colorValue == 3) {
			return 'Y';
		} else if (colorValue == 4) {
			return '*';
		}

		return '.';
	}

	private static boolean isValidColor(char color) {
		if (color == 'R' || color == 'G' || color == 'B' || color == 'Y' || color == '*' || color == '.') {
			return true;
		}
		return false;
	}
}