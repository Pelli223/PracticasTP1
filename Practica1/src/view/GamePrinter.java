package view;

import logic.Game;
import utils.MyStringUtils;

public class GamePrinter {
	
	Game game;
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	public GamePrinter (Game game, int cols, int rows) {
		this.game = game;
		this.numRows = rows;
		this.numCols = cols;
	}
	
	public String toString() {
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;
	
		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);

		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;

		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);

		StringBuilder str = new StringBuilder();
		encodeGame(this.game);
		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
		        str.append(margin).append(vDelimiter);
		        for (int j=0; j<numCols; j++)
		            str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
		        if (i != numRows - 1) str.append(lineDelimiter);
		        else str.append(lineEdge);   
		}

		return str.toString();
	}
	private void encodeGame(Game game) {
			this.board = new String [numRows][numCols];
			for (int i = 0; i < this.numRows; i++) {
				for (int j = 0; j < numCols; j++) {
					board[i][j] = game.positionToString(j, i);
				}
			}
		}
	 public int getRows() {
		 return this.numRows;
	 }
	 public int getCols() {
		 return this.numCols;
	 }
}