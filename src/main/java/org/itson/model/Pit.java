/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.model;

/**
 *
 * @author luis-
 */
public class Pit {

    private Token tokens[];

    public Pit() {
    }

    public Pit(Token[] tokens) {
        this.tokens = tokens;
    }

    public Token[] getTokens() {
        return tokens;
    }

    public void setTokens(Token[] tokens) {
        this.tokens = tokens;
    }

}
