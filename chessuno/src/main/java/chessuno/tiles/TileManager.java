package chessuno.tiles;

import java.util.ArrayList;

import chessuno.Color;

public class TileManager {

    private static TileManager tileManager;

    // create a list of all the tiles in the format of a grid
    private ArrayList<ArrayList<Tile> > tileListGridForm;

    private TileManager() {
        
        tileListGridForm = initializeTiles();


    }

    public static TileManager getInstance() {
        if (tileManager == null) {
            tileManager = new TileManager();
        }
        return tileManager;
    }

    public ArrayList<ArrayList<Tile>> getTileListGridForm() {
        return tileListGridForm;
    }

    public void setTileListGridForm( ArrayList<ArrayList<Tile>> tileList) {
        this.tileListGridForm = tileList;
    }   

    public ArrayList<ArrayList<Tile>> initializeTiles() {

        tileListGridForm = new ArrayList<>();

        // wil be used to create the tiles and determine what color to add now
        Color tempColor;

        // for row
        for ( int row = 0; row < 8; row++ ){

            // at every row, initialise a new ArrayList to store the data
            ArrayList<Tile> tempTileList = new ArrayList<>();

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
                Tile tile = TileFactory.getInstance().createTile(tempColor, col, row);

                // add the tiles in the form of a grid
                tempTileList.add(tile);
            }

            // add the row list to the main arrayList
            tileListGridForm.add(tempTileList);

        }


        return tileListGridForm;
    }

}
