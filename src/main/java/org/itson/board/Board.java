package org.itson.board;

import java.util.ArrayList;
import java.util.List;
import org.itson.model.domain.Entity;
import org.itson.token.Token;

/**
 * Clase tablero
 *
 * @author arace
 */
public class Board extends Entity {

    private List<Token> tokens;

    /**
     * Metodo contructor
     */
    public Board() {
        this.tokens = new ArrayList<>();
    }

    /**
     *
     * @param tokens
     */
    public Board(List<Token> tokens) {
        this.tokens = tokens;
    }

    /**
     * Obtiene los tokens
     *
     * @return
     */
    public List<Token> getTokens() {
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
        this.tokens.add(token);
    }

    @Override
    public String toString() {
        return "Board{" + "tokens=" + tokens + '}';
    }
}
