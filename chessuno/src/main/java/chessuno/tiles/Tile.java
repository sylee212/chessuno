package chessuno.tiles;

import chessuno.ChessLocation;
import chessuno.ClickType;
import chessuno.Color;
import chessuno.Engine;
import chessuno.EntityClicked;
import chessuno.ImageManager;
import chessuno.SetClick;
import chessuno.chessPieces.ChessPiece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile implements SetClick,EntityClicked {

    // the color of this piece
    private Color color;

    // the unique ID for each of this class' objects
    private int uniqueID;

    // if this piece is clicked
    // used for condition checking
    protected boolean isClick;

    // this is used for condition checking for the 3 main elements of the game
    protected ClickType clickType;

    protected ChessLocation chessLocation;

    private boolean isChessPieceOnTile;

    private ChessPiece chessPieceOnTile;

    // the coordinates for the piece on the board
    private float UIXcoordinate;
    private float UIYcoordinate;


    // the UI associated to this piece
    private Image image;

    // the ImageView associated to this piece
    private ImageView imageView;

    public Tile(int uniqueID, Color color, int tileColNumber, int tileRowNumber) {
        // create the location
        // set the location
        chessLocation = new ChessLocation(tileColNumber, tileRowNumber);

        // set the unique ID
        setUniqueID(uniqueID);

        setColor(color);
        setClick(false);
        setClickType(clickType.TILE);
        setUIXcoordinate(0);
        setUIYcoordinate(0);

        setImage(ImageManager.getInstance().getBlankColorBaseImage(color));

        // set the imageView
        setImageView(new ImageView(getImage()));

        // set the height and width
        getImageView().setFitHeight(ImageManager.tilefitHeight);
        getImageView().setFitWidth(ImageManager.tilefitWidth);

        // set the click action
        setOnClick();
    }
    
    private void setOnClick() {
        getImageView().setOnMouseClicked(event -> {
            toggleIsClick();
            Engine.getInstance().informEngineEntityClicked(this);
        });
    }

    @Override
    public EntityClicked getOriginal(){
        return this;
    }

    private void toggleIsClick(){
        if ( isClick ){
            setClick(false);
        } else {
            setClick(true);
        }
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
     * @return float return the UIXcoordinate
     */
    public float getUIXcoordinate() {
        return UIXcoordinate;
    }

    /**
     * @param UIXcoordinate the UIXcoordinate to set
     */
    public void setUIXcoordinate(float UIXcoordinate) {
        this.UIXcoordinate = UIXcoordinate;
    }

    /**
     * @return float return the UIYcoordinate
     */
    public float getUIYcoordinate() {
        return UIYcoordinate;
    }

    /**
     * @param UIYcoordinate the UIYcoordinate to set
     */
    public void setUIYcoordinate(float UIYcoordinate) {
        this.UIYcoordinate = UIYcoordinate;
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

    


    /**
     * @return boolean return the isChessPieceOnTile
     */
    public boolean getIsChessPieceOnTile() {
        return isChessPieceOnTile;
    }

    /**
     * @param isChessPieceOnTile the isChessPieceOnTile to set
     */
    public void setIsChessPieceOnTile(boolean isChessPieceOnTile) {
        this.isChessPieceOnTile = isChessPieceOnTile;
    }

    /**
     * @return ChessPiece return the chessPieceOnTile
     */
    public ChessPiece getChessPieceOnTile() {
        return chessPieceOnTile;
    }

    /**
     * @param chessPieceOnTile the chessPieceOnTile to set
     */
    public void setChessPieceOnTile(ChessPiece chessPieceOnTile) {
        this.chessPieceOnTile = chessPieceOnTile;
    }

    @Override
    public String toString() {
        return "Tile: " + getChessLocation().getChessColumnCoordinate() + ", " + getChessLocation().getChessRowCoordinate();
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

    /**
     * @return boolean return the isChessPieceOnTile
     */
    public boolean isIsChessPieceOnTile() {
        return isChessPieceOnTile;
    }

}
