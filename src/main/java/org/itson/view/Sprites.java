/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class Sprites {

    private Image image;
    private int x, y;
    private boolean isDragging = false;

    public Sprites(String imagePath, int x, int y) {
        ImageIcon ii = new ImageIcon(imagePath);
        this.image = ii.getImage();
        this.x = x;
        this.y = y;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
    
    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(image, x, y, observer);
    }

    public void setIsDragging(boolean isDragging) {
        this.isDragging = isDragging;
    }

    public boolean isDragging() {
        return isDragging;
    }

    public void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
