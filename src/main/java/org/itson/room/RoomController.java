/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.room;

/**
 *
 * @author oscar
 */
public class RoomController {
    private static RoomController instance;
    
    private RoomController() {
        
    }
    
    public static RoomController get() {
        if (RoomController.instance == null) {
            RoomController.instance = new RoomController();
        }
        
        return RoomController.instance;
    }
    
    public Room createRoom() {
        return new Room();
    }
}
