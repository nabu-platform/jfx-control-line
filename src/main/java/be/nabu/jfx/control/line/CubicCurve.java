/*
* Copyright (C) 2014 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

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
		invisibleTarget.setFill(null);
		invisibleTarget.setStroke(Color.TRANSPARENT);
		CurveUtils.loadEvents(this, invisibleTarget);
	}
	
	public DoubleProperty eventSizeProperty() {
		return invisibleTarget.strokeWidthProperty();
	}

}
