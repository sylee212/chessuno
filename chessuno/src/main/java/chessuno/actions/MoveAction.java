package chessuno.actions;

import chessuno.ChessLocation;
import chessuno.chessPieces.ChessPiece;
import chessuno.tiles.Tile;

public abstract class MoveAction extends ActionAbstract {

    private ChessPiece currentChessPiece;

    private ChessPiece clickedChessPiece;

    private ChessLocation currentLocation;

    private ChessLocation clickedLocation;

    private Tile currentTile;

    private Tile clickedTile;

    private boolean isChessPieceClicked;

    private boolean isClickedTile;

    public MoveAction() {
        super();
    }

    @Override
    public abstract boolean execute();

    @Override
    public abstract boolean verify();

    @Override
    public void fillInformation(ActionInformation actionInformation) {
        // this part is because sometimes the newly clicked content can be a chessPiece or Tile

        // check the newly clicked chess piece 
        ChessPiece clickedChessPiece = actionInformation.getchessPieceClicked();

        // get the clicked tile
        Tile clickedTile = actionInformation.gettileClicked();

        // set the variable to be true and only 
        setIsChessPieceClicked(false);

        setIsClickedTile(false);

        if ( clickedChessPiece != null ) {
            setIsChessPieceClicked(true);
            setClickedChessPiece(clickedChessPiece);
            setClickedLocation(clickedChessPiece.getChessLocation());
        }

        if ( clickedTile != null ) {
            setIsClickedTile(true);
            setClickedTile(clickedTile);
            setClickedLocation(clickedTile.getChessLocation());
        }



        // set the current Chess Piece 
        setCurrentChessPiece(actionInformation.getCurrentChessPiece());
        setCurrentLocation(getCurrentChessPiece().getChessLocation());
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
     * @return ChessPiece return the clickedChessPiece
     */
    public ChessPiece getClickedChessPiece() {
        return clickedChessPiece;
    }

    /**
     * @param clickedChessPiece the clickedChessPiece to set
     */
    public void setClickedChessPiece(ChessPiece clickedChessPiece) {
        this.clickedChessPiece = clickedChessPiece;
    }

    /**
     * @return ChessLocation return the currentLocation
     */
    public ChessLocation getCurrentLocation() {
        return currentLocation;
    }

    /**
     * @param currentLocation the currentLocation to set
     */
    public void setCurrentLocation(ChessLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * @return ChessLocation return the clickedLocation
     */
    public ChessLocation getClickedLocation() {
        return clickedLocation;
    }

    /**
     * @param clickedLocation the clickedLocation to set
     */
    public void setClickedLocation(ChessLocation clickedLocation) {
        this.clickedLocation = clickedLocation;
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
     * @return Tile return the clickedTile
     */
    public Tile getClickedTile() {
        return clickedTile;
    }

    /**
     * @param clickedTile the clickedTile to set
     */
    public void setClickedTile(Tile clickedTile) {
        this.clickedTile = clickedTile;
    }


    /**
     * @return boolean return the isChessPieceClicked
     */
    public boolean isChessPieceClicked() {
        return isChessPieceClicked;
    }

    /**
     * @param isChessPieceClicked the isChessPieceClicked to set
     */
    public void setIsChessPieceClicked(boolean isChessPieceClicked) {
        this.isChessPieceClicked = isChessPieceClicked;
    }

    /**
     * @return boolean return the isClickedTile
     */
    public boolean isClickedTile() {
        return isClickedTile;
    }

    /**
     * @param isClickedTile the isClickedTile to set
     */
    public void setIsClickedTile(boolean isClickedTile) {
        this.isClickedTile = isClickedTile;
    }

}
