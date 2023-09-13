/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.src;

import java.awt.Dimension;
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
        
        while (this.isRunning) {
            this.update();
            this.render();
            this.draw();
        }
    }
    
    private int x = 0;
    
    public void update() {
        System.out.println(this.x++);
    }
    
    public void render() {
        
    }
    
    public void draw() {
        
    }
}
