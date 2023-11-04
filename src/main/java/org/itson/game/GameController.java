package org.itson.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.itson.board.Board;
import org.itson.board.BoardController;
import org.itson.engine.ControllerFactory;
import org.itson.pit.Pit;
import org.itson.room.Room;
import org.itson.token.TokenController;
import org.itson.pit.PitController;
import org.itson.player.Player;
import org.itson.player.PlayerController;
import org.itson.room.RoomController;
import org.itson.token.MuleToken;
import org.itson.token.Token;
import org.itson.token.TokenComponent;
import org.itson.token.TokenManager;

public class GameController {

    private static GameController instance;
    private Game game;
    private Board board;

    private RoomController roomController;
    private PitController pitController;
    private TokenManager tokenManager;
    private PlayerController playerController;
    private BoardController boardController;

    private GameController() {
        this.roomController = ControllerFactory.getRoomController();
        this.pitController = ControllerFactory.getPitController();
        this.tokenManager = TokenManager.get();
        this.playerController = ControllerFactory.getPlayerController();
        this.boardController = ControllerFactory.getBoardController();
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

    public List<Token> getTokensFromPit() {
        return this.pitController.getTokens();
    }

    public Token getRandomTokenFromThePit() {
        return this.pitController.getRandomToken();
    }

    public void addPlayerToTheRoom(Player player) {
        this.roomController.addPlayerToTheRoom(player);
    }

    public void generateTokens() throws IOException {
        this.tokenManager.generateTokens();
    }
    
    public List<Token >getTokens() {
        return this.tokenManager.getTokens();
    }

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

    public MuleToken getBiggestMuleTokenFromPlayers(List<Player> players) {
        List<MuleToken> muleTokens = new ArrayList<>();

        for (Player player : players) {
            muleTokens.add(this.tokenManager.getBiggestMuleTokenPerPlayer(player));
        }

        MuleToken removedToken = this.tokenManager.getBiggestMuleToken(muleTokens);
        return (MuleToken) this.tokenManager.removeTokenPerThePlayer(players, removedToken);
    }

    public void createBoard() {
        this.boardController.createBoard();
    }

    public Board getBoard() {
        return this.boardController.getBoard();
    }

    public boolean boardIsFull() {
        if (this.board != null) {
            int currentSize = this.getTokensFromPit().size();
            return currentSize >= 28;
        }
        throw new RuntimeException("The board has not been created yet.");
    }

    public void putTokenOnBoard(Token token) {
        this.boardController.addTokenOnBoard(token);
    }

    public List<Token> getTokensFromTheBoard() {
        return this.boardController.getTokens();
    }
}
