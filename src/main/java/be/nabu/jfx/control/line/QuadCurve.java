package be.nabu.jfx.control.line;

import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;

public class QuadCurve extends javafx.scene.shape.QuadCurve {

	private javafx.scene.shape.QuadCurve invisibleTarget;
	
	public QuadCurve() {
		invisibleTarget = new javafx.scene.shape.QuadCurve();
		invisibleTarget.startXProperty().bind(startXProperty());
		invisibleTarget.startYProperty().bind(startYProperty());
		invisibleTarget.endXProperty().bind(endXProperty());
		invisibleTarget.endYProperty().bind(endYProperty());
		invisibleTarget.controlXProperty().bind(controlXProperty());
		invisibleTarget.controlYProperty().bind(controlYProperty());
		invisibleTarget.setFill(Color.TRANSPARENT);
		invisibleTarget.setStroke(Color.TRANSPARENT);
		CurveUtils.loadEvents(this, invisibleTarget);
	}
	
	public DoubleProperty eventSizeProperty() {
		return invisibleTarget.strokeWidthProperty();
	}

}
