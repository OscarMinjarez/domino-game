package org.itson.token;

import java.io.IOException;
import org.itson.utils.Vector2;

/**
 * Clase que representa un token específico llamado NormalToken, que es una
 * extensión de la clase Token.
 */
public class NormalToken extends Token {

    public NormalToken(int value1, int value2) throws IOException {
        super(value1, value2);
    }
    
    /**
     * Constructor de la clase NormalToken.
     *
     * @param face1Valor El valor asociado a la primera cara del token.
     * @param face2Valor El valor asociado a la segunda cara del token.
     * @param position La posición en el mundo virtual donde se coloca el token.
     * @param tokenHorVer La orientación horizontal o vertical del token.
     * @param tokenPosition La posición específica del token en el mundo
     * virtual.
     */
    public NormalToken(int face1Valor, int face2Valor, Vector2 position, TokenHorVer tokenHorVer, TokenPosition tokenPosition) throws IOException {
        super(face1Valor, face2Valor, position, tokenHorVer, tokenPosition);
    }

}
