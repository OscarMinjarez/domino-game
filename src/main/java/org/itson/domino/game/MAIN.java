package org.itson.domino.game;

import org.itson.utils.Tile;
import org.itson.utils.Grid;
import java.util.List;
import javax.swing.JFrame;
import org.itson.engine.FrmGame;
import org.itson.game.Game;
import org.itson.token.TokenView;

public class MAIN extends JFrame implements Runnable {

    private static MAIN instance;
    private Thread gameThread;
    private Game game;

    private List<TokenView> dominoTiles;

    private FrmGame display;

    private MAIN() {
        super("Mi juego");

    }

    public static MAIN get() {
        if (MAIN.instance == null) {
            MAIN.instance = new MAIN();
        }

        return MAIN.instance;
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
        this.add(FrmGame.get());

        int maxScreeenCol = FrmGame.maxScreeenCol;
        int maxScreenRow = FrmGame.maxScreenRow;
        Grid grid = new Grid(maxScreeenCol, maxScreenRow, new Tile[maxScreeenCol][maxScreenRow]);
        this.display = new FrmGame(grid); // Aquí se crea el Display y se pasa el Grid

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

            FrmGame.get().repaint();
        }
    }

    public void setDisplay(FrmGame display) {
        this.display = display;
    }
    
    public static void main(String args[]){
        
        get().run();
        
    }
}
