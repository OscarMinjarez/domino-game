package org.itson.game;

import java.util.List;
import org.itson.board.Board;
import org.itson.pit.Pit;
import org.itson.player.Player;
import org.itson.token.Token;

/**
 * Clase que representa el juego.
 */
public class Game {

    private Board board;
    private Pit pit;
    private List<Player> players;

    /**
     * Constructor de la clase Game.
     *
     *
     */
    public Game() {

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Pit getPit() {
        return pit;
    }

    public void setPit(Pit pit) {
        this.pit = pit;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public String toString() {
        return "Game{" + "board=" + board + ", pit=" + pit + ", players=" + players + '}';
    }

    
}
