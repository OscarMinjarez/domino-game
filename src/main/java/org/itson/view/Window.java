/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author arace
 */
public class Window extends JFrame implements MouseListener, KeyListener {

    private Graphics graphics;

    public Window() {
        super("My Game");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crea el objeto Graphics
        graphics = getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        // Dibuja en la pantalla
        g.drawString("Hola mundo!", 100, 100);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Procesa el evento de clic del mouse
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Procesa el evento de liberación del mouse
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Procesa el evento de pulsación de tecla
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Procesa el evento de liberación de tecla
    }

}

