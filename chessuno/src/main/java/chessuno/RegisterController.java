package chessuno;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
/**
 * How to use drop down box or ChoiceBox
 * 1) create a ChoiceBox in FXML
 * 2) connect the ChoiceBox to the controller
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

    @FXML Polygon registerTriangleGoBackShape;

    @FXML
    private Button registerNextButton;

    /**
     * This is the function that is called when the scene is first loaded
     */
    @FXML
    private void initialize(){

    }


    @FXML
    private void registerButtonClicked() {
        System.out.println(choiceBox.getValue());
    }
}
