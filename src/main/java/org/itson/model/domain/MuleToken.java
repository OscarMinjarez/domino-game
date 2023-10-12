
package org.itson.model.domain;

import org.itson.model.enums.TokenHorVer;
import org.itson.model.enums.TokenPosition;
import org.itson.utils.Vector2;
import org.itson.view.Sprite;



public class MuleToken extends Token {
    public MuleToken(Sprite faceSprite, int valor, Vector2 position, TokenHorVer tokenHorVer, TokenPosition tokenPosition) {
        super(faceSprite, valor, faceSprite, valor, position, tokenHorVer, tokenPosition);
    }

}