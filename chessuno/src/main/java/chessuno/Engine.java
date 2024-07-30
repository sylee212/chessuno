package chessuno;

import java.io.IOException;
import java.util.ArrayList;

import chessuno.cards.Card;
import chessuno.cards.CardDeck;
import chessuno.cards.CardManager;
import chessuno.chessPieces.ChessPiece;
import chessuno.chessPieces.ChessPieceManager;
import chessuno.player.Player;
import chessuno.player.PlayerManager;
import chessuno.tiles.Tile;
import chessuno.tiles.TileManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 * Dictates everything, has all the instances of every controller class
 */
public class Engine {

    // the singleton engine instance 
    private static Engine instance;

    // the stage
    private static Stage stage;

    // chessPieceManager
    private ChessPieceManager chessPieceManager;

    // tileManager
    private TileManager tileManager;

    // cardManager
    private CardManager cardManager;

    // playerManager
    private PlayerManager playerManager;

    

    // start scene change
    private static boolean isStartSceneChange;

    // register scene change 
    private static boolean isRegisterSceneChange;

    // game scene change, means change into the game scene
    private static boolean isGameSceneChange;

    // stores the values of the users screen and width
    private double maxScreenWidth;
    private double maxScreenHeight;

    public static Engine getInstance() {

        // if the instance is null, create a new one
        if (Engine.instance == null) {
            Engine.instance = new Engine();
        }
        return instance;

    }

    /**
     * Blank constructor
     */
    private Engine() {
        Engine.isStartSceneChange = false;
        Engine.isRegisterSceneChange = false;

        // get the size of the screen
        ArrayList<Double> screenSize = Engine.getScreenSize();
        maxScreenWidth = screenSize.get(0);
        maxScreenHeight = screenSize.get(1);

        // instantiate the singletons
        this.chessPieceManager = ChessPieceManager.getInstance();

        // instantiate the singletons
        this.tileManager = TileManager.getInstance();

        // set the players to be connected to the chess pieces and cards
        this.cardManager = CardManager.getInstance();

        // set the playerManager
        this.playerManager = PlayerManager.getInstance();

        // unite the chess pieces and the tiles
        setChessPieceAndTile();
        
        // the player cards are created after the players are created //
    }


    /** 
     * If possible find a wayy to avoid type casting
     */
    public void informEngineEntityClicked(EntityClicked entity) {
        
        // get the click type of the entity that called the engine
        ClickType clickType = entity.getClickType();

        // get the clicked card if exist
        Card clickedCard = cardManager.getClickedCard();

        // get the current player
        Player player = playerManager.getCurrentPlayer();
        
        // get the player color
        Color playerColor = player.getColor();       



        // if the click type is card
        if (clickType == ClickType.CARD && clickedCard == null  ) {
            Card originalEntity = (Card) entity.getOriginal();

            System.out.println("original entity = " + originalEntity);

        } else if( clickType == ClickType.CHESSPIECE ) {
            ChessPiece originalEntity = (ChessPiece)entity.getOriginal();

            System.out.println("original entity = " + originalEntity);
        } else if ( clickType == ClickType.TILE ) {
            Tile originalEntity = (Tile)entity.getOriginal();

            System.out.println("original entity = " + originalEntity);
        } else if ( clickType == ClickType.DECK ) {

            CardDeck originalEntity = (CardDeck)entity.getOriginal();

            System.out.println("original entity = " + originalEntity);
        }
        


    }
    



    private void setPlayerCards(){
        // get the players list
        ArrayList<Player> players = PlayerManager.getInstance().getPlayers();

        // for every player
        for ( int i = 0 ; i < players.size() ; i++ ) {

            // get the player
            Player player = players.get(i);

            // get the color
            Color color = player.getColor();

            // create the cards 
            ArrayList<Card> cards = cardManager.initializeCards(color);

            // assign the cards to the player
            player.setCards(cards);

        }

    }

