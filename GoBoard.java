import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

// class definition for drawing a game board
class GoBoard extends Pane {
  
  // private fields of the class
private int[][] board; // array that holds all pieces
private BStone[][] renders; // array that holds all the render pieces
private Rectangle back; // background of the board
private Line h1, h2, v1, v2; // horizontal and vertical grid lines
private double cell_width, cell_height; // width and height of a cell
  
// translation of {one, two} cell {width, height}
private Translate ch_one, ch_two, cw_one, cw_two;
private int current_player; // who is the current player
  
// constants for the class
private final int EMPTY = 0;
private final int BStone = 1;
private final int WStone = 2;
  
// constructor for the class
public GoBoard() {

  // initialise the rectangle and lines
back = new Rectangle();
back.setFill(Color.ORANGE);
h1 = new Line(); h2 = new Line();
v1 = new Line(); v2 = new Line();
h1.setStroke(Color.BLACK); h2.setStroke(Color.BLACK);
v1.setStroke(Color.BLACK); v2.setStroke(Color.BLACK);
  
  // initialise the boards
board = new int[7][7];
renders = new WStone[7][7];
for(int i = 0; i < 7; i++)
for(int j = 0; j < 7; j++) {
board[i][j] = EMPTY;
renders[i][j] = null;
}
current_player = BStone;
}
  
  
  
// we have to override resizing behaviour to make our view appear properly
public void resize(double width, double height) {
// call the superclass method first
super.resize(width, height);
}
  
// public method for resetting the game
public void resetGame() {
}
  
// public method that tries to place a piece
public void placePiece(final double x, final double y) {
}
