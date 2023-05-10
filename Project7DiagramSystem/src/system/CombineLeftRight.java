package system;

import gui.BoardCell;

public class CombineLeftRight implements Diagram {
	private char[][] board;
	private int animationType;

	public CombineLeftRight(Diagram left, Diagram right, int animationType) {
		if (left.getBoard().length != right.getBoard().length) {
			throw new IllegalArgumentException("uh oh");
		}
		this.animationType = animationType;
		board = TwoDimArrayUtil.appendLeftRight(left.getBoard(), right.getBoard());
	}

	public char[][] getBoard() {
		return board;
	}

	public char[][] nextAnimationStep() {
		switch (animationType) {
		case 1:
			TwoDimArrayUtil.rotateLeftOneColumn(board);
			break;
		case 2:
			TwoDimArrayUtil.rotateTopOneRow(board);
			break;
		}
		return board;
	}

	public int getNumberRows() {
		return board.length;
	}

	public int getNumberCols() {
		return board[0].length;
	}

}
