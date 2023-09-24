package org.itson.domino.game;

import javax.swing.SwingUtilities;
import org.itson.view.Window;

/**
 *
 * @author arace
 */
public class DominoGame {

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        Window window = Window.get();
        window.startGameThread(); // Inicia el bucle del juego
    });
}
}
