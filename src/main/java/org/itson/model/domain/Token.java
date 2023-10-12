package org.itson.model.domain;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import org.itson.utils.Vector2;
import org.itson.view.Sprite;

public class Token extends Entity {
    private Face[] faces;
    private Vector2 position;

    public Token(Sprite face1Sprite, int face1Valor, Sprite face2Sprite, int face2Valor, Vector2 position) {
        this.faces = new Face[2];
        this.faces[0] = new Face(face1Sprite, face1Valor);
        this.faces[1] = new Face(face2Sprite, face2Valor);
        this.position = position;
    }

    private class Face {
        private Sprite sprite;
        private int valor;

        public Face(Sprite sprite, int valor) {
            this.sprite = sprite;
            this.valor = valor;
        }

        public Sprite getSprite() {
            return sprite;
        }

        public int getValor() {
            return valor;
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
