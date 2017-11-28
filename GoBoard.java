import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;



	//class definition for the go board
	class GoBoard extends Pane {
		// default constructor for the class
		public GoBoard() {
			render = new Stone[7][7];
			horizontal = new Line[7];
			vertical = new Line[7];
			horizontal_t = new Translate[7];
			vertical_t = new Translate[7];
			surrounding = new int[3][3];
			can_go  = new boolean[3][3];
			
			initialiseLinesBackground();
			initialiseRender();
			resetGame();
			
		
			
			
		}
		
		// public method that will try to place a piece in the given x,y coordinate
		public void placePiece(final double x, final double y) {
			  // figure out which cell the current player has clicked on
			  final int cellx = (int) (x / cell_width);
			  final int celly = (int) (y / cell_height);

			  // if the game is not in play then do nothing
			  if(!in_play)
			    return;

			  // if there is a stone already placed then return and do nothing
			  if(render[cellx][celly].getWBStone() != 0)
			    return;

			  // determine what pieces surround the current piece. if there is no opposing
			  // pieces then a valid move cannot be made.
			  determineSurrounding(cellx, celly);
			  if(!adjacentOpposingPiece())
			    return;

			  // see if a reverse can be made in any direction if none can be made then return
			  if(!determineReverse(cellx, celly))
			    return;

			  // at this point we have done all the checks and they have passed so now we can place
			  // the piece and perform the reversing also check if the game has ended
			  placeAndReverse(cellx, celly);

			  // if we get to this point then a successful move has been made so swap the
			  // players and update the scores
			  swapPlayers();
			  updateScores();
			  determineEndGame();

			  // print out some information
			  System.out.println("placed at: " + cellx + ", " + celly);
			  System.out.println("White: " + player1_score + " Black: " + player2_score);
			  if(current_player == 1)
			    System.out.println("current player is White");
			  else
			    System.out.println("current player is Black");
			}

		
		
		// overridden version of the resize method to give the board the correct size
		@Override
		public void resize(double width, double height) {
			super.resize(width, height);
			cell_width = width / 7.0;
		    cell_height = height / 7.0;
		      
		    background.setWidth(width); 
		    background.setHeight(height);

			pieceResizeRelocate();
			horizontalResizeRelocate(width);
			verticalResizeRelocate(height);

		}
		
		// public method for resetting the game
		public void resetGame() {
			resetRenders();
			render[3][3].setWBStone(1);
			render[4][4].setWBStone(1);
			render[3][4].setWBStone(2);
			render[4][3].setWBStone(2);
			
			in_play = true;
			current_player = 2;
			opposing = 1;
			player1_score = 2;
			player2_score = 2;

		}
		
		// private method that will reset the renders
		private void resetRenders() {
			for (int i = 0; i < 7; i++) { 
				for (int j = 0; j < 7; j++) {
					render[i][j].setWBStone(EMPTY);
			System.out.printf("\n %d %d", i, j); } }

		}
		
		// private method that will initialise the background and the lines
		private void initialiseLinesBackground() {
			background = new Rectangle();
			background.setFill(Color.CYAN);
			getChildren().add(background);
			
			for (int j =0; j < 7; j++) {
				horizontal[j] = new Line(); 
				horizontal[j].setStroke(Color.WHITE); 
				horizontal[j].setStartX(0); 
				horizontal[j].setStartY(0); 
				horizontal[j].setEndY(0); 
				horizontal_t[j] = new Translate(0, 0); 
				horizontal[j].getTransforms().add(horizontal_t[j]); 
				getChildren().add(horizontal[j]); 
			}
			
			for (int j =0; j < 7; j++) {
				vertical[j] = new Line(); 
				vertical[j].setStroke(Color.WHITE); 
				vertical[j].setStartX(0); 
				vertical[j].setStartY(0); 
				vertical[j].setEndY(0); 
				vertical_t[j] = new Translate(0, 0); 
				vertical[j].getTransforms().add(vertical_t[j]); 
				getChildren().add(vertical[j]); 
			}
			

		}
		
		// private method for resizing and relocating the horizontal lines
		private void horizontalResizeRelocate(final double width) {
			
			for(int j=1;j<7;j++) {
			horizontal_t[j].setX(0.5*cell-cell_height);
			horizontal_t[j].setY(0.5*cell-cell_width/2);
				horizontal[j].setEndY(width);
			}

		}
		
		// private method for resizing and relocating the vertical lines
		private void verticalResizeRelocate(final double height) {
			for(int j=1;j<7;j++) {
				vertical_t[j].setX(0.5*cell-cell_width);
				vertical[j].setEndY(height);
				
			}

		}
		
		// private method for swapping the players
		private void swapPlayers() {
			if(current_player==1) {
				opposing=1;
				current_player=2;
			}
			else {
				opposing=2;
				current_player=1;
			}

		}
		
		// private method for updating the player scores
		private void updateScores() {

		}
		
		// private method for resizing and relocating all the pieces
		private void pieceResizeRelocate() {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					render[i][j].resize(cell_width, cell_height);
					render[i][j].relocate(cell_width*i, cell_height*j);
				}
			}

		}
		
		// private method for determining which pieces surround x,y will update the
		// surrounding array to reflect this
		private void determineSurrounding(final int x, final int y) {
			System.out.printf("Determine surrounding\n %d, %d", x, y);
			try {
				surrounding[x-1][y] = render[x-1][y].getWBStone();
				surrounding[x+1][y] = render[x+1][y].getWBStone();
				surrounding[x-1][y-1] = render[x-1][y-1].getWBStone();
				surrounding[x+1][y-1] = render[x+1][y-1].getWBStone();
				surrounding[x][y-1] = render[x][y-1].getWBStone();
				surrounding[x+1][y+1] = render[x+1][y+1].getWBStone();
				surrounding[x][y+1] = render[x][y+1].getWBStone();
				surrounding[x-1][y+1] = render[x-1][y+1].getWBStone();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// private method for determining if a reverse can be made will update the can_reverse
		// array to reflect the answers will return true if a single reverse is found
		private boolean determineReverse(final int x, final int y) {
			// NOTE: this is to keep the compiler happy until you get to this part
			return false;
		}
		
		// private method for determining if a reverse can be made from a position (x,y) for
		// a player piece in the given direction (dx,dy) returns true if possible
		// assumes that the first piece has already been checked
		private boolean isReverseChain(final int x, final int y, final int dx, final int dy, final int player) {
			// NOTE: this is to keep the compiler happy until you get to this part
			return false;
		}
		
		// private method for determining if any of the surrounding pieces are an opposing
		// piece. if a single one exists then return true otherwise false
		private boolean adjacentOpposingPiece() {
			
			return false; 
		}
		
		// private method for placing a piece and reversing pieces
		private void placeAndReverse(final int x, final int y) {
					
		}
		
		// private method to reverse a chain
		private void reverseChain(final int x, final int y, final int dx, final int dy) {
			
		}
		
		// private method for getting a piece on the board. this will return the board
		// value unless we access an index that doesnt exist. this is to make the code
		// for determing reverse chains much easier
		private int getWBStone(final int x, final int y) {
			// NOTE: this is to keep the compiler happy until you get to this point
			try {
				return render[x][y].getWBStone();	
			}catch (Exception e) {
				return -1;
			}		
			
		}
		
		// private method that will determine if the end of the game has been reached
		private void determineEndGame() {
			
		}
		
		// private method to determine if a player has a move available
		private boolean canMove() {
			// NOTE: this is to keep the compiler happy until you get to this part
			return false;
		}
		
		// private method that determines who won the game
		private void determineWinner() {
				
		}
		
		// private method that will initialise everything in the render array
		private void initialiseRender() {
						for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					render[i][j] = new Stone(EMPTY);
					getChildren().add(render[i][j]);
				}
			}

		}
		
		
		
		// rectangle that makes the background of the board
		private Rectangle background;
		// arrays for the lines that makeup the horizontal and vertical grid lines
		private Line[] horizontal;
		private Line[] vertical;
		// arrays holding translate objects for the horizontal and vertical grid lines
		private Translate[] horizontal_t;
		private Translate[] vertical_t;
		// arrays for the internal representation of the board and the pieces that are
		// in place
		private Stone[][] render;
		// the current player who is playing and who is his opposition
		private int current_player;
		private int opposing;
		// is the game currently in play
		private boolean in_play;
		// current scores of player 1 and player 2
		private int player1_score;
		private int player2_score;
		// the width and height of a cell in the board
		private double cell_width;
		private double cell_height;
		private double cell;
		// 3x3 array that holds the pieces that surround a given piece
		private int[][] surrounding;
		// 3x3 array that determines if a reverse can be made in any direction
		private boolean[][] can_go;
		private final int EMPTY=0;
	
}


