package chessuno.chessPieces;

import chessuno.Color;
import chessuno.ImageManager;
import chessuno.actions.ActionInformation;
import chessuno.actions.MoveAction;
import chessuno.actions.MoveForward;
import chessuno.tiles.Tile;
import javafx.scene.image.ImageView;

public class Pawn extends ChessPiece {
    
    public Pawn(int uniqueID, Color color) {
        super( uniqueID, ChessPieceType.PAWN, color);

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

    @Override
    public MoveAction getMoveAction(ChessPiece chessPiece) {

        // create the moveForward action
        MoveForward moveForward = new MoveForward();

        // create the action information
        ActionInformation actionInformation = new ActionInformation();

        // fill the information
        actionInformation.setCurrentChessPiece(this);
        actionInformation.setchessPieceClicked(chessPiece);

        // fill in the action information to the moveForward action
        moveForward.fillInformation(actionInformation);

        // return the moveForward action
        return moveForward;
    }

    @Override
    public MoveAction getMoveAction(Tile tile) {
        
        // create the moveForward action
        MoveForward moveForward = new MoveForward();

        // create the action information
        ActionInformation actionInformation = new ActionInformation();

        // fill the information
        actionInformation.setCurrentChessPiece(this);
        actionInformation.settileClicked(tile);

        // fill in the action information to the moveForward action
        moveForward.fillInformation(actionInformation);

        // return the moveForward action
        return moveForward;
    }




}