package org.itson.model.domain;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import org.itson.model.enums.TokenHorVer;
import org.itson.model.enums.TokenPosition;
import org.itson.utils.Vector2;
import org.itson.view.Sprite;

public class Token extends Entity {

    private Face[] faces;
    private Vector2 position;
    private TokenHorVer tokenHorVer;

    public Token(Sprite face1Sprite, int face1Valor, Sprite face2Sprite, int face2Valor, Vector2 position, TokenHorVer tokenHorVer, TokenPosition tokenPosition) {
        this.faces = new Face[2];
        this.faces[0] = new Face(face1Sprite, face1Valor, tokenPosition);
        this.faces[1] = new Face(face2Sprite, face2Valor, tokenPosition);
        this.position = position;
        this.tokenHorVer = tokenHorVer;
    }

    public class Face {

        private Sprite sprite;
        private int value;
        private TokenPosition tokenPosition;

        public Face(Sprite sprite, int valor, TokenPosition tokenPosition) {
            this.sprite = sprite;
            this.value = value;
            this.tokenPosition = tokenPosition;
        }

        public Face() {

        }

        public Sprite getSprite() {
            return sprite;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setTokenPosition(TokenPosition tokenPosition) {
            this.tokenPosition = tokenPosition;
        }

    }

    public Face[] getFaces() {
        return faces;
    }

    public void setFaces(Face[] faces) {
        this.faces = faces;
    }

    public TokenHorVer getTokenHorVer() {
        return tokenHorVer;
    }

    public void setTokenHorVer(TokenHorVer tokenHorVer) {
        this.tokenHorVer = tokenHorVer;
    }

    public void setTokenPosition(TokenPosition tokenPosition) {
        this.faces[0].setTokenPosition(tokenPosition);

        if (tokenHorVer == TokenHorVer.HORIZONTAL) {
            if (tokenPosition == TokenPosition.TOP) {
                this.faces[1].setTokenPosition(TokenPosition.RIGHT);
            } else if (tokenPosition == TokenPosition.BOTTOM) {
                this.faces[1].setTokenPosition(TokenPosition.LEFT);
            }
        } else {
            if (tokenPosition == TokenPosition.LEFT) {
                this.faces[1].setTokenPosition(TokenPosition.TOP);
            } else if (tokenPosition == TokenPosition.RIGHT) {
                this.faces[1].setTokenPosition(TokenPosition.BOTTOM);
            }
        }
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    public void draw(Graphics g, ImageObserver observer) {
        // Dibuja las caras del token usando faces[0].getSprite() y faces[1].getSprite()
        // Asegúrate de gestionar la posición adecuadamente durante el dibujo.
    }

    @Override
    public void update() {
        // Actualiza la lógica del token si es necesario.
    }
}
