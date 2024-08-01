package chessuno.actions;

import chessuno.cards.Card;
import chessuno.cards.CardManager;

public class CardClickedAction extends ActionAbstract {

    private Card cardClicked;

    // the current card is the card that is on the top / end of the stack / list
    private Card currentCard;

    private CardManager cardManager;


    public CardClickedAction() {
        super();

       setCardManager(CardManager.getInstance() );
    }

    @Override
    public boolean execute() {
        boolean isValidCard = verify();

        System.out.println("\n////////////////CardClickedAction | execute | currentCard = " + currentCard);

        System.out.println("\n////////////////CardClickedAction | execute | cardClicked = " + cardClicked);

        // if the card is valid perform the required actions
        if (isValidCard) {

            System.out.println("CardClickedAction| isValidCard = " + isValidCard);

            //System.out.println("\nCardClickedAction | BEFORE " + "size = " + getCardManager().getCardStack().getCardStackList().size() + " | " + getCardManager().getCardStack().getCardStackList());

            // add the card onto the stack
            getCardManager().getCardStack().addCardToStack(getCardClicked());

            // gets the card stack list
            //System.out.println("\nCardClickedAction | AFTER " + "size = " + getCardManager().getCardStack().getCardStackList().size() + " | " + getCardManager().getCardStack().getCardStackList());

            // remove the card from the card list
            //System.out.println("\nCardClickedAction | ORIGINAL " + "size = " + cardManager.getPlayerCards().get(Color.WHITE).size() + " | " + cardManager.getPlayerCards());

            // remove the card from the list 
            getCardManager().removeSpecificCard(getCardClicked());

            //System.out.println("\nCardClickedAction | AFTER " + "size = " + cardManager.getPlayerCards().get(Color.WHITE).size() + " | " + cardManager.getPlayerCards());

            // if we reach until here already, means the card has been confirmed
            getCardManager().setIsClickedCardConfirmed(true);

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


    /**
     * @param cardManager the cardManager to set
     */
    public void setCardManager(CardManager cardManager) {
        this.cardManager = cardManager;
    }

    public CardManager getCardManager() {   
        return cardManager;
    }

}
