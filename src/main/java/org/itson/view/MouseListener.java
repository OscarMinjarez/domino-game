/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author arace
 */
public class MouseListener extends MouseAdapter implements MouseMotionListener {
    private static MouseListener instance;
    
    private Sprite selectedSprite;
    
    private MouseListener() {
    }
    
    public static MouseListener get() {
        if (MouseListener.instance == null) {
            MouseListener.instance = new MouseListener();
        }
        
        return MouseListener.instance;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Sprite image : Display.getSprites()) {
            if (image.getBounds().contains(e.getPoint())) {
                this.selectedSprite = image;
                this.selectedSprite.setIsDragging(true);
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.selectedSprite != null) {
            this.selectedSprite.setIsDragging(false);
        }
        
        this.selectedSprite = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Procesa el evento de clic del mouse
        System.out.println("Mouse clickeado en la ubicación: (" + e.getX() + ", " + e.getY() + ")");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Procesa el evento de entrada del mouse en la ventana
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Procesa el evento de salida del mouse de la ventana
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.selectedSprite != null && this.selectedSprite.isDragging()) {
            this.selectedSprite.updatePosition(e.getX(), e.getY());
        }
    }
}
