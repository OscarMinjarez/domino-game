package org.itson.view;

// Clase Window

import javax.swing.JFrame;

public class Window extends JFrame {

    private MouseListener mouseListener;
    private KeyListener keyListener;

    public Window() {
        super("Mi juego");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crea una instancia de MouseListener
        mouseListener = new MouseListener();

        // Crea una instancia de InputListener
        keyListener = new KeyListener();

        // Agrega los oyentes de eventos a la ventana
        addMouseListener(mouseListener);
        addKeyListener(keyListener);

        // Muestra la ventana
        setVisible(true);
    }
}
