/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.engine;

import org.itson.board.Board;
import org.itson.game.Game;
import org.itson.model.domain.Avatar;
import org.itson.model.domain.Rule;
import org.itson.pit.Pit;
import org.itson.player.Player;
import org.itson.room.Room;
import org.itson.token.Token;

/**
 *
 * @author luis-
 */
public class ModelFactory {

    public ModelFactory() {

    }

    public static Avatar getAvatar() {
        //return getAvatar();
        return new Avatar();
    }

    public static Board getBoard() {
        return new Board();
    }

    public static Game getGame() {
        return new Game();
    }

    public static Rule getRule() {
        return new Rule();
    }

    public static Pit getPit() {
        return new Pit();
    }

    public static Player getPlayer() {
        return new Player();
    }

    public static Room getRoom() {
        return new Room();
    }

    public static Token getToken() {
        return new Token();
    }

}
