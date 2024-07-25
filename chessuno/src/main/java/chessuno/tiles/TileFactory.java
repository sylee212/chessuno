package chessuno.tiles;

import chessuno.Color;

public class TileFactory {

    private static TileFactory tileFactory;

    private TileFactory() {
    }

    public static TileFactory getInstance() {
        if (TileFactory.tileFactory == null) {
            TileFactory.tileFactory = new TileFactory();
        }
        return TileFactory.tileFactory;
    }

    public Tile createTile(Color color, int tileColNumber, int tileRowNumber) {
        return new Tile(color, tileColNumber, tileRowNumber);
    }


}
