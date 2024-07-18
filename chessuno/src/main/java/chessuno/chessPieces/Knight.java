package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import javafx.scene.image.ImageView;

public class Knight extends ChessPiece {

    public Knight(Color color) {
        super(ChessPieceType.KNIGHT, color);

        setImage(ImageManager.getInstance().getKnightImage(color));

        // set the imageView
        setImageView(new ImageView(getImage()));

        // set the height and width
        getImageView().setFitHeight(ImageManager.chessPiecefitHeight);
        getImageView().setFitWidth(ImageManager.chessPiecefitWidth);
    }

}
