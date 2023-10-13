package org.itson.domino.game;

import javax.swing.SwingUtilities;
import org.itson.view.Window;

/**
 * Esta es la clase que hace la funcion de iniciar el juego
 * @author arace
 */
public class DominoGame {

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        Window window = Window.get();
        window.startGameThread(); 
    });
}
}
