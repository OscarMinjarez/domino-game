package org.itson.model;

/**
 *
 * @author arace
 */
public class Room {

    private Player player[];
    private Game game;

    public Room() {
    }

    public Room(Player[] player, Game game) {
        this.player = player;
        this.game = game;
    }

    public Player[] getPlayer() {
        return player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
