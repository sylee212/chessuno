package chessuno;

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

    public Image getTileImage(Color color) {

        // decides the color of the tile
        if ( color == Color.GREY ){
            String first = imageDirectory + "greyTile.png";
            return new Image(getClass().getResource(first).toString());
        } else {
            String second = imageDirectory + "blueTile.png";
            return new Image(getClass().getResource(second).toString());
        }
    }

    public Image getKingImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whiteKing.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackKing.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }

    public Image getQueenImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whiteQueen.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackQueen.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }

    public Image getBishopImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whiteBishop.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackBishop.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }

    public Image getKnightImage(Color color) {
        
        // decides the color of the pawn
        if ( color == Color.WHITE ){
            String white = imageDirectory + "whiteKnight.png";
            return new Image(getClass().getResource(white).toString());
        } else {
            String black = imageDirectory + "blackKnight.png";
            return new Image(getClass().getResource(black).toString());
        }
        
    }

    public Image getRookImage(Color color) {
        
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
    public Image getPawnImage(Color color) {
        
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
