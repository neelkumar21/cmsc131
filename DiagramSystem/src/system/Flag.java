package system;

import app.DrawingApp;
import gui.BoardCell;

public class Flag implements Diagram {
	int animationType;
	char[][] board;

	public Flag(int size, char color1, char color2, char color3, int animationType) {
		String flag = DrawingApp.getFlag(size, color1, color2, color3);
		board = BoardCell.getCharArray(flag);
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
		} else if (animationType == 2) {
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
