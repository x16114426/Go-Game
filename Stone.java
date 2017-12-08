import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;

// class definition for an X or O piece
class Stone extends Group {

// constructor for the class
	
public Stone(int player) {
	pos = new Translate();
	stone = new Ellipse();
	//piece.getTransforms().add(t);
	this.player = player;
	this.getChildren().add(stone);
	
	if (player == 1) {
		stone.setFill(Color.WHITE);
	}
	else if (player == 2){
		stone.setFill(Color.BLACK);
	}
	else if(player==0){
		stone.setFill(Color.TRANSPARENT);
	}
}
	
// overridden version of the resize method
public void resize(double width, double height) {
// call the super class method
super.resize(width,height);
stone.setCenterX(width / 2); stone.setCenterY(height / 2);
stone.setRadiusX(width / 2); stone.setRadiusY(height / 2);
}
	
// overridden version of the relocate method
public void relocate(double x, double y) {
	super.relocate(x, y);
	pos.setX(x); pos.setY(y);
}
public int getStone() {
	// NOTE: this is to keep the compiler happy until you get to this point
	
	return player;
}

//method that will set the piece type
	public void setStone(final int type) {
		player=type;
		if(player == 1 ){
			stone.setFill(Color.WHITE);
			}
			
			else if(player == 2){
				stone.setFill(Color.BLACK);
				
			}
			
			else if(player == 0){
			stone.setFill(Color.TRANSPARENT);

		}
	}

	// private fields of the class
//	private Line l1, l2; // lines for drawing the X piece
	private Ellipse stone; // ellipse for rendering the O piece
	private int player; // maintain a copy of the piece type we have
	private Translate pos; // translate that set the position of this piece
}
