package chessuno.actions;

import chessuno.Color;
import chessuno.uiContainer.ChessBoardContainer;
import javafx.scene.layout.GridPane;

public class MoveForward extends MoveAction {

    @Override
    public boolean execute() {

        boolean verifyRes = verify();

        System.out.println("MOVEFORWARD | verifyRes = " + verifyRes);

        if( verifyRes == false ) {
            return verifyRes;
        }

        GridPane chessGridPane = ChessBoardContainer.getInstance().getChessBoardGridPane();

        if ( verifyRes == true ) {
            // if a chess piece is clicked remove that chess piece
            if ( isChessPieceClicked() == true ) {

                chessGridPane.getChildren().remove( getClickedChessPiece().getImageView() );
            }

            // remove the current chess piece at the current lcoation
            chessGridPane.getChildren().remove( getCurrentChessPiece().getImageView() );

            // update the current chess piece location
            getCurrentChessPiece().setChessLocation( getClickedLocation());

            // update the clicked chess piece UI 
            chessGridPane.add( getCurrentChessPiece().getImageView(), getClickedLocation().getChessColumnCoordinate(), getClickedLocation().getChessRowCoordinate() );
        }

        return verifyRes;
    }

    @Override
    public boolean verify() {
        boolean res = true;

        // get the location of the clicked tile or chess piece
        int clickedCol = getClickedLocation().getChessColumnCoordinate();
        int clickedRow = getClickedLocation().getChessRowCoordinate();

        // get the location of the current tile or chess piece
        int currentCol = getCurrentLocation().getChessColumnCoordinate();
        int currentRow = getCurrentLocation().getChessRowCoordinate();

        // check if its a clicked tile that we clicked on, check if the coordinate is valid or not
        int validRowFactor = 1;

        if ( isUpForward() == true ) {
            validRowFactor = -1;
        }

        // check if the tile is clicked or not
        // check if the x is the same, cause the x must be the same to move forward
        // if not same, then it is not possible to move forward
        if ( isClickedTile() == true ) {

            if ( clickedCol != currentCol ) {
                res = false;
            }
        }


        // check if its a chesspiece that we clicked on 
        if ( isChessPieceClicked() == true ) {

            // check if the clicked chess piece is same color or not
            // only valid if different color
            if ( getClickedChessPiece().getColor() == getCurrentChessPiece().getColor() ) {
                res = false;
            }

            boolean rowCondition = ( currentRow + validRowFactor ) != clickedRow;

            boolean colCondition = ( ( currentCol + 1 ) != clickedCol ) && ( ( currentCol - 1 ) != clickedCol );

            // check if the row is valid
            // by using our row, and checking if the clicked row is the same after the addition of the factor
            if (rowCondition == false && colCondition == false) {
                res = false;
            }

        }



        return  res; 
    }


    public boolean isUpForward(){
        boolean res = true;

        // if the color is black, means we are going down, so going down is forward not going up 
        if (getCurrentChessPiece().getColor() == Color.BLACK) {
            res = false;
        }
        return res;
    }

}
