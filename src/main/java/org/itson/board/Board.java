package org.itson.board;

import org.itson.model.domain.Entity;
import org.itson.token.Token;

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
     * Agrega un token al tablero
     * 
     * @param token token a agregar
     * @throws IllegalArgumentException si el token es nulo
     * @throws IllegalStateException si el tablero está lleno
     */
    public void addToken(Token token) {
    if (token == null) {
        throw new IllegalArgumentException("Token cannot be null");
    }

    int currentIndex = 0;
    while (currentIndex < tokens.length && tokens[currentIndex] != null) {
        currentIndex++;
    }

    if (currentIndex < tokens.length) {
        tokens[currentIndex] = token;
    } else {
        throw new IllegalStateException("The board is already full.");
    }
}
    
}
