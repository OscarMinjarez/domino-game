
package org.itson.model.domain;

import org.itson.model.enums.TokenHorVer;
import org.itson.model.enums.TokenPosition;
import org.itson.utils.Vector2;
import org.itson.view.Sprite;


/**
 * Clase que representa un token específico llamado MuleToken, que es una extensión de la clase Token.
 */
public class MuleToken extends Token {
     /**
     * Constructor de la clase MuleToken.
     * @param faceSprite     El sprite que representa la cara del token.
     * @param valor          El valor asociado al token.
     * @param position       La posición en el mundo virtual donde se coloca el token.
     * @param tokenHorVer    La orientación horizontal o vertical del token.
     * @param tokenPosition  La posición específica del token en el mundo virtual.
     */
    public MuleToken(Sprite faceSprite, int valor, Vector2 position, TokenHorVer tokenHorVer, TokenPosition tokenPosition) {
        super(faceSprite, valor, faceSprite, valor, position, tokenHorVer, tokenPosition);
    }

}