package org.itson.room;

import java.util.ArrayList;
import java.util.List;
import org.itson.game.Game;
import org.itson.player.Player;

/**
 * Clase que representa una sala en el contexto de un juego. Una sala contiene un conjunto de jugadores
 * y un juego en curso.
 * @author arace
 */
public class Room {
    private List<Player> players;
    private Game game;
    /**
     * Constructor por defecto de la clase Room. Inicializa una sala sin jugadores ni juego.
     */
    public Room() {
        this.players = new ArrayList<>();
    }

    /**
     * Constructor de la clase Room que permite especificar un arreglo de jugadores y un juego para la sala.
     * @param game El juego en curso en la sala.
     */
    public Room(Game game) {
        this.players = new ArrayList<>();
        this.game = game;
    }

    /**
     * Obtiene el arreglo de jugadores en la sala.
     * @return Un arreglo de jugadores en la sala.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Establece el arreglo de jugadores en la sala.
     *
     * @param players Un arreglo de jugadores que se asociarán a la sala.
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Obtiene el juego en curso en la sala.
     * @return El juego en curso en la sala.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Establece el juego en curso en la sala.
     * @param game El juego que se asociará a la sala.
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public String toString() {
        return "Room{" + "players=" + players + ", game=" + game + '}';
    }
}