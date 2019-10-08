package dad.javafx.geometria.controllers;

import dad.javafx.geometria.model.RectanguloModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class RectanguloController extends VBox {
	
	// view
	
	private TextField anchoText;
	private TextField altoText;
	private Label areaLabel;
	private Rectangle rectanguloShape;
	
	// model
	
	private RectanguloModel rectanguloModel = new RectanguloModel(20.0, 20.0);

	public RectanguloController() {
		super();
		
		anchoText = new TextField();
		anchoText.setPrefColumnCount(5);
		
		HBox anchoBox = new HBox(5, new Label("Ancho:"), anchoText);
		anchoBox.setAlignment(Pos.BASELINE_CENTER);

		altoText = new TextField();
		altoText.setPrefColumnCount(5);
		
		HBox altoBox = new HBox(5, new Label("Alto:"), altoText);
		altoBox.setAlignment(Pos.BASELINE_CENTER);
		
		areaLabel = new Label("�rea: XXX p�xeles cuadrados");
		
		rectanguloShape = new Rectangle(100, 50);
		rectanguloShape.setFill(Color.AQUAMARINE);
		rectanguloShape.setStroke(Color.DARKBLUE);
		rectanguloShape.setStrokeWidth(2);
		
		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().addAll(anchoBox, altoBox, areaLabel, rectanguloShape);
		this.setPadding(new Insets(5));
		
		// view-model bindings
		
		anchoText.textProperty().bindBidirectional(rectanguloModel.baseProperty(), new NumberStringConverter());
		altoText.textProperty().bindBidirectional(rectanguloModel.alturaProperty(), new NumberStringConverter());
		areaLabel.textProperty().bind(rectanguloModel.areaProperty().asString());
		rectanguloShape.widthProperty().bind(rectanguloModel.baseProperty());
		rectanguloShape.heightProperty().bind(rectanguloModel.alturaProperty());
		
	}
	
}
