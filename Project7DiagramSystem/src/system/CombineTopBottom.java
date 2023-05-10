package system;

import gui.BoardCell;

public class CombineTopBottom implements Diagram {
	private char[][] board;
	private int animationType;
	
	public CombineTopBottom(Diagram top, Diagram bottom, int animationType) {
		this.animationType = animationType;
		board = TwoDimArrayUtil.appendTopBottom(top.getBoard(), bottom.getBoard());
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
