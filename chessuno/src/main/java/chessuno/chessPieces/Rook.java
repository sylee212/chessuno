package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import javafx.scene.image.ImageView;

public class Rook extends ChessPiece {

    public Rook(Color color) {
        super(ChessPieceType.ROOK, color);

        setImage(ImageManager.getInstance().getChessPieceImage(color, ChessPieceType.ROOK));

        // set the imageView
        setImageView(new ImageView(getImage()));

        // set the height and width
        getImageView().setFitHeight(ImageManager.chessPiecefitHeight);
        getImageView().setFitWidth(ImageManager.chessPiecefitWidth);

        // {POTENTIAL OPTIMIZATION}
        // by putting it inside the parent class
        // set the onClick
        setOnCLick();
    }

}
