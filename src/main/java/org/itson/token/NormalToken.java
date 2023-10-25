package org.itson.model.domain;

import org.itson.model.enums.TokenHorVer;
import org.itson.model.enums.TokenPosition;
import org.itson.utils.Vector2;
import org.itson.view.Sprite;


/**
 * Clase que representa un token específico llamado NormalToken, que es una extensión de la clase Token.
 */
public class NormalToken extends Token {
    /**
     * Constructor de la clase NormalToken.
     * @param face1Sprite     El sprite que representa la primera cara del token.
     * @param face1Valor      El valor asociado a la primera cara del token.
     * @param face2Sprite     El sprite que representa la segunda cara del token.
     * @param face2Valor      El valor asociado a la segunda cara del token.
     * @param position        La posición en el mundo virtual donde se coloca el token.
     * @param tokenHorVer     La orientación horizontal o vertical del token.
     * @param tokenPosition   La posición específica del token en el mundo virtual.
     */
    public NormalToken(Sprite face1Sprite, int face1Valor, Sprite face2Sprite, int face2Valor, Vector2 position, TokenHorVer tokenHorVer, TokenPosition tokenPosition) {
        super(face1Sprite, face1Valor, face2Sprite, face2Valor, position, tokenHorVer, tokenPosition);
    }

}