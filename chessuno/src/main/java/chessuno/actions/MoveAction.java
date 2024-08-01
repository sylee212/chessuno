package chessuno.actions;

import chessuno.ChessLocation;
import chessuno.chessPieces.ChessPiece;

public abstract class MoveAction extends ActionAbstract {

    private ChessPiece currentChessPiece;

    private ChessPiece clickedChessPiece;

    private ChessLocation currentLocation;

    private ChessLocation clickedLocation;

    public MoveAction() {
        super();
    }

    @Override
    public boolean execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public abstract boolean verify();

    @Override
    public void fillInformation(ActionInformation actionInformation) {
        setClickedChessPiece(actionInformation.getchessPieceClicked());
        setCurrentChessPiece(actionInformation.getCurrentChessPiece());
        setClickedLocation(getClickedChessPiece().getChessLocation());
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

}
