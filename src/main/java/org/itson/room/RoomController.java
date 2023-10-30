/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.room;

import java.util.List;
import org.itson.game.Game;
import org.itson.player.Player;

/**
 *
 * @author oscar
 */
public class RoomController {
    private static RoomController instance;
    private Room room;
    
    private RoomController() {
        
    }
    
    public static RoomController get() {
        if (RoomController.instance == null) {
            RoomController.instance = new RoomController();
        }
        
        return RoomController.instance;
    }
    
    public void createRoom() {
        this.room = new Room();
    }
    
    public Room getRoom() {
        return this.room;
    }
    
    public void setGame(Game game) {
        this.room.setGame(game);
    }
    
    public void addPlayerToTheRoom(Player player) {
        this.room.addPlayer(player);
    }
    
    public List<Player> getPlayers() {
        return this.room.getPlayers();
    }
}
