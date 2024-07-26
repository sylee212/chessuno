package chessuno.cards;

public class CardManager {

    private static CardManager cardManager;

    public static final int MAX_NUMBER_OF_CARDS_PER_PLAYER = 8;

    private CardManager() {
    }   

    public static CardManager getInstance() {
        if (CardManager.cardManager == null) {
            CardManager.cardManager = new CardManager();
        }
        return CardManager.cardManager;
    }

    

}
