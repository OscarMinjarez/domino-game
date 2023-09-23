/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

/**
 *
 * @author oscar
 */
public class Vector2 {
    private float x;
    private float y;

    public Vector2() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Vector2 get() {
        return new Vector2(this.x, this.y);
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 v) {
        return new Vector2(this.x + v.getX(), this.y + v.getY());
    }

    public Vector2 sub(Vector2 v) {
        return new Vector2(this.x - v.getX(), this.y - v.getY());
    }

    public Vector2 mul(float scalar) {
        return new Vector2(this.x * scalar, this.y * scalar);
    }

    public Vector2 div(float scalar) {
        return new Vector2(this.x / scalar, this.y / scalar);
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2 normalize() {
        float length = this.length();
        if (length != 0) {
            return this.mul(1f / length);
        } else {
            return new Vector2(0, 0);
        }
    }

    public float dot(Vector2 v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    public Vector2 cross(Vector2 v) {
        return new Vector2(this.y * v.getX() - this.x * v.getY(), -(this.y * v.getY() - this.x * v.getX()));
    }
}
