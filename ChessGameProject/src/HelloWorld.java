import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	@Override
	public void start(Stage primary) throws Exception {
		Button button = new Button("Say Hello World!");
		button.setOnAction((e) -> System.out.println("Hello World!"));
		
		StackPane root = new StackPane();
		root.getChildren().add(button);
		
		Scene scene = new Scene(root, 300, 300);
		primary.setTitle("First FX App");
		primary.setScene(scene);
		primary.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
