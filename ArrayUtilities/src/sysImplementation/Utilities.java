package sysImplementation;

import java.util.Arrays;

public class Utilities {

	public static java.lang.String getArrayString​(int[] array, char separator) {
		if (array == null) {
			throw new IllegalArgumentException("Invalid Arguments");
		}
		String string = "";
		for (int i = 0; i < array.length; i++) {
			string += array[i];
			if (i < array.length - 1) {
				string += separator;
			}
		}
		return string;
	}

	public static int getInstances​(int[] array, int lowerLimit, int upperLimit) {
		if (array == null) {
			throw new IllegalArgumentException("Invalid Arguments");
		}
		int values = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= upperLimit && array[i] >= lowerLimit) {
				values++;
			}
		}
		return values;
	}

	public static int[] filter​(int[] array, int lowerLimit, int upperLimit) {
		if (array == null || lowerLimit > upperLimit) {
			throw new IllegalArgumentException("Invalid Arguments");
		}
		int index = 0;
		int[] newArray = new int[getInstances​(array, lowerLimit, upperLimit)];
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= upperLimit && array[i] >= lowerLimit) {
				newArray[index] = array[i];
				index++;
			}
		}
		return newArray;
	}

	private static void rotateLeft(int[] array) {
		int newValue = array[0];
		int[] newArray = new int[array.length];
		for (int i = array.length - 1; i > 0; i--) {
			newArray[i - 1] = array[i];
		}
		newArray[array.length - 1] = newValue;

		for (int i = 0; i < array.length; i++) {
			array[i] = newArray[i];
		}
	}

	private static void rotateRight(int[] array) {
		int newValue = array[array.length - 1];
		int[] newArray = new int[array.length];
		for (int i = 0; i < array.length - 1; i++) {
			newArray[i + 1] = array[i];
		}
		newArray[0] = newValue;

		for (int i = 0; i < array.length; i++) {
			array[i] = newArray[i];
		}
	}

	public static void rotate​(int[] array, boolean leftRotation, int positions) {
		if (array == null) {
			throw new IllegalArgumentException("Invalid Arguments");
		}
		for (int i = 0; i < positions; i++) {
			if (leftRotation) {
				rotateLeft(array);
			} else {
				rotateRight(array);
			}

		}

	}

	public static java.lang.StringBuffer[] getArrayStringsLongerThan​(java.lang.StringBuffer[] array, int length) {
		if (array == null) {
			throw new IllegalArgumentException("Invalid Arguments");
		}
		int numberGreater = 0;
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() > length) {
				numberGreater++;
			}
		}
		StringBuffer[] newArray = new StringBuffer[numberGreater];
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() > length) {
				newArray[index] = array[i];
				index++;
			}
		}
		return newArray;

	}

}