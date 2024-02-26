package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;  /* Allow us to use Arrays.toString() */
import system.*;          /* We need access to the classes we defined */
import app.*;

public class StudentTests {

	@Test
	public void test1TwoRowsDiagram() {
		char firstRowChar = 'R', secondRowChar = 'G';
		int columns = 2;
		
		String answer = DrawingApp.getTwoRowsDiagram(firstRowChar, secondRowChar, columns);
		
		System.out.println("First Test:\n" + answer);
		assertTrue(answer.equals("RR\nGG"));
	}
	
	@Test
	public void test2Swap() {
		char[][] array = {{'R', 'R'}, {'G', 'G'}};
		
		char[][] swapped = TwoDimArrayUtil.swapFirstAndSecondRow(array);
		String answer = getStringTwoDimArrayChar(swapped);
		
		System.out.println("\nSecond Test:\n" + answer);
		assertTrue(answer.equals("[G, G]\n[R, R]"));
	}
	
	@Test
	public void test3Swap() {
		char firstRowChar = 'R', secondRowChar = 'G';
		int columns = 2;
		char[][] board;
		String answer = "";
		
		/* Creating the diagram */
		Diagram diagram = new SwapRows(firstRowChar, secondRowChar, columns);			
	
		/* Checking the board associated with the diagram */
		board = diagram.getBoard();
		answer += "\nBoard1:\n" + getStringTwoDimArrayChar(board);
		
		/* An animation step */
		board = diagram.nextAnimationStep();
		answer += "\n\nBoard2:\n" + getStringTwoDimArrayChar(board);
		
		/* Another animation step */
		board = diagram.nextAnimationStep();
		answer += "\n\nBoard3:\n" + getStringTwoDimArrayChar(board);
		
		TestingSupport.generateExpectedResultsFile(answer, "test3Swap.txt");
		
		System.out.println("\nThird Test:\n" + answer);
		assertTrue(TestingSupport.exactCorrectResults("test3Swap.txt", answer));
	}
	
	private static String getStringTwoDimArrayChar(char[][] array) {
		return Arrays.toString(array[0]) + "\n" + Arrays.toString(array[1]);
	}
}
