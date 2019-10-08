package dad.javafx.geometria;

import dad.javafx.geometria.controllers.CirculoController;
import dad.javafx.geometria.controllers.HexagonoController;
import dad.javafx.geometria.controllers.RectanguloController;
import dad.javafx.geometria.controllers.TrianguloController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Stage;

public class GeometriApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		TabPane root = new TabPane();
		root.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		root.getTabs().add(new Tab("Rect�ngulo", new RectanguloController()));
		root.getTabs().add(new Tab("Tri�ngulo", new TrianguloController()));
		root.getTabs().add(new Tab("C�rculo", new CirculoController()));
		root.getTabs().add(new Tab("Hex�gono", new HexagonoController()));
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Geometr�a");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
