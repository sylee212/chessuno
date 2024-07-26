package chessuno.player;

import java.util.ArrayList;

import chessuno.Color;
import chessuno.cards.Card;
import chessuno.chessPieces.ChessPiece;

public class PlayerManager {

    // current max number of players
    public static final int MAX_NUMBER_OF_PLAYERS = 2;

    // singleton 
    private static PlayerManager playerManager;

    // list of players
    private static ArrayList<Player> players;


    private PlayerManager() {
        PlayerManager.players = new ArrayList<>();
    }

    public static PlayerManager getInstance() {

        // if the instance is null, create a new one
        if (PlayerManager.playerManager == null) {
            PlayerManager.playerManager = new PlayerManager();
        }
        return PlayerManager.playerManager;
    }

    public boolean createPlayer(String name, Color color) {

        // if there is max number of player, do not allow more player
        if ( getNumberOfPlayers() < MAX_NUMBER_OF_PLAYERS) {
            Player player = new Player(name, color);
            PlayerManager.players.add(player);
            return true;
        }
        else {
            return false;
        }

    }

    public int getNumberOfPlayers() {
        return PlayerManager.players.size();
    }

    public void setPlayerChessPiecesAndCards(Color color, ArrayList<ChessPiece> chessPieces, ArrayList<Card> cards) {
        Player player = findPlayerBasedOnColor(color);

        player.setChessPieces(chessPieces);
        player.setCards(cards);

    }

    public Player findPlayerBasedOnColor(Color color) {
        for (int i = 0; i < PlayerManager.players.size(); i++) { // for each player : PlayerManager.players) {
            Player player = this.getPlayers().get(i);
            if (player.getColor() == color) {
                return player;
            }
        }
        return null;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }   

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
