package system;

import app.DrawingApp;
import gui.BoardCell;

/**
 * This class represents a SwapRows diagram and relies on the DrawingApp.getTwoRowsDiagram()
 * This class implements the Diagram interface and defines one instance variable, the array
 * of characters representing the diagram (board).
 * 
 * @author cmsc132
 *
 */
public class SwapRows implements Diagram {
	private char[][] board;
	
	public SwapRows(char firstRowChar, char secondRowChar, int columns) {
		/* Getting the diagram as a string */
		String diagramAsString = DrawingApp.getTwoRowsDiagram(firstRowChar, secondRowChar, columns);
		
		/* Converting diagram to two-dim array of characters using the */
		/* provided method and assigning it to the board instance variable */
		board = BoardCell.getCharArray(diagramAsString);
	}
	
	/**
	 * Returns the board.
	 * 
	 * @return two-dimensional array of characters (no need to perform a deep copy).
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * Returns a two-dimensional array of characters representing the next
	 * animation step.  We will swap rows for each step.
	 * 
	 * @return a reference to the updated board (no need to perform a deep copy).
	 */
	public char[][] nextAnimationStep() {
		board = TwoDimArrayUtil.swapFirstAndSecondRow(board);
		
		return board;
	}
	
	/**
	 * Number of rows associated with the diagram.
	 * @return
	 */
	public int getNumberRows() {
		return board.length;
	}

	/**
	 * Number of columns associated with the diagram.
	 * @return
	 */
	public int getNumberCols() {
		return board[0].length;
	}
}