package org.itson.domino.game;

import org.itson.utils.Tile;
import org.itson.utils.Grid;
import java.util.List;
import javax.swing.JFrame;
import org.itson.engine.FrmGame;
import org.itson.game.Game;
import org.itson.token.TokenView;

public class Window extends JFrame implements Runnable {

    private static Window instance;
    private Thread gameThread;
    private Game game;

    private List<TokenView> dominoTiles;

    private FrmGame display;

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
        this.setSize(FrmGame.getScreenWidth(), FrmGame.getScreenHeight());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
//        this.keyListener = new KeyListener();
//        this.addKeyListener(keyListener);

        int maxScreeenCol = FrmGame.maxScreeenCol;
        int maxScreenRow = FrmGame.maxScreenRow;
        Grid grid = new Grid(maxScreeenCol, maxScreenRow, new Tile[maxScreeenCol][maxScreenRow]);
        this.display = FrmGame.get(); // Aquí se crea el Display y se pasa el Grid
        this.display.setGrid(grid);

        this.add(display);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

//    public void startGameThread() {
//        gameThread = new Thread(this);
//        gameThread.start();
//    }

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

            this.display.repaint();
        }
    }

    public void setDisplay(FrmGame display) {
        this.display = display;
    }
    
    public static void main(String args[]){
        
        get().run();
        
    }
}
