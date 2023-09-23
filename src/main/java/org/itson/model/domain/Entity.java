/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.model.domain;

import org.itson.utils.Vector2;

/**
 *
 * @author oscar
 */
public abstract class Entity {
    private Vector2 position;

    public Entity() {
        this.position = new Vector2();
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public abstract void update();
}
