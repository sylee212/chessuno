package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import javafx.scene.image.ImageView;

public class Pawn extends ChessPiece {
    
    public Pawn(Color color) {
        super(ChessPieceType.PAWN, color);

        // set the image
        //setImage( new Image(getClass().getResource("whitePawn.png").toString()) );
        setImage(ImageManager.getInstance().getPawnImage(color));

        // set the imageView
        setImageView(new ImageView(getImage()));

        // set the height and width
        getImageView().setFitHeight(400.0);
        getImageView().setFitWidth(400.0);
    }


}