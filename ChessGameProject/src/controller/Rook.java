package controller;

import view.Square;

public class Rook extends Piece {
	private String whiteRook = "whiterook.png";
	private String blackRook = "blackrook.png";
	
	public Rook(int x, int y, boolean side) {
		if(side) {
			this.setValue(5);
			this.setImageUrl(whiteRook);
		}
		else {
			this.setValue(-5);
			this.setImageUrl(blackRook);
		}
		
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public boolean move(int x, int y, Square[][] board) {
		if(x < board.length && x >= 0 && y < board.length && y >= 0) {
			if(this.getValue() > 0) {
				if(x == this.getX()) {
					if(y < this.getY()) {
						boolean clear = true;
						
						for(int i = this.getY() - 1; i > y; i--) {
							if(board[x][i].getValue() != 0) {
								clear = false;
							}
						}
						
						if(clear) {
							if(board[x][y].getValue() <= 0) {
								return true;
							}
						}
					}
					else if(y > this.getY()) {
						boolean clear = true;
						
						for(int i = y + 1; i < this.getY(); i++) {
							if(board[x][i].getValue() != 0) {
								clear = false;
							}
						}
						
						if(clear) {
							if(board[x][y].getValue() <= 0) {
								return true;
							}
						}
					}
				}
				else if(y == this.getY()) {
					if(x < this.getX()) {
						boolean clear = true;
						
						for(int i = this.getX() - 1; i > x; i--) {
							if(board[i][y].getValue() != 0) {
								clear = false;
							}
						}
						
						if(clear) {
							if(board[x][y].getValue() <= 0) {
								return true;
							}
						}
					}
					else if(x > this.getX()) {
						boolean clear = true;
						
						for(int i = x + 1; i < this.getX(); i++) {
							if(board[i][y].getValue() != 0) {
								clear = false;
							}
						}
						
						if(clear) {
							if(board[x][y].getValue() <= 0) {
								return true;
							}
						}
					}
				}
			}
			else {
				if(x == this.getX()) {
					if(y < this.getY()) {
						boolean clear = true;
						
						for(int i = this.getY() - 1; i > y; i--) {
							if(board[x][i].getValue() != 0) {
								clear = false;
							}
						}
						
						if(clear) {
							if(board[x][y].getValue() >= 0) {
								return true;
							}
						}
					}
					else if(y > this.getY()) {
						boolean clear = true;
						
						for(int i = y + 1; i < this.getY(); i++) {
							if(board[x][i].getValue() != 0) {
								clear = false;
							}
						}
						
						if(clear) {
							if(board[x][y].getValue() >= 0) {
								return true;
							}
						}
					}
				}
				else if(y == this.getY()) {
					if(x < this.getX()) {
						boolean clear = true;
						
						for(int i = this.getX() - 1; i > x; i--) {
							if(board[i][y].getValue() != 0) {
								clear = false;
							}
						}
						
						if(clear) {
							if(board[x][y].getValue() >= 0) {
								return true;
							}
						}
					}
					else if(x > this.getX()) {
						boolean clear = true;
						
						for(int i = x + 1; i < this.getX(); i++) {
							if(board[i][y].getValue() != 0) {
								clear = false;
							}
						}
						
						if(clear) {
							if(board[x][y].getValue() >= 0) {
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
}
