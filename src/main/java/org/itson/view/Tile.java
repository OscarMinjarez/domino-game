/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;

import java.awt.Image;

/**
 *
 * @author icedo
 */
public class Tile {
    
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private Image image;

    public Tile(int x, int y, int ancho, int alto, Image image) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.image = image;
    }
    
    
    
}
