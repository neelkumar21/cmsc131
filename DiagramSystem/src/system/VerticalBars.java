package system;

import app.DrawingApp;
import gui.BoardCell;

public class VerticalBars implements Diagram {

	int animationType;
	char[][] board;

	public VerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3, int animationType) {
		String verticalBars = DrawingApp.getVerticalBars(maxRows, maxCols, bars, color1, color2, color3);
		board = BoardCell.getCharArray(verticalBars);
		this.animationType = animationType;
	}

	@Override
	public char[][] getBoard() {
		return board;
	}

	@Override
	public char[][] nextAnimationStep() {
		if (animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn​(board);
		}
		return board;
	}

	@Override
	public int getNumberRows() {
		return board.length;
	}

	@Override
	public int getNumberCols() {
		return board[0].length;
	}
}
