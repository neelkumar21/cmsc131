package system;

public class TwoDimArrayUtil {

	public static char[][] swapFirstAndSecondRow(char[][] array) {
		String errorMessage = "Error: we only accept arrays with 2 rows that have same # of columns";
		if (array[0].length != array[1].length || array.length != 2) {
			throw new IllegalArgumentException(errorMessage);
		}

		char[][] answer = new char[array.length][];

		answer[0] = new char[array[0].length];
		answer[1] = new char[array[1].length];

		/* Copying rows into new array so they are flipped */
		for (int col = 0; col < array[0].length; col++) {
			answer[0][col] = array[1][col];
			answer[1][col] = array[0][col];
		}

		return answer;
	}

	public static boolean isRagged(char[][] array) {
		int length = array[0].length;
		for (int row = 1; row < array.length; row++) {
			if (length > array[row].length || length < array[row].length) {
				return true;
			}

		}
		return false;
	}

	public static void rotateTopOneRow(char[][] array) {

		if (array.length == 1 || array == null || isRagged(array)) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		char[] rowOne = array[0];
		for (int row = 0; row < array.length - 1; row++) {
			array[row] = array[row + 1];
		}
		array[array.length - 1] = rowOne;
	}

	public static void rotateLeftOneColumn​(char[][] array) {
		if (array[0].length == 1 || array == null || isRagged(array)) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		char first;
		for (int i = 0; i < array.length; i++) {
			first = array[i][0];
			for (int j = 0; j < array[i].length - 1; j++) {
				array[i][j] = array[i][j + 1];
			}
			array[i][array[i].length - 1] = first;
		}

	}

	public static char[][] appendTopBottom​(char[][] top, char[][] bottom) {
		char[][] returnArray = new char[top.length + bottom.length][];
		for (int row = 0; row < top.length; row++) {
			returnArray[row] = top[row];
		}
		for (int row = 0; row < bottom.length; row++) {
			returnArray[row + top.length] = bottom[row];
		}
		return returnArray;
	}

	public static char[][] appendLeftRight(char[][] left, char[][] right) {
		char[][] returnArray;
		int llength = 0;
		int rlength = 0;
		if (left.length > right.length) {
			returnArray = new char[left.length][];
		} else {
			returnArray = new char[right.length][];
		}

		for (int row = 0; row < returnArray.length; row++) {
			if (left.length - 1 < row) {
				llength = 0;
				rlength = right[row].length;
				returnArray[row] = new char[rlength];
			} else if (right.length - 1 < row) {
				llength = left[row].length;
				rlength = 0;
				returnArray[row] = new char[llength];
			} else {
				llength = left[row].length;
				rlength = right[row].length;
				returnArray[row] = new char[llength + rlength];
			}
			for (int col = 0; col < llength + rlength; col++) {
				if (col < llength) {
					returnArray[row][col] = left[row][col];
				} else {
					returnArray[row][col] = right[row][col - llength];
				}
			}
		}

		return returnArray;
	}
}
