
package org.itson.game;

import java.io.IOException;
import java.util.List;
import org.itson.pit.Pit;
import org.itson.room.Room;
import org.itson.token.TokenController;
import org.itson.pit.PitController;
import org.itson.player.Player;
import org.itson.player.PlayerController;
import org.itson.room.RoomController;
import org.itson.token.Token;

public class GameController {
    private static GameController instance;
    private Game game;
    
    private RoomController roomController;
    private PitController pitController;
    private TokenController tokenController;
    private PlayerController playerController;
    
    private GameController() {
        this.roomController = RoomController.get();
        this.pitController = PitController.get();
        this.tokenController = TokenController.get();
        this.playerController = PlayerController.get();
    }
    
    public static GameController get() {
        if (GameController.instance == null) {
            GameController.instance = new GameController();
        }
        
        return GameController.instance;
    }
    
    public void createGame() {
        this.game = new Game();
    }
    
    public Game getGame() {
        return this.game;
    }
    
    public void setGameInTheRoom(Game game) {
        this.roomController.setGame(game);
    }
    
    public Game getGameFromRoom(Room room) {
        return room.getGame();
    }
    
    public void createRoom() {
        this.roomController.createRoom();
    }
    
    public Room getRoom() {
        return this.roomController.getRoom();
    }
    
    public void createPit() {
        this.pitController.createPit();
    }
    
    public Pit getPit() {
        return this.pitController.getPit();
    }
    
    public void saveTokensInThePit(List<Token> tokens) {
        this.pitController.setTokens(tokens);
    }
    
    public List<Token> getTokens() {
        return this.pitController.getTokens();
    }
    
    public void addPlayerToTheRoom(Player player) {
        this.roomController.addPlayerToTheRoom(player);
    }
    
    public List<Token> generateTokens() throws IOException {
        return this.tokenController.generateTokens();
    }
    
    // TODO: mandar esta responsabilidad al pozo
    public void dealTokens(List<Player> players, int quantity) {
        if (!this.checkNumberOfPlayers(players)) {
            throw new RuntimeException("Invalid number of players.");
        }
        
        for (Player player : players) {
            player.setTokens(this.pitController.getTokens(quantity));
        }
    }
    
    public Player createPlayer(String name) {
        return this.playerController.createPlayer(name);
    }
    
    public List<Player> getPlayers() {
        return this.roomController.getPlayers();
    }
    
    private boolean checkNumberOfPlayers(List<Player> players) {
        return players.size() <= 4 || players.size() >= 2;
    }
}
