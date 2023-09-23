/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.view;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import javax.swing.JFrame;

/**
 *
 * @author arace
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame window  = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Domino Master");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        // Crea una instancia de MouseListener
        java.awt.event.MouseListener mouseListener = new MouseListener();

        // Agrega el oyente de eventos de mouse a la ventana
        window.addMouseListener(mouseListener);
   
    }
    
}
