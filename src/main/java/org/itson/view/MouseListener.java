/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MouseListener extends MouseAdapter implements MouseMotionListener {
    private static MouseListener instance;

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
        for (Sprite sprite : Display.getSprites()) {
            if (sprite.getBounds().contains(e.getPoint())) {
                sprite.setIsDragging(true);
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (Sprite sprite : Display.getSprites()) {
            sprite.setIsDragging(false);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for (Sprite sprite : Display.getSprites()) {
            if (sprite.isDragging()) {
                sprite.updatePosition(e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}