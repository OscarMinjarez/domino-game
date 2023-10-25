package org.itson.player;

import org.itson.model.domain.Avatar;
import org.itson.token.Token;

/**
 * Clase que representa a un jugador en el contexto de un juego. Un jugador tiene un avatar y puede
 * poseer una colección de tokens
 * @author arace
 */
public class Player {
    private Avatar avatar;
    private Token tokens[];
     /**
     * Constructor por defecto de la clase Player. Inicializa un jugador sin avatar ni tokens.
     */
    public Player() {
    }
    /**
     * Constructor de la clase Player que permite especificar un avatar y una colección de tokens
     * para el jugador.
     * @param avatar El avatar asociado al jugador.
     * @param tokens Un arreglo de tokens que pertenecen al jugador.
     */
    public Player(Avatar avatar, Token[] tokens) {
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
    public Token[] getTokens() {
        return tokens;
    }

    /**
     * Establece la colección de tokens que pertenecen al jugador.
     * @param tokens Un arreglo de tokens que se asociarán al jugador.
     */
    public void setTokens(Token[] tokens) {
        this.tokens = tokens;
    }
}
