package view;

import controller.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Square extends Pane {
	private int value;
	private int x;
	private int y;
	private Piece piece;
	
	public Square(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setPiece(null);
		
		if((x + y) % 2 == 0) {
			Background white = new Background(new BackgroundFill(Color.SANDYBROWN, null, null));
			this.setBackground(white);
		}
		else {
			Background black = new Background(new BackgroundFill(Color.SADDLEBROWN, null, null));
			this.setBackground(black);
		}
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
		
		if(this.piece != null) {
			ImageView imv = new ImageView(new Image(piece.getImageUrl()));
			
			imv.fitWidthProperty().bind(this.widthProperty());
			imv.setPreserveRatio(true);
			
			this.piece.setX(this.x);
			this.piece.setY(this.y);
			
			this.getChildren().add(imv);
			this.setValue(this.piece.getValue());
		}
		else {
			this.getChildren().clear();
			this.setValue(0);
		}
	}
	
	public Piece removePiece() {
		Piece temp = this.piece;
		setPiece(null);
		return temp;	
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}
}
