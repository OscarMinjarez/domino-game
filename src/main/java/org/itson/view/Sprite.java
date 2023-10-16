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

public class Sprite {

    private Image image;
    private int x, y;
    private int width, height;
    private boolean isDragging = false;
    private boolean imageLoaded = false; // Agregamos un atributo para rastrear si la imagen está cargada

    public Sprite(String imagePath, int x, int y) {
        ImageIcon ii = new ImageIcon(imagePath);
        this.image =ii.getImage();
        this.x=x;
        this.y=y;
    }

    public Sprite(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getWidth() {
        return width; // Devolver el ancho de la imagen
    }

    public int getHeight() {
        return height; // Devolver el alto de la imagen
    }
    
    // Método para cargar la imagen
    public void loadImage(String imagePath, int width, int height) {
        ImageIcon ii = new ImageIcon(imagePath);
        this.image = ii.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        imageLoaded = true;
    }

    public boolean isImageLoaded() {
        return imageLoaded;
    }
    
    // Nuevo método para establecer el estado de la imagen cargada
    public void setImageLoaded(boolean loaded) {
        imageLoaded = loaded;
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
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
