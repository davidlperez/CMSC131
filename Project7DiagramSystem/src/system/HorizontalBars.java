package system;

import app.DrawingApp;
import gui.BoardCell;

public class HorizontalBars implements Diagram {
	private int animationType;
	private char[][] board;

	public HorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3,
			int animationType) {
		String horizBarsAsString = DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3);
		this.animationType = animationType;
		board = BoardCell.getCharArray(horizBarsAsString);
	}

	public char[][] getBoard() {
		return board;
	}

	public char[][] nextAnimationStep() {
		switch (animationType) {
		case 1:
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
