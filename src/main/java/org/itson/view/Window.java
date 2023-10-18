package org.itson.view;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.itson.model.domain.Game;
import org.itson.view.TokenView;


public class Window extends JFrame implements Runnable {
    private static Window instance;
    private Thread gameThread;
    private Game game; 
    private Sprite sprite;
    private List<TokenView> dominoTiles;

    private Window() {
        setTitle("Juego de Dominó");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        // Inicializar la lista de fichas de dominó
        dominoTiles = new ArrayList<>();

        // Agregar algunas fichas de dominó de ejemplo
        dominoTiles.add(new TokenView("/assets/1.jpg", "/assets/1.jpg"));
        dominoTiles.add(new TokenView("/assets/1.jpg", "/assets/2.jpg"));
        dominoTiles.add(new TokenView("/assets/2.jpg", "/assets/4.jpg"));
        dominoTiles.add(new TokenView("/assets/3.jpg", "/assets/6.jpg"));
        dominoTiles.add(new TokenView("/assets/4.jpg", "/assets/2.jpg"));

        // Agregar las fichas de dominó a la ventana
        for (TokenView tile : dominoTiles) {
            add(tile);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window view = new Window();
            view.setVisible(true);
        });
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
//        this.keyListener = new KeyListener();
//        this.addKeyListener(keyListener);
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
                delta--;
            }    
            Display.get().repaint();
        }
    }
}
