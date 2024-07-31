package chessuno.tiles;

import chessuno.Color;

public class TileFactory {

    private static TileFactory tileFactory;

    // the unique ID for each tile
    private int uniqueID;

    private TileFactory() {
        setUniqueID(0);
    }

    public static TileFactory getInstance() {
        if (TileFactory.tileFactory == null) {
            TileFactory.tileFactory = new TileFactory();
        }
        return TileFactory.tileFactory;
    }

    public Tile createTile(Color color, int tileColNumber, int tileRowNumber) {
        int ID = getUniqueID();

        Tile tile = new Tile(ID, color, tileColNumber, tileRowNumber);

        setUniqueID( getUniqueID() + 1);

        return tile;
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
