package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import system.TwoDimArrayUtil;

public class StudentTests {
	
	private static String getStringForTwoDimArray(char[][] data) {
		String answer = "";

		for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
			answer += Arrays.toString(data[rowIndex]);
		}

		return answer;
	}
	
	@Test
	public void test() {
		char[][] myArray = { {'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd'}};
		char[][] myArray2 = { {'d', 'c', 'b', 'a' , 'f'}, {'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd' , 'e'}};
		TwoDimArrayUtil.appendLeftRight(myArray, myArray2);
		System.out.println(getStringForTwoDimArray(TwoDimArrayUtil.appendTopBottom​(myArray, myArray2)));
	}

}
