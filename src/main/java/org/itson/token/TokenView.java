
package org.itson.token;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author arace
 */
public class TokenView extends JPanel{
    private BufferedImage face1;
    private BufferedImage face2;
    
    private int startX, startY;
    private boolean isDragging = false;
    private int faceWidth = 16 * 3;
    private int faceHeight = 32 * 3;
    
    private Dimension tokenSize = new Dimension(this.faceWidth, this.faceHeight);
    
    public TokenView(Token token) {
        this.face1 = token.getFaces()[0].getImage();
        this.face2 = token.getFaces()[1].getImage();
        setSize(this.tokenSize); // variable de las dimensiones
        setPreferredSize(this.tokenSize);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isDragging) {
                    // Si la ficha se estaba arrastrando, verifica si se soltó en una posición válida para jugar.
                    // Implementa aquí la lógica para verificar la posición de soltar.
                    // Por ejemplo, si se suelta sobre un área de juego válida, realiza la acción correspondiente.
                    // Puedes llamar a un método en el controlador para procesar el movimiento.

                    // Aquí puedes restaurar la posición de la ficha a su ubicación original.
                    // setLocation(startX, startY);
                    isDragging = false;
                }
            }
        });
        
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Mueve la ficha mientras el mouse se arrastra
                isDragging = true;
                int deltaX = e.getX() - startX;
                int deltaY = e.getY() - startY;
                setLocation(getX() + deltaX, getY() + deltaY);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Dibuja los valores de la ficha
        if (face1 != null && face2 != null) {
            g.drawImage(face1, 0, 0, this);
            g.drawImage(face2, 0, 16 * 3, this);
        }
    }
}
    

