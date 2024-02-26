package system;

public class CombineLeftRight implements Diagram {
	int animationType;
	char[][] board;

	public CombineLeftRight(Diagram left, Diagram right, int animationType) {
		if (left.getNumberCols() != right.getNumberCols()) {
			throw new IllegalArgumentException("Illegal Arguments");
		}
		board = TwoDimArrayUtil.appendLeftRight(left.getBoard(), right.getBoard());
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
