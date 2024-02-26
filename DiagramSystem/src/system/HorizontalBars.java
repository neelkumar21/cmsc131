package system;

import app.DrawingApp;
import gui.BoardCell;

public class HorizontalBars implements Diagram {
	int animationType;
	char[][] board;

	public HorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3,
			int animationType) {
		String horizontalBars = DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3);
		board = BoardCell.getCharArray(horizontalBars);
		this.animationType = animationType;
	}

	@Override
	public char[][] getBoard() {
		return board;
	}

	@Override
	public char[][] nextAnimationStep() {
		if (animationType == 1) {
			TwoDimArrayUtil.rotateTopOneRow(board);
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
