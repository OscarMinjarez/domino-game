/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author arace
 */
public class Display extends JPanel {

    private static Display instance;

    private static final int originalTitleSize = 16;
    private static final int scale = 3;
    private static final int titleSize = originalTitleSize * scale;
    public static final int maxScreeenCol = 16;
    public static final int maxScreenRow = 12;
    private static final int screenWidth = titleSize * maxScreeenCol;
    private static final int screenHeight = titleSize * maxScreenRow;
    private Grid grid;

    public Display(Grid grid) {
        this.grid = grid;

    }

    public Display() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addMouseListener(MouseListener.get());
        this.addMouseMotionListener(MouseListener.get());
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int tileWidth = screenWidth / maxScreeenCol;
        int tileHeight = screenHeight / maxScreenRow;

        for (int i = 0; i < maxScreeenCol; i++) {
            for (int j = 0; j < maxScreenRow; j++) {
                Tile tile = grid.getTile(i, j);
                int x = i * tileWidth;
                int y = j * tileHeight;

                g.drawRect(x, y, tileWidth, tileHeight); 

              
                g.setColor(Color.RED); 

                // Línea horizontal
                g.drawLine(x, y + tileHeight, x + tileWidth, y + tileHeight);

                // Línea vertical
                g.drawLine(x + tileWidth, y, x + tileWidth, y + tileHeight);
            }
        }
    }

    public static Display get() {
        if (Display.instance == null) {
            Display.instance = new Display();
        }

        return Display.instance;
    }

    public static int getScreenWidth() {
        return get().screenWidth;
    }

    public static int getScreenHeight() {
        return get().screenHeight;
    }
}
