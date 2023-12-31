package org.itson.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.itson.model.domain.Avatar;
import org.itson.token.Token;
import org.itson.token.TokenComponent;

/**
 * Clase que representa a un jugador en el contexto de un juego. Un jugador tiene un avatar y puede
 * poseer una colección de tokens
 * @author arace
 */
public class Player implements Serializable {
    private Avatar avatar;
    private List<TokenComponent> tokens;
    private String name;
    
     /**
     * Constructor por defecto de la clase Player. Inicializa un jugador sin avatar ni tokens.
     */
    public Player() {
        this.tokens = new ArrayList<>();
    }
    /**
     * Constructor de la clase Player que permite especificar un avatar y una colección de tokens
     * para el jugador.
     * @param avatar El avatar asociado al jugador.
     * @param tokens Un arreglo de tokens que pertenecen al jugador.
     * @param name Nombre del jugador
     */
    public Player(Avatar avatar, List<TokenComponent> tokens, String name) {
        this.tokens = new ArrayList<>();
        this.avatar = avatar;
        this.tokens = tokens;
    }
    /**
     * Obtiene el avatar asociado al jugador.
     * @return El avatar del jugador.
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     * Establece el avatar asociado al jugador.
     * @param avatar El avatar que se asociará al jugador.
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * Obtiene la colección de tokens que pertenecen al jugador.
     * @return Un arreglo de tokens que pertenecen al jugador.
     */
    public List<TokenComponent> getTokens() {
        return tokens;
    }

    /**
     * Establece la colección de tokens que pertenecen al jugador.
     * @param tokens Un arreglo de tokens que se asociarán al jugador.
     */
    public void setTokens(List<TokenComponent> tokens) {
        this.tokens = tokens;
    }
    
    public void addToken(Token token) {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" + "avatar=" + avatar + ", tokens=" + tokens + ", name=" + name + '}';
    }
}
