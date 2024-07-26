package chessuno;

import java.util.ArrayList;

import chessuno.cards.Card;
import chessuno.cards.CardFactory;
import chessuno.chessPieces.ChessPiece;
import chessuno.chessPieces.ChessPieceManager;
import chessuno.chessPieces.ChessPieceType;
import chessuno.tiles.Tile;
import chessuno.tiles.TileManager;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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

    // creates the card BorderPane 
    private BorderPane cardBorderPane;

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

        // add in the chess pieces
        setChessBoardPieces();

        // set the card contents 
        BorderPane cardBorderPaneTemp = new BorderPane();

        // set the BorderPane to the instance variable
        setCardBorderPane(cardBorderPaneTemp);

        setCards();

        // add to anchorpane
        GameAnchorPane.getChildren().add(getChessBoardGridPane());

        setScreenContentPositions();

        // used for testing
        Card card = CardFactory.getInstance().createSpecificCard(Color.RED, ChessPieceType.BISHOP, 9);

        GameAnchorPane.getChildren().add(card.getCardStackPane());
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

    private void setCards(){
        
    }

    private void setChessBoardTiles(){

        // get the list of tiles
        ArrayList<ArrayList<Tile>> tileList = TileManager.getInstance().getTileListGridForm();
        
        // get the number of tiles
        int numberOfTilesPerRow = tileList.size();

        // for row
        for ( int tileRow = 0; tileRow < numberOfTilesPerRow; tileRow++ ){

            int numberOfTilesPerColumn = tileList.get(tileRow).size();

            ArrayList<Tile> currentTileList = tileList.get(tileRow);

            for ( int tileColumn = 0 ; tileColumn < numberOfTilesPerColumn ; tileColumn++ ){

                // get the tile
                Tile tile = currentTileList.get(tileColumn);
                // get the column
                int col = tile.getChessLocation().getChessColumnCoordinate();
                // get the row
                int row = tile.getChessLocation().getChessRowCoordinate();
                
                chessBoardGridPane.add(tile.getImageView(), col, row);
            }
        }


    }


    public void setChessBoardPieces(){

        // instantiate the chess pieces 
        // get the list of chess pieces
        ArrayList<ChessPiece> blackChessPieceList = ChessPieceManager.getInstance().getBlackChessPieceList();

        ArrayList<ChessPiece> whiteChessPieceList = ChessPieceManager.getInstance().getWhiteChessPieceList();

        int listMinSize = Math.min(blackChessPieceList.size(), whiteChessPieceList.size());


        /////////// PENDING ////////////////////// need to add the pieces connection to the tiles
        for ( int i = 0 ; i < listMinSize ; i++ ){
        
            // get the black chess piece
            ChessPiece blackChessPiece = blackChessPieceList.get(i);    
            
            // get black chess piece location
            int blackCol = blackChessPiece.getChessLocation().getChessColumnCoordinate();
            int blackRow = blackChessPiece.getChessLocation().getChessRowCoordinate();

            // add the black chess piece to the gridpane
            chessBoardGridPane.add(blackChessPiece.getImageView(), blackCol, blackRow);

            // get the white chess piece
            ChessPiece whiteChessPiece = whiteChessPieceList.get(i);
            
            // get white chess piece location
            int whiteCol = whiteChessPiece.getChessLocation().getChessColumnCoordinate();
            int whiteRow = whiteChessPiece.getChessLocation().getChessRowCoordinate();

            // get the white chess piece
            chessBoardGridPane.add(whiteChessPiece.getImageView(), whiteCol, whiteRow);
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


    /**
     * @return BorderPane return the cardBorderPane
     */
    public BorderPane getCardBorderPane() {
        return cardBorderPane;
    }

    /**
     * @param cardBorderPane the cardBorderPane to set
     */
    public void setCardBorderPane(BorderPane cardBorderPane) {
        this.cardBorderPane = cardBorderPane;
    }

}
