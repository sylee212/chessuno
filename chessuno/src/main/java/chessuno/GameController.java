package chessuno;

import java.util.ArrayList;

import chessuno.cards.Card;
import chessuno.cards.CardFactory;
import chessuno.chessPieces.ChessPieceType;
import chessuno.uiContainer.ChessBoard;
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

    // chess variables // 
    private ChessBoard chessBoard;

    // the chess board grid pane where all the pieces will be in 
    private GridPane chessBoardGridPane;

    // card variables //

    // creates the card BorderPane 
    private BorderPane cardBorderPane;

    

    /**
     * This is the function that is called when the scene is first loaded
     */
    @FXML
    private void initialize(){

        // store the size of the screen // 
        ArrayList<Double> screenSize = Engine.getScreenSize();
        maxScreenWidth = screenSize.get(0);
        maxScreenHeight = screenSize.get(1);

        // set the chess contents // 
        // get the singleton for the chess board ui 
        chessBoard = ChessBoard.getInstance();

        // assign the GridPane to the instance variable
        setChessBoardGridPane(chessBoard.getChessBoardGridPane());

        // set the card contents // 
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

            chessBoard.setChessBoardGridPaneWidth( width);
            chessBoard.setChessBoardGridPaneHeight( height);

        });

        System.out.println("GridPane width: " + chessBoard.getChessBoardGridPaneWidth());
        System.out.println("GridPane height: " + chessBoard.getChessBoardGridPaneHeight());

        // the y coordinate might need to change
        double gridPaneX = 100;
        double gridPaneY = y;

        getChessBoardGridPane().setLayoutX(gridPaneX);
        getChessBoardGridPane().setLayoutY(gridPaneY);


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

    public AnchorPane getGameAnchorPane() {
        return GameAnchorPane;
    }

    public void setGameAnchorPane(AnchorPane GameAnchorPane) {
        this.GameAnchorPane = GameAnchorPane;
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

    public void setChessBoardGridPane(GridPane chessBoardGridPane) {
        this.chessBoardGridPane = chessBoardGridPane;
    }

    public GridPane getChessBoardGridPane() {
        return chessBoardGridPane;
    }

}
