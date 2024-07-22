package chessuno;

import java.util.ArrayList;

import chessuno.tiles.Tile;
import chessuno.tiles.TileManager;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private AnchorPane GameAnchorPane;

    // stores the values of the users screen and width
    private double maxScreenWidth;
    private double maxScreenHeight;

    // the chess board grid pane where all the pieces will be in 
    private GridPane chessBoardGridPane;

    // stores the gridpane width and height
    private double chessBoardGridPaneWidth;
    private double chessBoardGridPaneHeight;

    public AnchorPane getGameAnchorPane() {
        return GameAnchorPane;
    }

    public void setGameAnchorPane(AnchorPane GameAnchorPane) {
        this.GameAnchorPane = GameAnchorPane;
    }

    public void setChessBoardGridPane(GridPane chessBoardGridPane) {
        this.chessBoardGridPane = chessBoardGridPane;
    }

    public GridPane getChessBoardGridPane() {
        return chessBoardGridPane;
    }

    /**
     * @return double return the maxScreenWidth
     */
    public double getMaxScreenWidth() {
        return maxScreenWidth;
    }

    /**
     * @param maxScreenWidth the maxScreenWidth to set
     */
    public void setMaxScreenWidth(double maxScreenWidth) {
        this.maxScreenWidth = maxScreenWidth;
    }

    /**
     * @return double return the maxScreenHeight
     */
    public double getMaxScreenHeight() {
        return maxScreenHeight;
    }

    /**
     * @param maxScreenHeight the maxScreenHeight to set
     */
    public void setMaxScreenHeight(double maxScreenHeight) {
        this.maxScreenHeight = maxScreenHeight;
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

        // create the GridPane
        GridPane chessBoardGridPaneTemp = new GridPane();

        // assign the GridPane to the instance variable
        setChessBoardGridPane(chessBoardGridPaneTemp);

        // add in the tiles
        setChessBoardTiles();

        // add to anchorpane
        GameAnchorPane.getChildren().add(getChessBoardGridPane());

        setScreenContentPositions();
    }

    private void setScreenContentPositions(){
        
        // calculate x and y positions
        double x = maxScreenWidth / 2;
        double y = maxScreenHeight / 2; 


        // ChatGPT
        // because we can only get the size of the gridpane after the gridpane is added to the anchorpane
        // Access the size of the GridPane after layout
        getChessBoardGridPane().layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            double width = getChessBoardGridPane().getWidth();
            double height = getChessBoardGridPane().getHeight();

            setChessBoardGridPaneWidth(chessBoardGridPaneWidth = width);
            setChessBoardGridPaneHeight(chessBoardGridPaneHeight = height);

        });

        System.out.println("GridPane width: " + getChessBoardGridPaneWidth());
        System.out.println("GridPane height: " + getChessBoardGridPaneHeight());

        // the y coordinate might need to change
        double gridPaneX = 100;
        double gridPaneY = y;

        getChessBoardGridPane().setLayoutX(gridPaneX);
        getChessBoardGridPane().setLayoutY(gridPaneY);


    }

    private void setChessBoardTiles(){

        // get the list of tiles
        ArrayList<Tile> tileList = TileManager.getInstance().getTileList();
        
        // get the number of tiles
        int numberOfTiles = tileList.size();

        // for row
        for ( int tileNumber = 0; tileNumber < numberOfTiles; tileNumber++ ){

            // get the tile
            Tile tile = tileList.get(tileNumber);
            // get the column
            int col = tile.getChessLocation().getChessColumnCoordinate();
            // get the row
            int row = tile.getChessLocation().getChessRowCoordinate();
            
            chessBoardGridPane.add(tile.getImageView(), col, row);
        }


    }







    /**
     * @return double return the chessBoardGridPaneWidth
     */
    public double getChessBoardGridPaneWidth() {
        return chessBoardGridPaneWidth;
    }

    /**
     * @param chessBoardGridPaneWidth the chessBoardGridPaneWidth to set
     */
    public void setChessBoardGridPaneWidth(double chessBoardGridPaneWidth) {
        this.chessBoardGridPaneWidth = chessBoardGridPaneWidth;
    }

    /**
     * @return double return the chessBoardGridPaneHeight
     */
    public double getChessBoardGridPaneHeight() {
        return chessBoardGridPaneHeight;
    }

    /**
     * @param chessBoardGridPaneHeight the chessBoardGridPaneHeight to set
     */
    public void setChessBoardGridPaneHeight(double chessBoardGridPaneHeight) {
        this.chessBoardGridPaneHeight = chessBoardGridPaneHeight;
    }

}
