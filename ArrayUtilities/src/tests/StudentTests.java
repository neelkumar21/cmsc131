package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import sysImplementation.Utilities;

public class StudentTests {

	int[] intArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	StringBuffer[] StringBuffer = new StringBuffer[] { new StringBuffer("cat"), new StringBuffer("fishies"),
			new StringBuffer("potatoes") };

	@Test
	public void test01getArrayString() {
		String actualResult = Utilities.getArrayString​(intArray, 'a');
		String expectedResult = "1a2a3a4a5a6a7a8a9a10";
		assertTrue(expectedResult.equals(actualResult));
	}

	@Test
	public void test02getInstances() {
		int actualInstances = Utilities.getInstances​(intArray, 3, 8);
		int expectedInstances = 6;
		assertTrue(expectedInstances == actualInstances);
	}

	@Test
	public void test03filter() {
		int[] actualArray = Utilities.filter​(intArray, 2, 7);
		int[] expectedArray = new int[] { 2, 3, 4, 5, 6, 7 };
		assertTrue(Arrays.equals(expectedArray, actualArray));
	}

	@Test
	public void test04rotate() {
		int[] expectedArray = new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		Utilities.rotate​(intArray, true, 3);
		assertTrue(Arrays.equals(expectedArray, intArray));

	}

	@Test
	public void test05getArrayStringsLongerThan() {
		StringBuffer[] expectedArray = { new StringBuffer("fishies"), new StringBuffer("potatoes") };
		StringBuffer[] actualArray = Utilities.getArrayStringsLongerThan​(StringBuffer, 3);
		assertTrue(Arrays.toString(expectedArray).equals(Arrays.toString(actualArray)));

	}
}
