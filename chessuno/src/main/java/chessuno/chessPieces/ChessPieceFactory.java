package chessuno.chessPieces;

import java.util.ArrayList;

import chessuno.Color;

public class ChessPieceFactory {

    private static ChessPieceFactory chessPieceFactory = null;

    private int uniqueID;

    public ChessPieceFactory() {
        // initialize the unique ID for each of chess piece
        setUniqueID(0);
    }

    public static ChessPieceFactory getInstance() {

        // instantiate a new chess piece factory
        if (ChessPieceFactory.chessPieceFactory == null) {
            ChessPieceFactory.chessPieceFactory = new ChessPieceFactory();
        }
        return chessPieceFactory;
    }

    public ArrayList<ChessPiece> instantiateChessPieces(Color color){

        ArrayList<ChessPiece> chessPieceList = new ArrayList<>();

        // instantiate the chess pieces
        // pawn
        for ( int i = 0 ; i < 8 ; i++ ){
           // instantiate the Pawn
            Pawn pawn = new Pawn( getUniqueID(), color);  

            // add the pawn to the list
            chessPieceList.add(pawn);

            // increment the unique ID
            setUniqueID( getUniqueID() + 1 );
        }

        // instantiate the rook
        for ( int i = 0 ; i < 2 ; i++ ){

            // instantiate the Rook
            Rook rook = new Rook( getUniqueID(), color);

            // add the rook to the list
            chessPieceList.add(rook);

            // increment the unique ID
            setUniqueID( getUniqueID() + 1 );
        }

        // instantiate the knight
        for ( int i = 0 ; i < 2 ; i++ ){

            // instantiate the Knight
            Knight knight = new Knight(getUniqueID(), color);

            // add the knight to the list
            chessPieceList.add(knight);

            // increment the unique ID
            setUniqueID( getUniqueID() + 1 );
        }

        // instantiate the bishop
        for ( int i = 0 ; i < 2 ; i++ ){

            // instantiate the Bishop
            Bishop bishop = new Bishop(getUniqueID(), color);

            // add the bishop to the list
            chessPieceList.add(bishop);

            // increment the unique ID
            setUniqueID( getUniqueID() + 1 );
        }

        // instantiate the queen
        for ( int i = 0 ; i < 1 ; i++ ){

            // instantiate the Queen
            Queen queen = new Queen(getUniqueID(), color);

            // add the queen to the list
            chessPieceList.add(queen);

            // increment the unique ID
            setUniqueID( getUniqueID() + 1 );
        }

        // instantiate the king
        for ( int i = 0 ; i < 1 ; i++ ){

            // instantiate the King
            King king = new King(getUniqueID(), color);

            // add the king to the list
            chessPieceList.add(king);

            // increment the unique ID
            setUniqueID( getUniqueID() + 1 );
        }

        



        return chessPieceList;
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

}
