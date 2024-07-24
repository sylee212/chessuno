package chessuno.cards;

import chessuno.ClickType;
import chessuno.Color;
import chessuno.GetClickType;
import chessuno.chessPieces.ChessPieceType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Card implements GetClickType{

    // what kind of click type is this
    private ClickType clickType;

    // the core attributes of the card
    private Color color;
    private ChessPieceType chessPieceType;
    private int number;

    // the images
    private Image baseImage;
    private Image chessPieceImage;
    private Image numberImage;

    // the imageViews
    private ImageView baseImageView;
    private ImageView chessPieceImageView;
    private ImageView numberImageView;

    // the StackPane that will hold the imageViews
    private StackPane cardStackPane;

    public Card(){
        
    }

    

    @Override
    public ClickType getClickType() {
        return clickType;
    }

    /**
     * @param clickType the clickType to set
     */
    @Override
    public void setClickType(ClickType clickType) {
        this.clickType = clickType;
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
     * @return ChessPieceType return the chessPieceType
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
     * @return int return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return Image return the baseImage
     */
    public Image getBaseImage() {
        return baseImage;
    }

    /**
     * @param baseImage the baseImage to set
     */
    public void setBaseImage(Image baseImage) {
        this.baseImage = baseImage;
    }

    /**
     * @return Image return the chessPieceImage
     */
    public Image getChessPieceImage() {
        return chessPieceImage;
    }

    /**
     * @param chessPieceImage the chessPieceImage to set
     */
    public void setChessPieceImage(Image chessPieceImage) {
        this.chessPieceImage = chessPieceImage;
    }

    /**
     * @return Image return the numberImage
     */
    public Image getNumberImage() {
        return numberImage;
    }

    /**
     * @param numberImage the numberImage to set
     */
    public void setNumberImage(Image numberImage) {
        this.numberImage = numberImage;
    }

    /**
     * @return ImageView return the baseImageView
     */
    public ImageView getBaseImageView() {
        return baseImageView;
    }

    /**
     * @param baseImageView the baseImageView to set
     */
    public void setBaseImageView(ImageView baseImageView) {
        this.baseImageView = baseImageView;
    }

    /**
     * @return ImageView return the chessPieceImageView
     */
    public ImageView getChessPieceImageView() {
        return chessPieceImageView;
    }

    /**
     * @param chessPieceImageView the chessPieceImageView to set
     */
    public void setChessPieceImageView(ImageView chessPieceImageView) {
        this.chessPieceImageView = chessPieceImageView;
    }

    /**
     * @return ImageView return the numberImageView
     */
    public ImageView getNumberImageView() {
        return numberImageView;
    }

    /**
     * @param numberImageView the numberImageView to set
     */
    public void setNumberImageView(ImageView numberImageView) {
        this.numberImageView = numberImageView;
    }

}
