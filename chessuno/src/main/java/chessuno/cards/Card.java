package chessuno.cards;

import chessuno.ClickType;
import chessuno.Color;
import chessuno.Engine;
import chessuno.EntityClicked;
import chessuno.ImageManager;
import chessuno.chessPieces.ChessPieceType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Card implements EntityClicked{

    // what kind of click type is this
    private ClickType clickType;

    // the core attributes of the card
    private Color color;
    private Color chessPieceColor;
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



    public Card(Color color, Color chessPieceColor, ChessPieceType chessPieceType, int number) {
        // set the card data
        setClickType(clickType.CARD);

        setColor(color);
        setChessPieceColor(chessPieceColor);
        setChessPieceType(chessPieceType);
        setNumber(number);

        // set the images
        setBaseImage( ImageManager.getInstance().getBlankColorBaseImage(color) );
        setChessPieceImage( ImageManager.getInstance().getChessPieceImage(chessPieceColor, chessPieceType) );
        setNumberImage( ImageManager.getInstance().getNumberImage(number) );

        // set the imageViews
        setBaseImageView( new ImageView(getBaseImage()) );
        setChessPieceImageView( new ImageView(getChessPieceImage()) );
        setNumberImageView( new ImageView(getNumberImage()) );

        // set the StackPane
        setCardStackPane( new StackPane(getBaseImageView(), getChessPieceImageView(), getNumberImageView()) );

        // set the contents of the stackPane
        setCardStackPaneContent();

        setCardStackPaneOnClick();
    }

    private void setCardStackPaneContent(){
        // set the dimensions of the StackPane
        getCardStackPane().setPrefSize(CardFactory.getInstance().CARD_BASE_WIDTH , CardFactory.getInstance().CARD_BASE_WIDTH);

        // set the dimensions for the contents
        getChessPieceImageView().setFitHeight(CardFactory.getInstance().CHESS_PIECE_IMAGEVIEW_HEIGHT);
        getChessPieceImageView().setFitWidth(CardFactory.getInstance().CHESS_PIECE_IMAGEVIEW_WIDTH);

        getNumberImageView().setFitHeight(CardFactory.getInstance().NUMBER_IMAGEVIEW_HEIGHT);
        getNumberImageView().setFitWidth(CardFactory.getInstance().CHESS_PIECE_IMAGEVIEW_WIDTH); 

        getBaseImageView().setFitHeight(CardFactory.getInstance().CARD_BASE_HEIGHT);
        getBaseImageView().setFitWidth(CardFactory.getInstance().CARD_BASE_WIDTH);

        // set the coordinates 
        getChessPieceImageView().setTranslateX(CardFactory.getInstance().CHESS_PIECE_IMAGEVIEW_X);
        getChessPieceImageView().setTranslateY(CardFactory.getInstance().CHESS_PIECE_IMAGEVIEW_Y);

        // set the coordinates
        // the x and y coordinates are relative to the StackPane's center point, not the ImageView's top left corner
        // so need to set (-) to put it to the left
        getNumberImageView().setTranslateX(CardFactory.getInstance().NUMBER_IMAGEVIEW_X);
        getNumberImageView().setTranslateY(CardFactory.getInstance().NUMBER_IMAGEVIEW_Y);

        getBaseImageView().setTranslateX(0);
        getBaseImageView().setTranslateY(0);

    }

    public void setCardStackPaneOnClick(){
        getCardStackPane().setOnMouseClicked(event -> {
            Engine.getInstance().informEngineEntityClicked(this);
        });
    }

    @Override
    public EntityClicked getOriginal(){
        return this;
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
        this.baseImageView.setPreserveRatio(false);
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
        this.chessPieceImageView.setPreserveRatio(false);
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
        this.numberImageView.setPreserveRatio(false);
    }

    /**
     * @return StackPane return the cardStackPane
     */
    public StackPane getCardStackPane() {
        return cardStackPane;
    }

    /**
     * @param cardStackPane the cardStackPane to set
     */
    public void setCardStackPane(StackPane cardStackPane) {
        this.cardStackPane = cardStackPane;
    }




    /**
     * @return Color return the chessPieceColor
     */
    public Color getChessPieceColor() {
        return chessPieceColor;
    }

    /**
     * @param chessPieceColor the chessPieceColor to set
     */
    public void setChessPieceColor(Color chessPieceColor) {
        this.chessPieceColor = chessPieceColor;
    }

    @Override
    public String toString() {
        return "Card [color=" + color + ", chessPieceColor=" + chessPieceColor + ", chessPieceType=" + chessPieceType
                + ", number=" + number + "]";
    }

}
