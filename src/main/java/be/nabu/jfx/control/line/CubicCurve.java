package be.nabu.jfx.control.line;

import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;

public class CubicCurve extends javafx.scene.shape.CubicCurve {

	private javafx.scene.shape.CubicCurve invisibleTarget;
	
	public CubicCurve() {
		invisibleTarget = new javafx.scene.shape.CubicCurve();
		invisibleTarget.startXProperty().bind(startXProperty());
		invisibleTarget.startYProperty().bind(startYProperty());
		invisibleTarget.endXProperty().bind(endXProperty());
		invisibleTarget.endYProperty().bind(endYProperty());
		invisibleTarget.controlX1Property().bind(controlX1Property());
		invisibleTarget.controlY1Property().bind(controlY1Property());
		invisibleTarget.controlX2Property().bind(controlX2Property());
		invisibleTarget.controlY2Property().bind(controlY2Property());
		invisibleTarget.setFill(Color.TRANSPARENT);
		invisibleTarget.setStroke(Color.TRANSPARENT);
		CurveUtils.loadEvents(this, invisibleTarget);
	}
	
	public DoubleProperty eventSizeProperty() {
		return invisibleTarget.strokeWidthProperty();
	}

}
