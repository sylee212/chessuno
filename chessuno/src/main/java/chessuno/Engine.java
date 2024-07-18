package chessuno;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Dictates everything, has all the instances of every controller class
 */
public class Engine {

    // the singleton engine instance 
    private static Engine instance;

    // the stage
    private Stage stage;

    // start scene change
    private boolean isStartSceneChange = false;

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
            5) for load the fxml, although it is not used, need to load it. So what you can do is, 
                this -> loader.load();
                instead of 
                this -> Pane root = loader.getController();
            6) get the controller 
                GameController controller = loader.getController();
            7) access the variable, for this case, cause the variable is private, need to use a function
                AnchorPane gameControllerAnchorPane = gameController.getGameAnchorPane();

         */

        // assign the stage
        this.stage = stage;
        
        startScene();

    }

    /**
     * Function to load the main scene for the game
     * 
     * @param stage
     * @throws IOException
     */
    private void startScene() throws IOException {
 
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/start.fxml"));
        loader.load();

        // get the controller. COMPULSORY
        StartController startController = loader.getController();

        // access the variable
        AnchorPane startControllerAnchorPane = startController.getStartAnchorPane();

        // Create and set the scene
        Scene scene = new Scene(startControllerAnchorPane, 640, 480);
        stage.setScene(scene);

        // Show the stage
        stage.show();

    }

    /**
     * This function still exist because the change must inform the engine so that the engine can tell the state manager
     * @param b
     */
    public boolean getIsStartSceneChange() {
        return isStartSceneChange;    
    }

    public void setIsStartSceneChange(boolean b) {
        isStartSceneChange = b;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
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
