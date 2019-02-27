package controller;

import view.Square;

public class King extends Piece {
	private String whiteKing = "whiteking.png";
	private String blackKing = "blackking.png";
	
	public King(int x, int y, boolean side) {
		if(side) {
			this.setValue(Integer.MAX_VALUE);
			this.setImageUrl(whiteKing);
		}
		else {
			this.setValue(Integer.MIN_VALUE);
			this.setImageUrl(blackKing);
		}
		
		this.setX(x);
		this.setY(y);
	}

	@Override
	public boolean move(int x, int y, Square[][] board) {
		if(this.getValue() > 0) {
			if(x > this.getX()) {
				if(y > this.getY()) {
					if(board[x][y].getValue() <= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else if(y == this.getY()) {
					if(board[x][y].getValue() <= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else {
					if(board[x][y].getValue() <= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
			}
			else if(x == this.getX()) {
				if(y > this.getY()) {
					if(board[x][y].getValue() <= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else if(y < this.getY()) {
					if(board[x][y].getValue() <= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
			}
			else {
				if(y > this.getY()) {
					if(board[x][y].getValue() <= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else if(y == this.getY()) {
					if(board[x][y].getValue() <= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else {
					if(board[x][y].getValue() <= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
			}
		}
		else {
			if(x > this.getX()) {
				if(y > this.getY()) {
					if(board[x][y].getValue() >= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else if(y == this.getY()) {
					if(board[x][y].getValue() >= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else {
					if(board[x][y].getValue() >= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
			}
			else if(x == this.getX()) {
				if(y > this.getY()) {
					if(board[x][y].getValue() >= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else if(y < this.getY()) {
					if(board[x][y].getValue() >= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
			}
			else {
				if(y > this.getY()) {
					if(board[x][y].getValue() >= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else if(y == this.getY()) {
					if(board[x][y].getValue() >= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
				else {
					if(board[x][y].getValue() >= 0 && !isChecked(x, y, board)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isChecked(int x, int y, Square[][] board) {
		
		
		
		return false;
	}
}
