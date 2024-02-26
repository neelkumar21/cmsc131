package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import sysImplementation.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentTests {
	Utilities utilities = new Utilities();
	char test[] = { 'h', 'b', 'o', 'j', 'a', 'n' };
	int test2[] = { 3, 4, 5, 6, 7, 8 };
	int[][] test3 = new int[][] { { 8, 8, 8 }, { 6, 8, 6 }, { 7, 8, 8, 7 }, { 1, 1, 1, 1, 1 }, { 2, 2, 2 } };
	char[][] test4 = new char[][] { { 'a', 'a', 'a' }, 
									{ 'b', 'a', 'b' }, 
									{ 'c', 'a', 'a', 'c' },
									{ 'd', 'd', 'd', 'd', 'd' }, 
									{ 'e', 'e', 'e' } };

	@Test
	public void test1() {
		System.out.println(utilities.addDelimiter("hiiii", 'a'));
		System.out.println(utilities.getDigits("hii08ii"));
		utilities.replaceCharacter(test, 'a', 'b');
		System.out.println(test);
		System.out.println(utilities.getSumEven(test2));
		int[] a = { 0, 3, 5, 6, 2, 4 };
		System.out.println(utilities.getSumEven(a));
		System.out.println(utilities.getListRowIndices(test3, 3));
		System.out.println(utilities.replaceCells(test4, 1, 1, 'a', 'b'));
	}
}