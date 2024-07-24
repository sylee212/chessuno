package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import javafx.scene.image.ImageView;

public class Pawn extends ChessPiece {
    
    public Pawn(Color color) {
        super(ChessPieceType.PAWN, color);

        // set the image
        //setImage( new Image(getClass().getResource("whitePawn.png").toString()) );
        setImage(ImageManager.getInstance().getChessPieceImage(color, ChessPieceType.PAWN));

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