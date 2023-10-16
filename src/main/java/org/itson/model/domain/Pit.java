
package org.itson.model.domain;

/**
 * Clase que representa un pozo (Pit) en un mundo virtual. Un pozo es una entidad que puede contener
 * múltiples tokens.
 * @author luis-
 */

public class Pit extends Entity {
    private Token tokens[];
     /**
     * Constructor por defecto de la clase Pit. Inicializa un pozo sin tokens.
     */
    public Pit() {
    }
    /**
     * Constructor de la clase Pit que permite especificar los tokens iniciales contenidos en el pozo.
     * @param tokens Un arreglo de tokens que se colocarán en el pozo.
     */
    public Pit(Token[] tokens) {
        this.tokens = tokens;
    }
     /**
     * Obtiene los tokens contenidos en el pozo.
     * @return Un arreglo de tokens en el pozo.
     */
    public Token[] getTokens() {
        return tokens;
    }
    /**
     * Establece los tokens contenidos en el pozo.
     * @param tokens Un arreglo de tokens que se colocarán en el pozo.
     */
    public void setTokens(Token[] tokens) {
        this.tokens = tokens;
    }
  
}
