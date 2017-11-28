import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;

// class definition for an X or O piece
class Stone extends Group {

// private fields of the class
private Line l1, l2; // lines for drawing the X piece
private Ellipse e; // ellipse for rendering the O piece
private int type; // maintain a copy of the piece type we have
private Translate pos; // translate that set the position of this piece
// constructor for the class
	
public Stone(int type) {
}
	
// overridden version of the resize method
public void resize(double width, double height) {
// call the super class method
super.resize(width, height);
}
	
// overridden version of the relocate method
public void relocate(double x, double y) {
}

}
