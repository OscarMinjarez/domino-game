package org.itson.view;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {
    private static Window instance;

    private KeyListener keyListener;
    
    Thread gameThread;
    
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
        this.loop();
    }
    
    public void init() {
        this.setSize(Display.getScreenWidth(), Display.getScreenHeight());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        // Crea una instancia de InputListener
        this.keyListener = new KeyListener();

        // Agrega los oyentes de eventos a la ventana
        this.addKeyListener(keyListener);
        
        this.add(Display.get());

        // Muestra la ventana
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        Sprite sprite = new Sprite("src/main/java/imagenes/flechita.png",50,50);
         Display.get().addSprite(sprite);
        
    }
    
    public void startGameThread() {
       gameThread = new Thread(this); 
       gameThread.start();
    }
    
     
    // Implementa el game loop
    public void loop() {
        long lastUpdateTime = System.nanoTime();
        final double targetFPS = 60.0;
        final double nsPerFrame = 1_000_000_000.0 / targetFPS;
        double delta = 0;
        
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastUpdateTime) / nsPerFrame;
            lastUpdateTime = now;
            
            if (delta >= 1) {
                // Actualiza la lógica del juego
                delta--;
            }
            
            // Dibuja el juego en el panel
            repaint();
        }
    }
}
