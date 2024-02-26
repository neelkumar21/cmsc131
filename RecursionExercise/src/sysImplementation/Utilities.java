package sysImplementation;

import java.util.ArrayList;

public class Utilities {

	public static String addDelimiter(String str, char delimeter) {
		if (0 < str.length() - 1) {
			return str.substring(0, 1) + delimeter + addDelimiter(str.substring(1), delimeter);
		} else {
			return str;
		}
	}

	public static String getDigits(String str) {
		if (0 <= str.length() - 1) {
			if (Character.isDigit(str.charAt(0))) {
				return str.substring(0, 1) + "" + getDigits(str.substring(1));
			} else {
				return getDigits(str.substring(1));
			}
		}

		return "";
	}

	public static void replaceCharacter(char[] array, char target, char replacement) {
		changeArrayCharacter(array, target, replacement, 0);
	}

	private static void changeArrayCharacter(char[] array, char target, char replacement, int index) {
		if (index <= array.length - 1) {
			if (array[index] == target) {
				array[index] = replacement;
			}
			changeArrayCharacter(array, target, replacement, index + 1);
		}
	}

	public static int getSumEven(int[] array) {
		return addEven(array, 0);
	}

	private static int addEven(int[] array, int index) {
		if (index <= array.length - 1) {
			if (array[index] % 2 == 0) {
				return array[index] + addEven(array, index + 1);
			} else {
				return addEven(array, index + 1);
			}
		}
		return 0;
	}

	public static ArrayList<Integer> getListRowIndices(int[][] array, int rowLength) {
		ArrayList<Integer> indices = new ArrayList<>();
		rowLengths(array, 0, rowLength, indices);
		return indices;
	}

	private static ArrayList<Integer> rowLengths(int[][] array, int rowNumber, int rowLength,
			ArrayList<Integer> indices) {
		if (rowNumber <= array.length - 1) {
			if (rowLength == array[rowNumber].length) {
				indices.add(rowNumber);
			}
			rowLengths(array, rowNumber + 1, rowLength, indices);
		}

		return indices;
	}

	public static int replaceCells(char[][] array, int x, int y, char target, char replacement) {
		return replaceAround(array, x, y, 0, target, replacement);

	}

	private static int replaceAround(char[][] array, int x, int y, int replaced, char target, char replacement) {
		if (isValidCell(array, x, y)) {
			if (array[x][y] == target) {
				array[x][y] = replacement;
				replaced = 1;
			} else {
				return 0;
			}

		} else {
			return 0;
		}
		if (isValidCell(array, x - 1, y - 1)) {
			replaced += replaceAround(array, x - 1, y - 1, replaced, target, replacement);
		}
		if (isValidCell(array, x - 1, y)) {
			replaced += replaceAround(array, x - 1, y, replaced, target, replacement);
		}
		if (isValidCell(array, x - 1, y + 1)) {
			replaced += replaceAround(array, x - 1, y + 1, replaced, target, replacement);
		}
		if (isValidCell(array, x, y - 1)) {
			replaced += replaceAround(array, x, y - 1, replaced, target, replacement);
		}
		if (isValidCell(array, x, y + 1)) {
			replaced += replaceAround(array, x, y + 1, replaced, target, replacement);
		}
		if (isValidCell(array, x + 1, y - 1)) {
			replaced += replaceAround(array, x + 1, y - 1, replaced, target, replacement);
		}
		if (isValidCell(array, x + 1, y)) {
			replaced += replaceAround(array, x + 1, y, replaced, target, replacement);
		}
		if (isValidCell(array, x + 1, y + 1)) {
			replaced += replaceAround(array, x + 1, y + 1, replaced, target, replacement);
		}

		return replaced;

	}

	private static boolean isValidCell(char[][] array, int x, int y) {
		if (x <= array.length - 1 && x > -1) {
			if (y <= array[x].length - 1 && y > -1) {
				return true;
			}
		}
		return false;

	}
}
