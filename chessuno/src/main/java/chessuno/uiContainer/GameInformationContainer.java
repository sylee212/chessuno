package chessuno.uiContainer;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;



public class GameInformationContainer {

    private static GameInformationContainer gameInformationContainer;

    private GridPane gameInformationGridPane;

    private double gameInformationGridPaneWidth;
    private double gameInformationGridPaneHeight;
    private double gameInformationGridPaneX;
    private double gameInformationGridPaneY;


    private Label currentPlayerLabel;
    private String currentPlayerLabelPrefix;

    private Label currentPlayerColorLabel;
    private String currentPlayerColorLabelPrefix;

    private Label clickedChessPieceLabel;
    private String clickedChessPieceLabelPrefix;

    private Label clickedCardLabel;
    private String clickedCardLabelPrefix;

    private Label clickedTileLabel;
    private String clickedTilePrefix;

    public static GameInformationContainer getInstance() {
        if ( GameInformationContainer.gameInformationContainer == null ) {
            GameInformationContainer.gameInformationContainer = new GameInformationContainer();
        }

        return GameInformationContainer.gameInformationContainer;

    }

    private GameInformationContainer() {

        // initialize the prefix
        setCurrentPlayerLabelPrefix("Current Player: ");
        setCurrentPlayerColorLabelPrefix("Current Player color: ");
        setClickedChessPieceLabelPrefix("Clicked Chess Piece: ");
        setClickedCardLabelPrefix("Clicked Card: ");
        setClickedTilePrefix("Clicked Tile: ");

        // initialize the Labels
        setCurrentPlayerLabel(new Label(getCurrentPlayerLabelPrefix()));
        setCurrentPlayerColorLabel(new Label(getCurrentPlayerColorLabelPrefix()));
        setClickedChessPieceLabel(new Label(getClickedChessPieceLabelPrefix()));
        setClickedCardLabel(new Label(getClickedCardLabelPrefix()));
        setClickedTileLabel(new Label(getClickedTilePrefix()));

        // initialize the GridPane
        setGameInformationGridPane(new GridPane());

        setGameInformationGridPaneWidth(1000);
        setGameInformationGridPaneHeight(200);
        setGameInformationGridPaneX(0);
        setGameInformationGridPaneY(0);

        // set the properties
        getGameInformationGridPane().setPrefWidth(getGameInformationGridPaneWidth());
        getGameInformationGridPane().setPrefHeight(getGameInformationGridPaneHeight());
        getGameInformationGridPane().setLayoutX(getGameInformationGridPaneX());
        getGameInformationGridPane().setLayoutY(getGameInformationGridPaneY());

        // add the contents to the gridPane
        getGameInformationGridPane().add(getCurrentPlayerLabel(), 0, 0);
        getGameInformationGridPane().add(getCurrentPlayerColorLabel(), 0, 1);
        getGameInformationGridPane().add(getClickedChessPieceLabel(), 0, 2);
        getGameInformationGridPane().add(getClickedCardLabel(), 0, 3);
        getGameInformationGridPane().add(getClickedTileLabel(), 0, 4);

    }

    public void updateCurrentPlayerLabel(String text) {

        getCurrentPlayerLabel().setText(getCurrentPlayerLabelPrefix() + text);
    }

    public void updateCurrentPlayerColorLabel(String text) {

        getCurrentPlayerColorLabel().setText(getCurrentPlayerColorLabelPrefix() + text);
    }

    public void updateClickedChessPieceLabel(String text) {

        getClickedChessPieceLabel().setText(getClickedChessPieceLabelPrefix() + text);
    }

    public void updateClickedCardLabel(String text) {

        getClickedCardLabel().setText(getClickedCardLabelPrefix() + text);
    }

    public void updateClickedTileLabel(String text) {

        getClickedTileLabel().setText(getClickedTilePrefix() + text);
    }


    /**
     * @return Label return the currentPlayerLabel
     */
    public Label getCurrentPlayerLabel() {
        return currentPlayerLabel;
    }

    /**
     * @param currentPlayerLabel the currentPlayerLabel to set
     */
    public void setCurrentPlayerLabel(Label currentPlayerLabel) {
        this.currentPlayerLabel = currentPlayerLabel;
    }

    /**
     * @return Label return the currentPlayerColorLabel
     */
    public Label getCurrentPlayerColorLabel() {
        return currentPlayerColorLabel;
    }

    /**
     * @param currentPlayerColorLabel the currentPlayerColorLabel to set
     */
    public void setCurrentPlayerColorLabel(Label currentPlayerColorLabel) {
        this.currentPlayerColorLabel = currentPlayerColorLabel;
    }

    /**
     * @return Label return the clickedChessPieceLabel
     */
    public Label getClickedChessPieceLabel() {
        return clickedChessPieceLabel;
    }

    /**
     * @param clickedChessPieceLabel the clickedChessPieceLabel to set
     */
    public void setClickedChessPieceLabel(Label clickedChessPieceLabel) {
        this.clickedChessPieceLabel = clickedChessPieceLabel;
    }

