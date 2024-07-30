package chessuno.cards;

import chessuno.ClickType;
import chessuno.Color;
import chessuno.Engine;
import chessuno.GetClickType;
import chessuno.ImageManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class CardDeck implements GetClickType {

    private ClickType clickType;

    private Image cardDeckImage;

    private Image cardDeckBaseImage;

    private ImageView cardDeckImageView;

    private ImageView cardDeckBaseImageView;

    private double cardDeckImageViewWidth;

    private double cardDeckImageViewHeight;

    private double cardDeckBaseImageViewWidth;

    private double cardDeckBaseImageViewHeight;

    private StackPane cardDeckStackPane;
    

    public CardDeck() {
        setCardDeckBaseImageViewWidth(CardFactory.getInstance().CARD_BASE_WIDTH);
        setCardDeckBaseImageViewHeight(CardFactory.getInstance().CARD_BASE_HEIGHT);

        setCardDeckImageViewWidth(CardFactory.getInstance().CARD_BASE_WIDTH);
        setCardDeckImageViewHeight(CardFactory.getInstance().CARD_BASE_HEIGHT);

        setCardDeckImage(ImageManager.getInstance().getCardDeckImage());
        setCardDeckBaseImage( ImageManager.getInstance().getBlankColorBaseImage(Color.GREY));

        setCardDeckImageView(new ImageView(getCardDeckImage()));
        setCardDeckBaseImageView( new ImageView(getCardDeckBaseImage()));

        setCardDeckStackPane(new StackPane(getCardDeckBaseImageView(), getCardDeckImageView()));

        setCardDeckUISize();

        // set Click Type
        setClickType(ClickType.DECK);

        setOnClick();
    }

    private void setCardDeckUISize(){

        getCardDeckImageView().setFitWidth(getCardDeckImageViewWidth());
        getCardDeckImageView().setFitHeight(getCardDeckImageViewHeight());
        getCardDeckImageView().setPreserveRatio(false);

        getCardDeckBaseImageView().setFitWidth(getCardDeckBaseImageViewWidth());
        getCardDeckBaseImageView().setFitHeight(getCardDeckBaseImageViewHeight());
        getCardDeckImageView().setPreserveRatio(false);
    }

    private void setOnClick(){

        getCardDeckStackPane().setOnMouseClicked(event -> {
           Engine.getInstance().informEngineEntityClicked(this);
        });
    }

    public Image getCardDeckImage() {
        return cardDeckImage;
    }   

    public void setCardDeckImage(Image cardDeckImage) {
        this.cardDeckImage = cardDeckImage;
    }

    public ImageView getCardDeckImageView() {
        return cardDeckImageView;
    }   

    public void setCardDeckImageView(ImageView cardDeckImageView) {
        this.cardDeckImageView = cardDeckImageView;
    }

    public StackPane getCardDeckStackPane() {
        return cardDeckStackPane;
    }   

    public void setCardDeckStackPane(StackPane cardDeckStackPane) {
        this.cardDeckStackPane = cardDeckStackPane;
    }
    


    /**
     * @return Image return the cardDeckBaseImage
     */
    public Image getCardDeckBaseImage() {
        return cardDeckBaseImage;
    }

    /**
     * @param cardDeckBaseImage the cardDeckBaseImage to set
     */
    public void setCardDeckBaseImage(Image cardDeckBaseImage) {
        this.cardDeckBaseImage = cardDeckBaseImage;
    }

    /**
     * @return ImageView return the cardDeckBaseImageView
     */
    public ImageView getCardDeckBaseImageView() {
        return cardDeckBaseImageView;
    }

    /**
     * @param cardDeckBaseImageView the cardDeckBaseImageView to set
     */
    public void setCardDeckBaseImageView(ImageView cardDeckBaseImageView) {
        this.cardDeckBaseImageView = cardDeckBaseImageView;
    }


    /**
     * @return double return the cardDeckImageViewWidth
     */
    public double getCardDeckImageViewWidth() {
        return cardDeckImageViewWidth;
    }

    /**
     * @param cardDeckImageViewWidth the cardDeckImageViewWidth to set
     */
    public void setCardDeckImageViewWidth(double cardDeckImageViewWidth) {
        this.cardDeckImageViewWidth = cardDeckImageViewWidth;
    }

    /**
     * @return double return the cardDeckImageViewHeight
     */
    public double getCardDeckImageViewHeight() {
        return cardDeckImageViewHeight;
    }

    /**
     * @param cardDeckImageViewHeight the cardDeckImageViewHeight to set
     */
    public void setCardDeckImageViewHeight(double cardDeckImageViewHeight) {
        this.cardDeckImageViewHeight = cardDeckImageViewHeight;
    }

    /**
     * @return double return the cardDeckBaseImageViewWidth
     */
    public double getCardDeckBaseImageViewWidth() {
        return cardDeckBaseImageViewWidth;
    }

    /**
     * @param cardDeckBaseImageViewWidth the cardDeckBaseImageViewWidth to set
     */
    public void setCardDeckBaseImageViewWidth(double cardDeckBaseImageViewWidth) {
        this.cardDeckBaseImageViewWidth = cardDeckBaseImageViewWidth;
    }

    /**
     * @return double return the cardDeckBaseImageViewHeight
     */
    public double getCardDeckBaseImageViewHeight() {
        return cardDeckBaseImageViewHeight;
    }

    /**
     * @param cardDeckBaseImageViewHeight the cardDeckBaseImageViewHeight to set
     */
    public void setCardDeckBaseImageViewHeight(double cardDeckBaseImageViewHeight) {
        this.cardDeckBaseImageViewHeight = cardDeckBaseImageViewHeight;
    }


    /**
     * @return ClickType return the clickType
     */
    public ClickType getClickType() {
        return clickType;
    }

    /**
     * @param clickType the clickType to set
     */
    public void setClickType(ClickType clickType) {
        this.clickType = clickType;
    }

    @Override
    public String toString(){

        return "CardDeck";
    }

}
