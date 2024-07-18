package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import javafx.scene.image.ImageView;

public class King extends ChessPiece {

    public King(Color color) {
        super(ChessPieceType.KING, color);

        setImage(ImageManager.getInstance().getKingImage(color));

        // set the imageView
        setImageView(new ImageView(getImage()));

        // set the height and width
        getImageView().setFitHeight(ImageManager.chessPiecefitHeight);
        getImageView().setFitWidth(ImageManager.chessPiecefitWidth);
    }

}
