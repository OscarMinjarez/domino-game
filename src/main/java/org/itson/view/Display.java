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
    private static final int maxScreeenCol = 16;
    private static final int maxScreenRow = 12;
    private static final int screenWidth = titleSize * maxScreeenCol;
    private static final int screenHeight = titleSize * maxScreenRow;
    private static List<Sprite> sprites = new ArrayList<>();

    public void addSprite(Sprite sprite) {
        get().sprites.add(sprite);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el juego en el panel
        for (Sprite image : get().sprites) {
            image.draw(g, this);
        }
    }

    public Display() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addMouseListener(MouseListener.get());
        this.addMouseMotionListener(MouseListener.get());
    }

    public static Display get() {
        if (Display.instance == null) {
            Display.instance = new Display();
        }

        return Display.instance;
    }

    public static List<Sprite> getSprites() {
        return get().sprites;
    }

    public static int getScreenWidth() {
        return get().screenWidth;
    }

    public static int getScreenHeight() {
        return get().screenHeight;
    }
}
