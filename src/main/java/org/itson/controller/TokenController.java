/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.controller;

/**
 *
 * @author luis-
 */
public class TokenController {
    
    private static TokenController instance = new TokenController();
    
    private TokenController(){
        
    }
    
    public static TokenController get() {
        if (instance == null) {
            instance = new TokenController();
        }
        return instance;
    }
    
}
