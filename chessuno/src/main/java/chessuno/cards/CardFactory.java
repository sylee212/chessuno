package chessuno.cards;

import java.util.ArrayList;
import java.util.Random;

import chessuno.Color;
import chessuno.chessPieces.ChessPieceType;

/**
 * This class is used to create the cards.
 * it will not create a list of all the cards, because we want the cards to be created with an infinite amount and 
 * with reduced space complexity
 */
public class CardFactory {

    // the singleton instance
    private static CardFactory cardFactory;

    // set the unique ID of each card
    private int uniqueID;

    // the card dimensions
    public final double CARD_WIDTH = 50;
    public final double CARD_HEIGHT = 100;

    // the center point of the StackPane 
    public final double CARD_X_CENTER = CARD_WIDTH / 2;
    public final double CARD_Y_CENTER = CARD_HEIGHT / 2;

    public final double CARD_BASE_WIDTH = CARD_WIDTH;
    public final double CARD_BASE_HEIGHT = CARD_HEIGHT;

    // the card content dimensions
    public final double CHESS_PIECE_IMAGEVIEW_WIDTH = 50;
    public final double CHESS_PIECE_IMAGEVIEW_HEIGHT = 50;

    public final double NUMBER_IMAGEVIEW_WIDTH = 100;
    public final double NUMBER_IMAGEVIEW_HEIGHT = 100;

    // the imageViews coordinates
    // 0 , 0 means the center of the card piece
    public final double CHESS_PIECE_IMAGEVIEW_X = 0;
    public final double CHESS_PIECE_IMAGEVIEW_Y = 0;

    // 0 - the center of the card to get the left edge of the card
    // + 10 to put it a bit to the right
    public final double NUMBER_IMAGEVIEW_X =  0 - CARD_X_CENTER + 10;
    public final double NUMBER_IMAGEVIEW_Y = 0 - CARD_Y_CENTER + 20;

    // all the possible numbers for the cards
    private ArrayList<Integer> possibleNumbers;

    private ArrayList<ChessPieceType> possibleChessPiecesTypes;

    private ArrayList<Color> possibleColors;


    private CardFactory() {

        // initialize the unique ID to 0
        setUniqueID(0);

        // set the possible numbers
        setCardNumbers();

        // set the possible chess pieces
        setCardChessPieces();

        // set the possible colors
        setCardColors();
    }



    public static CardFactory getInstance() {
        if ( CardFactory.cardFactory == null ) {
            CardFactory.cardFactory = new CardFactory();
        }
        return CardFactory.cardFactory;
    }

    public Card createRandomCard(Color chessPieceColor) {
        
        // initialize the random variable
        Random random = new Random();

        // select a random number for the card number
        int randomCardNumber = random.nextInt(possibleNumbers.size());
        // get the selected card number
        int selectedCardNumber = possibleNumbers.get(randomCardNumber);

        // select a random number for the chess piece
        int randomChessPiece = random.nextInt(possibleChessPiecesTypes.size());
        // get the selected chess piece
        ChessPieceType selectedChessPiece = possibleChessPiecesTypes.get(randomChessPiece);

        // select a random number for the card color
        int randomCardColor = random.nextInt(possibleColors.size());
        // get the selected card color
        Color selectedCardColor = possibleColors.get(randomCardColor);

        // get the unique ID
        int uniqueID = getUniqueID();

        Card card = new Card(uniqueID, selectedCardColor, chessPieceColor, selectedChessPiece, selectedCardNumber);

        // increment the unique ID
        setUniqueID(uniqueID + 1);

        return card;
        

    }

    public Card createSpecificCard(Color color, Color chessPieceColor, ChessPieceType chessPieceType, int number) {

        // get the unique ID
        int uniqueID = getUniqueID();

        Card card = new Card(uniqueID,color, chessPieceColor,  chessPieceType, number);

        // increment the unique ID
        setUniqueID(uniqueID + 1);

        return card;
    }

    private void setCardNumbers(){
        // set the possible numbers
        possibleNumbers = new ArrayList<>();
        possibleNumbers.add(0);
        possibleNumbers.add(1);
        possibleNumbers.add(2); 
        possibleNumbers.add(3);
        possibleNumbers.add(4);
        possibleNumbers.add(5);
        possibleNumbers.add(6);
        possibleNumbers.add(7);
        possibleNumbers.add(8);
        possibleNumbers.add(9);
    }

    private void setCardChessPieces(){

        // set the possible chess pieces
        possibleChessPiecesTypes = new ArrayList<>();
        possibleChessPiecesTypes.add(ChessPieceType.PAWN);
        possibleChessPiecesTypes.add(ChessPieceType.ROOK);
        possibleChessPiecesTypes.add(ChessPieceType.KNIGHT);
        possibleChessPiecesTypes.add(ChessPieceType.BISHOP);
        possibleChessPiecesTypes.add(ChessPieceType.QUEEN);

        // remove king because we dont want a king card
        // possibleChessPiecesTypes.add(ChessPieceType.KING);

    }

    private void setCardColors(){

        // set the possible colors
        possibleColors = new ArrayList<>();
        possibleColors.add(Color.BLUE);
        possibleColors.add(Color.RED);
        possibleColors.add(Color.GREEN);
        possibleColors.add(Color.YELLOW);
    }


    /**
     * @return int return the uniqueID
     */
    public int getUniqueID() {
        return uniqueID;
    }

    /**
     * @param uniqueID the uniqueID to set
     */
    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    /**
     * @return ArrayList<Integer> return the possibleNumbers
     */
    public ArrayList<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    /**
     * @param possibleNumbers the possibleNumbers to set
     */
    public void setPossibleNumbers(ArrayList<Integer> possibleNumbers) {
        this.possibleNumbers = possibleNumbers;
    }

    /**
     * @return ArrayList<ChessPieceType> return the possibleChessPiecesTypes
     */
    public ArrayList<ChessPieceType> getPossibleChessPiecesTypes() {
        return possibleChessPiecesTypes;
    }

    /**
     * @param possibleChessPiecesTypes the possibleChessPiecesTypes to set
     */
    public void setPossibleChessPiecesTypes(ArrayList<ChessPieceType> possibleChessPiecesTypes) {
        this.possibleChessPiecesTypes = possibleChessPiecesTypes;
    }

    /**
     * @return ArrayList<Color> return the possibleColors
     */
    public ArrayList<Color> getPossibleColors() {
        return possibleColors;
    }

    /**
     * @param possibleColors the possibleColors to set
     */
    public void setPossibleColors(ArrayList<Color> possibleColors) {
        this.possibleColors = possibleColors;
    }

}
