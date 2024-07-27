package chessuno.uiContainer;

import java.util.ArrayList;
import java.util.HashMap;

import chessuno.Color;
import chessuno.cards.Card;
import chessuno.cards.CardManager;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CardContainer {

    private static CardContainer cardContainer;

    private CardManager cardManager;

    // this is the AnchorPane that will store everything    
    private AnchorPane cardContainerAnchorPane;

    private double cardContainerAnchorPaneWidth;
    private double cardContainerAnchorPaneHeight;

    private double cardContainerAnchorPaneX;
    private double cardContainerAnchorPaneY;

    // the top gridPane that will store the cards for the top player
    private  GridPane topCardGridPane;

    private double topCardGridPaneWidth;
    private double topCardGridPaneHeight;

    private double topCardGridPaneX;
    private double topCardGridPaneY;

    // the bottom gridPane that will store the cards for the bottom player
    private  GridPane bottomCardGridPane;

    private double bottomCardGridPaneWidth;
    private double bottomCardGridPaneHeight;    

    private double bottomCardGridPaneX;
    private double bottomCardGridPaneY;

    // the middle gridPane that will store the cards that is played and the deck
    private  GridPane middleCardGridPane;
    
    private double middleCardGridPaneWidth;
    private double middleCardGridPaneHeight;

    private double middleCardGridPaneX;
    private double middleCardGridPaneY;





    private CardContainer() {
        // set the singleton
        setCardManager(CardManager.getInstance());

        // initialize the cardContainerAnchorPane
        setCardContainerAnchorPane( new AnchorPane() );

        // initialize the gridpane values
        setTopCardGridPaneWidth(200);
        setTopCardGridPaneHeight(200);
        setTopCardGridPaneX(0);
        setTopCardGridPaneY(0);

        setBottomCardGridPaneWidth(200);
        setBottomCardGridPaneHeight(200);
        setBottomCardGridPaneX(0);
        setBottomCardGridPaneY(600);

        setMiddleCardGridPaneWidth(200);
        setMiddleCardGridPaneHeight(200);

        // 200 is not bad of a coordinate for x
        setMiddleCardGridPaneX(0);
        setMiddleCardGridPaneY(300);

        // set the gridpanes coordinates and size
        setGridPanes();

        // set the gridpanes contents
        setGridPanesContents();
    }

    public static CardContainer getInstance() {
        if (CardContainer.cardContainer == null) {
            CardContainer.cardContainer = new CardContainer();
        }
        return CardContainer.cardContainer;
    }

    private void setGridPanes(){

        // initialize the gridPanes
        setTopCardGridPane( new GridPane() );
        setBottomCardGridPane( new GridPane() );
        setMiddleCardGridPane( new GridPane() );

        // secondly add them to the cardContainerAnchorPane
        cardContainerAnchorPane.getChildren().add(topCardGridPane);
        cardContainerAnchorPane.getChildren().add(bottomCardGridPane);
        cardContainerAnchorPane.getChildren().add(middleCardGridPane);

        // set the top gridPane
        topCardGridPane.setLayoutX(getTopCardGridPaneX());
        topCardGridPane.setLayoutY(getTopCardGridPaneY());
        topCardGridPane.setPrefWidth(getTopCardGridPaneWidth());
        topCardGridPane.setPrefHeight(getTopCardGridPaneHeight());
        
        // set the bottom gridPane
        bottomCardGridPane.setLayoutX(getBottomCardGridPaneX());
        bottomCardGridPane.setLayoutY(getBottomCardGridPaneY());
        bottomCardGridPane.setPrefWidth(getBottomCardGridPaneWidth());
        bottomCardGridPane.setPrefHeight(getBottomCardGridPaneHeight());

        // set the middle gridPane
        middleCardGridPane.setLayoutX(getMiddleCardGridPaneX());
        middleCardGridPane.setLayoutY(getMiddleCardGridPaneY());
        middleCardGridPane.setPrefWidth(getMiddleCardGridPaneWidth());
        middleCardGridPane.setPrefHeight(getMiddleCardGridPaneHeight());
        
    }

    private void setGridPanesContents() {
        // get the cards hash map
        HashMap<Color, ArrayList<Card>> cardsHashMap = cardManager.getPlayerCards();

        // for all the cards array list 
        for ( ArrayList<Card> cardsList : cardsHashMap.values() ) {

            // for each and every card
            // add the cards to the gridPanes
            for ( int x = 0; x < cardsList.size(); x++ ){
                
                Card card = cardsList.get(x);

                GridPane currentGridPane = card.getChessPieceColor() == Color.WHITE ? bottomCardGridPane : topCardGridPane;

                // add it at position column x and row 0 because we only need 1 row
                currentGridPane.add( card.getCardStackPane() , x , 0 );
            }
        }

        // set the card deck in the middle
        setCardDeckInMiddle();

    }

    private void setCardDeckInMiddle(){

        middleCardGridPane.add( cardManager.getCardDeck().getCardDeckStackPane() , 0 , 0 );
    }

    


    /**
     * @return AnchorPane return the cardContainerAnchorPane
     */
    public AnchorPane getCardContainerAnchorPane() {
        return cardContainerAnchorPane;
    }

    /**
     * @param cardContainerAnchorPane the cardContainerAnchorPane to set
     */
    public void setCardContainerAnchorPane(AnchorPane cardContainerAnchorPane) {
        this.cardContainerAnchorPane = cardContainerAnchorPane;
    }

    


    /**
     * @return GridPane return the topCardGridPane
     */
    public GridPane getTopCardGridPane() {
        return topCardGridPane;
    }

    /**
     * @param topCardGridPane the topCardGridPane to set
     */
    public void setTopCardGridPane(GridPane topCardGridPane) {
        this.topCardGridPane = topCardGridPane;
    }

    /**
     * @return GridPane return the bottomCardGridPane
     */
    public GridPane getBottomCardGridPane() {
        return bottomCardGridPane;
    }

    /**
     * @param bottomCardGridPane the bottomCardGridPane to set
     */
    public void setBottomCardGridPane(GridPane bottomCardGridPane) {
        this.bottomCardGridPane = bottomCardGridPane;
    }

    


    /**
     * @return double return the topCardGridPaneWidth
     */
    public double getTopCardGridPaneWidth() {
        return topCardGridPaneWidth;
    }

    /**
     * @param topCardGridPaneWidth the topCardGridPaneWidth to set
     */
    public void setTopCardGridPaneWidth(double topCardGridPaneWidth) {
        this.topCardGridPaneWidth = topCardGridPaneWidth;
    }

    /**
     * @return double return the topCardGridPaneHeight
     */
    public double getTopCardGridPaneHeight() {
        return topCardGridPaneHeight;
    }

    /**
     * @param topCardGridPaneHeight the topCardGridPaneHeight to set
     */
    public void setTopCardGridPaneHeight(double topCardGridPaneHeight) {
        this.topCardGridPaneHeight = topCardGridPaneHeight;
    }

    /**
     * @return double return the topCardGridPaneX
     */
    public double getTopCardGridPaneX() {
        return topCardGridPaneX;
    }

    /**
     * @param topCardGridPaneX the topCardGridPaneX to set
     */
    public void setTopCardGridPaneX(double topCardGridPaneX) {
        this.topCardGridPaneX = topCardGridPaneX;
    }

    /**
     * @return double return the topCardGridPaneY
     */
    public double getTopCardGridPaneY() {
        return topCardGridPaneY;
    }

    /**
     * @param topCardGridPaneY the topCardGridPaneY to set
     */
    public void setTopCardGridPaneY(double topCardGridPaneY) {
        this.topCardGridPaneY = topCardGridPaneY;
    }

    /**
     * @return double return the bottomCardGridPaneWidth
     */
    public double getBottomCardGridPaneWidth() {
        return bottomCardGridPaneWidth;
    }

    /**
     * @param bottomCardGridPaneWidth the bottomCardGridPaneWidth to set
     */
    public void setBottomCardGridPaneWidth(double bottomCardGridPaneWidth) {
        this.bottomCardGridPaneWidth = bottomCardGridPaneWidth;
    }

    /**
     * @return double return the bottomCardGridPaneHeight
     */
    public double getBottomCardGridPaneHeight() {
        return bottomCardGridPaneHeight;
    }

    /**
     * @param bottomCardGridPaneHeight the bottomCardGridPaneHeight to set
     */
    public void setBottomCardGridPaneHeight(double bottomCardGridPaneHeight) {
        this.bottomCardGridPaneHeight = bottomCardGridPaneHeight;
    }

    /**
     * @return double return the bottomCardGridPaneX
     */
    public double getBottomCardGridPaneX() {
        return bottomCardGridPaneX;
    }

    /**
     * @param bottomCardGridPaneX the bottomCardGridPaneX to set
     */
    public void setBottomCardGridPaneX(double bottomCardGridPaneX) {
        this.bottomCardGridPaneX = bottomCardGridPaneX;
    }

    /**
     * @return double return the bottomCardGridPaneY
     */
    public double getBottomCardGridPaneY() {
        return bottomCardGridPaneY;
    }

    /**
     * @param bottomCardGridPaneY the bottomCardGridPaneY to set
     */
    public void setBottomCardGridPaneY(double bottomCardGridPaneY) {
        this.bottomCardGridPaneY = bottomCardGridPaneY;
    }


    /**
     * @return CardManager return the cardManager
     */
    public void setCardManager(CardManager cardManager) {
        this.cardManager = cardManager;
    }


    /**
     * @return CardManager return the cardManager
     */
    public CardManager getCardManager() {
        return cardManager;
    }

    /**
     * @return double return the cardContainerAnchorPaneWidth
     */
    public double getCardContainerAnchorPaneWidth() {
        return cardContainerAnchorPaneWidth;
    }

    /**
     * @param cardContainerAnchorPaneWidth the cardContainerAnchorPaneWidth to set
     */
    public void setCardContainerAnchorPaneWidth(double cardContainerAnchorPaneWidth) {
        this.cardContainerAnchorPaneWidth = cardContainerAnchorPaneWidth;
    }

    /**
     * @return double return the cardContainerAnchorPaneHeight
     */
    public double getCardContainerAnchorPaneHeight() {
        return cardContainerAnchorPaneHeight;
    }

    /**
     * @param cardContainerAnchorPaneHeight the cardContainerAnchorPaneHeight to set
     */
    public void setCardContainerAnchorPaneHeight(double cardContainerAnchorPaneHeight) {
        this.cardContainerAnchorPaneHeight = cardContainerAnchorPaneHeight;
    }

    /**
     * @return double return the cardContainerAnchorPaneX
     */
    public double getCardContainerAnchorPaneX() {
        return cardContainerAnchorPaneX;
    }

    /**
     * @param cardContainerAnchorPaneX the cardContainerAnchorPaneX to set
     */
    public void setCardContainerAnchorPaneX(double cardContainerAnchorPaneX) {
        this.cardContainerAnchorPaneX = cardContainerAnchorPaneX;
    }

    /**
     * @return double return the cardContainerAnchorPaneY
     */
    public double getCardContainerAnchorPaneY() {
        return cardContainerAnchorPaneY;
    }

    /**
     * @param cardContainerAnchorPaneY the cardContainerAnchorPaneY to set
     */
    public void setCardContainerAnchorPaneY(double cardContainerAnchorPaneY) {
        this.cardContainerAnchorPaneY = cardContainerAnchorPaneY;
    }


    /**
     * @return GridPane return the middleCardGridPane
     */
    public GridPane getMiddleCardGridPane() {
        return middleCardGridPane;
    }

    /**
     * @param middleCardGridPane the middleCardGridPane to set
     */
    public void setMiddleCardGridPane(GridPane middleCardGridPane) {
        this.middleCardGridPane = middleCardGridPane;
    }

    /**
     * @return double return the middleCardGridPaneWidth
     */
    public double getMiddleCardGridPaneWidth() {
        return middleCardGridPaneWidth;
    }

    /**
     * @param middleCardGridPaneWidth the middleCardGridPaneWidth to set
     */
    public void setMiddleCardGridPaneWidth(double middleCardGridPaneWidth) {
        this.middleCardGridPaneWidth = middleCardGridPaneWidth;
    }

    /**
     * @return double return the middleCardGridPaneHeight
     */
    public double getMiddleCardGridPaneHeight() {
        return middleCardGridPaneHeight;
    }

    /**
     * @param middleCardGridPaneHeight the middleCardGridPaneHeight to set
     */
    public void setMiddleCardGridPaneHeight(double middleCardGridPaneHeight) {
        this.middleCardGridPaneHeight = middleCardGridPaneHeight;
    }

    /**
     * @return double return the middleCardGridPaneX
     */
    public double getMiddleCardGridPaneX() {
        return middleCardGridPaneX;
    }

    /**
     * @param middleCardGridPaneX the middleCardGridPaneX to set
     */
    public void setMiddleCardGridPaneX(double middleCardGridPaneX) {
        this.middleCardGridPaneX = middleCardGridPaneX;
    }

    /**
     * @return double return the middleCardGridPaneY
     */
    public double getMiddleCardGridPaneY() {
        return middleCardGridPaneY;
    }

    /**
     * @param middleCardGridPaneY the middleCardGridPaneY to set
     */
    public void setMiddleCardGridPaneY(double middleCardGridPaneY) {
        this.middleCardGridPaneY = middleCardGridPaneY;
    }

}
