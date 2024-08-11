package chessuno.actions;

import chessuno.Color;
import chessuno.chessPieces.ChessPieceManager;
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

        System.out.println("first clicked "+ getFirstClickedChessPiece());
        System.out.println("second clicked "+ getSecondClickedChessPiece());
        System.out.println("isClickedTile "+ isClickedTile());

        if ( verifyRes == true ) {

            // if the second click is a chess piece, remove the image view
            if ( isClickedChessPiece()== true ) {
                //System.out.println("\nMoveForward killed a piece, before black list size " + ChessPieceManager.getInstance().getBlackChessPieceList().size());
                //System.out.println("\nMoveForward killed a piece, before white list size " + ChessPieceManager.getInstance().getWhiteChessPieceList().size());

                // remove all the data about the second clicked chess piece
                // remove the second piece clicked chess piece
                ChessPieceManager.getInstance().deleteSpecificChessPiece( getSecondClickedChessPiece().getColor(), getSecondClickedChessPiece() );

                // remove the UI
                chessGridPane.getChildren().remove( getSecondClickedChessPiece().getImageView() );


                //System.out.println("\nMoveForward killed a piece, after black list size " + ChessPieceManager.getInstance().getBlackChessPieceList().size());
                //System.out.println("\nMoveForward killed a piece, after white list size " + ChessPieceManager.getInstance().getWhiteChessPieceList().size());



                // remove the first piece clicked chess piece
                chessGridPane.getChildren().remove( getFirstClickedChessPiece().getImageView() );

                // update the current chess piece location
                getFirstClickedChessPiece().setChessLocation( getSecondClickedChessPieceLocation() );

                // update the clicked chess piece UI 
                chessGridPane.add( getFirstClickedChessPiece().getImageView(), getFirstClickedChessPiece().getChessLocation().getChessColumnCoordinate(),  getFirstClickedChessPiece().getChessLocation().getChessRowCoordinate() );
            } 
            else if ( isClickedTile() == true ){

                ///////////////////// issues is here when clicking on tile after klilling a pawn
                // remove the first piece clicked chess piece
                chessGridPane.getChildren().remove( getFirstClickedChessPiece().getImageView() );

                // update the current chess piece location
                getFirstClickedChessPiece().setChessLocation( getFirstClickedTile().getChessLocation() );

                // update the clicked chess piece UI 
                chessGridPane.add( getFirstClickedChessPiece().getImageView(), getFirstClickedChessPiece().getChessLocation().getChessColumnCoordinate(),  getFirstClickedChessPiece().getChessLocation().getChessRowCoordinate() );

                System.out.println("MOVEFORWARD | execute | tile clicked and execute " );
            }



        }

        return verifyRes;
    }

    @Override
    public boolean verify() {
        boolean res = true;

        // get the location of the clicked chess piece
        int firstClickedChessPieceCol = getFirstClickedChessPieceLocation().getChessColumnCoordinate();
        int firstClickedChessPieceRow = getFirstClickedChessPieceLocation().getChessRowCoordinate();

        // check if its a clicked tile that we clicked on, check if the coordinate is valid or not
        int validRowFactor = 1;

        if ( isUpForward() == true ) {
            validRowFactor = -1;
        }

        // check if the tile is clicked or not
        // check if the x is the same, cause the x must be the same to move forward
        // if not same, then it is not possible to move forward
        if ( isClickedTile() == true ) {

            // get the location of the current tile 
            int firstClickedTileCol = getFirstClickedTile().getChessLocation().getChessColumnCoordinate();
            int firstClickedTileRow = getFirstClickedTile().getChessLocation().getChessRowCoordinate();

            // if we clicked a tile, and the tile is on a different column, invalid move
            if ( firstClickedChessPieceCol != firstClickedTileCol ) {
                res = false;
            }
        }


        // check if its a chesspiece that we clicked on 
        if ( isClickedChessPiece() == true ) {

            // get the location of the current tile or chess piece
            int secondClickedChessPieceCol = getSecondClickedChessPieceLocation().getChessColumnCoordinate();
            int secondClickedChessPieceRow = getSecondClickedChessPieceLocation().getChessRowCoordinate();

            // check if the clicked chess piece is same color or not
            // only valid if different color
            if ( getSecondClickedChessPiece().getColor() == getFirstClickedChessPiece().getColor() ) {
                res = false;
            }

            boolean rowCondition = ( secondClickedChessPieceRow + validRowFactor ) != firstClickedChessPieceRow;

            boolean colCondition = ( ( secondClickedChessPieceCol + 1 ) != firstClickedChessPieceCol ) || ( ( secondClickedChessPieceCol - 1 ) != firstClickedChessPieceCol );

            
            // System.out.println("\n");
            // System.out.println("MOVEFORWARD | rowCondition = " + rowCondition + " | colCondition = " + colCondition);
            // System.out.println("current");
            // System.out.println("row " +  ( secondClickedChessPieceRow + validRowFactor ) );
            // System.out.println("col right " + (( secondClickedChessPieceCol + 1 )));
            // System.out.println("col left " + (( secondClickedChessPieceCol - 1 ) ));
            // System.out.println("clicked");
            // System.out.println("row " + firstClickedChessPieceRow);
            // System.out.println("col " + firstClickedChessPieceCol);


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

        // checks if the first clicked chess piece is black or white
        // if its black, means we are going down
        // so dwon is forward
        if (getFirstClickedChessPiece().getColor() == Color.BLACK) {
            res = false;
        }
        return res;
    }

}
