package org.itson.model.domain;

import java.awt.Graphics;

import org.itson.view.Display;
import org.itson.view.Sprite;
/**
 * Clase que representa el juego y administra el token en un mundo virtual.
 */
public class Game {

    private Board board;
    private Token token;
    private Sprite sprite;
    private TokenManager tokenManager;

    /**
     * Constructor de la clase Game. Inicializa la instancia del juego con un administrador de tokens y
     * genera un token aleatorio.
     *
     * @param tokenManager El administrador de tokens que se utilizará en el juego.
     */
    public Game(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
        token = tokenManager.generateRandomToken();
    }
     /**
     * Inicia la generación de tokens en el juego utilizando el administrador de tokens.
     */
    public void startTokenGeneration() {
        tokenManager.startTokenGeneration();
    }
    /**
     * Detiene la generación de tokens en el juego utilizando el administrador de tokens.
     */
    public void stopTokenGeneration() {
        tokenManager.stopTokenGeneration();
    }
    /**
     * Carga la imagen del token actual en el juego y la muestra en la pantalla.
     */
    public void loadTokenImage() {   
    tokenManager.loadTokenImage(token);
    Display.get().addSprite(token.getSprite());
}
    /**
     * Actualiza el estado del token en el juego.
     */
    public void update() {
        token.update();
    }
    
    /**
     * Obtiene el token actual en el juego.
     * @return El token actual en el juego.
     */
    public Token getToken() {
    return token;
}
     /**
     * Dibuja el token en la pantalla utilizando las coordenadas proporcionadas con un desplazamiento.
     * @param g  El objeto Graphics utilizado para dibujar.
     * @param xOffset  El desplazamiento horizontal.
     * @param yOffset  El desplazamiento vertical.
     */
    public void draw(Graphics g, int xOffset, int yOffset) {
    int x = (int) token.getPosition().getX() + xOffset;
    int y = (int) token.getPosition().getY() + yOffset;
    token.draw(g, Display.get());
    }
}