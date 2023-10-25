/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.player;

/**
 *
 * @author oscar
 */
public class PlayerController {
    private static PlayerController instance;
    
    private PlayerController() {
        
    }
    
    public static PlayerController get() {
        if (PlayerController.instance == null) {
            PlayerController.instance = new PlayerController();
        }
        
        return PlayerController.instance;
    }
    
    public Player createPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        return player;
    }
}
