package org.itson.player;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase sera el manejador de jugadores
 *
 * @author arace
 */
public class PlayerManager {

    private static PlayerManager instace;
    private List<PlayerComponent> playersComponent;

    public PlayerManager() {
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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.playersComponent.add(new PlayerComponent());
            }
        }
        if (this.playersComponent.size() == 3) {
            System.out.println("Players are create");
        } else {
            System.out.println("Players are not create");
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
