package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import chessuno.actions.MoveAction;
import chessuno.tiles.Tile;
import javafx.scene.image.ImageView;

public class Rook extends ChessPiece {

    public Rook(int uniqueID, Color color) {
        super( uniqueID,ChessPieceType.ROOK, color);

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

    @Override
    public MoveAction getMoveAction(ChessPiece chessPiece) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MoveAction getMoveAction(Tile tile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
