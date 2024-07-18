package chessuno;

import java.io.IOException;

import chessuno.chessPieces.Pawn;
import chessuno.tiles.Tile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartController {

    @FXML
    private AnchorPane startAnchorPane;
    
    @FXML
    private Button startStartButton;
    
    public AnchorPane getStartAnchorPane() {
        return startAnchorPane;
    }
    
    public void startStartButtonClicked() throws IOException{
        System.out.println("start button clicked");

        // inform game Engine
        Engine.getInstance().setIsStartSceneChange(true);

        // get the stage from the engine
        Stage stage = Engine.getInstance().getStage();

        // get the fxml. COMPULSORY
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/game.fxml"));

        // load the FXML. COMPULSORY
        loader.load();

        // get the controller. COMPULSORY
        GameController gameController = loader.getController();

        // access the variable
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