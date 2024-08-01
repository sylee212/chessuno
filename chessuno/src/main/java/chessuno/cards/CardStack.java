package chessuno.cards;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;

public class CardStack {


    private GridPane cardStackGridPane;

    private ArrayList<Card> cardStackList;

    public CardStack() {

        // initialize the variables
        setCardStackGridPane( new GridPane() );

        setCardStackList( new ArrayList<Card>() );
    }

    public Card getLastCard() {
        Card card = getCardStackList().get( getCardStackList().size() - 1 );
        return card;
    }


    /**
     * @return ArrayList<Card> return the cardStackList
     */
    public ArrayList<Card> getCardStackList() {
        return cardStackList;
    }

    /**
     * @param cardStackList the cardStackList to set
     */
    public void setCardStackList(ArrayList<Card> cardStackList) {
        this.cardStackList = cardStackList;
    }

    public void addCardToStack(Card card) {

        // add the card to the arrayList
        getCardStackList().add(card);

        // add the card to the UI
        addCardToStackUI(card);
    }

    private void addCardToStackUI(Card card) {

        int cardStackListSize = getCardStackList().size();

        // if there is already a card on the cardStack
        if ( cardStackListSize > 0 ){

            // remove the card that is already on the UI
            getCardStackGridPane().getChildren().remove( getCardStackList().get( cardStackListSize - 1 ).getCardStackPane() );
        }

        // add the card to the UI
        getCardStackGridPane().add( card.getCardStackPane() , 0 , 0);

    }


    /**
     * @return GridPane return the cardStackGridPane
     */
    public GridPane getCardStackGridPane() {
        return cardStackGridPane;
    }

    /**
     * @param cardStackGridPane the cardStackGridPane to set
     */
    public void setCardStackGridPane(GridPane cardStackGridPane) {
        this.cardStackGridPane = cardStackGridPane;
    }

}
