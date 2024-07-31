package chessuno.cards;

import java.util.ArrayList;

import javafx.scene.layout.AnchorPane;

public class CardStack {

    private AnchorPane cardStackAnchorPane;

    private ArrayList<Card> cardStackList;

    public CardStack() {

        // initialize the variables
        setCardStackAnchorPane( new AnchorPane() );

        setCardStackList( new ArrayList<Card>() );
    }

    public Card getLastCard() {
        Card card = getCardStackList().get( getCardStackList().size() - 1 );
        return card;
    }


    public AnchorPane getCardStackAnchorPane() {
        return cardStackAnchorPane;
    }

    public void setCardStackAnchorPane(AnchorPane cardStackAnchorPane) {
        this.cardStackAnchorPane = cardStackAnchorPane;
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
            getCardStackAnchorPane().getChildren().remove( getCardStackList().get( cardStackListSize - 1 ).getCardStackPane() );
        }

        // add the card to the UI
        getCardStackAnchorPane().getChildren().add( card.getCardStackPane() );

    }

}
