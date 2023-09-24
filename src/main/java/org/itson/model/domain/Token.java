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

   public int side1;
   public int side2;
   public Sprite sprite;
    private Vector2 position; // Agrega una posición para el token

    public Token(int side1, int side2, Sprite sprite) {
        this.side1 = side1;
        this.side2 = side2;
        this.sprite = sprite;
        this.position = new Vector2(0, 0); // Inicializa la posición en (0, 0) por defecto
    }

   @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }

   @Override
    public Vector2 getPosition() {
        return position;
    }

    public void draw(Graphics g, ImageObserver observer) {
    sprite.draw(g, observer);
    }
    
    public void setSprite(Sprite sprite) {
    this.sprite = sprite;
    }

   @Override
    public void update() {
        // Si el sprite está siendo arrastrado, actualiza su posición según la posición del mouse
        if (sprite.isDragging()) {
            int mouseX = (int) Display.get().getMousePosition().getX();
            int mouseY = (int) Display.get().getMousePosition().getY();
            setPosition(new Vector2(mouseX, mouseY));
        }
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
