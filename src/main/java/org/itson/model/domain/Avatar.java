package org.itson.model.domain;

import java.awt.Image;

/**
 * Clase con los atributos del avatar
 * @author arace
 */
public class Avatar {
    private Image image;

    /**
     * Metodo contructor 
     */
    public Avatar() {
    }

    public Avatar(Image image) {
        this.image = image;
    }
    /**
     * Obtiene la imagen del avatar
     * @return 
     */
    public Image getImage() {
        return image;
    }
    /**
     * Establece la imagen del avatar
     * @param image 
     */
    public void setImage(Image image) {
        this.image = image;
    }
}
