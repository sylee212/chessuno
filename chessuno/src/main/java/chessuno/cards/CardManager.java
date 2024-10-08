package chessuno.cards;

import java.util.ArrayList;
import java.util.HashMap;

import chessuno.Color;

public class CardManager {

    private static CardManager cardManager;

    public static final int MAX_NUMBER_OF_CARDS_PER_PLAYER = 8;

    private HashMap< Color , ArrayList<Card> > playerCards;

    private CardDeck cardDeck;
    
    private CardStack cardStack;
    
    private CardFactory cardFactory;

    private Card clickedCard;

    private boolean isClickedCardConfirmed;

    

    

    private CardManager() {

        // initialize the hashmap
        playerCards = new HashMap<>();

        // initialize the card deck
        setCardDeck(new CardDeck());

        // initialize the card stack
        setCardStack(new CardStack());

        // initialize the factory
        setCardFactory(CardFactory.getInstance());

        // ask factory to generate a random card
        // can be any color on here
        Card firstCard = cardFactory.createRandomCard(Color.WHITE);

        // add the first card to the cardStack
        getCardStack().addCardToStack(firstCard );

        // initialize the isClickedCardConfirmed
        setIsClickedCardConfirmed(false);
    }   

    public static CardManager getInstance() {
        if (CardManager.cardManager == null) {
            CardManager.cardManager = new CardManager();
        }
        return CardManager.cardManager;
    }

    public ArrayList<Card> initializeCards(Color chessPieceColor) {

        System.out.println(chessPieceColor);

        // create the cards list
        ArrayList<Card> cardsList = new ArrayList<>();

        // for each card, create a card and add it to the list
        for (int i = 0; i < MAX_NUMBER_OF_CARDS_PER_PLAYER; i++) {
            cardsList.add(cardFactory.createRandomCard(chessPieceColor));
        }

        // add the cards to the list
        putPlayerCards(chessPieceColor, cardsList);

        return cardsList;
    }

    


    /**
     * @return ArrayList<ArrayList<Card>> return the playerCards
     */
    public HashMap< Color , ArrayList<Card> > getPlayerCards() {
        return playerCards;
    }

    /**
     * @param playerCards the playerCards to set
     */
    public void setPlayerCards(HashMap< Color , ArrayList<Card> > playerCards) {
        this.playerCards = playerCards;
    }

    public void putPlayerCards(Color color, ArrayList<Card> cards) {
        getPlayerCards().put(color, cards);
    }

    public ArrayList<Card> getPlayerCardsBasedOnColor(Color color) {
        return getPlayerCards().get(color);
    }


    /**
     * @return CardDeck return the cardDeck
     */
    public CardDeck getCardDeck() {
        return cardDeck;
    }

    /**
     * @param cardDeck the cardDeck to set
     */
    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }


    /**
     * @return CardStack return the cardStack
     */
    public CardStack getCardStack() {
        return cardStack;
    }

    /**
     * @param cardStack the cardStack to set
     */
    public void setCardStack(CardStack cardStack) {
        this.cardStack = cardStack;
    }


    /**
     * @return CardFactory return the cardFactory
     */
    public CardFactory getCardFactory() {
        return cardFactory;
    }

    /**
     * @param cardFactory the cardFactory to set
     */
    public void setCardFactory(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
    }


    /**
     * @return Card return the clickedCard
     */
    public Card getClickedCard() {
        return clickedCard;
    }

    /**
     * @param clickedCard the clickedCard to set
     */
    public void setClickedCard(Card clickedCard) {
        this.clickedCard = clickedCard;
    }

    public void removeSpecificCard(Card card){

        getPlayerCards().get(card.getChessPieceColor()).remove(card);
    }

    public Card createRandomCard( Color chessPieceColor){

        // create the card
        Card card = cardFactory.createRandomCard(chessPieceColor);

        // add the card to the list
        getPlayerCards().get(chessPieceColor).add(card);

        return card;
    }


    /**
     * @return boolean return the isClickedCardConfirmed
     */
    public boolean isClickedCardConfirmed() {
        return isClickedCardConfirmed;
    }

    /**
     * @param isClickedCardConfirmed the isClickedCardConfirmed to set
     */
    public void setIsClickedCardConfirmed(boolean isClickedCardConfirmed) {
        this.isClickedCardConfirmed = isClickedCardConfirmed;
    }

}
