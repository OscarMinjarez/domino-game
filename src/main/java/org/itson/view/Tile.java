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
    private int wide;
    private int high;
    private Image image;

    public Tile(int x, int y, int wide, int high, Image image) {
        this.x = x;
        this.y = y;
        this.wide = wide;
        this.high = high;
        this.image = image;
    }
    
    
    
}
