package system;

public class CombineTopBottom implements Diagram {
	int animationType;
	char [][ ]board;
	
	public CombineTopBottom(Diagram top, Diagram bottom, int animationType) {
		if(top.getNumberCols() != bottom.getNumberCols()) {
			throw new IllegalArgumentException("Illegal Arguments");
		}
		board = TwoDimArrayUtil.appendTopBottom​(top.getBoard(), bottom.getBoard());
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
