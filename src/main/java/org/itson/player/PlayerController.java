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
    
//    public Player createPlayer(String name) {
//        Player player = new Player();
//        player.setName(name);
//        return player;
//    }
    public Player createFirstPlayer(String name) {
        Player playerOne = new Player();
        playerOne.setName(name);
        return playerOne;
    }
    public Player createSecondPlayer(String name) {
        Player playerTwo = new Player();
        playerTwo.setName(name);
        return playerTwo;
    }
    public Player createThirdPlayer(String name) {
        Player playerThree = new Player();
        playerThree.setName(name);
        return playerThree;
    }
    public Player createFourthPlayer(String name) {
        Player playerFour = new Player();
        playerFour.setName(name);
        return playerFour;
    }
}

