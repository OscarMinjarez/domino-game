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
    private List<Sprites> images = new ArrayList<>();
    private Sprites seleccionaImagen = null;

    public void agregarImagen(Sprites image) {
        images.add(image);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Sprites image : images) {
            image.draw(g, this);
        }
    }
    
    public Display() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (Sprites image : images) {
                    if (image.getBounds().contains(e.getPoint())) {
                        seleccionaImagen = image;
                        seleccionaImagen.setIsDragging(true);
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (seleccionaImagen != null) {
                    seleccionaImagen.setIsDragging(false);
                }
                seleccionaImagen = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (seleccionaImagen != null && seleccionaImagen.isDragging()) {
                    seleccionaImagen.updatePosition(e.getX(), e.getY());
                    repaint();
                }
            }
        });
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
