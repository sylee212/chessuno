package chessuno.chessPieces;

import java.util.ArrayList;

import chessuno.Color;

public class ChessPieceManager {

    private static ChessPieceManager chessPieceManager = null;

    private ArrayList<ChessPiece> blackChessPieceList;

    private ArrayList<ChessPiece> whiteChessPiecesList;

    private ChessPieceFactory chessPieceFactory;

    private ChessPieceManager(){

        chessPieceFactory = ChessPieceFactory.getInstance();
        

        setBlackChessPieceList( chessPieceFactory.instantiateChessPieces( Color.BLACK ) );
        setWhiteChessPieceList( chessPieceFactory.instantiateChessPieces( Color.WHITE ) );
    }


    public static ChessPieceManager getInstance(){

        if ( ChessPieceManager.chessPieceManager == null ) {
            ChessPieceManager.chessPieceManager = new ChessPieceManager();
        }
        return ChessPieceManager.chessPieceManager;
    }
    
    public ArrayList<ChessPiece> getBlackChessPieceList() {
        return this.blackChessPieceList;
    }


    public void setBlackChessPieceList(ArrayList<ChessPiece> chessPieceList) {
        this.blackChessPieceList = chessPieceList;
    }

    public ArrayList<ChessPiece> getWhiteChessPieceList() {
        return this.whiteChessPiecesList;
    }


    public void setWhiteChessPieceList(ArrayList<ChessPiece> chessPieceList) {
        this.whiteChessPiecesList = chessPieceList;
    }



}
