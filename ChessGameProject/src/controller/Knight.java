package controller;

import view.Square;

public class Knight extends Piece {
	private String whiteKnight = "whiteknight.png";
	private String blackKnight = "blackknight.png";
	
	public Knight(int x, int y, boolean side) {
		if(side) {
			this.setValue(3);
			this.setImageUrl(whiteKnight);
		}
		else {
			this.setValue(-3);
			this.setImageUrl(blackKnight);
		}
		
		this.setX(x);
		this.setY(y);
	}

	@Override
	public boolean move(int x, int y, Square[][] board) {
		if(this.getValue() > 0) {
			if(x < board.length && x >= 0 && y < board.length && y >= 0) {
				if(x == this.getX() + 1) {
					if(y == this.getY() + 2 || y == this.getY() - 2) {
						if(board[x][y].getValue() <= 0) {
							return true;
						}
					}
				}
				else if(x == this.getX() + 2) {
					if(y == this.getY() + 1 || y == this.getY() - 1) {
						if(board[x][y].getValue() <= 0) {
							return true;
						}
					}
				}
				else if(x == this.getX() - 1) {
					if(y == this.getY() + 2 || y == this.getY() - 2) {
						if(board[x][y].getValue() <= 0) {
							return true;
						}
					}
				}
				else if(x == this.getX() - 2) {
					if(y == this.getY() + 1 || y == this.getY() - 1) {
						if(board[x][y].getValue() <= 0) {
							return true;
						}
					}
				}
			}
		}
		else {
			if(x < board.length && x >= 0 && y < board.length && y >= 0) {
				if(x == this.getX() + 1) {
					if(y == this.getY() + 2 || y == this.getY() - 2) {
						if(board[x][y].getValue() >= 0) {
							return true;
						}
					}
				}
				else if(x == this.getX() + 2) {
					if(y == this.getY() + 1 || y == this.getY() - 1) {
						if(board[x][y].getValue() >= 0) {
							return true;
						}
					}
				}
				else if(x == this.getX() - 1) {
					if(y == this.getY() + 2 || y == this.getY() - 2) {
						if(board[x][y].getValue() >= 0) {
							return true;
						}
					}
				}
				else if(x == this.getX() - 2) {
					if(y == this.getY() + 1 || y == this.getY() - 1) {
						if(board[x][y].getValue() >= 0) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
}
