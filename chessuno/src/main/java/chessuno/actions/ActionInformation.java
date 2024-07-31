package chessuno.actions;

import chessuno.cards.Card;
import chessuno.chessPieces.ChessPiece;
import chessuno.tiles.Tile;

public class ActionInformation {

    private Tile tileClicked;

    private Tile currentTile;

    private ChessPiece chessPieceClicked;

    private ChessPiece currentChessPiece;

    private Card cardClicked;

    private Card currentCard;

    public ActionInformation(){}


    /**
     * @return Tile return the tileClicked
     */
    public Tile gettileClicked() {
        return tileClicked;
    }

    /**
     * @param tileClicked the tileClicked to set
     */
    public void settileClicked(Tile tileClicked) {
        this.tileClicked = tileClicked;
    }

    /**
     * @return Tile return the currentTile
     */
    public Tile getCurrentTile() {
        return currentTile;
    }

    /**
     * @param currentTile the currentTile to set
     */
    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    /**
     * @return ChessPiece return the chessPieceClicked
     */
    public ChessPiece getchessPieceClicked() {
        return chessPieceClicked;
    }

    /**
     * @param chessPieceClicked the chessPieceClicked to set
     */
    public void setchessPieceClicked(ChessPiece chessPieceClicked) {
        this.chessPieceClicked = chessPieceClicked;
    }

    /**
     * @return ChessPiece return the currentChessPiece
     */
    public ChessPiece getCurrentChessPiece() {
        return currentChessPiece;
    }

    /**
     * @param currentChessPiece the currentChessPiece to set
     */
    public void setCurrentChessPiece(ChessPiece currentChessPiece) {
        this.currentChessPiece = currentChessPiece;
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
