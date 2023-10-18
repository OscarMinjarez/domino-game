package org.itson.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Esta clase se encargará de administrar todos los eventos que ocurran con el
 * ratón dentro de nuestro juego.
 * @author oscar
 */
public class MouseListener extends MouseAdapter implements MouseMotionListener {

    /**
     * Instancia de esta misma clase para aplicar singleton.
     */
    private static MouseListener instance;
    
    /**
     * Posición actual de X.
     */
    private int x;
    /**
     * Posición actual de Y.
     */
    private int y;
    
    /**
     * Última posición donde se hizo click en X.
     */
    private int lastX;
    /**
     * Última posición donde se hizo click en Y.
     */
    private int lastY;
    
    /**
     * Arreglo para saber qué botón del ratón está siendo presionado.
     */
    private final boolean[] mouseButtonPressed = new boolean[3];
    
    /**
     * Atributo para saber si el ratón está arrastrando algo.
     */
    private boolean isDragging;

    /**
     * Método constructor por omisión privado.
     */
    private MouseListener() {
    }

    /**
     * Método que utiliza singleton para obtener una instancia de esta clase
     * para que sólo exista una en cualquier parte del programa.
     * @return instancia de MouseListener.
     */
    public static MouseListener get() {
        if (MouseListener.instance == null) {
            MouseListener.instance = new MouseListener();
        }

        return MouseListener.instance;
    }

    /**
     * Método que se encarga de actualizar el estado de un botón del ratón
     * específico para saber si se presionó.
     * @param e eventop del ratón.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        get().mouseButtonPressed[e.getButton() - 1] = true;
        get().isDragging = true;
        
        System.out.println(e.getButton() + ": " +  get().mouseButtonPressed[e.getButton() - 1]);
    }

    /**
     * Método que se encarga de actualizar el estado de un botón del ratón
     * específico para saber si se soltó.
     * @param e evento del ratón.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        get().mouseButtonPressed[e.getButton() - 1] = false;
        get().isDragging = false;
    }
    
    /**
     * Método que verifica si un botón del ratón ha sido clickeado (presionado
     * y soltado).
     * @param e evento del ratón.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        get().lastX = e.getX();
        get().lastY = e.getY();
    }
    
    /**
     * Método que guarda las coordenadas del ratón cuando se está moviendo
     * por la pantalla.
     * @param e evento del ratón.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        get().x = e.getX();
        get().y = e.getY();
    }

    /**
     * Método que obtiene la coordenada X.
     * @return coordenada X.
     */
    public int getX() {
        return x;
    }

    /**
     * Método que obtiene la coordenada Y.
     * @return coordenada Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Método que obtiene la última coordenada X donde se dió un click.
     * @return coordenada X.
     */
    public int getLastX() {
        return lastX;
    }

    /**
     * Método que obtiene la última coordenada Y donde se  dió un click.
     * @return coordenada Y.
     */
    public int getLastY() {
        return lastY;
    }

    /**
     * Método para saber si actualmente se está arrastrando algo por la pantalla
     * o no.
     * @return 
     */
    public boolean getIsDragging() {
        return isDragging;
    }

    /**
     * Método para obtener el botón que se está presionando.
     * @param button índice del botón a presionar.
     * @return verdadero si el botón especificado se está presionando.
     */
    public boolean getMouseButtonPressed(int button) {
        if (button < get().mouseButtonPressed.length) {
            return mouseButtonPressed[button];
        }
        
        return false;
    }
}
