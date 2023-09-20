/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.src;

import javax.swing.JFrame;

/**
 *
 * @author oscar
 */
public class Window extends JFrame {
    public Window() {
        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setContentPane(new GamePanel(640, 420));
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
