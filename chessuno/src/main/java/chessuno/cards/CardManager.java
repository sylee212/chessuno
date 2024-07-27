package chessuno.cards;

import java.util.ArrayList;
import java.util.HashMap;

import chessuno.Color;

public class CardManager {

    private static CardManager cardManager;

    public static final int MAX_NUMBER_OF_CARDS_PER_PLAYER = 8;

    private HashMap< Color , ArrayList<Card> > playerCards;

    private CardDeck cardDeck;

    

    private CardManager() {

        // initialize the hashmap
        playerCards = new HashMap<>();

        // initialize the card deck
        setCardDeck(new CardDeck());
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

        // get the card factory 
        CardFactory cardFactory = CardFactory.getInstance();

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

}
