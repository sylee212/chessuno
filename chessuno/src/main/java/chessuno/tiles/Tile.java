package chessuno.tiles;

import chessuno.ClickType;
import chessuno.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile {

    // stores the tile number
    private int tileNumberVertical;
    private int tileNumberHorizontal;
    
    // the color of this piece
    private Color color;

    // if this piece is clicked
    // used for condition checking
    protected boolean isClick;

    // this is used for condition checking for the 3 main elements of the game
    protected ClickType clickType;

    // the coordinates for the piece on the board
    private float UIXcoordinate;
    private float UIYcoordinate;

    // the UI associated to this piece
    private Image image;

    // the ImageView associated to this piece
    private ImageView imageView;


}
