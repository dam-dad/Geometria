package dad.javafx.geometria.controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.converter.NumberStringConverter;

public class CirculoController extends VBox {
	
	// view
	
	private TextField radioText;
	private Circle circleShape;
	
	// model
	
	private DoubleProperty radio = new SimpleDoubleProperty(20);

	public CirculoController() {
		super();
		
		radioText = new TextField();
		
		HBox radioBox = new HBox(5, new Label("Radio:"), radioText);
		radioBox.setAlignment(Pos.BASELINE_CENTER);
		
		circleShape = new Circle();
		circleShape.setFill(Color.RED);
		circleShape.setStroke(Color.DARKBLUE);
		circleShape.setStrokeWidth(2);
		
		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().addAll(radioBox, circleShape);
		this.setPadding(new Insets(5));
		
		// bindeo modelo y vista 
		radioText.textProperty().bindBidirectional(radio, new NumberStringConverter());
		circleShape.radiusProperty().bind(radio);		
		
	}
	
}
