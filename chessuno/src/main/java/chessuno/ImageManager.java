package chessuno;

import chessuno.chessPieces.ChessPieceType;
import javafx.scene.image.Image;

/**
 * 
 * @author Lee Sing Yuan
 * purpose of this class is to get the images so that all objects will have the same reference to the images instead of their own references
 * 
 */
public class ImageManager {


    // the size of the imageViews of the chess pieces, eg: Pawn
    public static double chessPiecefitWidth = 40.0;
    public static double chessPiecefitHeight = 40.0;

    
    // the size of the imageViews of the chess pieces, eg: Tiles
    public static double tilefitWidth = 50.0;
    public static double tilefitHeight = 50.0;

    // the singleton object of this class
    private static ImageManager imageManager = null;

    // stores the address of the root / working directory
    private String imageDirectory = "/chessuno/Images/";

    public static ImageManager getInstance() {
        if (ImageManager.imageManager == null) {
            ImageManager.imageManager = new ImageManager();
        }
        return imageManager;
    }

    private ImageManager() {}

    public Image getCardBackImage(){

        return new Image(getClass().getResource(imageDirectory + "cardBack.png").toString());
    }

    public Image getCardDeckImage(){

        return new Image(getClass().getResource(imageDirectory + "cardDeck.png").toString());
    }

    public Image getNumberImage(int number) {
    
        // returns an image based on the number
        switch (number) {
            case 0:
                return new Image(getClass().getResource(imageDirectory + "numberZero.png").toString());
            case 1:
                return new Image(getClass().getResource(imageDirectory + "numberOne.png").toString());
            case 2:
                return new Image(getClass().getResource(imageDirectory + "numberTwo.png").toString());
            case 3:
                return new Image(getClass().getResource(imageDirectory + "numberThree.png").toString());
            case 4:
                return new Image(getClass().getResource(imageDirectory + "numberFour.png").toString());
            case 5:
                return new Image(getClass().getResource(imageDirectory + "numberFive.png").toString());
            case 6:
                return new Image(getClass().getResource(imageDirectory + "numberSix.png").toString());
            case 7:
                return new Image(getClass().getResource(imageDirectory + "numberSeven.png").toString());
            case 8:
                return new Image(getClass().getResource(imageDirectory + "numberEight.png").toString());
            case 9:
                return new Image(getClass().getResource(imageDirectory + "numberNine.png").toString());
            default:
                return new Image(getClass().getResource(imageDirectory + "errorTile.png").toString());
        }
    }

    public Image getChessPieceImage(Color color, ChessPieceType chessPieceType) {
        if ( null == chessPieceType ) {
            return new Image(getClass().getResource(imageDirectory + "errorTile.png").toString());
        } else switch (chessPieceType) {
            case PAWN:
                return getPawnImage(color);
            case ROOK:
                return getRookImage(color);
            case BISHOP:
                return getBishopImage(color);
            case QUEEN:
                return getQueenImage(color);
            case KING:
                return getKingImage(color);
            case KNIGHT:
                return getKnightImage(color);
            default:
                return new Image(getClass().getResource(imageDirectory + "errorTile.png").toString());
        }
        
    }

    public Image getBlankColorBaseImage(Color color) {

        // decides the color of the tile
        if ( color == Color.GREY ){
            String wantedColor = imageDirectory + "greyTile.png";
            return new Image(getClass().getResource(wantedColor).toString());
        } else if ( color == Color.BLUE ) {
            String wantedColor = imageDirectory + "blueTile.png";
            return new Image(getClass().getResource(wantedColor).toString());
        } else if ( color == Color.RED ) {
            String wantedColor = imageDirectory + "redCardBase.png";
            return new Image(getClass().getResource(wantedColor).toString());
        } else if ( color == Color.GREEN ) {
            String wantedColor = imageDirectory + "greenCardBase.png";
            return new Image(getClass().getResource(wantedColor).toString());
        } else if ( color == Color.YELLOW ) {
            String wantedColor = imageDirectory + "yellowCardBase.png";
            return new Image(getClass().getResource(wantedColor).toString());
        } else {
            String error = imageDirectory + "errorTile.png";
            return new Image(getClass().getResource(error).toString());
        }
    }

    private Image getKingImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whiteKing.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackKing.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }

    private Image getQueenImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whiteQueen.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackQueen.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }

    private Image getBishopImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whiteBishop.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackBishop.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }

    private Image getKnightImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whiteKnight.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackKnight.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }

    private Image getRookImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whiteRook.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackRook.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }

    /**
     * <b>OBJECTIVE:</b>   
     * 
     * Returns the path of the pawn image
     *
     * 
     * <b>NOTE:</b>
     * 
     * when the pawn image was in the chessPieces folder, the following works
     * 
     * src/main/resources becomes root path, / = root path, so we are using absolute path
     * getResoruce returns a URL pointing to the object
     * 
     * System.out.println(ImageManager.getInstance().getClass().getName());
     * return new Image(getClass().getResource("chessPieces/whitePawn.png").toString());
     * 
     * PARAMETERS:
     * @param color
     * @return
     */
    private Image getPawnImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whitePawn.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackPawn.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }



}
