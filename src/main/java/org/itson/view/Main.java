/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.view;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 *
 * @author arace
 */
public class Main {
    public static void main(String[] args) {
        // Crea la ventana
        Window window = new Window();

        // Agrega los oyentes de eventos
        window.addMouseListener(new MouseListener());
        window.addKeyListener(new KeyListener() {});

        // Muestra la ventana
        window.setVisible(true);
    }
}
