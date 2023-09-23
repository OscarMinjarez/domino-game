package org.itson.model;

import java.awt.Image;

/**
 *
 * @author arace
 */
public class Avatar {

    private Image image;

    public Avatar() {
    }

    public Avatar(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
