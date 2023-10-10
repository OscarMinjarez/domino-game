package org.itson.model.domain;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import org.itson.utils.Vector2;
import org.itson.view.Display;
import org.itson.view.Sprite;

/**
 *
 * @author arace
 */
public class Token extends Entity {

    private Face[] faces;
    private Vector2 position; // Agrega una posición para el token

    public Token() {

    }

    public Token(Vector2 position) {
        this.faces = new Face[2];
        this.position = position;
    }

    private class Face {

        private Sprite sprite;
        private int valor;

        public Face(Sprite sprite, int valor) {
            this.sprite = sprite;
            this.valor = valor;
        }

        public Face() {

        }

        public Sprite getSprite() {
            return sprite;
        }

        public void setSprite(Sprite sprite) {
            this.sprite = sprite;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    public void draw(Graphics g, ImageObserver observer) {
//        sprite.draw(g, observer);
    }

    @Override
    public void update() {
        // Si el sprite está siendo arrastrado, actualiza su posición según la posición del mouse
//        if (sprite.isDragging()) {
//            int mouseX = (int) Display.get().getMousePosition().getX();
//            int mouseY = (int) Display.get().getMousePosition().getY();
//            setPosition(new Vector2(mouseX, mouseY));
//        }
    }

}
