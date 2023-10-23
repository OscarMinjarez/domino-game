/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.frames;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class TokenView extends JPanel {
    private BufferedImage image1;
    private BufferedImage image2;
    
    private int value1;
    private int value2;
    
    private int startX, startY;
    private boolean isDragging = false;

    public TokenView(String image1Path, String image2Path) {
        try {
            this.image1 = ImageIO.read(getClass().getResource(image1Path));
            this.image2 = ImageIO.read(getClass().getResource(image2Path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        this.setPreferredSize(new Dimension(16, 32)); // Tamaño de la ficha
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isDragging) {
                    // setLocation(startX, startY);
                    isDragging = false;
                }
            }
        });
        
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Mueve la ficha mientras el mouse se arrastra
                isDragging = true;
                int deltaX = e.getX() - startX;
                int deltaY = e.getY() - startY;
                setLocation(getX() + deltaX, getY() + deltaY);
            }
        });

        // Puedes personalizar la representación de la ficha aquí, como agregar imágenes o dibujar los valores en el panel.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (image1 != null && image2 != null) {
            g.drawImage(image1, 0, 0, this);
            g.drawImage(image2, 0, 60, this);
        }
    }
}
