package controller;

import view.Square;

public class Queen extends Piece {
	private String whiteQueen = "whitequeen.png";
	private String blackQueen = "blackqueen.png";
	
	public Queen(int x, int y, boolean side) {
		if(side) {
			this.setValue(9);
			this.setImageUrl(whiteQueen);
		}
		else {
			this.setValue(-9);
			this.setImageUrl(blackQueen);
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
					
					for(int i = 1; i < y - this.getY() - 1; i++) {
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
				else if(y == this.getY()) {
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
				else {
					boolean clear = true;
					
					for(int i = 1; i < this.getY() - y - 1; i++) {
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
			else if(x == this.getX()) {
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
			else {
				if(y > this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < y - this.getY() - 1; i++) {
						if(board[this.getX() - i][this.getY() + i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear) {
						if(board[x][y].getValue() <= 0) {
							return true;
						}
					}
				}
				else if(y == this.getY()) {
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
				else {
					boolean clear = true;
					
					for(int i = 1; i < this.getY() - y - 1; i++) {
						if(board[this.getX() - i][this.getY() - i].getValue() != 0) {
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
			if(x > this.getX()) {
				if(y > this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < y - this.getY() - 1; i++) {
						if(board[this.getX() + i][this.getY() + i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear) {
						if(board[x][y].getValue() >= 0) {
							return true;
						}
					}
				}
				else if(y == this.getY()) {
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
				else {
					boolean clear = true;
					
					for(int i = 1; i < this.getY() - y - 1; i++) {
						if(board[this.getX() + i][this.getY() - i].getValue() != 0) {
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
			else if(x == this.getX()) {
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
			else {
				if(y > this.getY()) {
					boolean clear = true;
					
					for(int i = 1; i < y - this.getY() - 1; i++) {
						if(board[this.getX() - i][this.getY() + i].getValue() != 0) {
							clear = false;
						}
					}
					
					if(clear) {
						if(board[x][y].getValue() >= 0) {
							return true;
						}
					}
				}
				else if(y == this.getY()) {
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
				else {
					boolean clear = true;
					
					for(int i = 1; i < this.getY() - y - 1; i++) {
						if(board[this.getX() - i][this.getY() - i].getValue() != 0) {
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
		
		return false;
	}

}
