//Clase tablero
package org.itson.model;

/**
 *
 * @author arace
 */
public class Board {

    private Token tokens[];

    public Board() {
    }

    public Board(Token[] tokens) {
        this.tokens = tokens;
    }

    public Token[] getTokens() {
        return tokens;
    }

    public void setTokens(Token[] tokens) {
        this.tokens = tokens;
    }

}
