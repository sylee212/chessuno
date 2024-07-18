package chessuno;

import java.io.IOException;

import chessuno.chessPieces.Pawn;
import chessuno.tiles.Tile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {


        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/game.fxml"));
        Pane root = loader.load();

        // Create Tile and Pawn
        Tile piece = new Tile(Color.WHITE, 0, 0);
        Pawn pawn = new Pawn(Color.WHITE);

        // Add Tile and Pawn to the layout (assuming Pane is the root layout)
        root.getChildren().addAll(piece.getImageView(), pawn.getImageView());

        // Create and set the scene
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);

        // Show the stage
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

/*
 *         //scene = new Scene(loadFXML("primary"), 640, 480);
        //stage.setScene(scene);

        scene = new Scene(loadFXML("game"), 640, 480);

        StackPane root = new StackPane();
        Tile piece = new Tile(Color.WHITE,0,0);
        Pawn pawn = new Pawn(Color.WHITE);
        root.getChildren().addAll(piece.getImageView(),pawn.getImageView());

        Scene scene2 = new Scene(root, 640, 480);
        stage.setScene(scene2);

        stage.show();
 */