package system;

/**
 * This class provides a set of utility methods that process two-dimensional
 * arrays.
 * 
 * @author cmsc132, UMCP
 *
 */
public class TwoDimArrayUtil {

	/**
	 * Very simple example of an Array Utility method.  It takes a two-dimensional
	 * array of two rows and returns a new two-dimensional array where copies of the rows
	 * of the parameter array have been swapped.  The number of columns must be the
	 * same for each row.
	 * 
	 * @return
	 */
	public static char[][] swapFirstAndSecondRow(char[][] array) {
		String errorMessage = "Error: we only accept arrays with 2 rows that have same # of columns";
		if (array[0].length  != array[1].length || array.length != 2) {
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
}