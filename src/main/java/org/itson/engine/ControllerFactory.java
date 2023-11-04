/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.engine;

import org.itson.board.BoardController;
import org.itson.game.GameController;
import org.itson.pit.PitController;
import org.itson.player.PlayerController;
import org.itson.room.RoomController;
import org.itson.token.TokenController;

/**
 *
 * @author luis-
 */
public class ControllerFactory {

    public ControllerFactory() {

    }

    public static BoardController getBoardController() {
        return BoardController.get();
    }

    public static GameController getGameController() {
        return GameController.get();
    }

    public static PitController getPitController() {
        return PitController.get();
    }

    public static PlayerController getPlayerController() {
        return PlayerController.get();
    }

    public static RoomController getRoomController() {
        return RoomController.get();
    }

//    public static TokenController getTokenController() {
//        return TokenController.get();
//    }

}
