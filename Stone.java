
import javafx.scene.Group;
import javafx.scene.shape.Ellipse;
import javafx.scene.transform.Translate;

//class definition for a reversi piece
class GoStone extends Group {
  
  	// private fields
	private int player;		// the player that this stone belongs to
	private Ellipse piece;	// ellipse representing the player's stone
	private Translate t;	// translation for the player piece
  
	// default constructor for the class
	public GoStone(int player) {

	}
	
	// overridden version of the resize method to give the stone the correct size
	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

	}
	
	// overridden version of the relocate method to position the piece correctly
	@Override
	public void relocate(double x, double y) {

	}
	
	// public method that will swap the colour and type of this piece
	public void swapStone() {

	}
	
	// method that will set the piece type
	public void setStone(final int type) {
		
	}
	
	// returns the type of this piece
	public int getStone() {
		// NOTE: this is to keep the compiler happy until you get to this point
		return 0;
	}
	
}
