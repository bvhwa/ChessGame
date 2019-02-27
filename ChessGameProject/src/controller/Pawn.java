package controller;

import view.Square;

public class Pawn extends Piece {
	private boolean moved;
	private String whitePawn = "whitepawn.png";
	private String blackPawn = "blackpawn.png";
	
	public Pawn(int x, int y, boolean side) {
		if(side) {
			this.setValue(1);
			this.setImageUrl(whitePawn);
		}
		else {
			this.setValue(-1);
			this.setImageUrl(blackPawn);
		}
		
		moved = false;
		this.setX(x);
		this.setY(y);
	}

	@Override
	public boolean move(int x, int y, Square[][] board) {
		if(this.getValue() > 0) {
			if(moved) {
				if(x == this.getX() + 1) {
					if(y == this.getY()) {
						if(board[x][y].getValue() == 0) {
							return true;
						}
					}
					else if(y == this.getY() + 1 || y == this.getY() - 1) {
						if(board[x][y].getValue() < 0) {
							return true;
						}
					}
				}
			}
			else {
				if(x == this.getX() + 2) {
					if(y == this.getY()) {
						if(board[x][y].getValue() == 0 && board[x-1][y].getValue() == 0) {
							moved = true;
							return true;
						}
					}
				}
				else if(x == this.getX() + 1) {
					if(y == this.getY()) {
						if(board[x][y].getValue() == 0) {
							moved = true;
							return true;
						}
					}
					else if(y == this.getY() + 1 || y == this.getY() - 1) {
						if(board[x][y].getValue() < 0) {
							moved = true;
							return true;
						}
					}
				}
			}
		}
		else {
			if(moved) {
				if(x == this.getX() - 1) {
					if(y == this.getY()) {
						if(board[x][y].getValue() == 0) {
							return true;
						}
					}
					else if(y == this.getY() + 1 || y == this.getY() - 1) {
						if(board[x][y].getValue() > 0) {
							return true;
						}
					}
				}
			}
			else {
				if(x == this.getX() - 2) {
					if(y == this.getY()) {
						if(board[x][y].getValue() == 0 && board[x+1][y].getValue() == 0) {
							moved = true;
							return true;
						}
					}
				}
				else if(x == this.getX() - 1) {
					if(y == this.getY()) {
						if(board[x][y].getValue() == 0) {
							moved = true;
							return true;
						}
					}
					else if(y == this.getY() + 1 || y == this.getY() - 1) {
						if(board[x][y].getValue() > 0) {
							moved = true;
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
}
