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
    /** 
     * Metodo que actualiza los tokens
     * Falta modificar
     */
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
