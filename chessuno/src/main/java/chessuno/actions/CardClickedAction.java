package chessuno.actions;

import chessuno.cards.Card;

public class CardClickedAction extends ActionAbstract {

    private Card cardClicked;

    // the current card is the card that is on the top / end of the stack / list
    private Card currentCard;

    @Override
    public boolean execute() {
        boolean isValidCard = verify();
        if (isValidCard) {

        } 
        return isValidCard;

    }

    /**
     * The verify function can change depending on the settings
     */
    @Override
    public boolean verify() {
        // these 2 conditions are an OR
        boolean cardColorCondition = cardClicked.getColor() == currentCard.getColor();
        boolean cardNumberCondition = cardClicked.getNumber() == currentCard.getNumber();

        // if and only if the 2 cards are chess pieces are different color
        boolean chessPieceColorCondition = cardClicked.getChessPieceColor() == currentCard.getChessPieceColor();

        // this is an extra precaution to ensure that the cards are not the same
        boolean cardUniqueIDCondition = cardClicked.getUniqueID() != currentCard.getUniqueID();

        return ( cardColorCondition || cardNumberCondition) && chessPieceColorCondition && cardUniqueIDCondition;

        
    }

    @Override
    public void fillInformation(ActionInformation actionInformation) {
        setCardClicked(actionInformation.getcardClicked());
        setCurrentCard(actionInformation.getCurrentCard());
    }

    


    /**
     * @return Card return the cardClicked
     */
    public Card getCardClicked() {
        return cardClicked;
    }

    /**
     * @param cardClicked the cardClicked to set
     */
    public void setCardClicked(Card cardClicked) {
        this.cardClicked = cardClicked;
    }

    /**
     * @return Card return the currentCard
     */
    public Card getCurrentCard() {
        return currentCard;
    }

    /**
     * @param currentCard the currentCard to set
     */
    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

}
