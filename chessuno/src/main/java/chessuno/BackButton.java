package chessuno;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class BackButton {

    private Polygon backButtonPolygon;

    public BackButton()
    {
        Polygon backButton = new Polygon();
        backButton.getPoints().addAll(new Double[]{
            10.0, 20.0,  // Left point
            30.0, 10.0,  // Top point
            30.0, 15.0,  // Top right point
            50.0, 15.0,  // Right point
            50.0, 25.0,  // Bottom right point
            30.0, 25.0,  // Bottom point
            30.0, 30.0   // Bottom left point
        });

        // fill the polygon, but this Color does not use the Color class of our own. It uses the 
        // import javafx.scene.paint.Color;
        backButton.setFill(Color.BLACK);



        // add the polygon to the variable
        setBackButtonPolygon(backButton);
    }

    

    /**
     * @return Polygon return the backButtonPolygon
     */
    public Polygon getBackButtonPolygon() {
        return backButtonPolygon;
    }

    /**
     * @param backButtonPolygon the backButtonPolygon to set
     */
    public void setBackButtonPolygon(Polygon backButtonPolygon) {
        this.backButtonPolygon = backButtonPolygon;
    }

    /**
     * 
     * @param FXMLAddress eg, "/chessuno/register.fxml"
     * @return
     */
    private void setGoBack(String FXMLAddress, double maxScreenWidth, double maxScreenHeight) throws IOException {

        // get the stage from the engine
        Stage stage = Engine.getInstance().getStage();

        // get the fxml. COMPULSORY
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLAddress));

        // load the FXML. COMPULSORY
        Pane root =loader.load();

        // Create and set the scene
        Scene scene = new Scene(root, maxScreenWidth, maxScreenHeight);
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    public void setOnMouseClicked( String FXMLAddress, double maxScreenWidth, double maxScreenHeight) throws IOException{
        // Add a click event to the polygon
        this.backButtonPolygon.setOnMouseClicked(event -> {
            System.out.println("Back button clicked!");

            
            try {
                setGoBack(FXMLAddress, maxScreenWidth, maxScreenHeight);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }); 

    }


}
