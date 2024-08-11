package chessuno.actions;

import chessuno.cards.Card;
import chessuno.chessPieces.ChessPiece;
import chessuno.tiles.Tile;

public class ActionInformation {

    private Tile firstClickedTile;

    private Tile secondClickedTile;

    private ChessPiece firstClickedChessPiece;

    private ChessPiece secondClickedChessPiece;

    private Card cardClicked;

    private Card currentCard;

    public ActionInformation(){}


    /**
     * @return Tile return the tileClicked
     */
    public Tile getfirstClickedTile() {
        return firstClickedTile;
    }

    /**
     * @param tileClicked the tileClicked to set
     */
    public void setfirstClickedTile(Tile tileClicked) {
        this.firstClickedTile = tileClicked;
    }

    /**
     * @return Tile return the currentTile
     */
    public Tile getSecondClickedTile() {
        return secondClickedTile;
    }

    /**
     * @param currentTile the currentTile to set
     */
    public void setSecondClickedTile(Tile currentTile) {
        this.secondClickedTile = currentTile;
    }

    /**
     * @return ChessPiece return the chessPieceClicked
     */
    public ChessPiece getFirstClickedChessPiece() {
        return firstClickedChessPiece;
    }

    /**
     * @param chessPieceClicked the chessPieceClicked to set
     */
    public void setFirstClickedChessPiece(ChessPiece chessPieceClicked) {
        this.firstClickedChessPiece = chessPieceClicked;
    }

    /**
     * @return ChessPiece return the currentChessPiece
     */
    public ChessPiece getSecondClickedChessPiece() {
        return secondClickedChessPiece;
    }

    /**
     * @param currentChessPiece the currentChessPiece to set
     */
    public void setSecondClickedChessPiece(ChessPiece currentChessPiece) {
        this.secondClickedChessPiece = currentChessPiece;
    }

    /**
     * @return Card return the cardClicked
     */
    public Card getcardClicked() {
        return cardClicked;
    }

    /**
     * @param cardClicked the cardClicked to set
     */
    public void setcardClicked(Card cardClicked) {
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
