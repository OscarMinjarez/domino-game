package org.itson.room;

import org.itson.game.Game;
import org.itson.player.Player;

/**
 * Clase que representa una sala en el contexto de un juego. Una sala contiene un conjunto de jugadores
 * y un juego en curso.
 * @author arace
 */
public class Room {
    private Player player[];
    private Game game;
    /**
     * Constructor por defecto de la clase Room. Inicializa una sala sin jugadores ni juego.
     */
    public Room() {
    }

    /**
     * Constructor de la clase Room que permite especificar un arreglo de jugadores y un juego para la sala.
     * @param player Un arreglo de jugadores en la sala.
     * @param game El juego en curso en la sala.
     */
    public Room(Player[] player, Game game) {
        this.player = player;
        this.game = game;
    }

    /**
     * Obtiene el arreglo de jugadores en la sala.
     * @return Un arreglo de jugadores en la sala.
     */
    public Player[] getPlayer() {
        return player;
    }

    /**
     * Establece el arreglo de jugadores en la sala.
     *
     * @param player Un arreglo de jugadores que se asociarán a la sala.
     */
    public void setPlayer(Player[] player) {
        this.player = player;
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
}