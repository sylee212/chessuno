package chessuno.actions;

import chessuno.ChessLocation;
import chessuno.chessPieces.ChessPiece;
import chessuno.tiles.Tile;

public abstract class MoveAction extends ActionAbstract {

    private ChessPiece firstClickedChessPiece;

    private ChessPiece secondClickedChessPiece;

    private ChessLocation firstClickedChessPieceLocation;

    private ChessLocation secondClickedChessPieceLocation;

    private Tile firstClickedTile;

    private Tile secondClickedTile;

    private boolean isClickedChessPiece;

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
        ChessPiece secondClickedChessPiece = actionInformation.getSecondClickedChessPiece();

        // get the clicked tile
        Tile firstClickedTile = actionInformation.getfirstClickedTile();

        // set the variable to be true and only 
        setIsClickedChessPiece(false);

        setIsClickedTile(false);

        if ( secondClickedChessPiece != null ) {
            setIsClickedChessPiece(true);
            setSecondClickedChessPiece(secondClickedChessPiece);
            setSecondClickedChessPieceLocation(secondClickedChessPiece.getChessLocation());
        }

        if ( firstClickedTile != null ) {
            setIsClickedTile(true);
            setFirstClickedTile(firstClickedTile);
        }

        System.out.println("\n////////////////MoveAction | fillInformation | " + "isClickedChessPiece = " + isClickedChessPiece + " | " + "isClickedTile = " + isClickedTile);



        // set the first clicked chess piece and location
        setFirstClickedChessPiece(actionInformation.getFirstClickedChessPiece());
        setFirstClickedChessPieceLocation(getFirstClickedChessPiece().getChessLocation());
    }



    


    /**
     * @return ChessPiece return the currentChessPiece
     */
    public ChessPiece getFirstClickedChessPiece() {
        return firstClickedChessPiece;
    }

    /**
     * @param currentChessPiece the currentChessPiece to set
     */
    public void setFirstClickedChessPiece(ChessPiece currentChessPiece) {
        this.firstClickedChessPiece = currentChessPiece;
    }

    /**
     * @return ChessPiece return the clickedChessPiece
     */
    public ChessPiece getSecondClickedChessPiece() {
        return secondClickedChessPiece;
    }

    /**
     * @param clickedChessPiece the clickedChessPiece to set
     */
    public void setSecondClickedChessPiece(ChessPiece clickedChessPiece) {
        this.secondClickedChessPiece = clickedChessPiece;
    }

    /**
     * @return ChessLocation return the currentLocation
     */
    public ChessLocation getFirstClickedChessPieceLocation() {
        return firstClickedChessPieceLocation;
    }

    /**
     * @param currentLocation the currentLocation to set
     */
    public void setFirstClickedChessPieceLocation(ChessLocation currentLocation) {
        this.firstClickedChessPieceLocation = currentLocation;
    }

    /**
     * @return ChessLocation return the clickedLocation
     */
    public ChessLocation getSecondClickedChessPieceLocation() {
        return secondClickedChessPieceLocation;
    }

    /**
     * @param clickedLocation the clickedLocation to set
     */
    public void setSecondClickedChessPieceLocation(ChessLocation clickedLocation) {
        this.secondClickedChessPieceLocation = clickedLocation;
    }



    /**
     * @return Tile return the currentTile
     */
    public Tile getFirstClickedTile() {
        return firstClickedTile;
    }

    /**
     * @param currentTile the currentTile to set
     */
    public void setFirstClickedTile(Tile currentTile) {
        this.firstClickedTile = currentTile;
    }

    /**
     * @return Tile return the clickedTile
     */
    public Tile getSecondClickedTile() {
        return secondClickedTile;
    }

    /**
     * @param clickedTile the clickedTile to set
     */
    public void setSecondClickedTile(Tile clickedTile) {
        this.secondClickedTile = clickedTile;
    }


    /**
     * @return boolean return the isCurrentChessPiece
     */
    public boolean isClickedChessPiece() {
        return isClickedChessPiece;
    }

    /**
     * @param isCurrentChessPiece the isCurrentChessPiece to set
     */
    public void setIsClickedChessPiece(boolean isCurrentChessPiece) {
        this.isClickedChessPiece = isCurrentChessPiece;
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
