package org.itson.player;

import java.util.ArrayList;
import java.util.List;

import org.itson.token.Token;

/**
 *
 * @author arace
 */
public class PlayerComponent {

    private PlayerController playerController;
    private Player player;
    private List<Token> tokens;
    private String name;

    public PlayerComponent() {
    }

    /**
     * Constructor de la clase Player que permite especificar un avatar y una
     * colección de tokens para el jugador.
     *
     * @param avatar El avatar asociado al jugador.
     * @param tokens Un arreglo de tokens que pertenecen al jugador.
     * @param name Nombre del jugador
     */
    public PlayerComponent( List<Token> tokens, String name) {
        this.tokens = new ArrayList<>();
      
        this.tokens = tokens;
        this.name = name;
    }

    public Player getPlayer() {
        return this.playerController.getPlayer();
    }

    @Override
    public String toString() {
        return "PlayerComponent{" + "playerController=" + playerController + ", player=" + player + ", tokens=" + tokens + ", name=" + name + '}';
    }

    

}
