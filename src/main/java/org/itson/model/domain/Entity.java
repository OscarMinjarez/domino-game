
package org.itson.model.domain;

import org.itson.utils.Vector2;

/**
 * Clase abstracta que representa una entidad 
 * @author oscar
 */
public abstract class Entity {
    private Vector2 position;
    /**
     * Metodo que inicializa la posicion del vector
     */
    public Entity() {
        this.position = new Vector2();
    }
    /**
     * Metodo que obtiene la posicion actual del vector
     * @return 
     */
    public Vector2 getPosition() {
        return this.position;
    }
    /**
     * Metodo que establece la posicion actual del vector
     * @param position 
     */
    public void setPosition(Vector2 position) {
        this.position = position;
    }  
}
