package chessuno.chessPieces;

import java.util.ArrayList;

import chessuno.Color;

public class ChessPieceFactory {

    private static ChessPieceFactory chessPieceFactory = null;

    public ChessPieceFactory() {

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
        for ( int i = 0 ; i < 0 ; i++ ){
           // instantiate the Pawn
            Pawn pawn = new Pawn(color);  

            // add the pawn to the list
            chessPieceList.add(pawn);
        }

        // instantiate the rook
        for ( int i = 0 ; i < 2 ; i++ ){

            // instantiate the Rook
            Rook rook = new Rook(color);

            // add the rook to the list
            chessPieceList.add(rook);
        }

        // instantiate the knight
        for ( int i = 0 ; i < 2 ; i++ ){

            // instantiate the Knight
            Knight knight = new Knight(color);

            // add the knight to the list
            chessPieceList.add(knight);
        }

        // instantiate the bishop
        for ( int i = 0 ; i < 2 ; i++ ){

            // instantiate the Bishop
            Bishop bishop = new Bishop(color);

            // add the bishop to the list
            chessPieceList.add(bishop);
        }

        // instantiate the queen
        for ( int i = 0 ; i < 1 ; i++ ){

            // instantiate the Queen
            Queen queen = new Queen(color);

            // add the queen to the list
            chessPieceList.add(queen);
        }

        // instantiate the king
        for ( int i = 0 ; i < 1 ; i++ ){

            // instantiate the King
            King king = new King(color);

            // add the king to the list
            chessPieceList.add(king);
        }

        



        return chessPieceList;
    }
}
