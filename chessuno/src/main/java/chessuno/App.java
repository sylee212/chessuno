package chessuno;

import java.io.IOException;

import chessuno.chessPieces.Pawn;
import chessuno.tiles.Tile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("primary"), 640, 480);
        //stage.setScene(scene);

        StackPane root = new StackPane();
        Tile piece = new Tile(Color.WHITE,0,0);
        Pawn pawn = new Pawn(Color.WHITE);
        root.getChildren().addAll(piece.getImageView(),pawn.getImageView());

        Scene scene2 = new Scene(root, 640, 480);
        stage.setScene(scene2);

        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}