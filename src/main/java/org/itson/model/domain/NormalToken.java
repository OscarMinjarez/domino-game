package org.itson.model.domain;

import org.itson.utils.Vector2;
import org.itson.view.Sprite;



public class NormalToken extends Token {
    public NormalToken(Sprite face1Sprite, int face1Valor, Sprite face2Sprite, int face2Valor, Vector2 position) {
        super(face1Sprite, face1Valor, face2Sprite, face2Valor, position);
    }

}