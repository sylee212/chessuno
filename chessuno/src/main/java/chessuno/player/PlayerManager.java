package chessuno.player;

import java.util.ArrayList;

import chessuno.Color;

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


}
