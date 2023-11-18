/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.player.Player;

/**
 *
 * @author icedo
 */
public class PlayerConnection extends Thread {
    private Server server;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    public PlayerConnection(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        try {
            output=new ObjectOutputStream(this.socket.getOutputStream());
            input= new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(PlayerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public void run() {
        
            try {
                while(true){
                Object object = input.readObject();
                if(object instanceof Player){
                    Player player = (Player) object;
                    server.getGameController().addPlayerToTheRoom(player);
                    server.sendAll(server.getGameController());
             }
             }
            } catch (IOException ex) {
                System.out.println("Se desconectó un Jugador");
            } catch (ClassNotFoundException ex) {
                System.out.println("Se desconectó un Jugador");
            }
        
              
    }
    
    
    
}
