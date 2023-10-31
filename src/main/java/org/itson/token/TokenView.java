
package org.itson.token;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author arace
 */
public class TokenView extends JPanel{
    private BufferedImage image1;
    private BufferedImage image2;
    
    private int startX, startY;
    private boolean isDragging = false;

    public TokenView(){
        
    }
    
    public TokenView(String image1Path, String image2Path) {
        try {
            this.image1 = ImageIO.read(getClass().getResource(image1Path));
            this.image2 = ImageIO.read(getClass().getResource(image2Path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        setPreferredSize(new Dimension(16 * 3, 32 * 3)); // Tamaño de la ficha

        // Puedes personalizar la representación de la ficha aquí, como agregar imágenes o dibujar los valores en el panel.
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Guarda la posición inicial del mouse al hacer clic en la ficha
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
        if (image1 != null && image2 != null) {
            g.drawImage(image1, 0, 0, this);
            g.drawImage(image2, 0, 16 * 3, this);
        }
    }
}
    

