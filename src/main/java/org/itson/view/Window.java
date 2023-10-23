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


    
    private Display display;

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
//        this.keyListener = new KeyListener();
//        this.addKeyListener(keyListener);
        this.add(Display.get());

        int maxScreeenCol = Display.maxScreeenCol;
        int maxScreenRow = Display.maxScreenRow;
        Grid grid = new Grid(maxScreeenCol, maxScreenRow, new Tile[maxScreeenCol][maxScreenRow]);
        this.display = new Display(grid); // Aquí se crea el Display y se pasa el Grid

        this.add(display);
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

            if (delta >= 1) {

                delta--;
            }

            Display.get().repaint();
        }
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