    /**
     * @return Label return the clickedCardLabel
     */
    public Label getClickedCardLabel() {
        return clickedCardLabel;
    }

    /**
     * @param clickedCardLabel the clickedCardLabel to set
     */
    public void setClickedCardLabel(Label clickedCardLabel) {
        this.clickedCardLabel = clickedCardLabel;
    }


    /**
     * @return String return the currentPlayerLabelPrefix
     */
    public String getCurrentPlayerLabelPrefix() {
        return currentPlayerLabelPrefix;
    }

    /**
     * @param currentPlayerLabelPrefix the currentPlayerLabelPrefix to set
     */
    public void setCurrentPlayerLabelPrefix(String currentPlayerLabelPrefix) {
        this.currentPlayerLabelPrefix = currentPlayerLabelPrefix;
    }

    /**
     * @return String return the currentPlayerColorLabelPrefix
     */
    public String getCurrentPlayerColorLabelPrefix() {
        return currentPlayerColorLabelPrefix;
    }

    /**
     * @param currentPlayerColorLabelPrefix the currentPlayerColorLabelPrefix to set
     */
    public void setCurrentPlayerColorLabelPrefix(String currentPlayerColorLabelPrefix) {
        this.currentPlayerColorLabelPrefix = currentPlayerColorLabelPrefix;
    }

    /**
     * @return String return the clickedChessPieceLabelPrefix
     */
    public String getClickedChessPieceLabelPrefix() {
        return clickedChessPieceLabelPrefix;
    }

    /**
     * @param clickedChessPieceLabelPrefix the clickedChessPieceLabelPrefix to set
     */
    public void setClickedChessPieceLabelPrefix(String clickedChessPieceLabelPrefix) {
        this.clickedChessPieceLabelPrefix = clickedChessPieceLabelPrefix;
    }

    /**
     * @return String return the clickedCardLabelPrefix
     */
    public String getClickedCardLabelPrefix() {
        return clickedCardLabelPrefix;
    }

    /**
     * @param clickedCardLabelPrefix the clickedCardLabelPrefix to set
     */
    public void setClickedCardLabelPrefix(String clickedCardLabelPrefix) {
        this.clickedCardLabelPrefix = clickedCardLabelPrefix;
    }


    /**
     * @return GridPane return the gameInformationGridPane
     */
    public GridPane getGameInformationGridPane() {
        return gameInformationGridPane;
    }

    /**
     * @param gameInformationGridPane the gameInformationGridPane to set
     */
    public void setGameInformationGridPane(GridPane gameInformationGridPane) {
        this.gameInformationGridPane = gameInformationGridPane;
    }


    /**
     * @return double return the gameInformationGridPaneWidth
     */
    public double getGameInformationGridPaneWidth() {
        return gameInformationGridPaneWidth;
    }

    /**
     * @param gameInformationGridPaneWidth the gameInformationGridPaneWidth to set
     */
    public void setGameInformationGridPaneWidth(double gameInformationGridPaneWidth) {
        this.gameInformationGridPaneWidth = gameInformationGridPaneWidth;
    }

    /**
     * @return double return the gameInformationGridPaneHeight
     */
    public double getGameInformationGridPaneHeight() {
        return gameInformationGridPaneHeight;
    }

    /**
     * @param gameInformationGridPaneHeight the gameInformationGridPaneHeight to set
     */
    public void setGameInformationGridPaneHeight(double gameInformationGridPaneHeight) {
        this.gameInformationGridPaneHeight = gameInformationGridPaneHeight;
    }

    /**
     * @return double return the gameInformationGridPaneX
     */
    public double getGameInformationGridPaneX() {
        return gameInformationGridPaneX;
    }

    /**
     * @param gameInformationGridPaneX the gameInformationGridPaneX to set
     */
    public void setGameInformationGridPaneX(double gameInformationGridPaneX) {
        this.gameInformationGridPaneX = gameInformationGridPaneX;
    }

    /**
     * @return double return the gameInformationGridPaneY
     */
    public double getGameInformationGridPaneY() {
        return gameInformationGridPaneY;
    }

    /**
     * @param gameInformationGridPaneY the gameInformationGridPaneY to set
     */
    public void setGameInformationGridPaneY(double gameInformationGridPaneY) {
        this.gameInformationGridPaneY = gameInformationGridPaneY;
    }


    /**
     * @return Label return the clickedTileLabel
     */
    public Label getClickedTileLabel() {
        return clickedTileLabel;
    }

    /**
     * @param clickedTileLabel the clickedTileLabel to set
     */
    public void setClickedTileLabel(Label clickedTileLabel) {
        this.clickedTileLabel = clickedTileLabel;
    }

    /**
     * @return String return the clickedTilePrefix
     */
    public String getClickedTilePrefix() {
        return clickedTilePrefix;
    }

    /**
     * @param clickedTilePrefix the clickedTilePrefix to set
     */
    public void setClickedTilePrefix(String clickedTilePrefix) {
        this.clickedTilePrefix = clickedTilePrefix;
    }

}
