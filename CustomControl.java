
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


// class definition for a custom control
class CustomControl extends Control {
  
   // private fields of the class
   private GOBoard goboard;
 
  
// constructor for the class
public CustomControl() {
  
// set a default skin and generate a game board
setSkin(new CustomControlSkin(this));
goboard = new GOBoard();
getChildren().add(goboard);
}
  
// override the resize method
public void resize(double width, double height) {
}
 
}
