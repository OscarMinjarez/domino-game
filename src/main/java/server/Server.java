/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.game.GameController;

/**
 *
 * @author icedo
 */
public class Server extends Thread{
    private List <Socket> players = new ArrayList<>();
    private GameController gameController;

    public Server() {
        gameController = new GameController();
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
    
    
    
    
    @Override
    public void run() {
        try {
            ServerSocket  serversocket = new ServerSocket(1001);
            System.out.println("El server ha iniciado");
            while(true){
                Socket socket = serversocket.accept();
                System.out.println("Jugador nuevo");
                players.add(socket);
                PlayerConnection playerconnection= new PlayerConnection(this, socket);
                playerconnection.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendAll(Object object){
        for (Socket player : players) {
            try {
                ObjectOutputStream output = new ObjectOutputStream(player.getOutputStream());
                output.writeObject(object);
                output.flush();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
            
        
    }
    
}
