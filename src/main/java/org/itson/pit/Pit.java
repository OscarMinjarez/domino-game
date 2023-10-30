
package org.itson.pit;

import java.util.List;
import org.itson.model.domain.Entity;
import org.itson.token.Token;

/**
 * Clase que representa un pozo (Pit) en un mundo virtual. Un pozo es una entidad que puede contener
 * múltiples tokens.
 * @author luis-
 */

public class Pit extends Entity {
    private List<Token> tokens;
    
     /**
     * Constructor por defecto de la clase Pit. Inicializa un pozo sin tokens.
     */
    public Pit() {
    }
    
    /**
     * Constructor de la clase Pit que permite especificar los tokens iniciales contenidos en el pozo.
     * @param tokens Un arreglo de tokens que se colocarán en el pozo.
     */
    public Pit(List<Token> tokens) {
        this.tokens = tokens;
    }
    
     /**
     * Obtiene los tokens contenidos en el pozo.
     * @return Un arreglo de tokens en el pozo.
     */
    public List<Token> getTokens() {
        return tokens;
    }
    
    /**
     * Establece los tokens contenidos en el pozo.
     * @param tokens Un arreglo de tokens que se colocarán en el pozo.
     */
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
    
    public int getTokensQuantity() {
        return this.tokens.size();
    }
    
    public Token removeToken(int index) { 
        return this.tokens.remove(index);
    }

    @Override
    public String toString() {
        return "Pit{" + "tokens=" + tokens + '}';
    }
}
