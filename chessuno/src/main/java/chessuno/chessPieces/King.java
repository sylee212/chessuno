package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import chessuno.actions.MoveAction;
import chessuno.tiles.Tile;
import javafx.scene.image.ImageView;

public class King extends ChessPiece {

    public King(int uniqueID, Color color) {
        super( uniqueID, ChessPieceType.KING, color);

        setImage(ImageManager.getInstance().getChessPieceImage(color, ChessPieceType.KING));

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

    @Override
    public MoveAction getMoveAction(ChessPiece chessPiece) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MoveAction getMoveAction(Tile tile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
