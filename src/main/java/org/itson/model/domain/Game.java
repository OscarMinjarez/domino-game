package org.itson.model.domain;

import java.awt.Graphics;
import org.itson.utils.TokenManager;
import org.itson.view.Display;
import org.itson.view.Sprite;

public class Game {

    private Board board;
    private Token token;
    private Sprite sprite;
    private TokenManager tokenManager;

    public Game(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
        token = tokenManager.generateRandomToken();
    }

    public void startTokenGeneration() {
        tokenManager.startTokenGeneration();
    }

    public void stopTokenGeneration() {
        tokenManager.stopTokenGeneration();
    }

    public void loadTokenImage() {
        
    tokenManager.loadTokenImage(token);
    // Agregar el token al Display después de cargar la imagen
    Display.get().addSprite(token.getSprite());
}

    public void update() {
        // Actualiza la lógica del juego
        token.update();
    }

    public Token getToken() {
    return token;
}
    
    public void draw(Graphics g, int xOffset, int yOffset) {
    // Dibuja el token en el panel teniendo en cuenta el xOffset y yOffset
    int x = (int) token.getPosition().getX() + xOffset;
    int y = (int) token.getPosition().getY() + yOffset;
    token.draw(g, Display.get());
    }
}