package chessuno.chessPieces;

import java.util.ArrayList;

import chessuno.ChessLocation;
import chessuno.Color;

public class ChessPieceManager {

    private static ChessPieceManager chessPieceManager = null;

    private ArrayList<ChessPiece> blackChessPieceList;

    private ArrayList<ChessPiece> whiteChessPiecesList;

    private ChessPieceFactory chessPieceFactory;

    private ChessPiece clickedChessPiece;

    private ChessPieceManager(){

        chessPieceFactory = ChessPieceFactory.getInstance();
        

        // create the list
        setBlackChessPieceList( chessPieceFactory.instantiateChessPieces( Color.BLACK ) );
        setWhiteChessPieceList( chessPieceFactory.instantiateChessPieces( Color.WHITE ) );

        // set the locations
        setChessPieceLocations( getBlackChessPieceList(), true );
        setChessPieceLocations( getWhiteChessPieceList(), false );
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

    public void setChessPieceLocations(ArrayList<ChessPiece> chessPieceList, boolean isStartFromTop) {

        
        int currentY = ( isStartFromTop ? 1 : 6 );


        // instantiate all the locations
        // pawn locations
        ArrayList<ChessLocation> pawnChessLocation = new ArrayList<>();

        for ( int x = 0 ; x < 8 ; x++ ) {

            pawnChessLocation.add(new ChessLocation(x, currentY));
        }

        // so if we started from the top we need to move up, else go down
        if ( isStartFromTop ) {
            currentY -= 1;
        } else {
            currentY += 1;
        }

        // rook locations
        ArrayList<ChessLocation> rookChessLocation = new ArrayList<>();
        rookChessLocation.add(new ChessLocation(0, currentY));
        rookChessLocation.add(new ChessLocation(7, currentY));

        // knight locations
        ArrayList<ChessLocation> knightChessLocation = new ArrayList<>();
        knightChessLocation.add(new ChessLocation(1, currentY));
        knightChessLocation.add(new ChessLocation(6, currentY));

        // bishop locations
        ArrayList<ChessLocation> bishopChessLocation = new ArrayList<>();
        bishopChessLocation.add(new ChessLocation(2, currentY));
        bishopChessLocation.add(new ChessLocation(5, currentY));

        // queen location
        ArrayList<ChessLocation> queenChessLocation = new ArrayList<>();
        queenChessLocation.add(new ChessLocation(3, currentY));

        // king location
        ArrayList<ChessLocation> kingChessLocation = new ArrayList<>();
        kingChessLocation.add(new ChessLocation(4, currentY));

        // loop through the chess pieces
        for ( int i = 0 ; i < chessPieceList.size() ; i++ ) {
            
            // get the current chess Piece
            ChessPiece chessPiece = chessPieceList.get(i);

            if ( null != chessPiece.getChessPieceType() ) // when intantiating theorethically, the first 8 is pawns
            switch (chessPiece.getChessPieceType()) {
                case PAWN:
                    chessPiece.setChessLocation(pawnChessLocation.get(0));
                    pawnChessLocation.remove(0);
                    break;
                case ROOK:
                    chessPiece.setChessLocation(rookChessLocation.get(0));
                    rookChessLocation.remove(0);
                    break;
                case KNIGHT:
                    chessPiece.setChessLocation(knightChessLocation.get(0));
                    knightChessLocation.remove(0);
                    break;
                case BISHOP:
                    chessPiece.setChessLocation(bishopChessLocation.get(0));
                    bishopChessLocation.remove(0);
                    break;
                case QUEEN:
                    chessPiece.setChessLocation(queenChessLocation.get(0));
                    queenChessLocation.remove(0);
                    break;
                case KING:
                    chessPiece.setChessLocation(kingChessLocation.get(0));
                    kingChessLocation.remove(0);
                    break;
                default:
                    break;
            }
            
        }
    }




    /**
     * @return ArrayList<ChessPiece> return the whiteChessPiecesList
     */
    public ArrayList<ChessPiece> getWhiteChessPiecesList() {
        return whiteChessPiecesList;
    }

    /**
     * @param whiteChessPiecesList the whiteChessPiecesList to set
     */
    public void setWhiteChessPiecesList(ArrayList<ChessPiece> whiteChessPiecesList) {
        this.whiteChessPiecesList = whiteChessPiecesList;
    }

    /**
     * @return ChessPieceFactory return the chessPieceFactory
     */
    public ChessPieceFactory getChessPieceFactory() {
        return chessPieceFactory;
    }

    /**
     * @param chessPieceFactory the chessPieceFactory to set
     */
    public void setChessPieceFactory(ChessPieceFactory chessPieceFactory) {
        this.chessPieceFactory = chessPieceFactory;
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

}
