package org.itson.model.domain;

/**
 * Clase tablero 
 * @author arace
 */
public class Board extends Entity {
    private Token tokens[];
    /**
     * Metodo contructor
     */
    public Board() {
    }
    /**
     * 
     * @param tokens 
     */
    public Board(Token[] tokens) {
        this.tokens = tokens;
    }
    /**
     * Obtiene los tokens
     * @return 
     */
    public Token[] getTokens() {
        return tokens;
    }
    /**
     * Establece los tokens
     * @param tokens 
     */
    public void setTokens(Token[] tokens) {
        this.tokens = tokens;
    }
}
