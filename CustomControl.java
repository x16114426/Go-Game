import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
//class definition for a custom go control
	class CustomControl extends Control {
		// constructor for the class
		public CustomControl() {
			setSkin(new CustomControlSkin(this));
			go_board = new GoBoard();
			getChildren().add(go_board);
			
			// add a mouse clicked listener that will try to place a stone
			setOnMouseClicked(new EventHandler<MouseEvent>() { // overridden handle method
			@Override
			public void handle(MouseEvent event) {
			            go_board.placeStone(event.getX(), event.getY());
			      }
			});
			
			setOnKeyPressed(new EventHandler<KeyEvent>() { // overridden handle method
				@Override
				public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.SPACE) go_board.resetGame();
				} });
			
		}//end of constructor
		
		// overridden version of the resize method
		@Override
		public void resize(double width, double height) {
			super.resize(width, height);
			go_board.resize(width, height);
		}
		
		// private fields of a go board
		GoBoard go_board;
	}

