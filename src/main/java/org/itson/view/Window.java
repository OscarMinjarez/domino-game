package org.itson.view;

import javax.swing.JFrame;

public class Window extends JFrame {
    private static Window instance;

    private MouseListener mouseListener;
    private KeyListener keyListener;
    

    private Window() {
        super("Mi juego");
    }
    
    public static Window get() {
        if (Window.instance == null) {
            Window.instance = new Window();
        }
        
        return Window.instance;
    }
    
    public void run() {
        this.init();
        this.run();
    }
    
    public void init() {
        this.setSize(GamePanel.getScreenWidth(), GamePanel.getScreenHeight());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        // Crea una instancia de MouseListener
        this.mouseListener = new MouseListener();

        // Crea una instancia de InputListener
        this.keyListener = new KeyListener();

        // Agrega los oyentes de eventos a la ventana
        this.addMouseListener(mouseListener);
        this.addKeyListener(keyListener);
        
        this.add(GamePanel.get());

        // Muestra la ventana
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void loop() {
        
    }
}
