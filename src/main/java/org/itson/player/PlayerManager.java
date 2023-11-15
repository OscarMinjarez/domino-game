package org.itson.player;

import java.util.ArrayList;
import java.util.List;

import org.itson.token.Token;

/**
 * Esta clase sera el manejador de jugadores
 *
 * @author arace
 */
public class PlayerManager {

    private static PlayerManager instace;
    private List<PlayerComponent> playersComponent;

    public PlayerManager() {
        this.playersComponent = new ArrayList<>();
    }

    public PlayerManager(List<PlayerComponent> playersComponent) {
        this.playersComponent = playersComponent;
    }

    public static PlayerManager get() {
        if (PlayerManager.instace == null) {
            PlayerManager.instace = new PlayerManager();
        }
        return PlayerManager.instace;
    }

    public void createPlayer(String name) {
        if (this.playersComponent.size() < 4) {
        List<Token> tokens = new ArrayList<>(); 

        PlayerComponent playerComponent = new PlayerComponent( tokens, name);
        this.playersComponent.add(playerComponent);
        System.out.println("Player " + name + " is created.");
    } else {
        System.out.println("Players are already created.");
    }

    }

    public List<PlayerComponent> getPlayersComponents() {
        return this.playersComponent;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        for (PlayerComponent playerComponent : this.playersComponent) {
            players.add(playerComponent.getPlayer());
        }
        return players;
    }

}
