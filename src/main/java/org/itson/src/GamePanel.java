
package org.itson.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class GamePanel extends JPanel implements Runnable {
    public static int width;
    public static int height;
    
    private Thread thread;
    private boolean isRunning = false;
    
    private BufferedImage image;
    private Graphics2D g;
    
    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);
        this.requestFocus();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        
        if (this.thread == null) {
            this.thread = new Thread(this, "GameThread");
            this.thread.start();
        }
    }
    
    public void init() {
        this.isRunning = true;
        
        this.image = new BufferedImage(GamePanel.width, GamePanel.height, BufferedImage.TYPE_INT_ARGB);
        this.g = (Graphics2D) this.image.getGraphics();
    }

    @Override
    public void run() {
        this.init();
        
        final double GAME_HERTZ = 60.0;
        final double TIME_BEFORE_UPDATE = 1_000_000_000 / GAME_HERTZ;
        
        final int MUST_UPDATE_BEFORE_RENDER = 5;
        
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;
        
        final double TARGET_FPS = 60;
        final double TOTAL_TIME_BEFORE_RENDER = 1_000_000_000 / TARGET_FPS;
        
        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1_000_000_000);
        int oldFrameCount = 0;
        
        while (this.isRunning) {
            double now = System.nanoTime();
            int updateCount = 0;
            
            while (((now - lastUpdateTime) > TIME_BEFORE_UPDATE) && (updateCount < MUST_UPDATE_BEFORE_RENDER)) {
                this.input();
                this.update();
                
                lastUpdateTime += TIME_BEFORE_UPDATE;
                updateCount++;
            }
            
            if ((now - lastUpdateTime) > TIME_BEFORE_UPDATE) {
                lastUpdateTime = now - TIME_BEFORE_UPDATE;
            }
            
            this.input();
            this.render();
            this.draw();
            
            lastRenderTime = now;
            frameCount++;
            
            int thisSecond = (int) (lastUpdateTime / 1_000_000_000);
            
            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {
                    System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                    oldFrameCount = frameCount;
                }
                
                frameCount = 0;
                lastSecondTime = thisSecond;
            }
            
            while (now - lastRenderTime < TOTAL_TIME_BEFORE_RENDER && now - lastUpdateTime < TIME_BEFORE_UPDATE) {
                Thread.yield();
                
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
                
                now = System.nanoTime();
            }
        }
    }

    public void input() {
        
    }
    
    public void update() {
        
    }
    
    public void render() {
        if (this.g != null) {
            g.setColor(new Color(66, 134, 244));
            g.fillRect(0, 0, this.width, this.height);
        }
    }
    
    public void draw() {
        Graphics g2 = (Graphics2D) this.getGraphics();
        g2.drawImage(this.image, 0, 0, this.width, this.height, null);
        g2.dispose();
    }
}
