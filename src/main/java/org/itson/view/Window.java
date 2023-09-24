package org.itson.view;

import javax.swing.JFrame;
import org.itson.model.domain.Game;
import org.itson.utils.TokenManager;

public class Window extends JFrame implements Runnable {

    private static Window instance;

    private KeyListener keyListener;
    private Thread gameThread;
    private Game game; // Agrega una referencia al objeto Game
    private TokenManager tokenManager; // Agrega una referencia al TokenManager
    private Sprite sprite;

    private Window() {
        super("Mi juego");
    }

    public static Window get() {
        if (Window.instance == null) {
            Window.instance = new Window();
        }

        return Window.instance;
    }

    @Override
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

        // Crea una instancia de TokenManager y Game
        tokenManager = new TokenManager(sprite);
        game = new Game(tokenManager);

        // Inicia la generación de tokens
        game.startTokenGeneration();

        // Carga la imagen del token en Game
        game.loadTokenImage();


        // Muestra la ventana después de configurar todo
        this.add(Display.get());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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
                game.update();
                delta--;
            }

            // Solicita que se repinte el panel para dibujar los tokens
            Display.get().repaint();
        }
    }
}
