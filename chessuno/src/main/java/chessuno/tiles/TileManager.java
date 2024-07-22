package chessuno.tiles;

import java.util.ArrayList;

import chessuno.Color;

public class TileManager {

    private static TileManager tileManager;

    private ArrayList<Tile> tileList;

    private TileManager() {
        tileList = initializeTiles();
    }

    public static TileManager getInstance() {
        if (tileManager == null) {
            tileManager = new TileManager();
        }
        return tileManager;
    }

    public ArrayList<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(ArrayList<Tile> tileList) {
        this.tileList = tileList;
    }   

    public ArrayList<Tile> initializeTiles() {

        ArrayList<Tile> tileListTemp = new ArrayList<>();

        // wil be used to create the tiles and determine what color to add now
        Color tempColor;

        // for row
        for ( int row = 0; row < 8; row++ ){

            // for column
            for ( int col = 0; col < 8; col++ ){

                // change the color
                if ( row % 2 == 0 ){
                    if ( col % 2 == 0 ){
                        tempColor = Color.GREY;
                    }else{
                        tempColor = Color.BLUE;
                    }
                }else{
                    if ( col % 2 == 0 ){
                        tempColor = Color.BLUE;
                    }else{
                        tempColor = Color.GREY;
                    }
                }

                // create the tile
                Tile tile = new Tile(tempColor, col, row);

                tileListTemp.add(tile);
            }

        }


        return tileListTemp;
    }

}
