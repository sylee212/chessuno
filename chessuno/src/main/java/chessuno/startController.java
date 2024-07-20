package chessuno;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartController {

    @FXML
    private AnchorPane startAnchorPane;
    
    @FXML
    private Button startNewGameButton;

    @FXML
    private Button startLoadGameButton;

    
    // stores the values of the users screen and width
    private double maxScreenWidth;
    private double maxScreenHeight;
    
    public AnchorPane getStartAnchorPane() {
        return startAnchorPane;
    }

    /**
     * This is the function that is called when the scene is first loaded
     */
    @FXML
    private void initialize(){

        // store the size
        ArrayList<Double> screenSize = Engine.getScreenSize();
        maxScreenWidth = screenSize.get(0);
        maxScreenHeight = screenSize.get(1);

        setScreenContentPositions();
    }
    
    public void startNewGameButtonClicked() throws IOException{
        System.out.println("start button clicked");

        // inform game Engine
        Engine.getInstance().setIsStartSceneChange(true);

        // get the stage from the engine
        Stage stage = Engine.getInstance().getStage();

        // get the fxml. COMPULSORY
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/register.fxml"));

        // load the FXML. COMPULSORY
        Pane root =loader.load();

        // Create and set the scene
        Scene scene = new Scene(root, maxScreenWidth, maxScreenHeight);
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    private void setScreenContentPositions(){
        
        // calculate x and y positions
        double x = maxScreenWidth / 2;
        double y = maxScreenHeight / 2; 

        // set the positions
        startNewGameButton.setLayoutX(x);
        startNewGameButton.setLayoutY(y);


        // set the positions
        y += 100;
        System.out.println("y = " + y);
        System.out.println("x = " + x);
        startLoadGameButton.setLayoutX(x);
        startLoadGameButton.setLayoutY(y);
    }
}