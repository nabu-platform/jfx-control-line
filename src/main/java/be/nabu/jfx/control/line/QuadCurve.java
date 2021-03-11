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
		// we must set it explicitly to null to prevent hitting it
		// if we set it to transparent, it will still catch mouseover events etc, if we set it to null explicitly, it no longer triggers on mouse over
		invisibleTarget.setFill(null);
		CurveUtils.loadEvents(this, invisibleTarget);
	}
	
	public DoubleProperty eventSizeProperty() {
		return invisibleTarget.strokeWidthProperty();
	}

}
