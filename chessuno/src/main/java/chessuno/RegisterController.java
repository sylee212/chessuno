package chessuno;

import java.io.IOException;
import java.util.ArrayList;

import chessuno.chessPieces.Pawn;
import chessuno.player.PlayerManager;
import chessuno.tiles.Tile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
/**
 * How to use drop down box or ChoiceBox
 * 1) create a ChoiceBox in FXML
 * 2) connect the ChoiceBox to the controller
 * 3) in the initialize function, fill in the ChoiceBox
 * 4) set the initial value
 * 5) get the value from the ChoiceBox when button is pressed OR setOnAction
 */
public class RegisterController {
        
    @FXML
    private AnchorPane registerAnchorPane;

    @FXML
    private Label registerRegisterPlayerLabel;

    @FXML
    private Label registerSelectColorLabel;

    @FXML
    private TextField registerEnterNameTextField;

    @FXML 
    private ChoiceBox<String> registerChoiceBox;

    @FXML
    private Button registerNextButton;

    // the backButton
    private Polygon backButton;

    // stores the values of the users screen and width
    private double maxScreenWidth;
    private double maxScreenHeight;

    /**
     * This is the function that is called when the scene is first loaded
     */
    @FXML
    private void initialize(){

        // set the screen resolutions
        ArrayList<Double> screenSize = Engine.getScreenSize();

        maxScreenWidth = screenSize.get(0);
        maxScreenHeight = screenSize.get(1);

        // set the screen contents based on the size of the screen
        setScreenContentPositions();

        // set the scene
        setRegisterScene();

        // set the ChoiceBox // 
        // Populate the ChoiceBox with items
        registerChoiceBox.getItems().addAll("Black", "White");

        // Set a default value
        registerChoiceBox.setValue("White");

        try {
            initializeBackButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    @FXML
    private void registerButtonClicked() throws IOException{

        // get the name of the player from the text field
        String inputPlayerName = registerEnterNameTextField.getText();

        // get the color of the player from the ChoiceBox
        String inputPlayerColor = registerChoiceBox.getValue();

        // set the wanted color 
        Color chosenPlayerColor = null;

        if ( inputPlayerColor.equals("Black" ) ) {

            // if the player chose black, set the chosen Color type to black and remove the item from the ChoiceBox
            chosenPlayerColor = Color.BLACK;

            // remove the choice from the ChoiceBox
            registerChoiceBox.getItems().remove(inputPlayerColor);

        } else if ( inputPlayerColor.equals("White" ) ) {

            // if the player chose white, set the chosen Color type to white
            chosenPlayerColor = Color.WHITE;

            // remove the choice from the ChoiceBox
            registerChoiceBox.getItems().remove(inputPlayerColor);

        } else {
            System.out.println("There was an error with the color selection");
        }

        // create the player
        boolean createPlayerRes = PlayerManager.getInstance().createPlayer(inputPlayerName, chosenPlayerColor);

        // check for creating player
        // if cannot create player inform the user
        if ( createPlayerRes == false ) {

            // inform the user
            System.out.println("Player could not be created");
        } else {

            // reset the TextField
            registerEnterNameTextField.clear();

            // only set the default value if there is a value
            if ( !registerChoiceBox.getItems().isEmpty() ){
                // set the default value for the choice box
                registerChoiceBox.setValue(registerChoiceBox.getItems().get(0));

            }

            // update the scene
            setRegisterScene();
        }

        // change the text next button 
        if ( PlayerManager.getInstance().getNumberOfPlayers() + 1  >= PlayerManager.MAX_NUMBER_OF_PLAYERS ) {

            // set the text
            registerNextButton.setText("Start Game");
        
        }

        // check if the max player cap is reached
        if ( PlayerManager.getInstance().getNumberOfPlayers() >= PlayerManager.MAX_NUMBER_OF_PLAYERS ) {
            playerMaxReached();
        }


    }

    private void setRegisterScene(){
        
        // set the label //
        // can use getText()
        String registerPlayerLabel =  "Register Player " + ( PlayerManager.getInstance().getNumberOfPlayers() + 1 ) ;

        // set the text
        registerRegisterPlayerLabel.setText( registerPlayerLabel );

        // clear the input field
        registerEnterNameTextField.clear();
    }

    public void playerMaxReached() throws IOException {
        System.out.println("register button clicked with max player cap");

        // inform game Engine
        Engine.getInstance().setIsRegisterSceneChange(true);

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
        Scene scene = new Scene(gameControllerAnchorPane, maxScreenWidth, maxScreenHeight);
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    private void setScreenContentPositions(){
        
        // calculate x and y positions
        double x = maxScreenWidth / 2;
        double y = maxScreenHeight / 2; 

        // set the positions
        //startNewGameButton.setLayoutX(x);
        //startNewGameButton.setLayoutY(y);


        // set the positions
        y += 100;
        //System.out.println("y = " + y);
        //System.out.println("x = " + x);
        //startLoadGameButton.setLayoutX(x);
        //startLoadGameButton.setLayoutY(y);
    }

    private void initializeBackButton() throws IOException{

        // create the blackButton and add it to the scene
        BackButton backButton = new BackButton();

        double x = maxScreenWidth / 2;
        double y = maxScreenHeight / 2;

        // set the x and y coordinate
        backButton.getBackButtonPolygon().setLayoutX(x);
        backButton.getBackButtonPolygon().setLayoutY(y);

        // set the back button functionality
        String FXMLAddress = "/chessuno/start.fxml";
        backButton.setOnMouseClicked(FXMLAddress, this.maxScreenWidth, this.maxScreenHeight);

        // inform Engine 
        Engine.getInstance().setIsStartSceneChange(false);

        // add the button to the pane
        registerAnchorPane.getChildren().add(backButton.getBackButtonPolygon());
    }



}
