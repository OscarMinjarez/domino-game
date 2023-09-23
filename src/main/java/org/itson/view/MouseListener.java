/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;

import java.awt.event.MouseEvent;

/**
 *
 * @author arace
 */
public class MouseListener implements java.awt.event.MouseListener {

    @Override
    public void mousePressed(MouseEvent e) {
       // Procesa el evento de presionar el mouse
            System.out.println("Mouse presionado en la ubicación: (" + e.getX() + ", " + e.getY() + ")");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Procesa el evento de liberar el mouse
            System.out.println("Mouse liberado en la ubicación: (" + e.getX() + ", " + e.getY() + ")");
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

    
    
    
    
}