    private void setChessPieceAndTile() {
        
        ArrayList<ChessPiece> blackChessPieceList = chessPieceManager.getBlackChessPieceList();

        ArrayList<ChessPiece> whiteChessPieceList = chessPieceManager.getWhiteChessPieceList();
        
        ArrayList<ArrayList<Tile>> tileList = tileManager.getTileListGridForm();


        // iterate through the chess pieces and add their location 
        ArrayList<ChessPiece> currentChessPieceList = blackChessPieceList;

        int currentChessPieceListSize = currentChessPieceList.size();

        // to iterate over the 2 lists
        for ( int x = 0 ; x < 2 ; x++ ) {

            // to iterate over all the chess pieces
            for ( int i = 0 ; i < currentChessPieceListSize ; i++ ) {
                // get the current chess piece
                ChessPiece chessPiece = currentChessPieceList.get(i);

                // get the current location
                int col = chessPiece.getChessLocation().getChessColumnCoordinate();
                int row = chessPiece.getChessLocation().getChessRowCoordinate();

                // get the correct tile
                Tile tile = tileList.get(row).get(col);

                // set the chessPiece to the tile
                tile.setChessPieceOnTile(chessPiece);

                // set the chessPiece on the tile to true
                tile.setIsChessPieceOnTile(true);

                // set the tile to the chessPiece
                chessPiece.setTileOn(tile);

            }
            currentChessPieceList = whiteChessPieceList;
        }


    }


    /**
     * This function still exist because the change must inform the engine so that the engine can tell the state manager
     * @param b
     */
    public boolean getIsStartSceneChange() {
        return Engine.isStartSceneChange;    
    }

    public void setIsStartSceneChange(boolean b) {
        Engine.isStartSceneChange = b;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setIsRegisterSceneChange(boolean b) {

        // cause the players are only created after this is called, 
        // set the players cards //
        // required because need to create the cards 
        setPlayerCards();

        System.out.println("engine informed");

        Engine.isRegisterSceneChange = b;
    }

    public boolean getIsRegisterSceneChange() {
        return Engine.isRegisterSceneChange;
    }

    public void setIsGameSceneChange(boolean b){
        Engine.isGameSceneChange = b;
    }

    public boolean getIsGameSceneChange(){
        return Engine.isGameSceneChange;
    }

    /**
     * Gets the visual screen size that does not include the toolbars
     * @return ArrayList of the screen size in the format of [ screenWidth, screenHeight ]
     */
    public static ArrayList<Double> getScreenSize(){
        // Get the primary screen
        Screen primaryScreen = Screen.getPrimary();

        // Get the visual bounds of the primary screen
        javafx.geometry.Rectangle2D bounds = primaryScreen.getVisualBounds();
        
        double screenWidthLocal = bounds.getWidth();

        // -20 because the height it gives us pushes the button above the screen
        double screenHeightLocal = bounds.getHeight() - 20;

        ArrayList<Double> screenSize = new ArrayList<>();

        screenSize.add(screenWidthLocal);
        screenSize.add(screenHeightLocal);

        return screenSize;

    }

    public void startGame(Stage stage)  throws IOException {

        // assign the stage
        Engine.stage = stage;
        
        startScene();

    }

    /**
     * Function to load the main scene for the game
     * 
     * To access the variables in the controller class
            1) create the variable and make it the same name as the anchorPane in the controller class
                @FXML
                private AnchorPane GameAnchorPane;
            2) dosent have to be private, can be public, if public no need method to access it
            3) get the FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/game.fxml"));
            4) load the fxml
                Pane root = loader.load();
            5) for load the fxml, although it is not used, need to load it. So what you can do is, 
                this -> loader.load();
                instead of 
                this -> Pane root = loader.getController();
            6) get the controller 
                GameController controller = loader.getController();
            7) access the variable, for this case, cause the variable is private, need to use a function
                AnchorPane gameControllerAnchorPane = gameController.getGameAnchorPane();
     * 
     * @param stage
     * @throws IOException
     */
    private void startScene() throws IOException {
 
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/start.fxml"));
        loader.load();

        // get the controller. COMPULSORY
        StartController startController = loader.getController();

        // access the variable
        AnchorPane startControllerAnchorPane = startController.getStartAnchorPane();

        // Create and set the scene
        Scene scene = new Scene(startControllerAnchorPane, maxScreenWidth, maxScreenHeight);
        stage.setScene(scene);

        // Show the stage
        stage.show();

    }



}

