package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import javafx.scene.image.ImageView;

public class Bishop extends ChessPiece {

    public Bishop(int uniqueID, Color color) {
        super( uniqueID, ChessPieceType.BISHOP, color);

        setImage(ImageManager.getInstance().getChessPieceImage(color, ChessPieceType.BISHOP));

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
