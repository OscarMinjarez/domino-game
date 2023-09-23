/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author arace
 */
public class GamePanel extends JPanel {
    private static GamePanel instance;

    private static final int originalTitleSize = 16;
    private static final int scale = 3;
    private static final int titleSize = originalTitleSize * scale;
    private static final int maxScreeenCol = 16;
    private static final int maxScreenRow = 12;
    private static final int screenWidth = titleSize * maxScreeenCol;
    private static final int screenHeight = titleSize * maxScreenRow;
    
    private GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }
    
    public static GamePanel get() {
        if (GamePanel.instance == null) {
            GamePanel.instance = new GamePanel();
        }
        
        return GamePanel.instance;
    }
    
    public static int getScreenWidth() {
        return get().screenWidth;
    }
    
    public static int getScreenHeight() {
        return get().screenHeight;
    }
}
