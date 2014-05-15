package be.nabu.jfx.control.line;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Line extends javafx.scene.shape.Line {
	
	private javafx.scene.shape.Line invisibleTarget;
	
	public Line() {
		invisibleTarget = new javafx.scene.shape.Line();
		invisibleTarget.startXProperty().bind(startXProperty());
		invisibleTarget.startYProperty().bind(startYProperty());
		invisibleTarget.endXProperty().bind(endXProperty());
		invisibleTarget.endYProperty().bind(endYProperty());
		invisibleTarget.setFill(Color.TRANSPARENT);
		invisibleTarget.setStroke(Color.TRANSPARENT);
		invisibleTarget.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Line.this.fireEvent(event.copyFor(Line.this, Line.this));
			}
		});
		invisibleTarget.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				Line.this.fireEvent(event.copyFor(Line.this, Line.this));
			}
		});
		parentProperty().addListener(new ChangeListener<Parent>() {
			@Override
			public void changed(ObservableValue<? extends Parent> arg0, Parent oldParent, Parent newParent) {
				if (newParent != null) {
					while (newParent != null && !(newParent instanceof Pane))
						newParent = newParent.getParent();
					if (newParent instanceof Pane)
						((Pane) newParent).getChildren().add(invisibleTarget);
					else
						throw new IllegalStateException("Can't add the line to an element with no pane parent");
				}
				// make sure the target line is also removed
				else if (oldParent != null) {
					while (oldParent != null && !(oldParent instanceof Pane))
						oldParent = oldParent.getParent();
					// can not remove the line in the same thread as the change is still pending
					// this will throw...odd...exceptions
					if (oldParent instanceof Pane) {
						final Pane oldPane = (Pane) oldParent;
						Platform.runLater(new Runnable() {
							public void run() {
								oldPane.getChildren().remove(invisibleTarget);
							}
						});
					}
					else
						throw new IllegalStateException("Can't remove the line from an element with no pane parent");
				}
			}
		});
	}
	
	public DoubleProperty eventSizeProperty() {
		return invisibleTarget.strokeWidthProperty();
	}
}
