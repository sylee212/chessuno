package chessuno.uiContainer;

import java.util.ArrayList;

import chessuno.chessPieces.ChessPiece;
import chessuno.chessPieces.ChessPieceManager;
import chessuno.tiles.Tile;
import chessuno.tiles.TileManager;
import javafx.scene.layout.GridPane;

public class ChessBoardContainer {

    private static ChessBoardContainer chessBoard;

    // the chess board grid pane where all the pieces will be in 
    private GridPane chessBoardGridPane;

    // stores the gridpane width and height
    private double chessBoardGridPaneWidth;
    private double chessBoardGridPaneHeight;

    private ChessBoardContainer(){

        // create the GridPane
        GridPane chessBoardGridPaneTemp = new GridPane();

        // assign the GridPane to the instance variable
        setChessBoardGridPane(chessBoardGridPaneTemp);

        // add in the tiles
        setChessBoardTiles();

        // add in the chess pieces
        setChessBoardPieces();

    }

    public static ChessBoardContainer getInstance(){

        if(ChessBoardContainer.chessBoard == null){
            ChessBoardContainer.chessBoard = new ChessBoardContainer();
        }
        return ChessBoardContainer.chessBoard;
    }

    private void setChessBoardTiles(){

        // get the list of tiles
        ArrayList<ArrayList<Tile>> tileList = TileManager.getInstance().getTileListGridForm();
        
        // get the number of tiles
        int numberOfTilesPerRow = tileList.size();

        // for row
        for ( int tileRow = 0; tileRow < numberOfTilesPerRow; tileRow++ ){

            int numberOfTilesPerColumn = tileList.get(tileRow).size();

            ArrayList<Tile> currentTileList = tileList.get(tileRow);

            for ( int tileColumn = 0 ; tileColumn < numberOfTilesPerColumn ; tileColumn++ ){

                // get the tile
                Tile tile = currentTileList.get(tileColumn);
                // get the column
                int col = tile.getChessLocation().getChessColumnCoordinate();
                // get the row
                int row = tile.getChessLocation().getChessRowCoordinate();
                
                chessBoardGridPane.add(tile.getImageView(), col, row);
            }
        }


    }


    public void setChessBoardPieces(){

        // instantiate the chess pieces 
        // get the list of chess pieces
        ArrayList<ChessPiece> blackChessPieceList = ChessPieceManager.getInstance().getBlackChessPieceList();

        ArrayList<ChessPiece> whiteChessPieceList = ChessPieceManager.getInstance().getWhiteChessPieceList();

        int listMinSize = Math.min(blackChessPieceList.size(), whiteChessPieceList.size());


        /////////// PENDING ////////////////////// need to add the pieces connection to the tiles
        for ( int i = 0 ; i < listMinSize ; i++ ){
        
            // get the black chess piece
            ChessPiece blackChessPiece = blackChessPieceList.get(i);    
            
            // get black chess piece location
            int blackCol = blackChessPiece.getChessLocation().getChessColumnCoordinate();
            int blackRow = blackChessPiece.getChessLocation().getChessRowCoordinate();

            // add the black chess piece to the gridpane
            chessBoardGridPane.add(blackChessPiece.getImageView(), blackCol, blackRow);

            // get the white chess piece
            ChessPiece whiteChessPiece = whiteChessPieceList.get(i);
            
            // get white chess piece location
            int whiteCol = whiteChessPiece.getChessLocation().getChessColumnCoordinate();
            int whiteRow = whiteChessPiece.getChessLocation().getChessRowCoordinate();

            // get the white chess piece
            chessBoardGridPane.add(whiteChessPiece.getImageView(), whiteCol, whiteRow);
        }


    }

    public void setChessBoardGridPane(GridPane chessBoardGridPane) {
        this.chessBoardGridPane = chessBoardGridPane;
    }

    public GridPane getChessBoardGridPane() {
        return chessBoardGridPane;
    }

    /**
     * @return double return the chessBoardGridPaneWidth
     */
    public double getChessBoardGridPaneWidth() {
        return chessBoardGridPaneWidth;
    }

    /**
     * @param chessBoardGridPaneWidth the chessBoardGridPaneWidth to set
     */
    public void setChessBoardGridPaneWidth(double chessBoardGridPaneWidth) {
        this.chessBoardGridPaneWidth = chessBoardGridPaneWidth;
    }

    /**
     * @return double return the chessBoardGridPaneHeight
     */
    public double getChessBoardGridPaneHeight() {
        return chessBoardGridPaneHeight;
    }

    /**
     * @param chessBoardGridPaneHeight the chessBoardGridPaneHeight to set
     */
    public void setChessBoardGridPaneHeight(double chessBoardGridPaneHeight) {
        this.chessBoardGridPaneHeight = chessBoardGridPaneHeight;
    }



}
