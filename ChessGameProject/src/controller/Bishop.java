package controller;

import view.Square;

public class Bishop extends Piece {
	private String whiteBishop = "whitebishop.png";
	private String blackBishop = "blackbishop.png";
	
	public Bishop(int x, int y, boolean side) {
		if(side) {
			this.setValue(3);
			this.setImageUrl(whiteBishop);
		}
		else {
			this.setValue(-3);
			this.setImageUrl(blackBishop);
		}
		
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public boolean move(int x, int y, Square[][] board) {		
		if(this.getValue() > 0) {
			if(x > this.getX()) {
				if(y > this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < y - this.getY(); i++) {
						if(board[this.getX() + i][this.getY() + i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear && x - y == this.getX() - this.getY()) {
						if(board[x][y].getValue() <= 0) {
							return true;
						}
					}
				}
				else if(y < this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < this.getY() - y; i++) {
						if(board[this.getX() + i][this.getY() - i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear && x + y == this.getX() + this.getY()) {
						if(board[x][y].getValue() <= 0) {
							return true;
						}
					}
				}
			}
			else if(x < this.getX()) {
				if(y > this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < y - this.getY(); i++) {
						if(board[this.getX() - i][this.getY() + i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear && x - y == this.getX() - this.getY()) {
						if(board[x][y].getValue() <= 0) {
							return true;
						}
					}
				}
				else if(y < this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < this.getY() - y; i++) {
						if(board[this.getX() - i][this.getY() - i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear && x + y == this.getX() + this.getY()) {
						if(board[x][y].getValue() <= 0) {
							return true;
						}
					}
				}
			}
		}
		else {
			if(x > this.getX()) {
				if(y > this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < y - this.getY(); i++) {
						if(board[this.getX() + i][this.getY() + i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear && x - y == this.getX() - this.getY()) {
						if(board[x][y].getValue() >= 0) {
							return true;
						}
					}
				}
				else if(y < this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < this.getY() - y; i++) {
						if(board[this.getX() + i][this.getY() - i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear && x + y == this.getX() + this.getY()) {
						if(board[x][y].getValue() >= 0) {
							return true;
						}
					}
				}
			}
			else if(x < this.getX()) {
				if(y > this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < y - this.getY(); i++) {
						if(board[this.getX() - i][this.getY() + i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear && x - y == this.getX() - this.getY()) {
						if(board[x][y].getValue() >= 0) {
							return true;
						}
					}
				}
				else if(y < this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < this.getY() - y; i++) {
						if(board[this.getX() - i][this.getY() - i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear && x + y == this.getX() + this.getY()) {
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
