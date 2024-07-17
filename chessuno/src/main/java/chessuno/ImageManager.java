package chessuno;

import javafx.scene.image.Image;

public class ImageManager {

    private static ImageManager imageManager = null;

    public static ImageManager getInstance() {
        if (imageManager == null) {
            imageManager = new ImageManager();
        }
        return imageManager;
    }

    private ImageManager() {
    }

    /**
     * Returns the path of the pawn image
     * 
     * when the pawnimage was in the chessPieces folder, the following works
     * 
     *  System.out.println(ImageManager.getInstance().getClass().getName());
        return new Image(getClass().getResource("chessPieces/whitePawn.png").toString());
     * @param color
     * @return
     */
    public Image getPawnImage(Color color) {
        /*
        if ( color == Color.WHITE ) {
            return new Image("images/whitePawn.png");
        } else {
            return new Image("blackPawn.png");
        }
        */
        // return new Image(getClass().getResource("chessPieces/whitePawn.png").toString());
        String s = "/chessuno/Images/whitePawn.png";

        // src/main/resources becomes root path, / = root path, so we are using absolute path
        // getResoruce returns a URL pointing to the object
        
        System.out.println(getClass().toString());
        return new Image(getClass().getResource(s).toString());
    }

}
