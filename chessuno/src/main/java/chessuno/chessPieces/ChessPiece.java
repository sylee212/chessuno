package chessuno.chessPieces;

import chessuno.ClickType;
import chessuno.Color;
import chessuno.GetClickType;
import chessuno.SetClick;
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

    // the coordinates for the piece on the board
    private float UIXcoordinate;
    private float UIYcoordinate;

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
        setUIXcoordinate(0);
        setUIYcoordinate(0);
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
     * @return boolean return the isClicked
     */
    public boolean isClick() {
        return isClick;
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

    public void setClickType(ClickType clickType) {
        this.clickType = clickType;
    }

    public ClickType getClickType() {
        return clickType;
    }

}
