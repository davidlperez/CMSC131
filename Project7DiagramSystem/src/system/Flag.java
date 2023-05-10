package system;

import app.DrawingApp;
import gui.BoardCell;

public class Flag implements Diagram {
	private int animationType;
	private char[][] board;

	public Flag(int size, char color1, char color2, char color3, int animationType) {
		String flagAsString = DrawingApp.getFlag(size, color1, color2, color3);
		this.animationType = animationType;
		board = BoardCell.getCharArray(flagAsString);
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
