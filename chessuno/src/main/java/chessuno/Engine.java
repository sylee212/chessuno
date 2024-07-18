package chessuno;

import java.io.IOException;

import chessuno.chessPieces.Pawn;
import chessuno.tiles.Tile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Dictates everything, has all the instances of every controller class
 */
public class Engine {

    // the singleton engine instance 
    private static Engine instance;

    public static Engine getInstance() {

        // if the instance is null, create a new one
        if (instance == null) {
            instance = new Engine();
        }
        return instance;

    }

    /**
     * Blank constructor
     */
    private Engine() {}

    public void startGame(Stage stage)  throws IOException {

        /*
         * To access the variables in the controller class
         * 1) create the variable and make it the same name as the anchorPane in the controller class
                @FXML
                private AnchorPane GameAnchorPane;
            2) dosent have to be private, can be public, if public no need method to access it
            3) get the FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/game.fxml"));
            4) load the fxml
                Pane root = loader.load();
            5) for load the fxml, not sure if needed. cause we wiill use something else later which is the var from the controller class
            6) get the controller 
                GameController controller = loader.getController();
            7) access the variable, for this case, cause the variable is private, need to use a function
                AnchorPane gameControllerAnchorPane = gameController.getGameAnchorPane();

         */

        
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/game.fxml"));
        Pane root = loader.load();

        GameController gameController = loader.getController();

        AnchorPane gameControllerAnchorPane = gameController.getGameAnchorPane();

        // Create Tile and Pawn
        Tile piece = new Tile(Color.WHITE, 0, 0);
        Pawn pawn = new Pawn(Color.WHITE);

        // Add Tile and Pawn to the layout (assuming Pane is the root layout)
        gameControllerAnchorPane.getChildren().addAll(piece.getImageView(), pawn.getImageView());
 
        // Create and set the scene
        Scene scene = new Scene(gameControllerAnchorPane, 640, 480);
        stage.setScene(scene);

        // Show the stage
        stage.show();

    }
}
/*
 *        
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/game.fxml"));
        Pane root = loader.load();

        GameController gameController = loader.getController();

        AnchorPane gameControllerAnchorPane = gameController.getGameAnchorPane();

        // Create Tile and Pawn
        Tile piece = new Tile(Color.WHITE, 0, 0);
        Pawn pawn = new Pawn(Color.WHITE);

        // Add Tile and Pawn to the layout (assuming Pane is the root layout)
        gameControllerAnchorPane.getChildren().addAll(piece.getImageView(), pawn.getImageView());
 
        // Create and set the scene
        Scene scene = new Scene(gameControllerAnchorPane, 640, 480);
        stage.setScene(scene);

        // Show the stage
        stage.show();

 */
