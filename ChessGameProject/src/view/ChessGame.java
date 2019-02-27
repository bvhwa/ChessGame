package view;

import controller.Bishop;
import controller.King;
import controller.Knight;
import controller.Pawn;
import controller.Piece;
import controller.Queen;
import controller.Rook;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChessGame extends Application {
	private final int size = 8;
	private final double width = 800;
	private final double height = 800;
	
	private Square[][] squares;
	private GridPane root;
	private boolean isWhitesTurn = true;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new GridPane();
		squares = new Square[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				Square square = new Square(i, j);
				
				square.setPrefWidth(width/size);
				square.setPrefHeight(height/size);
			
				squares[i][j] = square;
				root.add(square, i, j);
			}
		}
		
		this.loadStartPositions();
		
		primaryStage.setScene(new Scene(root, width, height));
		primaryStage.setTitle("Chess");
		primaryStage.show();
	}
	
	private void loadStartPositions() {
		// Create the pawns
		for(int i = 0; i < size; i++) {
			this.loadPiece(new Pawn(1, i, true));
			this.loadPiece(new Pawn(6, i, false));
		}
		this.loadPiece(new Rook(0, 0, true));
		this.loadPiece(new Rook(0, 7, true));
		this.loadPiece(new Knight(0, 1, true));
		this.loadPiece(new Knight(0, 6, true));
		this.loadPiece(new Bishop(0, 2, true));
		this.loadPiece(new Bishop(0, 5, true));
		this.loadPiece(new Queen(0, 3, true));
		this.loadPiece(new King(0, 4, true));
		this.loadPiece(new Rook(7, 0, false));
		this.loadPiece(new Rook(7, 7, false));
		this.loadPiece(new Knight(7, 1, false));
		this.loadPiece(new Knight(7, 6, false));
		this.loadPiece(new Bishop(7, 2, false));
		this.loadPiece(new Bishop(7, 5, false));
		this.loadPiece(new Queen(7, 3, false));
		this.loadPiece(new King(7, 4, false));
	}

	private void loadPiece(Piece piece) {
		Square square = squares[piece.getX()][piece.getY()];
		square.setPiece(piece);
		
		square.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				if(isWhitesTurn && piece.getValue() > 0) {
					System.out.println("Selected white piece!");
					movePiece(square);
					// square.setOnMouseClicked(null);
				}
				else if(!isWhitesTurn && piece.getValue() < 0) {
					System.out.println("Selected black piece!");
					movePiece(square);
					// square.setOnMouseClicked(null);
				}
			}
			
		});
	}
	
	private void movePiece(Square previous) {
		// User chooses square to move piece to, if possible
		previous.setStyle("-fx-border-color: lawngreen");
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				Square square = squares[i][j];
				
				// Reset all the squares so they aren't still clickable to move
				square.setOnMouseClicked(null);
				
				// Set this square's OnMouseClicked to an option for the piece to move to
				square.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						// If the piece can move then move its image to this square
						if(previous.getPiece() != null) {
							if((square.getValue() > 0 && previous.getValue() > 0) || (square.getValue() < 0 && previous.getValue() < 0)) {
								resetMove();
								movePiece(square);
							}
							if(previous.getPiece().move(square.getX(), square.getY(), squares)) {
								// Set the piece for this square
								if(square.getPiece() != null) {
									square.removePiece();
								}
								square.setPiece(previous.removePiece());
								// Reset every location's OnMouseClicked so opponent can move their pieces
								resetMove();
								switchTurn();
							}
						}
					}
					
				});
			}
		}
	}

	private void resetMove() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				Square square = squares[i][j];
				
				square.setStyle("-fx-border-color: clear");
				
				if(square.getValue() != 0) {
					square.setOnMouseClicked(null);
					square.setOnMouseClicked(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent event) {
							// Set up the pieces to move again
							if(isWhitesTurn && square.getValue() > 0) {
								System.out.println("Selected white piece!");
								movePiece(square);
							}
							else if(!isWhitesTurn && square.getValue() < 0) {
								System.out.println("Selected black piece!");
								movePiece(square);
							}
						}
						
					});
				}
			}
		}
	}
	
	private void switchTurn() {
		if(isWhitesTurn) {
			isWhitesTurn = false;
		}
		else {
			isWhitesTurn = true;
		}
	}

	public static void main(String[] args) {
		launch(args);
		System.exit(0);
	}
}
