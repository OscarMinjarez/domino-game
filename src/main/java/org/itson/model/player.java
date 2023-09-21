//Clase jugador
package org.itson.model;

/**
 *
 * @author arace
 */
public class Player {

    private Avatar Avatar;
    private Token tokens[];

    public Player() {
    }

    public Player(Avatar Avatar, Token[] tokens) {
        this.Avatar = Avatar;
        this.tokens = tokens;
    }

    public Avatar getAvatar() {
        return Avatar;
    }

    public void setAvatar(Avatar Avatar) {
        this.Avatar = Avatar;
    }

    public Token[] getTokens() {
        return tokens;
    }

    public void setTokens(Token[] tokens) {
        this.tokens = tokens;
    }

}
