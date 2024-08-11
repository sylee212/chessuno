package chessuno;

import java.io.IOException;
import java.util.ArrayList;

import chessuno.actions.CardClickedAction;
import chessuno.actions.MoveAction;
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
import javafx.scene.layout.Pane;
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

    // the game controller
    private GameController gameController;

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

        // get the clicked chess piece if exist
        ChessPiece clickedChessPiece = chessPieceManager.getClickedChessPiece();

        // get the current player
        Player player = playerManager.getCurrentPlayer();
        
        // get the player color
        Color playerColor = player.getColor();       

        // check if a card has been played
        // if a card has been played, then the player can not play another card
        boolean isCardPlayed = cardManager.isClickedCardConfirmed();

        System.out.println("###### Engine| clickedChessPiece = " + clickedChessPiece + "| entity = " + entity   );



        // if the click type is card
        if (clickType == ClickType.CARD ) {

            // get the original entity that called the engine
            Card originalEntity = (Card) entity.getOriginal();
            System.out.println("Engine| original entity = " + originalEntity);

            // get the color of the chessPiece on the card
            Color cardChessPieceColor = originalEntity.getChessPieceColor();

            // set the UI
            this.gameController.getGameInformationContainer().updateClickedCardLabel(originalEntity.toString());

            // if the clicked card is null and the card's color is the same as the player's color
            // means this card is put onto a pending state as it may be a valid move 
            // NOT SURE IF THIS CARD IS VALID OR NOT YET. CHECK LATER 
            if ( isCardPlayed == false && clickedCard == null && cardChessPieceColor == playerColor ) {
                
                // ask the cardManager to set this card as clicked Card
                cardManager.setClickedCard(originalEntity);
            } 
            // if the there is already a card, means the player could be confirming his choice to play this card
            else if ( isCardPlayed == false && clickedCard != null && cardChessPieceColor == playerColor ) {
                
                // check if the new clickedCard is the same as the old clickedCard
                // if yes means that the player confirmed his selection
                if ( clickedCard.getUniqueID() == originalEntity.getUniqueID() ) {


                    // get the card on top of the stack
                    Card cardOnTopOfStack = cardManager.getCardStack().getLastCard();

                    // call for the cardClickedAction which the information will be filled out by the card class
                    CardClickedAction cardClickedAction = originalEntity.getCardClickedAction(cardOnTopOfStack);
                    //System.out.println("Engine| card on top= " + cardOnTopOfStack);
                    
                    boolean executeResult = cardClickedAction.execute();
                    //System.out.println( executeResult );




                }

                // if the player wants to choose something else
                // set the recently clicked card, or the orignal entity and set that as the clicked card
                else if ( clickedCard.getUniqueID() != originalEntity.getUniqueID() ) {
                    cardManager.setClickedCard(originalEntity);
                }
                

            }

        } else if( clickType == ClickType.CHESSPIECE ) {


            ChessPiece originalEntity = (ChessPiece)entity.getOriginal();
            System.out.println("Engine| original entity = " + originalEntity);


            // get the color of the chessPiece
            Color chessPieceColor = originalEntity.getColor();

            // set the UI 
            this.gameController.getGameInformationContainer().updateClickedChessPieceLabel(originalEntity.toString());

            // says here card played is false
            System.out.println("Engine| isCardPlayed = " + ( isCardPlayed == true ) + " clickedChessPiece " +  ( clickedChessPiece != null ) + "| clickType = " + clickType);

            // only allow a click on the chess piece if a card has been played
            // if there is no currently clicked chess piece and the clicked chess piece's color is the same as the player's color
            if ( isCardPlayed == true && clickedChessPiece == null && chessPieceColor == playerColor ) {
                
                // ask the chessPieceManager to set this chessPiece as clicked chessPiece
                chessPieceManager.setClickedChessPiece(originalEntity);

            } else if ( isCardPlayed == true && clickedChessPiece != null && chessPieceColor == playerColor ) {

                // check if the new clickedChessPiece is the same as the old clickedChessPiece and the clicked chess piece's color is the same as the player's color
                // if yes means that the player drops the selection
                if ( clickedChessPiece.getUniqueID() == originalEntity.getUniqueID() && clickedChessPiece.getColor() == originalEntity.getColor() ) {

                    // set the clicked chess to null
                    chessPieceManager.setClickedChessPiece(null);

                    // reset the UI to nothing
                    gameController.getGameInformationContainer().updateClickedChessPieceLabel("");
                    
                    
                } 
                // if the clicked chess piece is different and the color is the same, set that as clicked chess pieces
                else if ( clickedChessPiece.getUniqueID() != originalEntity.getUniqueID() && clickedChessPiece.getColor() == originalEntity.getColor() ) {

                    // set the new chess piece
                    chessPieceManager.setClickedChessPiece(originalEntity);
                }
            }
            // if a different color was selected, checked if the previous clicked chess piece was the same as the new clicked chess piece
            else if ( isCardPlayed == true && clickedChessPiece != null && chessPieceColor != playerColor){
                System.out.println("Engine| kill other chess piece, clicked chess piece = " + clickedChessPiece);


                // if the clicked chess piece is different and the color is different, means we are selecting that chess piece to attack
                if ( clickedChessPiece.getUniqueID() != originalEntity.getUniqueID() && clickedChessPiece.getColor() != originalEntity.getColor() ) {
    
                    // get the move action 
                    MoveAction moveAction = originalEntity.getMoveAction(clickedChessPiece);

                    // execute the move action
                    boolean executeResult = moveAction.execute();

                    if ( executeResult == true ){

                        // remove the clicked chess piece
                        chessPieceManager.setClickedChessPiece(null);

                        // set the UI 
                        this.gameController.getGameInformationContainer().updateClickedChessPieceLabel("");

                        // set the card played to false ONLY IF WE HAVE SUCCESSFULLY MOVED THE PIECE
                        cardManager.setIsClickedCardConfirmed(false);
                    }

                    
                }
            }

        

        } else if ( clickType == ClickType.TILE ) {

            // maybe for this we can leave it be first // or we can use this as like after we click on the chess piece, this is used to determine where to go

            Tile originalEntity = (Tile)entity.getOriginal();
            System.out.println("Engine| original entity = " + originalEntity);

            // set the UI 
            this.gameController.getGameInformationContainer().updateClickedTileLabel(originalEntity.toString());

            // only allow a click on the tile if a chessPiece has been clicked
            if ( clickedChessPiece != null ) {
                
                // set the tileManager to the clicked tile
                tileManager.setClickedTile(originalEntity);

                MoveAction moveAction = clickedChessPiece.getMoveAction(originalEntity);

                boolean executeResult = moveAction.execute();

                if ( executeResult == true ){

                    // remove the clicked chess piece
                    chessPieceManager.setClickedChessPiece(null);

                    // set the UI 
                    this.gameController.getGameInformationContainer().updateClickedChessPieceLabel("");

                    // set the card played to false ONLY IF WE HAVE SUCCESSFULLY MOVED THE PIECE
                    cardManager.setIsClickedCardConfirmed(false);
                }

            }

        } else if ( clickType == ClickType.DECK ) {

            CardDeck originalEntity = (CardDeck)entity.getOriginal();
            System.out.println("Engine| original entity = " + originalEntity);

            //System.out.println("\nEngine | ORIGINAL " + "size = " + cardManager.getPlayerCards().get(Color.WHITE).size() + " | " + cardManager.getPlayerCards());

            // create a card and add it to the list
            Card card = cardManager.createRandomCard(playerColor);

            //System.out.println("\nEngine | AFTER " + "size = " + cardManager.getPlayerCards().get(Color.WHITE).size() + " | " + cardManager.getPlayerCards());

            // add the card to the UI
            gameController.getCardContainer().addCardToPlayerStack(card);

        }
        


    }

    public GameController getGameController(){
        // get the fxml. COMPULSORY
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chessuno/game.fxml"));

        try {
        // load the FXML. COMPULSORY
        Pane root = loader.load();
        } 
        catch (IOException e) {
        e.printStackTrace();
        }

        return loader.getController();
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
            //System.out.println("ENGINE | created players cards = " + cards);

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

        System.out.println("ENGINE | created players cards");

        Engine.isRegisterSceneChange = b;

        // set the gameController
        setGameController(getGameController());
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

    public void setGameController(GameController gameController) {

        this.gameController = gameController;

    }

    public CardManager getCardManager() {
        return cardManager;
    }

    public void setCardManager(CardManager cardManager) {
        this.cardManager = cardManager;
    }   



}

