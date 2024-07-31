package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import javafx.scene.image.ImageView;

public class Knight extends ChessPiece {

    public Knight(int uniqueID, Color color) {
        super( uniqueID,ChessPieceType.KNIGHT, color);

        setImage(ImageManager.getInstance().getChessPieceImage(color, ChessPieceType.KNIGHT));

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
