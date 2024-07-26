package chessuno.chessPieces;

import chessuno.ChessLocation;
import chessuno.ClickType;
import chessuno.Color;
import chessuno.GetClickType;
import chessuno.SetClick;
import chessuno.tiles.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ChessPiece implements SetClick, GetClickType{

    // the chess piece type
    private ChessPieceType chessPieceType;

    // the color of this piece
    private Color color;

    // if this piece is clicked
    // used for condition checking
    protected boolean isClick;

    // this is used for condition checking for the 3 main elements of the game
    protected ClickType clickType;

    // the location of this piece
    protected ChessLocation chessLocation;

    // the tile that it is currently on
    protected Tile tileOn;

    // the UI associated to this piece
    private Image image;

    // the ImageView associated to this piece
    private ImageView imageView;

    /**
     * This is the constructor of the chess piece
     * @param chessPieceType, the String of the type
     * @param color
    **/
    public ChessPiece(ChessPieceType chessPieceType, Color color) {
        setChessPieceType(chessPieceType);
        setColor(color);
        setClick(false);
        setClickType(clickType.CHESSPIECE);

    }

    /**
     * @return String return the chessPieceType
     */
    public ChessPieceType getChessPieceType() {
        return chessPieceType;
    }

    /**
     * @param chessPieceType the chessPieceType to set
     */
    public void setChessPieceType(ChessPieceType chessPieceType) {
        this.chessPieceType = chessPieceType;
    }

    /**
     * @return Color return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @param isClicked the isClicked to set
     */
    @Override
    public void setClick(boolean isClicked) {
        this.isClick = isClicked;
    }

    @Override
    public boolean getClick(){
        return isClick;
    }

    /**
     * @return Image return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }


    /**
     * @return ImageView return the imageView
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * @param imageView the imageView to set
     */
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void setClickType(ClickType clickType) {
        this.clickType = clickType;
    }

    @Override
    public ClickType getClickType() {
        return clickType;
    }

    public void setChessLocation(ChessLocation chessLocation) {
        this.chessLocation = chessLocation;
    }

    public ChessLocation getChessLocation() {
        return chessLocation;
    }

    public Tile getTileOn() {
        return tileOn;
    }

    public void setTileOn(Tile tileOn) {
        this.tileOn = tileOn;
    }  

    
    private void toggleIsClick(){
        if ( isClick ){
            setClick(false);
        } else {
            setClick(true);
        }
    }

    public void setOnCLick(){

        toggleIsClick();

        getImageView().setOnMouseClicked((mouseEvent) -> {
            System.out.println("Piece clicked: " + getChessLocation().getChessColumnCoordinate() + " " +  getChessLocation().getChessRowCoordinate());
        });
    }

}
