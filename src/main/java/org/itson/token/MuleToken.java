
package org.itson.token;

import java.io.IOException;

/**
 * Clase que representa un token específico llamado MuleToken, que es una extensión de la clase Token.
 */
public class MuleToken extends Token {
    
    public MuleToken(int value1, int value2) throws IOException {
        super(value1, value2);
    }
    
    public int getValue() {
        return super.getFaces()[0].getValue();
    }
}