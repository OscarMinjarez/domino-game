package org.itson.view;

import javax.swing.JFrame;
import org.itson.model.domain.Game;


public class Window extends JFrame implements Runnable {

    private static Window instance;

    private KeyListener keyListener;
    private Thread gameThread;
    private Game game; 
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

      
        this.keyListener = new KeyListener();


        this.addKeyListener(keyListener);

  
        
  
        game.startTokenGeneration();

  
        game.loadTokenImage();



        this.add(Display.get());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    

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

                game.update();
                delta--;
            }

            
            Display.get().repaint();
        }
    }
}
